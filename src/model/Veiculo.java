package model;

public class Veiculo {

    //dados private veículos
    private String veiculoPlaca;

    private String veiculoModelo;

    private String veiculoMarca;

    private int veiculoAno;

    private String veiculoCor;

    private double veiculoValorDiaria;

    private String veiculoDisponivel;

    //getters veículos
    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public String getVeiculoModelo() {
        return veiculoModelo;
    }

    public String getVeiculoMarca() {
        return veiculoMarca;
    }

    public int getVeiculoAno() {
        return veiculoAno;
    }

    public String getVeiculoCor() {
        return veiculoCor;
    }

    public double getVeiculoValorDiaria() {
        return veiculoValorDiaria;
    }

    public String isVeiculoDisponivel() {
        return veiculoDisponivel;
    }

    //setters veículos
    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public void setVeiculoModelo(String veiculoModelo) {
        this.veiculoModelo = veiculoModelo;
    }

    public void setVeiculoMarca(String veiculoMarca) {
        this.veiculoMarca = veiculoMarca;
    }

    public void setVeiculoAno(int veiculoAno) {
        this.veiculoAno = veiculoAno;
    }

    public void setVeiculoCor(String veiculoCor) {
        this.veiculoCor = veiculoCor;
    }

    public void setVeiculoValorDiaria(double veiculoValorDiaria) {
        this.veiculoValorDiaria = veiculoValorDiaria;
    }

    public void setVeiculoDisponivel(String veiculoDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
    }

    //construtor
    public Veiculo(String veiculoPlaca, String veiculoModelo, String veiculoMarca, int veiculoAno, String veiculoCor, double veiculoValorDiaria, String veiculoDisponivel) {
        this.veiculoPlaca = veiculoPlaca;
        this.veiculoModelo = veiculoModelo;
        this.veiculoMarca = veiculoMarca;
        this.veiculoAno = veiculoAno;
        this.veiculoCor = veiculoCor;
        this.veiculoValorDiaria = veiculoValorDiaria;
        this.veiculoDisponivel = veiculoDisponivel;
    }

    //toString
    @Override
    public String toString() {
        return
                "\n Placa: " + getVeiculoPlaca() +
                "\n Modelo: " + getVeiculoModelo() +
                "\n Marca:" + getVeiculoMarca() +
                "\n Ano: " + getVeiculoAno() +
                "\n Cor: " + getVeiculoCor() +
                "\n Valor da Diária: R$ " + String.format("%.2f", getVeiculoValorDiaria()) +
                "\n Disponibilidade: " + isVeiculoDisponivel() + "\n\n";

    }
}
