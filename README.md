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

Além disso também será necessário configurar o banco de dados para realização dos testes, onde suas variáveis também serão colocadas no `.env`, as referenciando nas propriedades do seu sistema (*TODO*):

```yml
spring:
  application:
    datasource:
      username: ${USERNAME}
      password: ${PASSWORD}
      url: ${URL}
...
```

OBS: *public_key* no código é equivalente ao *integrator_id*

## Enpoints

Para toda a comunicação com a API será mantido o padrão da V1 sendo: `dominio/api/v1` e para cada função sistemica e controllers diferentes sua nomenclatura mudará, portanto será divididos em submódulos os endpoint a fim de diferenciar os controllers

### Módulos

* [PaymentMethodsController](#paymentmethodscontroller)

#### PaymentMethodsController

Esta requisição faz com que o pagamento seja realizado, possuindo como paramêtro um pagador (junto ao seu endereço), um ou mais produtos e meios de pagamento, seguindo o body (Todos campos obrigatórios): 

```json
{
  "paymentMethod" : {
    "flag" : "pix",
    "divideBy" : "1"
  },
  "products" : [
    {
      "title" : "Computador",
      "description" : "Computador para teste",
      "pictureURL" : "https://example.com",
      "categoryId" : "Informática",
      "quantity" : 1,
      "unitPrice" : 3599.99
    }
  ],
  "user" : {
    "firstName" : "Pablo",
    "lastName" : "Silva",
    "ddd" : "89",
    "phone" : "112345678"
  },
  "address": {
    "zipCode" : "1234685",
    "stateName" : "Estado",
    "cityName" : "Cidade",
    "streetName" : "Rua X",
    "streetNumber" : "123" 
  }
}
```

Retornado:

```json
(TODO)
```
