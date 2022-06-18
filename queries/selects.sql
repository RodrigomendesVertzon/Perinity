/**************************************
Autor: Rodrigo Mendes Evangelista
Objetivo: Demonstra��o de resultados e vis�es
solicitada em testes
**************************************/


/**************************************************
Item 001: 
Solicita��o
- Montar select que retorne nome do departamento, 
quantidade de tarefas finalizadas e quantidade de 
tarefas n�o finalizadas
***********************************************/

Use Perinity

select 
	(select titulo from departamento d where d.id=iddepartamento)	[Departamento],
	case when finalizado = 1 then 'Tarefa Finalizada'
            when finalizado = 0 then 'Tarefa N�o Finalizada'
			end														[Status da Tarefa], 
	count(*)														[Quantidade de tarefas]
from tarefa			
group by iddepartamento, finalizado
order by 	(select titulo from departamento d where d.id=iddepartamento)

/*************Fim do Select do item 001********/


/***********************************************
Item 002: 
Solicita��o
Retornar a pessoa que mais gastou horas em janeiro de 2022
***********************************************/

/**********************************************
IMPORTANTE: se considerar apenas tarefas finalizadas
e com pessoas atribu�das a camila leva o maior tempo,
por�m caso considere tarefas atribu�das e n�o finalizadas,
o  n�o atribu�das, 
as tarefas n�o atribu�das tem o maior tempo de
forma geral.
***********************************************/

select top 1 nome, sum(duracao) [quantidade de horas]

from tarefa as t
left join pessoa as p
on t.idpessoa = p.id
group by nome
order by sum(duracao) desc

/****************************
Considerando apenas tarefas atribu�das
 e finalizadas
****************************/

select top 1 nome, sum(duracao) [quantidade de horas]

from tarefa as t
left join pessoa as p
on t.idpessoa = p.id
where nome is not null and finalizado = 1
group by nome
order by sum(duracao) desc


/****************************
Considerando apenas tarefas atribu�das
 e n�o finalizadas
****************************/

select top 1 nome, 
	sum(duracao) [quantidade de horas]
from tarefa as t
	left join pessoa as p
	on t.idpessoa = p.id
where nome is not null and finalizado = 0
	group by nome
	order by sum(duracao) desc


/************************************************

Select que retorne t�tulo da tarefa, prazo, se 
tiver pessoa alocada na tarefa exibir como �Encaminhado
para + nome do pessoa� caso contr�rio �Pendente� e total
de horas que essa pessoa j� gastou. Ordenar por 
prazo decrescente.

************************************************/

select	titulo														[Titulo da tarefa], 
		FORMAT( prazo, 'd', 'pt-br' )								[Prazo de entrega],

	case when t.idpessoa is null then 'Pendente'
            else 'Encaminhado para ' + p.nome
			end														[Status da Tarefa],
duracao																[quantidade de horas]

from tarefa as t

left join pessoa as p
on t.idpessoa = p.id
order by prazo
