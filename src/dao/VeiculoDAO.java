package dao;

import model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements DAO<Veiculo> {

    @Override
    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (placa, modelo, marca, ano, cor, valor_diaria, disponibilidade) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getVeiculoPlaca());
            stmt.setString(2, veiculo.getVeiculoModelo());
            stmt.setString(3, veiculo.getVeiculoMarca());
            stmt.setInt(4, veiculo.getVeiculoAno());
            stmt.setString(5, veiculo.getVeiculoCor());
            stmt.setDouble(6, veiculo.getVeiculoValorDiaria());
            stmt.setBoolean(7, true);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir veículo: " + e.getMessage());
        }
    }

    @Override
    public List<Veiculo> listarTodos() {
        String sql = "SELECT * FROM veiculos";
        List<Veiculo> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String disponibilidade = rs.getBoolean("disponibilidade") ? "Está disponível." : "Não está disponível.";
                Veiculo v = new Veiculo(
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("cor"),
                        rs.getDouble("valor_diaria"),
                        disponibilidade
                );
                lista.add(v);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar veículos: " + e.getMessage());
        }
        return lista;
    }

    public Veiculo buscarPorPlaca(String placa) {
        String sql = "SELECT * FROM veiculos WHERE placa = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String disponibilidade = rs.getBoolean("disponibilidade") ? "Está disponível." : "Não está disponível.";
                return new Veiculo(
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("cor"),
                        rs.getDouble("valor_diaria"),
                        disponibilidade
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar veículo por placa: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deletarPorString(String id) {
        //mais um so pra completar interface
    }

    @Override
    public void deletarPorInt(int id) {
        //same as above
    }
}