# API construída para o teste da empresa Perinity

- Adicionar uma pessoa (post/pessoas) 

- Alterar uma pessoa (put/pessoas/{id})

- Remover pessoa (delete/pessoas/{id})

- Adicionar um tarefa (post/tarefas)

- Alocar uma pessoa na tarefa que tenha o mesmo departamento (put/tarefas/alocar/{id}) (param: idPessoa: {id})

- Finalizar a tarefa (put/tarefas/finalizar/{id})

- Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.(get/pessoas)

- Buscar pessoas por nome e período, retorna média de horas gastas por tarefa. (get/pessoas/gastos)

- Listar 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos. (get/tarefas/pendentes)

- Listar departamento e quantidade de pessoas e tarefas (get/departamentos)

