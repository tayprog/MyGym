# MyGym 🏋️‍♀️

Sistema web para uma academia fictícia, desenvolvido como projeto acadêmico. O projeto reúne um site público, uma área administrativa e uma API em Java com Spring Boot para persistência de dados em banco H2.

## 📌 Sobre o projeto

O **MyGym** permite apresentar informações de uma academia, exibir planos e serviços, receber mensagens de contato e registrar solicitações de matrícula. O front-end foi desenvolvido com **HTML, CSS e JavaScript puro**, enquanto o back-end utiliza **Spring Boot**, **Spring MVC**, **Spring Data JPA** e **H2 Database**.

O back-end também serve os arquivos estáticos do front-end, que ficam em `src/main/resources/static`.

## ✨ Funcionalidades

### Área pública

- Página inicial institucional da academia.
- Página de planos com cards dinâmicos.
- Página de serviços/modalidades.
- Página de contato com envio de mensagem para a API.
- Modal de detalhes dos planos.
- Formulário de solicitação de matrícula.
- Seleção de modalidades adicionais.
- Layout responsivo com CSS próprio.

### Área administrativa

- Login simples de administrador.
- Dashboard com informações do sistema.
- Cadastro, edição e exclusão de serviços adicionais.
- Edição de planos.
- Visualização de solicitações de matrícula.
- Alteração de status das solicitações.
- Exclusão de solicitações.
- Exportação de solicitações em CSV.

> Observação: o projeto possui API REST para persistir planos, serviços, contatos e solicitações no H2. O arquivo `admin.js` também possui rotinas com `localStorage` para algumas telas administrativas.

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Lombok
- Maven Wrapper
- HTML5
- CSS3
- JavaScript
- Font Awesome
- Google Fonts

## 📁 Estrutura do projeto

```text
Gym_back/
└── api/
    ├── data/
    │   └── mygymdb.mv.db
    ├── src/
    │   ├── main/
    │   │   ├── java/com/mygym/api/
    │   │   │   ├── controller/
    │   │   │   ├── dto/
    │   │   │   ├── model/
    │   │   │   ├── repositories/
    │   │   │   ├── service/
    │   │   │   └── ApiApplication.java
    │   │   └── resources/
    │   │       ├── application.properties
    │   │       └── static/
    │   │           ├── index.html
    │   │           ├── planos.html
    │   │           ├── servicos.html
    │   │           ├── contato.html
    │   │           ├── login.html
    │   │           ├── admin.html
    │   │           ├── *.css
    │   │           ├── *.js
    │   │           └── img/
    │   └── test/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, instale:

- JDK 21 ou superior.
- Git, caso queira clonar o repositório.
- Maven não precisa ser instalado manualmente, pois o projeto possui Maven Wrapper.

### 1. Acesse a pasta da aplicação

```bash
cd Gym_back/api
```

### 2. Dê permissão ao Maven Wrapper, se estiver no Linux/macOS

```bash
chmod +x mvnw
```

### 3. Execute a aplicação

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

### 4. Acesse no navegador

```text
http://localhost:8080
```

Também é possível acessar as páginas diretamente:

```text
http://localhost:8080/index.html
http://localhost:8080/planos.html
http://localhost:8080/servicos.html
http://localhost:8080/contato.html
http://localhost:8080/login.html
http://localhost:8080/admin.html
```

## 🔐 Acesso administrativo

O login administrativo está configurado de forma simples no `AuthController`, apenas para fins acadêmicos/desenvolvimento.

```text
Usuário: admin
Senha: 1234
```

Após o login, o sistema salva uma flag em `sessionStorage` e redireciona para `admin.html`.

> Para uso em produção, substitua esse login fixo por autenticação real, com usuários no banco de dados, senha criptografada e controle de sessão/token seguro.

## 🗄️ Banco de dados

O projeto utiliza banco **H2 em arquivo**, configurado em `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:h2:file:./data/mygymdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

O banco fica salvo em:

```text
data/mygymdb.mv.db
```

### Console H2

Com a aplicação rodando, acesse:

```text
http://localhost:8080/h2-console
```

Use os dados:

```text
JDBC URL: jdbc:h2:file:./data/mygymdb
User Name: sa
Password: deixe em branco
```

## 🔌 Endpoints da API

Base URL:

```text
http://localhost:8080/api
```

### Autenticação

| Método | Rota | Descrição |
|---|---|---|
| POST | `/api/auth/login` | Realiza login administrativo simples. |

Exemplo de requisição:

```json
{
  "usuario": "admin",
  "senha": "1234"
}
```

Resposta de sucesso:

```json
{
  "token": "fake-jwt-token"
}
```

### Planos

| Método | Rota | Descrição |
|---|---|---|
| GET | `/api/planos` | Lista todos os planos cadastrados. |
| POST | `/api/planos` | Cria ou atualiza um plano. |

Exemplo de corpo para criar/atualizar plano:

```json
{
  "id": 1,
  "nome": "Premium",
  "preco": 99.0,
  "descricao": "Plano com musculação, cardio e aulas em grupo.",
  "beneficios": [
    "Acesso à musculação",
    "Área de cardio completa",
    "Aulas em grupo"
  ]
}
```

### Serviços

| Método | Rota | Descrição |
|---|---|---|
| GET | `/api/servicos` | Lista todos os serviços adicionais. |
| POST | `/api/servicos` | Cria ou atualiza um serviço. |
| DELETE | `/api/servicos/{id}` | Remove um serviço pelo ID. |

Exemplo de corpo para criar/atualizar serviço:

```json
{
  "nome": "Natação",
  "imagem": "img/natacao.jpg",
  "icone": "fa-solid fa-person-swimming",
  "preco": 69.0,
  "descricao": "Atividade completa para resistência e fortalecimento muscular."
}
```

### Contato

| Método | Rota | Descrição |
|---|---|---|
| POST | `/api/contato` | Salva uma mensagem enviada pelo formulário de contato. |

Exemplo de corpo:

```json
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "telefone": "11999999999",
  "assunto": "Informações sobre planos",
  "mensagem": "Gostaria de saber mais sobre os planos disponíveis."
}
```

### Solicitações de matrícula

| Método | Rota | Descrição |
|---|---|---|
| GET | `/api/solicitacoes` | Lista todas as solicitações. |
| POST | `/api/solicitacoes` | Cria uma nova solicitação de matrícula. |
| PUT | `/api/solicitacoes/{id}/status` | Altera o status da solicitação. |
| DELETE | `/api/solicitacoes/{id}` | Remove uma solicitação pelo ID. |

Exemplo de corpo para criar solicitação:

```json
{
  "nome": "João Pereira",
  "telefone": "11988887777",
  "email": "joao@email.com",
  "plano": "Premium",
  "horario": "Noite",
  "modalidadesExtras": "Natação • Jiu-Jitsu",
  "observacao": "Prefiro contato por WhatsApp."
}
```

O status inicial é definido como:

```text
Pendente
```

Ao chamar `PUT /api/solicitacoes/{id}/status`, o status segue o fluxo:

```text
Pendente → Contatado → Matriculado
```

## 🧪 Testes

Para executar os testes automatizados:

```bash
./mvnw test
```

No Windows:

```bash
mvnw.cmd test
```

## 🎨 Identidade visual

A interface utiliza uma estética fitness moderna, com:

- Fundo escuro.
- Tons de laranja.
- Cards com bordas arredondadas.
- Gradientes.
- Sombras e efeitos visuais.
- Layout responsivo.
- Tipografia forte para títulos.

## ⚠️ Observações importantes

- O login atual é fixo no código e deve ser usado apenas em ambiente acadêmico ou de desenvolvimento.
- O banco H2 em arquivo é prático para testes, mas pode ser substituído por PostgreSQL, MySQL ou outro banco em produção.
- O CORS está liberado com `@CrossOrigin("*")`, o que facilita o desenvolvimento, mas deve ser restringido em produção.
- Arquivos gerados como `target/` não precisam ser versionados.
- O banco local em `data/mygymdb.mv.db` pode conter dados de teste; avalie se ele deve ser versionado no repositório.

## 👩‍💻 Autoria

Projeto desenvolvido para fins acadêmicos.
Taynara Ribeiro de Souza - 202508229366
Ana Beatriz Barros - 202508318679
Lyndemberg dos Santos - 202203797182
Carlos Eduardo Alves -202504480081
Luiz Eduardo da Paz - 202203908952

## 📄 Licença

Este projeto ainda não possui uma licença definida. Antes de publicar ou distribuir, adicione uma licença adequada ao repositório.