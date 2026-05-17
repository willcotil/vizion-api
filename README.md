# VIZION API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?style=for-the-badge&logo=postgresql)

## 🚀 Sobre o Projeto
A **VIZION API** é o motor backend do ecossistema Vizion, um sistema de gestão de obras e recursos projetado para ser altamente escalável e seguro. A API utiliza uma arquitetura multi-tenant baseada em schemas, garantindo o isolamento completo de dados entre diferentes clientes (tenants).

## 🏗️ Arquitetura
O projeto segue o padrão de camadas (Layered Architecture):
- **Controllers:** Pontos de entrada REST, utilizando componentes genéricos para CRUD.
- **Facades:** Orquestração de serviços complexos e fluxos de negócio transversais.
- **Services:** Implementação das regras de negócio.
- **Repositories:** Abstração de acesso aos dados via Spring Data JPA.
- **Security:** Camada de proteção via Spring Security + JWT.

## 👥 Multi-tenancy
O sistema implementa **Multi-tenancy por Schema**.
- Cada tenant possui seu próprio schema no banco de dados PostgreSQL.
- A identificação do tenant deve ser enviada via header HTTP em cada requisição:
  - **Header:** `X-Tenant-ID`
  - **Exemplo:** `X-Tenant-ID: empresa_a`

## 🛠️ Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3+**
- **Spring Security & JWT** (Autenticação Stateless)
- **Flyway** (Gerenciamento de migrações em múltiplos schemas)
- **MapStruct** (Mapeamento performático de DTOs)
- **Lombok** (Produtividade e código limpo)
- **PostgreSQL** (Persistência robusta)

## 🏁 Como Iniciar

### Pré-requisitos
- Docker e Docker Compose
- JDK 21+
- Maven 3.9+

### Execução via Docker (Recomendado)
```bash
docker-compose up -d
```
A API estará disponível em `http://localhost:8090`.

### Execução Local (Desenvolvimento)
1. Certifique-se de que o banco de dados esteja rodando.
2. Execute o comando Maven:
```bash
./mvnw spring-boot:run
```

## 📖 Documentação da API
Com a aplicação rodando, acesse o Swagger UI para explorar os endpoints:
`http://localhost:8090/swagger-ui.html`
