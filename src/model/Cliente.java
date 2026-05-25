package model;

public class Cliente extends Pessoa{

    //dados private clientes
    private String clienteCNH;

    private String clienteValidadeCNH;

    private String clienteDataCadastro;

    //getters cliente
    public String getClienteCNH() {
        return clienteCNH;
    }

    public String getClienteValidadeCNH() {
        return clienteValidadeCNH;
    }

    public String getClienteDataCadastro() {
        return clienteDataCadastro;
    }

    //setters cliente
    public void setClienteCNH(String clienteCNH) {
        this.clienteCNH = clienteCNH;
    }

    public void setClienteValidadeCNH(String clienteValidadeCNH) {
        this.clienteValidadeCNH = clienteValidadeCNH;
    }

    public void setClienteDataCadastro(String clienteDataCadastro) {
        this.clienteDataCadastro = clienteDataCadastro;
    }

    //construtor
    public Cliente(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco, String clienteCNH, String clienteValidadeCNH, String clienteDataCadastro) {
        super(pessoaNome, pessoaCpf, pessoaTelefone, pessoaEmail, pessoaEndereco);
        this.clienteCNH = clienteCNH;
        this.clienteValidadeCNH = clienteValidadeCNH;
        this.clienteDataCadastro = clienteDataCadastro;
    }

    //toString
    @Override
    public String toString() {
        return
                "\n Nome: " + getPessoaNome() +
                "\n CPF: " + getPessoaCpf() +
                "\n Telefone :" + getPessoaTelefone() +
                "\n E-mail: " + getPessoaEmail() +
                "\n Endereço: " + getPessoaEndereco() +
                "\n Registro CNH: " + clienteCNH +
                "\n Validade CNH: " + clienteValidadeCNH +
                "\n Data de Cadastro: " + clienteDataCadastro + "\n\n";
    }
}
