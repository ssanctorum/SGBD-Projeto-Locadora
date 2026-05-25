package dao;

import dao.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class legado {
    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2,  pessoa.getCpf());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir a pessoa: "+ e.getMessage());
        }
    }
}
