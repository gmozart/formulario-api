
# API Formulário

API para cadastro de pessoas e seus multiplos endereços, conforme foi pedido na avaliação de desenvolvedor Back-end da Attornatus. 

## Instalação

- Java 17 
- Spring 2.7.5
- Spring-boot JPA 2.7.5
- Spring-boot Validation 2.7.5
- Spring-boot Starter-web 2.7.5
- Spring-boot Devtools 2.7.5
- Spring-boot Starter-test 2.7.5
- Springdoc-openapi-ui 1.6.14
- H2 Database Engine 2.1.214
- Flywaydb 8.5.13
- Loombok 1.18.24

Comandos a serem executados:

```bash
  mvn clean install
```
```git
  git clone https://github.com/gmozart/formulario-api.git 
```





    
## Documentação

- [Documentação Swagger localhost](http://localhost:8080/swagger-ui/index.html#/)

## Métodos CRUD da aplicação.

- Save
   
   Cria uma pessoa junto ao seu endereço. 

- SaveNewEndereco

  Cria um novo endereço para uma pessoa já existente.
  
- FindById

  Retorna pessoa por seu identificador.

- FindAll

  Retorna uma lista de pessoas junto ao seu   array de endereço.


- FindAll(Pages)

  Retorna uma lista paginada de pessoas.

- Update

  Atualiza os atributos de uma pessoa.

- Delete

  Deleta uma pessoa por seu identificador.


## Referência

 - [Teste únitario de cobertura](https://www.baeldung.com/jacoco)
 - [Swagger](https://www.baeldung.com/spring-rest-openapi-documentation)
 - [Mockito](https://www.baeldung.com/mockito-annotations)
 - [Mockito JUnit5](https://www.baeldung.com/mockito-junit-5-extension)
- [Readme.so](https://readme.so/pt)


## 🚀 Sobre mim

- [Perfil Git](https://github.com/gmozart)
- [Perfil Linkedin](https://www.linkedin.com/in/gleison-mozart/)

Eu sou uma pessoa desenvolvedora back-end, formado no ano de 2021 em sistemas da informação na instituição faculdade Estácio de Sá, no campus da abdias de carvalho recife-PE. Sempre gostei de trablhar com java iniciando no java 8 em diante, assim como springboot.

