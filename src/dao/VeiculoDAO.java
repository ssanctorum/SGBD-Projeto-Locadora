package dao;

import model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeiculoDAO {

    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO clientes (placa, modelo, marca, ano, cor, valor_diaria, disponibilidade) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, veiculo.getVeiculoPlaca());
            stmt.setString(2, veiculo.getVeiculoModelo());
            stmt.setString(3, veiculo.getVeiculoMarca());
            stmt.setInt(4, veiculo.getVeiculoAno());
            stmt.setString(5, veiculo.getVeiculoCor());
            stmt.setDouble(6, veiculo.getVeiculoValorDiaria());
            stmt.setString(7, veiculo.isVeiculoDisponivel());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir o cliente: "+ e.getMessage());
        }
    }
}
