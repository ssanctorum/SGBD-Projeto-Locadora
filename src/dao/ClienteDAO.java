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
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco, cnh_registro, cnh_validade) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPessoaNome());
            stmt.setString(2, cliente.getPessoaCpf());
            stmt.setString(3, cliente.getPessoaTelefone());
            stmt.setString(4, cliente.getPessoaEmail());
            stmt.setString(5, cliente.getPessoaEndereco());
            stmt.setString(6, cliente.getClienteCNH());
            stmt.setString(7, cliente.getClienteValidadeCNH());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM clientes";
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
                        rs.getString("cnh_validade"),
                        rs.getString("data_cadastro")
                );
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";
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
                        rs.getString("cnh_validade"),
                        rs.getString("data_cadastro")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage());
        }
        return null;
    }

    public Cliente buscarPorCnh(String cnh) {
        String sql = "SELECT * FROM clientes WHERE cnh_registro = ?";
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
                        rs.getString("cnh_validade"),
                        rs.getString("data_cadastro")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CNH: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deletarPorString(String id) {}
    // nao vai usar... massa, so por causa da interface

    @Override
    public void deletarPorInt(int id) {}
}   // mesmo caso do deletarPorString kkkkkkk