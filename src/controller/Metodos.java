package controller;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.VeiculoDAO;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;
import view.Layouts_JOptionPane;

import javax.swing.JOptionPane;
import java.util.List;

public class Metodos {

    ClienteDAO clienteDAO = new ClienteDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    VeiculoDAO veiculosDAO = new VeiculoDAO();

    ///MENUS PRINCIPAIS
    public void menuCliente(){

        int loop = -1;

        do {
            try {
                String menuResposta = JOptionPane.showInputDialog(null, Layouts_JOptionPane.menuCliente, "Menu Principal", JOptionPane.PLAIN_MESSAGE);

                //tratamentos que vão ser padrões abaixo
                if (menuResposta == null){
                    return;
                }

                menuResposta = menuResposta.trim();
                if (menuResposta.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                int menuRespostaInt = Integer.parseInt(menuResposta);

                switch (menuRespostaInt){

                    case 1:
                        cadastroCliente();
                        break;

                    case 2:
                        listarCliente();
                        break;

                    case 3:
                        verificarCliente();
                        break;

                    case 0:
                        loop = 0;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        } while (loop != 0);
    }

    public void menuFuncionario(){
        int loop = -1;

        do {
            try {
                String menuResposta = JOptionPane.showInputDialog(null, Layouts_JOptionPane.menuFuncionario, "Menu Principal", JOptionPane.PLAIN_MESSAGE);

                //tratamentos que vão ser padrões abaixo
                if (menuResposta == null){
                    return;
                }

                menuResposta = menuResposta.trim();
                if (menuResposta.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                int menuRespostaInt = Integer.parseInt(menuResposta);

                switch (menuRespostaInt){

                    case 1:
                        admissaoFuncionario();
                        break;

                    case 2:
                        listarFuncionario();
                        break;

                    case 3:
                        removerFuncionario();
                        break;

                    case 0:
                        loop = 0;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        } while (loop != 0);
    }

    public void menuVeiculo (){
        int loop = -1;

        do {
            try {
                String menuResposta = JOptionPane.showInputDialog(null, Layouts_JOptionPane.menuVeiculo, "Menu Principal", JOptionPane.PLAIN_MESSAGE);

                //tratamentos que vão ser padrões abaixo
                if (menuResposta == null){
                    return;
                }

                menuResposta = menuResposta.trim();
                if (menuResposta.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                int menuRespostaInt = Integer.parseInt(menuResposta);

                switch (menuRespostaInt){

                    case 1:
                        cadastrarVeiculo();
                        break;

                    case 2:
                        listarVeiculo();
                        break;

                    case 3:
                        pesquisarVeiculo();
                        break;

                    case 0:
                        loop = 0;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        } while (loop != 0);
    }

    /// METODOS DO MENU CLIENTE
    public void cadastroCliente(){

        int comecarCadastro = JOptionPane.showConfirmDialog(null,"Para iniciar o cadastro, certifique-se de ter esses dados em mãos:\n\n - Nome completo\n - CPF \n - Telefone \n - E-mail \n - Endereço\n - Número da CNH\n - Validade da CNH\n\nQuer prosseguir?","Cadastro de Cliente",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (comecarCadastro == 1 || comecarCadastro == -1){
            return;
        }

        String nomeCliente = "";
        while (nomeCliente.trim().isEmpty()){
            nomeCliente = JOptionPane.showInputDialog(null, "Insira o nome completo:", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (nomeCliente == null) return;
            if (nomeCliente.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O nome não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String cpfCliente = "";
        while (cpfCliente.trim().isEmpty()){
            cpfCliente = JOptionPane.showInputDialog(null, "Insira o CPF:\n Modelo: 000.000.000-00", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (cpfCliente == null) return;
            if (cpfCliente.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O CPF não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);

            if (clienteDAO.buscarPorCpf(cpfCliente) != null){
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                cpfCliente = "";
            }
        }

        String telefoneCliente = "";
        while (telefoneCliente.trim().isEmpty()){
            telefoneCliente = JOptionPane.showInputDialog(null, "Insira o telefone:\n Modelo: (DDD 90000-0000)", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (telefoneCliente == null) return;
            if (telefoneCliente.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O telefone não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String emailCliente = "";
        while (emailCliente.trim().isEmpty()){
            emailCliente = JOptionPane.showInputDialog(null, "Insira o e-mail de contato:", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (emailCliente == null) return;
            if (emailCliente.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O e-mail não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String enderecoCliente = "";
        while (enderecoCliente.trim().isEmpty()){
            enderecoCliente = JOptionPane.showInputDialog(null, "Insira o endereço:\n Modelo: Nome da rua, nº da casa - Nome do bairro - Nome da Cidade", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (enderecoCliente == null) return;
            if (enderecoCliente.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O endereço não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String cnhCliente = "";
        while (cnhCliente.trim().isEmpty()) {
            cnhCliente = JOptionPane.showInputDialog(null, "Digite o n° de Registro da CNH:", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

            if (cnhCliente == null) return;
            if (cnhCliente.trim().isEmpty())
                JOptionPane.showMessageDialog(null, "O Registro da CNH não pode ficar vazio!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

            if (clienteDAO.buscarPorCnh(cnhCliente) != null){
                JOptionPane.showMessageDialog(null, "CNH já cadastrada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                cnhCliente = "";
            }
        }

            String validadeCnhCliente = "";
            while (validadeCnhCliente.trim().isEmpty()) {
                validadeCnhCliente = JOptionPane.showInputDialog(null, "Digite a data de validade da CNH:\n Modelo: dd/mm/aaaa", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);

                if (validadeCnhCliente == null) return;
                if (validadeCnhCliente.trim().isEmpty())
                    JOptionPane.showMessageDialog(null, "A data de validade não pode ficar vazia!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

                try {
                    java.time.LocalDate.parse(validadeCnhCliente.trim(),
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.\nExemplo: 25/12/2027", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    validadeCnhCliente = "";
                }
            }

            Cliente cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente, emailCliente, enderecoCliente, cnhCliente, validadeCnhCliente);
            clienteDAO.inserir(cliente);

            Cliente clienteCadastrado = clienteDAO.buscarPorCpf(cpfCliente);


            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!\n" + clienteCadastrado.toString(), "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
        }

    public void listarCliente(){

        List<Cliente> clientes = clienteDAO.listarTodos();


        if (clientes.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum cliente cadastrado.", "Listar Clientes", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 0; i < clientes.size(); i++){

            Cliente cliente = clientes.get(i);
            if (i == clientes.size()-1){
                JOptionPane.showOptionDialog(null, cliente.toString(), "Listar Clientes", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Fim da lista"}, "Fim da lista.");
            } else {
                JOptionPane.showOptionDialog(null, cliente.toString(), "Listar Clientes", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Ver próximo..."}, "Ver próximo...");
            }
        }
    }

    public void verificarCliente(){
        List<Cliente> clientes = clienteDAO.listarTodos();

        if (clientes.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum cliente cadastrado.", "Verificar Cliente", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int loop = -1;

        do {
            try{
                String opcaoVerificar = JOptionPane.showInputDialog(null, "Selecione como deseja verificar:\n\n[1] - Verificar por CPF\n[2] - Verificar por CNH\n[0] - Voltar\n\n", "Verificar Cliente", JOptionPane.PLAIN_MESSAGE);

                if (opcaoVerificar == null){
                    return;
                }

                opcaoVerificar = opcaoVerificar.trim();
                if (opcaoVerificar.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                int opcaoVerificarInt = Integer.parseInt(opcaoVerificar);

                switch (opcaoVerificarInt){

                    case 1:
                        String cpfVerify = JOptionPane.showInputDialog(null, "Digite o CPF para verificar, seguindo o modelo:\n000.000.000-00", "Verificar Cliente", JOptionPane.PLAIN_MESSAGE);

                        if (cpfVerify == null) return;
                        if (cpfVerify.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }

                        Cliente clientePesquisaCPF = clienteDAO.buscarPorCpf(cpfVerify);

                        if (clientePesquisaCPF != null){
                            JOptionPane.showMessageDialog(null, clientePesquisaCPF.toString(), "Verificar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado! Tente novamente.\nVerifique se o CPF foi digitado corretamente.", "Verificar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 2:
                        String cnhVerify = JOptionPane.showInputDialog(null, "Digite a CNH para verificar:\n", "Verificar Cliente", JOptionPane.PLAIN_MESSAGE);

                        if (cnhVerify == null) return;
                        if (cnhVerify.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }

                        Cliente pesquisaPorCNH = clienteDAO.buscarPorCnh(cnhVerify);

                        if (pesquisaPorCNH != null) {
                            JOptionPane.showMessageDialog(null, pesquisaPorCNH.toString(), "Verificar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        } else {

                            JOptionPane.showMessageDialog(null, "Cliente não encontrado pela CNH! Tente novamente.\n", "Verificar Cliente", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 0:
                        loop = 0;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        } while (loop != 0);

    }

    /// METODOS DO MENU FUNCIONARIO
    public void admissaoFuncionario(){

        int comecarAdmissao = JOptionPane.showConfirmDialog(null,"Para iniciar a admissão, certifique-se de ter esses dados em mãos:\n\n - Nome completo\n - CPF \n - Telefone \n - E-mail \n - Endereço\n\nVocê precisará atribuir um cargo e definir um salário\n\nQuer prosseguir?","Admissão de Funcionário",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (comecarAdmissao == 1 || comecarAdmissao == -1){
            return;
        }

        String nomeFuncionario = "";
        while (nomeFuncionario.trim().isEmpty()){
            nomeFuncionario = JOptionPane.showInputDialog(null, "Insira o nome completo do funcionário:", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (nomeFuncionario == null) return;
            if (nomeFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O nome não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String cpfFuncionario = "";
        while (cpfFuncionario.trim().isEmpty()){
            cpfFuncionario = JOptionPane.showInputDialog(null, "Insira o CPF do funcionário:\n Modelo: 000.000.000-00", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (cpfFuncionario == null) return;
            if (cpfFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O CPF não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);

            if (funcionarioDAO.buscarPorCpf(cpfFuncionario) != null){
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);
                cpfFuncionario = "";
            }
        }

        String telefoneFuncionario = "";
        while (telefoneFuncionario.trim().isEmpty()){
            telefoneFuncionario = JOptionPane.showInputDialog(null, "Insira o telefone do funcionário:\n Modelo: (DDD 90000-0000)", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (telefoneFuncionario == null) return;
            if (telefoneFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O telefone não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String emailFuncionario = "";
        while (emailFuncionario.trim().isEmpty()){
            emailFuncionario = JOptionPane.showInputDialog(null, "Insira o e-mail de contato do funcionário:", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (emailFuncionario == null) return;
            if (emailFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O e-mail não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String enderecoFuncionario = "";
        while (enderecoFuncionario.trim().isEmpty()){
            enderecoFuncionario = JOptionPane.showInputDialog(null, "Insira o endereço do funcionário:\n Modelo: Nome da rua, nº da casa - Nome do bairro - Nome da Cidade", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (enderecoFuncionario == null) return;
            if (enderecoFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O endereço não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String cargoFuncionario = "";
        while (cargoFuncionario.trim().isEmpty()){
            cargoFuncionario = JOptionPane.showInputDialog(null, "Insira o cargo do funcionário:", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

            if (cargoFuncionario == null) return;
            if (cargoFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O cargo não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String salarioFuncionario = "";
        double salarioFuncionarioDouble = 0;
        while (salarioFuncionario.trim().isEmpty()){
            try {
                salarioFuncionario = JOptionPane.showInputDialog(null, "Insira um valor de salário para o funcionário:", "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);

                if (salarioFuncionario == null) return;
                if (salarioFuncionario.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O salário não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);

                salarioFuncionarioDouble = Double.parseDouble(salarioFuncionario);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                salarioFuncionario = "";
            }

        }

        Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, telefoneFuncionario, emailFuncionario, enderecoFuncionario, cargoFuncionario, salarioFuncionarioDouble);
        funcionarioDAO.inserir(funcionario);

        Funcionario funcionarioCadastrado = funcionarioDAO.buscarPorCpf(cpfFuncionario);


        JOptionPane.showMessageDialog(null, "Funcionário contratado com sucesso!\n" + funcionarioCadastrado.toString(), "Admissão de Funcionário", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listarFuncionario(){
        List<Funcionario> funcionarios = funcionarioDAO.listarTodos();

        if (funcionarios.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum funcionario contratado.", "Listar Funcionários", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 0; i < funcionarios.size(); i++){
            Funcionario funcionario = funcionarios.get(i);

            if (i == funcionarios.size() - 1){
                JOptionPane.showOptionDialog(null, funcionario.toString(), "Listar Funcionários", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Fim da lista"}, "Fim da lista.");
            } else {
                JOptionPane.showOptionDialog(null, funcionario.toString(), "Listar Funcionários", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Ver próximo..."}, "Ver próximo...");
            }
        }
    }

    public void removerFuncionario(){
        List<Funcionario> funcionarios = funcionarioDAO.listarTodos();


        if (funcionarios.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum funcionário contratado.", "Remover Funcionário", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int loop = -1;

        do {
            try{
                String opcaoRemover = JOptionPane.showInputDialog(null, "Selecione como deseja remover:\n\n[1] - Remover por CPF\n[2] - Remover por matrícula\n[0] - Voltar\n\n", "Remover Funcionário", JOptionPane.PLAIN_MESSAGE);

                if (opcaoRemover == null){
                    return;
                }

                opcaoRemover = opcaoRemover.trim();
                if (opcaoRemover.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                int opcaoRemoverInt = Integer.parseInt(opcaoRemover);

                switch (opcaoRemoverInt){

                    case 1:
                        String cpfRemove = JOptionPane.showInputDialog(null, "Digite o CPF para remover, seguindo o modelo:\n000.000.000-00", "Remover Funcionário", JOptionPane.PLAIN_MESSAGE);

                        if (cpfRemove == null) return;

                        if (cpfRemove.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                            continue;
                        }

                        Funcionario removerFuncionarioCPF = funcionarioDAO.buscarPorCpf(cpfRemove);

                        if (removerFuncionarioCPF != null){
                            JOptionPane.showMessageDialog(null, "O seguinte funcionário foi removido:\n" + removerFuncionarioCPF.toString(), "Remover Funcionário", JOptionPane.INFORMATION_MESSAGE);
                            funcionarioDAO.deletarPorString(cpfRemove);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Funcionário não encontrado! Tente novamente.\nVerifique também se o CPF foi digitado corretamente.", "Remover Funcionário", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;

                    case 2:
                        String matriculaRemove = "";
                        int matriculaRemoveInt = 0;

                        try{
                            matriculaRemove = JOptionPane.showInputDialog(null, "Digite a matrícula para remover:\n", "Remover Funcionário", JOptionPane.PLAIN_MESSAGE);

                            if (matriculaRemove == null) return;

                            matriculaRemove = matriculaRemove.trim();

                            if (matriculaRemove.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Você não digitou nada!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                                continue;
                            }

                            matriculaRemoveInt = Integer.parseInt(matriculaRemove);

                            Funcionario removerFuncionarioMatricula = funcionarioDAO.buscarPorMatricula(matriculaRemoveInt);

                            if (removerFuncionarioMatricula != null){
                                JOptionPane.showMessageDialog(null, "O seguinte funcionário foi removido:\n" + removerFuncionarioMatricula.toString(), "Remover Funcionário", JOptionPane.INFORMATION_MESSAGE);
                                funcionarioDAO.deletarPorInt(matriculaRemoveInt);
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "Funcionário não encontrado! Tente novamente.\n", "Remover Funcionário", JOptionPane.INFORMATION_MESSAGE);
                            }

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }

                        break;

                    case 0:
                        loop = 0;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }

        } while (loop != 0);

    }

    /// METODOS DO MENU VEICULO
    public void cadastrarVeiculo(){

        int cadastroVeiculo = JOptionPane.showConfirmDialog(null,"Para iniciar o cadastro, certifique-se de ter esses dados do veículo em mãos:\n\n - Placa\n - Modelo\n - Marca\n - Ano \n - Cor\n\n - Você deverá criar um valor para a diária do veículo\n\nQuer prosseguir?","Cadastro de Cliente",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (cadastroVeiculo == 1 || cadastroVeiculo == -1){
            return;
        }

        String placaVeiculo = "";
        while (placaVeiculo.trim().isEmpty()){
            placaVeiculo = JOptionPane.showInputDialog(null, "Insira a placa do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (placaVeiculo == null) return;
            if (placaVeiculo.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O nome não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);

            if (veiculosDAO.buscarPorPlaca(placaVeiculo) != null){
                JOptionPane.showMessageDialog(null, "Já existe um veículo com essa placa cadastrado!", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);
                placaVeiculo = "";
            }
        }

        String modeloVeiculo = "";
        while (modeloVeiculo.trim().isEmpty()){
            modeloVeiculo = JOptionPane.showInputDialog(null, "Insira o modelo do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (modeloVeiculo == null) return;
            if (modeloVeiculo.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O modelo não pode ficar vazio!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String marcaVeiculo = "";
        while (marcaVeiculo.trim().isEmpty()){
            marcaVeiculo = JOptionPane.showInputDialog(null, "Insira a marca do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (marcaVeiculo == null) return;
            if (marcaVeiculo.trim().isEmpty()) JOptionPane.showMessageDialog(null,"A marca não pode ficar vazia!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String veiculoAno = "";
        int veiculoAnoInt = 0;
        while (veiculoAno.trim().isEmpty()) {
            try {
                veiculoAno = JOptionPane.showInputDialog(null, "Insira o ano do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

                if (veiculoAno == null) return;
                if (veiculoAno.trim().isEmpty())
                    JOptionPane.showMessageDialog(null, "O ano não pode ficar vazio!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

                veiculoAnoInt = Integer.parseInt(veiculoAno);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                veiculoAno = "";
            }
        }

        String corVeiculo = "";
        while (corVeiculo.trim().isEmpty()){
            corVeiculo = JOptionPane.showInputDialog(null, "Insira a cor do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

            if (corVeiculo == null) return;
            if (corVeiculo.trim().isEmpty()) JOptionPane.showMessageDialog(null,"A cor não pode ficar vazia!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
        }

        String veiculoDiaria = "";
        double veiculoDiariaDouble = 0;
        while (veiculoDiaria.trim().isEmpty()){
            try {
                veiculoDiaria = JOptionPane.showInputDialog(null, "Insira o valor da diária do veículo:", "Cadastrar Veículo", JOptionPane.INFORMATION_MESSAGE);

                if (veiculoDiaria == null) return;
                if (veiculoDiaria.trim().isEmpty()) JOptionPane.showMessageDialog(null,"O valor não pode ficar vazio","Atenção!",JOptionPane.INFORMATION_MESSAGE);

                veiculoDiariaDouble = Double.parseDouble(veiculoDiaria);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, tente novamente.\nErro: "+ e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                veiculoDiaria = "";
            }
        }


        Veiculo veiculo = new Veiculo(placaVeiculo, modeloVeiculo, marcaVeiculo, veiculoAnoInt, corVeiculo, veiculoDiariaDouble, "Está disponível");
        veiculosDAO.inserir(veiculo);

        JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!\n" + veiculo.toString(), "Adicionar Veículo", JOptionPane.INFORMATION_MESSAGE);

    }

    public void listarVeiculo(){
        List<Veiculo> veiculos = veiculosDAO.listarTodos();

        if (veiculos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum veículo para listar.", "Listar Frota", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 0; i < veiculos.size(); i++){
            Veiculo veiculo = veiculos.get(i);

            if (i == veiculos.size() - 1){
                JOptionPane.showOptionDialog(null, veiculo.toString(), "Listar Frota", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Fim da lista"}, "Fim da lista.");
                return;
            } else {
                JOptionPane.showOptionDialog(null, veiculo.toString(), "Listar Frota", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Ver próximo..."}, "Ver próximo...");
            }
        }
    }

    public void pesquisarVeiculo(){
        List<Veiculo> veiculos = veiculosDAO.listarTodos();

        if (veiculos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há nenhum veículo para pesquisar.", "Pesquisar por placa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String pesquisaVeiculo = JOptionPane.showInputDialog(null,"Digite exatamente a placa do veículo: \n", "Pesquisar por placa", JOptionPane.PLAIN_MESSAGE);

        if (pesquisaVeiculo == null) {
            return;
        }

        if (pesquisaVeiculo.trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Você não digitou nada!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Veiculo veiculo = veiculosDAO.buscarPorPlaca(pesquisaVeiculo.trim());

        if (veiculo != null){
            JOptionPane.showMessageDialog(null, veiculo.toString(), "Pesquisar por placa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o veículo com essa placa.", "Pesquisar por placa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
