# CP3

Checkpoint desenvolvido para a matéria de Java para obtenção da nota. 

## Integrantes

 - Luiza Nunes RM99768
   
 - Pamella Schimalesky RM551600

## Tecnologias

 - [Java 17](https://docs.oracle.com/en/java/javase/17/)
 - [Gradle](https://gradle.org/)
 - [Spring Boot 3.2.5](https://spring.io/projects/spring-boot)
 - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
 - [Spring Web Starter](https://docs.spring.io/spring-boot/reference/web/index.html)
 - [Spring Validation Starter](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
 - [Spring HATEOAS](https://docs.spring.io/spring-hateoas/docs/current/reference/html/)
 - [Springdoc OpenAPI + Swagger](https://springdoc.org/)
 - [H2 Database](http://h2database.com/html/main.html)
 - [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
 - [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

 - [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
 - [Postman](https://www.postman.com/)
   
## API Reference

#### Obter todas as maquiagens (findAll maquiagemDTO)

```http
  GET /maquiagens
```

#### Obter maquiagem por id (findById maquiagemDTO)

```http
  GET /maquiagens/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da maquiagem a ser buscada |

#### Salvar maquiagem (save)

```http
  POST /maquiagens
```

Body:

```json
{
    "nome": "Delineador",
    "marca": "Rare beauty",
    "categoria": "Olhos",
    "crueltyFree": "True",
    "preco":"150"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome da maquiagem a ser salva  |
| `marca`   | `String` | Nome da marca da maquiagem a ser salva |
| `categoria`   | `String` | Categoria da maquiagem a ser salva  |
| `crueltyFree`   | `Boolean` | Informação se a marca testa ou não em animais a ser salva  |
| `preco`   | `Double` | Preço da maquiagem a ser salva  |


#### Atualizar maquiagem (update)

```http
  PUT /maquiagens/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da maquiagem a ser atualizada |

Body:

```json
{
    "nome": "Delineador",
    "marca": "Rare beauty",
    "categoria": "Olhos",
    "crueltyFree": "True",
    "preco":"150"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome da maquiagem a ser salva  |
| `marca`   | `String` | Nome da marca da maquiagem a ser salva |
| `categoria`   | `String` | Categoria da maquiagem a ser salva  |
| `crueltyFree`   | `Boolean` | Informação se a marca testa ou não em animais a ser salva  |
| `preco`   | `Double` | Preço da maquiagem a ser salva  |

#### Excluir maquiagem (delete)

```http
  DELETE /maquiagens/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da maquiagem a ser excluída |
