package model;

public class Funcionario extends Pessoa {

    //dados private dos funcionarios
    private int funcionarioMatricula;

    private String funcionarioCargo;

    private double funcionarioSalario;

    private String funcionarioDataAdmissao;

    //getters funcionarios
    public int getFuncionarioMatricula() {
        return funcionarioMatricula;
    }

    public String getFuncionarioCargo() {
        return funcionarioCargo;
    }

    public double getFuncionarioSalario() {
        return funcionarioSalario;
    }

    public String getFuncionarioDataAdmissao() {
        return funcionarioDataAdmissao;
    }

    //setters funcionarios
    public void setFuncionarioMatricula(int funcionarioMatricula) {
        this.funcionarioMatricula = funcionarioMatricula;
    }

    public void setFuncionarioCargo(String funcionarioCargo) {
        this.funcionarioCargo = funcionarioCargo;
    }

    public void setFuncionarioSalario(double funcionarioSalario) {
        this.funcionarioSalario = funcionarioSalario;
    }

    public void setFuncionarioDataAdmissao(String funcionarioDataAdmissao) {
        this.funcionarioDataAdmissao = funcionarioDataAdmissao;
    }

    //construtores
    public Funcionario(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco, int funcionarioMatricula, String funcionarioCargo, double funcionarioSalario, String funcionarioDataAdmissao) {
        super(pessoaNome, pessoaCpf, pessoaTelefone, pessoaEmail, pessoaEndereco);
        this.funcionarioMatricula = funcionarioMatricula;
        this.funcionarioCargo = funcionarioCargo;
        this.funcionarioSalario = funcionarioSalario;
        this.funcionarioDataAdmissao = funcionarioDataAdmissao;
    }

    ///  esse aqui em específico vai ser sem data e sem matricula, já que o SGBD vai criar a data em si
    public Funcionario(String pessoaNome, String pessoaCpf, String pessoaTelefone, String pessoaEmail, String pessoaEndereco, String funcionarioCargo, double funcionarioSalario) {
        super(pessoaNome, pessoaCpf, pessoaTelefone, pessoaEmail, pessoaEndereco);
        this.funcionarioMatricula = 0;
        this.funcionarioCargo = funcionarioCargo;
        this.funcionarioSalario = funcionarioSalario;
        this.funcionarioDataAdmissao = null;
    }

    //to string
    @Override
    public String toString() {
        return "\n Nome: " + getPessoaNome() +
                "\n CPF: " + getPessoaCpf() +
                "\n Telefone :" + getPessoaTelefone() +
                "\n E-mail: " + getPessoaEmail() +
                "\n Endereço: " + getPessoaEndereco() +
                "\n Matrícula: " + getFuncionarioMatricula() +
                "\n Cargo: " + getFuncionarioCargo() +
                "\n Salário: R$ " + String.format("%.2f",getFuncionarioSalario()) +
                "\n Data de admissão: " + getFuncionarioDataAdmissao() + "\n\n";
    }
}
