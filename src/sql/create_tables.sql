-- =============================================
-- 1. Tabela de Clientes
-- =============================================
DROP TABLE IF EXISTS public."Clientes";

CREATE TABLE IF NOT EXISTS public."Clientes"
(
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cpf character varying(11) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(13) COLLATE pg_catalog."default" NOT NULL,
    email character varying(60) COLLATE pg_catalog."default" NOT NULL,
    endereco character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cnh_registro character varying(11) COLLATE pg_catalog."default" NOT NULL,
    cnh_validade date NOT NULL,
    data_cadastro timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
   
    CONSTRAINT clientes_pkey PRIMARY KEY (cpf)
);

ALTER TABLE IF EXISTS public."Clientes" OWNER to postgres;

-- =============================================
-- 2. Tabela de Funcionários
-- =============================================
DROP TABLE IF EXISTS public."Funcionarios";

CREATE TABLE IF NOT EXISTS public."Funcionarios"
(
    matricula integer NOT NULL DEFAULT nextval('funcionarios_matricula_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cpf character varying(14) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(15) COLLATE pg_catalog."default" NOT NULL,
    email character varying(60) COLLATE pg_catalog."default" NOT NULL,
    endereco character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cargo character varying(50) COLLATE pg_catalog."default" NOT NULL,
    salario numeric(10,2) NOT NULL,
    data_admissao timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
   
    CONSTRAINT funcionarios_pkey PRIMARY KEY (matricula),
    CONSTRAINT funcionarios_cpf_key UNIQUE (cpf)
);

ALTER TABLE IF EXISTS public."Funcionarios" OWNER to postgres;

-- =============================================
-- 3. Tabela de Veículos
-- =============================================
DROP TABLE IF EXISTS public."Veiculos";

CREATE TABLE IF NOT EXISTS public."Veiculos"
(
    placa character varying(7) COLLATE pg_catalog."default" NOT NULL,
    modelo character varying(60) COLLATE pg_catalog."default" NOT NULL,
    marca character varying(30) COLLATE pg_catalog."default" NOT NULL,
    ano integer NOT NULL,
    cor character varying(25) COLLATE pg_catalog."default" NOT NULL,
    valor_diaria numeric(10,2) NOT NULL,
    disponibilidade boolean DEFAULT true,
   
    CONSTRAINT veiculos_pkey PRIMARY KEY (placa)
);

ALTER TABLE IF EXISTS public."Veiculos" OWNER to postgres;

-- =============================================
-- 4. Tabela de Aluguéis
-- =============================================
DROP TABLE IF EXISTS public."Alugueis";

CREATE TABLE IF NOT EXISTS public."Alugueis"
(
    id integer NOT NULL DEFAULT nextval('"Alugueis_id_seq"'::regclass),
    cpf_cliente character varying(11) COLLATE pg_catalog."default",
    placa_veiculo character varying(7) COLLATE pg_catalog."default",
    data_inicio timestamp without time zone DEFAULT now(),
    data_devolucao date,
    valor_total numeric(10,2),
    status character varying(20) COLLATE pg_catalog."default" DEFAULT 'ativo',
   
    CONSTRAINT "Alugueis_pkey" PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public."Alugueis" OWNER to postgres;

-- =============================================
-- Comentário do Banco
-- =============================================
COMMENT ON DATABASE locadora IS 'Banco de dados do Projeto Locadora - SGBD Unifacisa';