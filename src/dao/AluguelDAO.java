package dao;

import model.Aluguel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO implements DAO<Aluguel> {

    @Override
    public void inserir(Aluguel aluguel) {
        String sql = "INSERT INTO \"Alugueis\" (cpf_cliente, placa_veiculo, data_devolucao, valor_total, status) VALUES (?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluguel.getCpfCliente());
            stmt.setString(2, aluguel.getPlacaVeiculo());
            stmt.setDate(3, java.sql.Date.valueOf(
                    java.time.LocalDate.parse(aluguel.getDataDevolucao(),
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ));
            stmt.setDouble(4, aluguel.getValorTotal());
            stmt.setString(5, aluguel.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir aluguel: " + e.getMessage());
        }
    }

    @Override
    public List<Aluguel> listarTodos() {
        String sql = "SELECT * FROM \"Alugueis\"";
        List<Aluguel> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(montarAluguel(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar alugueis: " + e.getMessage());
        }
        return lista;
    }

    public List<Aluguel> buscarAtivosPorCpf(String cpf) {
        String sql = "SELECT * FROM \"Alugueis\" WHERE cpf_cliente = ? AND status = 'ativo'";
        List<Aluguel> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(montarAluguel(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar alugueis por CPF: " + e.getMessage());
        }
        return lista;
    }

    public Aluguel buscarAtivoPorPlaca(String placa) {
        String sql = "SELECT * FROM \"Alugueis\" WHERE placa_veiculo = ? AND status = 'ativo'";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return montarAluguel(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar aluguel por placa: " + e.getMessage());
        }
        return null;
    }

    public void encerrar(int id) {
        String sql = "UPDATE \"Alugueis\" SET status = 'encerrado' WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encerrar aluguel: " + e.getMessage());
        }
    }

    // métodos vazios
    @Override
    public void deletarPorString(String id) {}

    @Override
    public void deletarPorInt(int id) {}

    private Aluguel montarAluguel(ResultSet rs) throws Exception {
        return new Aluguel(
                rs.getInt("id"),
                rs.getString("cpf_cliente"),
                rs.getString("placa_veiculo"),
                rs.getTimestamp("data_inicio") != null
                        ? new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm")
                        .format(rs.getTimestamp("data_inicio"))
                        : null,
                rs.getDate("data_devolucao") != null
                        ? rs.getDate("data_devolucao").toLocalDate()
                        .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        : null,
                rs.getDouble("valor_total"),
                rs.getString("status")
        );
    }
}