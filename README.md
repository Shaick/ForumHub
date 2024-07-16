## ForumHub - Challenge Back End - OracleNextOne/Alura

<P>API REST desenvolvida com Spring Boot, permite o gerenciamento de tópicos, incluindo funcionalidades de autenticação de usuários.

Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos.
</P>

### A API se concentrará especificamente nos tópicos, e deve permitir aos usuários:

* Mostrar todos os tópicos criados;
* Mostrar um tópico específico;
* Atualizar um tópico;
* Eliminar um tópico.

#### CRUD (CREATE, READ, UPDATE, DELETE)

### Funcionalidades Principais:
* Listagem de tópicos
* Detalhamento de tópicos
* Criação, atualização e exclusão de tópicos
* Autenticação de usuários

## Tecnologias
<ul>
<li>Java 17v</li>
<li>Spring Boot 2.7</li>
<li>Hibernate</li>
<li>MySql</li>
<li>Maven</li>
</ul>

![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)

### Instalação
1. Clone o repositório:

<pre>
git clone https://github.com/Shaick/forumhub.git
cd forumhub
</pre>

2. Configure o banco de dados no arquivo application.properties:

<pre>
# Configurações do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/ForumHub
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configurações do Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration

# Configuração de log geral
logging.level.root=INFO
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%p] %m%n

#Não incluir stack trace em respostas de erro
server.error.include-stacktrace=never


# Configuração de log para o Hibernate (SQL)
logging.level.org.hibernate.SQL=INFO
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# /api-docs endpoint custom path
springdoc.api-docs.path=/api-docs

api.security.token.secret=${JWT_SECRET:password}
Execute o projeto:
</pre>

3. Execute o projeto:
<pre>mvn spring-boot:run</pre>

## configurando

* cloud.shaick.forumhub: Pacote principal do projeto.
- db/migration:
	 V1__Create_topics_table.sql
	 
	 V2__Create_usuarios_table.sql

#### V1__Create_topics_table.sql
<pre>
# Criando tabela topics
-- V1__Create_topics_table.sql
CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL
);
</pre>

#### V2__Create_usuarios_table.sql
<pre>
# Criando tabela usuarios
-- V1__Create_topics_table.sql
CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL
);
</pre>

## LinkedIn 
![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white) [LinkedIn Wilson Cardoso: Shaick](https://www.linkedin.com/in/shaick/)

## Youtube
![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white) [Meu Canal](https://www.youtube.com/channel/UCkmng9THj4jMxrk8963ZxLg)

![Badge-Spring](https://github.com/user-attachments/assets/1bb5f044-ee17-4133-94bf-71bb1390894a)



