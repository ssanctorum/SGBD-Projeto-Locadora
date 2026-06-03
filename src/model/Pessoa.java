package model;

abstract class Pessoa {

    //dados pessoa
    private String pessoaNome;

    private String pessoaCpf;

    private String pessoaTelefone;

    private String pessoaEmail;

    private String pessoaEndereco;

    //getters pessoa
    public String getPessoaNome() {
        return pessoaNome;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public String getPessoaTelefone() {
        return pessoaTelefone;
    }

    public String getPessoaEmail() {
        return pessoaEmail;
    }

    public String getPessoaEndereco() {
        return pessoaEndereco;
    }

    //setters pessoa
    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public void setPessoaTelefone(String pessoaTelefone) {
        this.pessoaTelefone = pessoaTelefone;
    }

    public void setPessoaEmail(String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    public void setPessoaEndereco(String pessoaEndereco) {
        this.pessoaEndereco = pessoaEndereco;
    }

    //construtor
    public Pessoa(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco) {
        this.pessoaNome = pessoaNome;
        this.pessoaCpf = pessoaCpf;
        this.pessoaTelefone = pessoaTelefone;
        this.pessoaEmail = pessoaEmail;
        this.pessoaEndereco = pessoaEndereco;
    }

    //toString
    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoaNome='" + pessoaNome + '\'' +
                ", pessoaCpf='" + pessoaCpf + '\'' +
                ", pessoaTelefone='" + pessoaTelefone + '\'' +
                ", pessoaEmail='" + pessoaEmail + '\'' +
                ", pessoaEndereco='" + pessoaEndereco + '\'' +
                '}';
    }
}
