# 🧭 Rotas, Autenticação e Autorização — API Spring Boot

> Projeto desenvolvido durante o módulo **“Rotas, Autenticação e Autorização”** da trilha de **Java / Spring Boot** da [Rocketseat](https://rocketseat.com.br).

---

## 📚 Descrição do Módulo

Neste módulo aprendemos a **construir uma API REST completa** utilizando o **Spring Boot**, com foco em:

- Estruturação de rotas RESTful  
- Persistência de dados com Spring Data JPA  
- Criação de entidades e relacionamentos (Empresa, Vaga e Candidatura)  
- Autenticação e autorização com **Spring Security e JWT**  
- Boas práticas de arquitetura em APIs Java  

> 💡 Este projeto é utilizado para as aulas práticas do módulo e **não se trata do desafio final** da trilha.

---

## 🧩 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security + JWT**
- **H2 Database** (banco em memória)
- **Lombok**
- **Maven**

---

## ⚙️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/omausantos/gestaovagas/
│   │       ├── controller/      → Controladores REST
│   │       ├── model/           → Entidades (Empresa, Vaga, Candidato)
│   │       ├── repository/      → Interfaces JPA
│   │       ├── service/         → Regras de negócio
│   │       └── security/        → Configurações e filtros JWT
│   └── resources/
│       ├── application.properties
│       └── data.sql             → Dados iniciais para teste
└── test/
    └── ...
```

---

## 🚀 Executando o Projeto

### ✅ Pré-requisitos
- **Java 21+**
- **Maven 3.9+**
- (Opcional) **IntelliJ IDEA** ou **VSCode** configurado com o plugin Spring Boot

### ▶️ Rodando a aplicação
```bash
# Clonar o repositório
git clone https://github.com/SEU_USUARIO/gestao-vagas.git

# Entrar na pasta
cd gestao-vagas

# Executar o projeto
mvn spring-boot:run
```

A aplicação iniciará em:
```
http://localhost:8080
```

---

## 🔑 Endpoints Principais

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| POST | `/auth/register` | Cria um novo usuário |
| POST | `/auth/login` | Retorna token JWT |
| GET | `/empresas` | Lista todas as empresas |
| POST | `/empresas` | Cadastra uma nova empresa |
| GET | `/vagas` | Lista vagas disponíveis |
| POST | `/vagas` | Cadastra nova vaga (apenas empresa autenticada) |

> Todas as rotas protegidas exigem **Bearer Token JWT** no cabeçalho:  
> `Authorization: Bearer {token}`

---

## 🧠 Conceitos Abordados

- Criação de endpoints RESTful
- Segurança com **Spring Security e JWT**
- Autorização baseada em perfis (roles)
- Injeção de dependências com Spring
- Persistência com **JPA / Hibernate**
- Testes com banco H2

---

## 🧪 Atividades do Módulo

- **28 Aulas**
- **2 Atividades Práticas**
- **4h48min de conteúdo**

---

## ✍️ Autor

**Mauricio Santos**  
[GitHub](https://github.com/omausantos) • [LinkedIn](https://www.linkedin.com/in/omausantos)

---

## 📜 Licença

Este projeto é apenas para fins educacionais, baseado nas aulas da Rocketseat.
