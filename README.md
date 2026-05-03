# 🐾 Sossego Pet Shop — Sistema de Gestão

Sistema completo de gerenciamento para pet shop, desenvolvido com Java/Spring Boot no backend, frontend em HTML/CSS/JS puro e banco de dados PostgreSQL. **Projeto em uso real** por um pet shop em São Paulo.

---

## 📋 Funcionalidades

- **Cadastro de clientes e pets** — suporte a múltiplos pets por dono (relacionamento ManyToOne)
- **Agendamento de serviços** — banho, tosa, banho & tosa, tosa higiênica
- **Fila de trabalho** — visualização e gerenciamento dos atendimentos do dia
- **Gestão de clientes** — busca por WhatsApp, edição de dados de dono e pets
- **Notificação via WhatsApp** — ao finalizar atendimento, abre link direto com mensagem pro cliente
- **Controle de entrega** — flag para serviços com busca e entrega do pet

---

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Backend | Java 21 + Spring Boot |
| Banco de dados | PostgreSQL 18 |
| Frontend | HTML5 / CSS3 / JavaScript |
| Servidor web | Nginx (proxy reverso) |
| Containerização | Docker + Docker Compose |

---

## 🏗️ Arquitetura

```
┌─────────────────────────────────────────┐
│              Docker Compose             │
│                                         │
│  ┌──────────┐    ┌──────────────────┐   │
│  │  Nginx   │───▶│  Spring Boot     │   │
│  │ :80      │    │  :8080           │   │
│  │ (front)  │    │  (backend/API)   │   │
│  └──────────┘    └────────┬─────────┘   │
│                           │             │
│                  ┌────────▼─────────┐   │
│                  │   PostgreSQL 18  │   │
│                  │   :5432          │   │
│                  └──────────────────┘   │
└─────────────────────────────────────────┘
```

O Nginx atua como proxy reverso: serve o frontend e encaminha chamadas `/api/*` para o backend Spring Boot. Os três serviços se comunicam na mesma rede Docker interna.

---

## 🚀 Como rodar localmente

**Pré-requisitos:** Docker e Docker Compose instalados.

```bash
# Clone o repositório
git clone https://github.com/Henriquesilvadev07/SossegoPetShop.git
cd SossegoPetShop

# Sobe todos os serviços
docker compose up --build
```

Acesse em: **http://localhost**

> Na primeira execução o build demora alguns minutos pois baixa as dependências do Maven. As execuções seguintes são significativamente mais rápidas por conta do cache de camadas do Docker.

---

## 📁 Estrutura do projeto

```
SossegoPetShop/
├── src/
│   └── main/
│       └── java/
│           └── com/sossegopet/
│               ├── controller/     # Endpoints REST
│               ├── service/        # Regras de negócio
│               ├── repository/     # Acesso ao banco (JPA)
│               ├── model/          # Entidades
│               └── dto/            # Objetos de transferência
├── nginx/
│   ├── index.html                  # Frontend
│   └── nginx.conf                  # Configuração proxy reverso
├── Dockerfile                      # Build multistage da aplicação
└── docker-compose.yaml             # Orquestração dos serviços
```

---

## 🔌 Endpoints principais

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/clientes` | Cadastrar novo cliente |
| GET | `/clientes` | Listar todos os clientes |
| GET | `/clientes/buscar-por-telefone/{tel}` | Buscar cliente por WhatsApp |
| PUT | `/clientes/{id}` | Atualizar dados do cliente |
| POST | `/animais` | Cadastrar pet |
| GET | `/animais` | Listar todos os pets |
| PUT | `/animais/{id}` | Atualizar pet |
| POST | `/agendamentos` | Criar agendamento |
| GET | `/agendamentos` | Listar fila de atendimentos |
| DELETE | `/agendamentos/{id}` | Finalizar atendimento + retorna link WhatsApp |

---

## 💡 Decisões técnicas

- **Proxy reverso com Nginx** — o frontend faz chamadas para `/api` e o Nginx encaminha para o backend, evitando problemas de CORS e centralizando o acesso por uma única porta
- **Named volume no Docker** — dados do banco persistem entre reinicializações sem depender de permissões de pasta no sistema operacional host
- **Build multistage no Dockerfile** — separação entre estágio de build (Maven) e estágio de runtime (JRE), reduzindo o tamanho final da imagem
- **Cache de dependências Maven** — o `pom.xml` é copiado antes do código-fonte para que o Docker reutilize a camada de dependências quando apenas o código muda

---

## 👨‍💻 Autor

**Henrique Silva**
- GitHub: [@Henriquesilvadev07](https://github.com/Henriquesilvadev07)
- LinkedIn: [henrique-silva-de-carvalho](https://www.linkedin.com/in/henrique-silva-de-carvalho-9a15b2356)
