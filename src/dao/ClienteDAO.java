package dao;

import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO \"Clientes\" (nome, cpf, telefone, email, endereco, cnh_registro, cnh_validade) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPessoaNome());
            stmt.setString(2, cliente.getPessoaCpf());
            stmt.setString(3, cliente.getPessoaTelefone());
            stmt.setString(4, cliente.getPessoaEmail());
            stmt.setString(5, cliente.getPessoaEndereco());
            stmt.setString(6, cliente.getClienteCNH());
            stmt.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.parse(cliente.getClienteValidadeCNH(), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM \"Clientes\"";
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("cnh_registro"),
                        rs.getDate("cnh_validade") != null ? rs.getDate("cnh_validade").toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null,
                        rs.getTimestamp("data_cadastro") != null ? new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(rs.getTimestamp("data_cadastro")) : null
                );
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM \"Clientes\" WHERE cpf = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("cnh_registro"),
                        rs.getDate("cnh_validade") != null ? rs.getDate("cnh_validade").toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null,
                        rs.getTimestamp("data_cadastro") != null ? new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(rs.getTimestamp("data_cadastro")) : null
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage());
        }
        return null;
    }

    public Cliente buscarPorCnh(String cnh) {
        String sql = "SELECT * FROM \"Clientes\" WHERE cnh_registro = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnh);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("cnh_registro"),
                        rs.getDate("cnh_validade") != null ? rs.getDate("cnh_validade").toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null,
                        rs.getTimestamp("data_cadastro") != null ? new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(rs.getTimestamp("data_cadastro")) : null
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CNH: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deletarPorString(String id) {/*somente para completar a interface*/}

    @Override
    public void deletarPorInt(int id) {/*somente para completar a interface*/}
}