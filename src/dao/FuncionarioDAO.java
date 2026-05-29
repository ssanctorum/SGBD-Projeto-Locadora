package dao;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco, matricula, cargo, salario, data_admissao) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, funcionario.getPessoaNome());
            stmt.setString(2, funcionario.getPessoaCpf());
            stmt.setString(3, funcionario.getPessoaTelefone());
            stmt.setString(4, funcionario.getPessoaEmail());
            stmt.setString(5, funcionario.getPessoaEndereco());
            stmt.setInt(6, funcionario.getFuncionarioMatricula());
            stmt.setString(7, funcionario.getFuncionarioCargo());
            stmt.setDouble(8, funcionario.getFuncionarioSalario());
            stmt.setString(9, funcionario.getFuncionarioDataAdmissao());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir o cliente: "+ e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listarTodos (){
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario(
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("endereco"),
                        resultSet.getInt("matricula"),
                        resultSet.getString("cargo"),
                        resultSet.getDouble("salario"),
                        resultSet.getString("data_admissao")
                );
                listaFuncionarios.add(funcionario);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os funcionários: "+ e.getMessage());
        }

        return listaFuncionarios;
}
