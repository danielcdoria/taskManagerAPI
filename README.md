# Task Manager API

API RESTful para gerenciamento de projetos e tarefas, desenvolvida com Java e Spring Boot.

## Tecnologias

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-ready-blue)

## Funcionalidades

- CRUD completo de Projetos e Tarefas
- Fluxo de status da tarefa: `PENDING → IN_PROGRESS → DONE`
- Regra de negócio: tarefas só podem ser criadas em projetos ativos
- Filtros de tarefas por status, prioridade e prazo
- Tratamento global de erros com mensagens claras
- Banco de dados PostgreSQL rodando via Docker

---

## Regras de Negócio

- Uma tarefa só pode ser criada em um **projeto ativo**
- O status da tarefa segue um fluxo obrigatório: `PENDING → IN_PROGRESS → DONE`
- Uma tarefa só pode ser iniciada se seu status for `PENDING`
- Uma tarefa só pode ser concluída se seu status for `IN_PROGRESS`

---

## Estrutura do Projeto

```
src/
└── main/
    └── java/
        └── com/example/taskManagerAPI/
            ├── controllers/     # Endpoints REST
            ├── service/         # Regras de negócio
            ├── repositories/    # Acesso ao banco de dados
            ├── models/          # Entidades (Project, Task)
            ├── dtos/            # Objetos de transferência de dados
            └── erro/            # Tratamento global de erros
```

---

## Autor

**Daniel Doria** — [github.com/danielcdoria](https://github.com/danielcdoria)
