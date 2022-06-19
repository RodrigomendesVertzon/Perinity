/**************************************
Autor: Rodrigo Mendes Evangelista
Objetivo: inserção de dados de testes em 
testes finais de processo seletivo
**************************************/ 

use Perinity 

-- inserção de departamentos ******
insert departamento (titulo) values ('Financeiro')
insert departamento (titulo) values ('Comercial')
insert departamento (titulo) values ('Desenvolvimento')

-- inserção de pessoas ************
insert pessoa ( nome, id_departamento) values ( 'Camila',1)
insert pessoa ( nome, id_departamento) values ( 'Pedro',2)
insert pessoa ( nome, id_departamento) values ( 'Fabiano',3)
insert pessoa ( nome, id_departamento) values ( 'Raquel',3)
insert pessoa ( nome, id_departamento) values ( 'Patricia',3)
insert pessoa ( nome, id_departamento) values ( 'Joaquim',1)

--inserção de tarefas**************
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Validar NF Janeiro','Validar notas recebidas no mês de Janeiro','2022-02-15',1,14,1,1)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Bug 352','Corrigir bug 352 na versão 1.25','2022-05-10',3,25,null,0)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Liberação da versão 1.24','Disponibilizar pacote para testes','2022-02-02',3,2,3,0)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Reunião A','Reunião com cliente A para apresentação do produto','2022-02-05',2,5,null,0)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Reunião final','Fechamento contrato','2022-03-28',2,6,null,0)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Pagamento 01/2022','Realizar pagamento dos fornecedores','2022-01-31',1,6,1,1)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Bug 401','Corrigir bug 401 na versão 1.20','2022-02-01',3,2,4,1)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Bug 399','Corrigir bug 399 na versão 1.20','2022-01-28',3,6,5,1)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Reunião B','Reunião com cliente B para apresentação do produto','2022-01-31',2,5,2,1)
insert tarefa (titulo, descricao, prazo, id_departamento, duracao, id_pessoa, Finalizado) values ('Validar NF Fevereiro','Validar notas recebidas no mês de Fevereiro','2022-03-15',1,14,6,0)