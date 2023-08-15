# Sobre
API com conexão ao mercado pago, feito para obtenção de certificação, utilizando-se de sua biblioteca compartilhada no gerenciador `Maven`:

```xml
<dependency>
    <groupId>com.mercadopago</groupId>
    <artifactId>sdk-java</artifactId>
    <version>2.1.12</version>
</dependency>
```

## Sumário

* [Arqutetura (PT-BR)](#arquitetura)
* [Configuração (PT-BR)](#configuração)
* [Enpoints (PT-BR)](#enpoints)

## Arquitetura

Utilização de `Kotlin` para back-end junto ao framework do `Spring Boot`, com configuração de pacotes de acorodo com o `MVC`.
Persistência de dados é utilizado um banco de dados `PostgreSql` público de *leitura* com as credenciais  *(TODO)*:

```json
{
  "url": "...",
  "username": "...",
  "password" : "..."
}
```

PS: Este banco está sendo disponibilizado apenas para meios de testes na API do mercado pago, portanto a conexão com sua API deve conter os dados necessários do seu usuário no mercado pago para que a aplicação funcione corretamente

Para a implementação da API foi utilizado a estrutura do `Git Flow`, contendo todo o histórico na aba de [*Releases*](https://github.com/pabloaugustocm17/mercado-pago-api/releases) de acordo com sua respectiva *tag*.

A hospedagem foi feita em uma máquina virtual na `AWS-EC2` a partir da conteinirização via `Docker`.

## Configuração

Para funcionamento da aplicação será necessário possuir as variáveis *access_token* e *public_key* fornecido pelo mercado pago, tais variáveis serão colocadas no `.env` de sua aplicação onde serão referenciadas nas propriedades da aplicação:

```yml
api-keys:
  access_token = ${ACCESS_TOKEN}
  public_key = ${PUBLIC_KEY}
...
```
Além disso também será necessário configurar o banco de dados para realização dos testes, onde suas variáveis também serão colocadas no `.env`, as referenciando nas propriedades do seu sistema :

```yml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create
      #em produção usar 'validate'
    database-platform: org.hibernate.dialect.PostgreSQLDialect
```

OBS: *public_key* no código é equivalente ao *integrator_id*

## Enpoints

Para toda a comunicação com a API será mantido o padrão da V1 sendo: `dominio/api/v1/` e para cada função sistemica e controllers diferentes sua nomenclatura mudará, portanto será divididos em submódulos os endpoint a fim de diferenciar os controllers

### Módulos

* [PaymentMethodsController](#paymentmethodscontroller)
* [UserController](#usercontroller)
* [ProductController](#productcontroller)

#### PaymentMethodsController

Esta requisição faz com que o pagamento seja realizado, possuindo como paramêtro um pagador (junto ao seu endereço), um ou mais produtos e meios de pagamento, seguindo o body (Todos campos obrigatórios): 

```json
{
  "paymentMethod" : {
    "flag" : "visa",
    "installments" : "1"
  },
  "products" : ["id1", "id2"],
  "user" : "idUser"
}
```

Retornado:

```json
(TODO)
```

----

#### UserController

A sua rota é: `dominio/api/v1/user/`, possuindo as funções de inserção, alteração, leitura pelo *ID* e leitura de todos, a partir dos enpoints:

----

Inserir usuário (POST) - `dominio/api/v1/user/`

```json 
{
  "user" : {
    "firstName" : "Pablo",
    "lastName" : "Teste",
    "ddd" : "89",
    "phone" : "112345678"
  },
  "address" : {
    "zipCode" : "000045689",
    "stateName" : "PE",
    "cityName" : "Cidade Y",
    "streetName" : "Rua X",
    "streetNumber" : "120"
  }
}
```

Erros possíveis: [Retorno Sucesso](#output-inserido-genérico), [Falha (Usuário existente)](#output-erro-genérico)

----

Retorna todos usuários (GET) - `dominio/api/v1/user/`


----

Retorna usuário pelo *ID* (GET) - `dominio/api/v1/user/{id}`

Erro possível: [Falha (Usuário não existe)](#output-erro-genérico)

----

#### ProductController

A sua rota é: `dominio/api/v1/products/`, possuindo as funções de inserção, alteração, leitura pelo *ID* e leitura de todos, a partir dos enpoints:

----

Inserir produto (POST) - `dominio/api/v1/products/`

```json
{
  "title" : "TV",
  "description" : "50 polegadas",
  "pictureURL" : "https://example.com",
  "categoryId" : "Eletrônicos",
  "quantity" : 10,
  "unitPrice" : 1999.99
}
```
----

Retorna todos produtos (GET) - `dominio/api/v1/products/`

----

Retorna produto pelo *ID* (GET) - `dominio/api/v1/products/{id}`

Erro possível: [Falha (Usuário não existe)](#output-erro-genérico)

----


### Outputs

#### Output Inserido Genérico

```json
{
  "mensagem": "Objeto inserido com sucesso",
  "id": "1f84b9e8-bbef-49d6-9ddd-3f883b84cc0c"
}
```

#### Output erro genérico

{objeto} = Qualquer objeto prensente na pasta de models, por exemplo Usuário, Produto...

```json
{
  "mensagem": "..."
}
```
