/**************************************
Autor: Rodrigo Mendes Evangelista
Objetivo: inser��o de dados de testes em 
testes finais de processo seletivo
**************************************/ 

use Perinity 

-- inser��o de departamentos ******
insert departamento (titulo) values ('Financeiro')
insert departamento (titulo) values ('Comercial')
insert departamento (titulo) values ('Desenvolvimento')

-- inser��o de pessoas ************
insert pessoa ( nome, idDepartamento) values ( 'Camila',1)
insert pessoa ( nome, idDepartamento) values ( 'Pedro',2)
insert pessoa ( nome, idDepartamento) values ( 'Fabiano',3)
insert pessoa ( nome, idDepartamento) values ( 'Raquel',3)
insert pessoa ( nome, idDepartamento) values ( 'Patricia',3)
insert pessoa ( nome, idDepartamento) values ( 'Joaquim',1)

--inser��o de tarefas**************
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Validar NF Janeiro','Validar notas recebidas no m�s de Janeiro','2022-02-15',1,14,1,1)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Bug 352','Corrigir bug 352 na vers�o 1.25','2022-05-10',3,25,null,0)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Libera��o da vers�o 1.24','Disponibilizar pacote para testes','2022-02-02',3,2,3,0)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Reuni�o A','Reuni�o com cliente A para apresenta��o do produto','2022-02-05',2,5,null,0)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Reuni�o final','Fechamento contrato','2022-03-28',2,6,null,0)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Pagamento 01/2022','Realizar pagamento dos fornecedores','2022-01-31',1,6,1,1)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Bug 401','Corrigir bug 401 na vers�o 1.20','2022-02-01',3,2,4,1)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Bug 399','Corrigir bug 399 na vers�o 1.20','2022-01-28',3,6,5,1)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Reuni�o B','Reuni�o com cliente B para apresenta��o do produto','2022-01-31',2,5,2,1)
insert tarefa (titulo, descricao, prazo, idDepartamento, duracao, idPessoa, Finalizado) values ('Validar NF Fevereiro','Validar notas recebidas no m�s de Fevereiro','2022-03-15',1,14,6,0)