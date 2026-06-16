package model;

public class Aluguel {

        private int id;
        private String cpfCliente;
        private String placaVeiculo;
        private String dataInicio;
        private String dataDevolucao;
        private double valorTotal;
        private String status;

        public int getId() { return id; }
        public String getCpfCliente() { return cpfCliente; }
        public String getPlacaVeiculo() { return placaVeiculo; }
        public String getDataInicio() { return dataInicio; }
        public String getDataDevolucao() { return dataDevolucao; }
        public double getValorTotal() { return valorTotal; }
        public String getStatus() { return status; }

        public void setId(int id) { this.id = id; }
        public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
        public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }
        public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
        public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }
        public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
        public void setStatus(String status) { this.status = status; }

    // construtor sem ID e dataInicio, já que o sgbd cria em si
    public Aluguel(String cpfCliente, String placaVeiculo, String dataDevolucao, double valorTotal) {
        this.cpfCliente = cpfCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.status = "ativo";
        this.dataInicio = null;
        this.id = 0;
    }

    // construtor com ID e dataInicio
    public Aluguel(int id, String cpfCliente, String placaVeiculo, String dataInicio, String dataDevolucao, double valorTotal, String status) {
        this.id = id;
        this.cpfCliente = cpfCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    @Override
    public String toString() {
        return  "\n ID do Aluguel: " + id +
                "\n CPF do Cliente: " + cpfCliente +
                "\n Placa do Veículo: " + placaVeiculo +
                "\n Data de Início: " + dataInicio +
                "\n Data de Devolução: " + dataDevolucao +
                "\n Valor Total: R$ " + String.format("%.2f", valorTotal) +
                "\n Status: " + status + "\n\n";
    }
}
