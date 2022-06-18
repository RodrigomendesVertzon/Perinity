/**************************************
Autor: Rodrigo Mendes Evangelista
Objetivo: Cria��o de tabelas e constraints para
projeto de teste final de processo seletivo
**************************************/

-- Cria��o de tabela de departamentos
create table departamento
( 
	id int identity, 
	titulo varchar(50), 
	
	CONSTRAINT PK_departamento PRIMARY KEY (id)
)
go

-- Cria��o de tabela de pessoas
create table pessoa 
(	id int identity, 
	nome varchar(70),
	idDepartamento int,
	
	CONSTRAINT PK_pessoa PRIMARY KEY (id),
	CONSTRAINT FK_PessoaDepartamento FOREIGN KEY (idDepartamento)
	REFERENCES departamento(id)
)


--cria��o de tabela de tarefas
create table tarefa
(	id int identity, 
	titulo varchar(200),
	descricao varchar(2000),
	prazo datetime, 
	idDepartamento int, 
	duracao int, 
	idPessoa int,
	finalizado bit,

	CONSTRAINT PK_tarefa PRIMARY KEY (id),
	CONSTRAINT FK_TarefaDepartamento FOREIGN KEY (idDepartamento) REFERENCES departamento(id),
	CONSTRAINT FK_TarefaPessoa FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
)