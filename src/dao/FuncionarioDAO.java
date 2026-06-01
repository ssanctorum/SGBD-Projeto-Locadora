package dao;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements DAO<Funcionario> {

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cpf, telefone, email, endereco, cargo, salario) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getPessoaNome());
            stmt.setString(2, funcionario.getPessoaCpf());
            stmt.setString(3, funcionario.getPessoaTelefone());
            stmt.setString(4, funcionario.getPessoaEmail());
            stmt.setString(5, funcionario.getPessoaEndereco());
            stmt.setString(6, funcionario.getFuncionarioCargo());
            stmt.setDouble(7, funcionario.getFuncionarioSalario());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getInt("matricula"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"),
                        rs.getString("data_admissao")
                );
                lista.add(f);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deletarPorString(String cpf) {
        String sql = "DELETE FROM funcionarios WHERE cpf = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover funcionário por CPF: " + e.getMessage());
        }
    }

    @Override
    public void deletarPorInt(int matricula) {
        String sql = "DELETE FROM funcionarios WHERE matricula = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover funcionário por matrícula: " + e.getMessage());
        }
    }

    public Funcionario buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getInt("matricula"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"),
                        rs.getString("data_admissao")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar funcionário por CPF: " + e.getMessage());
        }
        return null;
    }

    public Funcionario buscarPorMatricula(int matricula) {
        String sql = "SELECT * FROM funcionarios WHERE matricula = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getInt("matricula"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"),
                        rs.getString("data_admissao")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar funcionário por matrícula: " + e.getMessage());
        }
        return null;
    }
}