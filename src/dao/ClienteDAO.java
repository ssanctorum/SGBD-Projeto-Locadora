package dao;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco, cnh, validade_cnh, data_cadastro) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPessoaNome());
            stmt.setString(2, cliente.getPessoaCpf());
            stmt.setString(3, cliente.getPessoaTelefone());
            stmt.setString(4, cliente.getPessoaEmail());
            stmt.setString(5, cliente.getPessoaEndereco());
            stmt.setString(6, cliente.getClienteCNH());
            stmt.setString(7, cliente.getClienteValidadeCNH());
            stmt.setString(8, cliente.getClienteDataCadastro());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir o cliente: " + e.getMessage());
        }

    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> listaClientes = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            /// atualizar coluna de acordo com o sgbd q nn to com ele aq
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("endereco"),
                        resultSet.getString("cnh"),
                        resultSet.getString("validadeCNH"),
                        resultSet.getString("data_cadastro")
                );
                listaClientes.add(cliente);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os clientes: " + e.getMessage());
        }

        return listaClientes;
    }


    @Override
    public void atualizar (Cliente cliente){

    }

    @Override
    public void deletar (Cliente cliente){

    }



