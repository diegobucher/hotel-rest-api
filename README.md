## Aplicação REST realizada em Spring Boot, PostgreSQL, JPA, Hibernate

## Tutorial


## Passos para Instalação

**1. Clone o repositório**

```bash
git clone https://github.com/diegobucher/hotel-rest-api.git
```

**2. Configure o PostgreSQL**

Primeiro, crie um banco de dados chamado `hotel`. Em seguida, abra o arquivo `src/main/resources/application.properties` e altere o nome de usuário e a senha do datasource de acordo com a instalação do PostgreSQL.

**3. Execute o aplicativo**

Digite o seguinte comando no diretório raiz do projeto para executá-lo -

```bash
mvn spring-boot:run
```

Como alternativa, você pode empacotar o aplicativo na forma de um arquivo JAR e, em seguida, executá-lo da seguinte forma -

```bash
mvn clean package
java -jar target/hotel-rest-api-0.0.1-SNAPSHOT.jar
```