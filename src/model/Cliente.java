package model;

public class Cliente extends Pessoa{

    //dados private
    private String clienteCNH;

    private String clienteValidadeCNH;

    private String clienteDataCadastro;

    //getters
    public String getClienteCNH() {
        return clienteCNH;
    }

    public String getClienteValidadeCNH() {
        return clienteValidadeCNH;
    }

    public String getClienteDataCadastro() {
        return clienteDataCadastro;
    }

    //setters
    public void setClienteCNH(String clienteCNH) {
        this.clienteCNH = clienteCNH;
    }

    public void setClienteValidadeCNH(String clienteValidadeCNH) {
        this.clienteValidadeCNH = clienteValidadeCNH;
    }

    public void setClienteDataCadastro(String clienteDataCadastro) {
        this.clienteDataCadastro = clienteDataCadastro;
    }

    //construtores
    public Cliente(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco, String clienteCNH, String clienteValidadeCNH, String clienteDataCadastro) {
        super(pessoaNome, pessoaCpf, pessoaTelefone, pessoaEmail, pessoaEndereco);
        this.clienteCNH = clienteCNH;
        this.clienteValidadeCNH = clienteValidadeCNH;
        this.clienteDataCadastro = clienteDataCadastro;
    }
    // esse construtor em específico não possui data, já que o SGBD vai criar a data em si
    public Cliente(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco, String clienteCNH, String clienteValidadeCNH) {
        super(pessoaNome, pessoaCpf, pessoaTelefone, pessoaEmail, pessoaEndereco);
        this.clienteCNH = clienteCNH;
        this.clienteValidadeCNH = clienteValidadeCNH;
        this.clienteDataCadastro = null;
    }

    //toString
    @Override
    public String toString() {
        return
                "\n Nome: " + getPessoaNome() +
                "\n CPF: " + getPessoaCpf() +
                "\n Telefone: " + getPessoaTelefone() +
                "\n E-mail: " + getPessoaEmail() +
                "\n Endereço: " + getPessoaEndereco() +
                "\n Registro CNH: " + clienteCNH +
                "\n Validade CNH: " + clienteValidadeCNH +
                "\n Data de Cadastro: " + clienteDataCadastro + "\n\n";
    }
}
