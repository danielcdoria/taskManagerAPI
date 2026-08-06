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

## Como Rodar o Projeto

### Pré-requisitos

- Java 17+
- Docker Desktop

### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/danielcdoria/taskManagerAPI.git
cd taskManagerAPI
```

**2. Suba o banco de dados**
```bash
docker compose up -d
```

**3. Execute a aplicação**

Abra o projeto no IntelliJ IDEA e execute o arquivo `TaskManagerApiApplication.java`.

A API estará disponível em `http://localhost:8080`

---

## Endpoints

### Projetos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/projects` | Lista todos os projetos |
| POST | `/projects` | Cria um novo projeto |
| GET | `/projects/{id}` | Busca projeto por ID |
| GET | `/projects/{id}/details` | Busca projeto com suas tarefas |
| PUT | `/projects/{id}/activate` | Ativa um projeto |
| PUT | `/projects/{id}/deactivate` | Desativa um projeto |
| DELETE | `/projects/{id}` | Remove um projeto |

**Criar projeto — body da requisição:**
```json
{
  "name": "Meu Projeto",
  "description": "Descrição do projeto",
  "deadline": "2025-12-31"
}
```

### Tarefas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/tasks` | Lista todas as tarefas |
| POST | `/tasks` | Cria uma nova tarefa |
| GET | `/tasks/{id}` | Busca tarefa por ID |
| PUT | `/tasks/{id}/activate` | Ativa uma tarefa |
| PUT | `/tasks/{id}/deactivate` | Desativa uma tarefa |
| DELETE | `/tasks/{id}` | Remove uma tarefa |
| PUT | `/tasks/{id}/start` | Inicia uma tarefa (PENDING → IN_PROGRESS) |
| PUT | `/tasks/{id}/complete` | Conclui uma tarefa (IN_PROGRESS → DONE) |
| GET | `/tasks/project/{id}` | Lista tarefas por projeto |
| GET | `/tasks/active?active=true` | Filtra por status ativo |
| GET | `/tasks/status?status=PENDING` | Filtra por status |
| GET | `/tasks/priority?priority=HIGH` | Filtra por prioridade |
| GET | `/tasks/deadline?deadline=2025-12-31` | Filtra por prazo |

**Criar tarefa — body da requisição:**
```json
{
  "title": "Implementar login",
  "description": "Criar autenticação JWT",
  "priority": "HIGH",
  "projectId": 1
}
```

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
