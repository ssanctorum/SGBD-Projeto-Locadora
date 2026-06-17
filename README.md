# SGBD - Projeto Locadora de Veículos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Unifacisa](https://img.shields.io/badge/Unifacisa-2026-blue?style=for-the-badge)

Sistema de Locadora de Veículos desenvolvido em **Java** com **Banco de Dados PostgreSQL**, aplicando conceitos de **Sistemas de Gerenciamento de Banco de Dados (SGBD)**.

Projeto Integrador do curso de **Análise e Desenvolvimento de Sistemas (ADS)** - Unifacisa.

---

## Sobre o Projeto

Este projeto é uma evolução do sistema de locadora anterior, agora com **persistência real em banco de dados**. Utiliza o padrão **MVC** (Model-View-Controller) + **DAO** (Data Access Object) para melhor organização e manutenção do código.

---

## Funcionalidades

- Cadastro, edição e exclusão de Clientes, Funcionários e Veículos
- Sistema completo de Aluguel e Devolução de veículos
- Listagem e pesquisa de registros
- Conexão com PostgreSQL via JDBC
- Validações e tratamento de exceções

---

## Tecnologias Utilizadas

- **Java** (JDK 17+)
- **PostgreSQL**
- **JDBC**
- Padrão **MVC + DAO**
- Programação Orientada a Objetos (POO)

---

## Estrutura do Projeto

```bash
src/
├── controller/          # Controladores (lógica de negócio)
│   └── Metodos.java
├── dao/                 # Camada de acesso a dados
│   ├── Conexao.java
│   ├── ClienteDAO.java
│   ├── FuncionarioDAO.java
│   ├── VeiculoDAO.java
│   └── AluguelDAO.java
├── model/               # Entidades do sistema
│   ├── Pessoa.java
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Veiculo.java
│   └── Aluguel.java
└── view/                # Interfaces com o usuário
│   ├── Layouts_JOptionPane.java
|   └── Menu.java
```

Como Executar
1. Configurar o Banco de Dados

- Instale e rode o PostgreSQL (recomendado usar pgAdmin)
- Crie o banco de dados:
  ```
  SQLCREATE DATABASE locadora;
  ```
Execute o script de criação das tabelas:
Abra o arquivo ```sql/create_tables.sql``` e rode todos os comandos.


2. Rodar o Projeto
Clone o repositório:
```
git clone https://github.com/ssanctorum/SGBD-Projeto-Locadora.git
```

# Importe o projeto no IntelliJ, Eclipse ou VS Code

# Atualize as credenciais de conexão no arquivo:
# src/dao/Conexao.java (usuário, senha, porta e nome do banco)

# Execute a classe principal 
```Menu.java```
