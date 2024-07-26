# schedule Votation

###### Abaixo os autores do projeto

Nome: Henrique Ferreira Ferro

Nome: Guilherme Pinheiro (Mentor)

### Sistema para agendar votação

Iniciou-se a construção de um sistema com a linguagem Java com o objetivo de dominar os conceitos de Programação Orientada a Objetos (POO) e Spring Boot de maneira direta e prática. Abaixo, segue a especificação do que foi realizado até o momento e o que está planejado, juntamente com as tecnologias e ferramentas empregadas durante o desenvolvimento.

A pauta para agendar votação se faz presente em assembleias e decisões importantes e para tanto foi observado as necessidades e regras de negocio que circundam esse meio para a construção do sistema. 

Entidades que foram observadas:

**Usuario**

**Pauta** 

**Votação**
---
Funcionalidades presentes:

:dart: PAUTA

- Funcionalidade para cadastrar uma pauta de votação.

- Funcionalidade para buscar uma pauta de votação.

:dart: USUARIO
 
- Funcionalidade para cadastrar um usuário.

- Funcionalidade para buscar um usuário.

- Funcionalidade para listar todos usuários.

 :dart: VOTO
 
- Funcionalidade para cadastrar um voto.

- Funcionalidade para buscar um voto.

- Funcionalidade para buscar o resultado de votação da pauta.

#### Regras de négocio

Após criar a pauta, devemos criar uma sessão para essa pauta, essa sessão ficará aberta para os usuários votarem em até 1 minuto.
Se o usuário não inserir um prazo para a pauta, devemos inserir automaticamente o mesmo(lembrando que o prazo tem que ser um minuto por default).
Usuários não podem votar mais de uma vez.
Os votos dos associados serão Sim/Não.
Cada usuário, pauta, voto serão identificados por um id único.

#### Tecnologias empregadas 

Para a criação de um sistema robusto e moderno que atenda as demandas do mercado foram empregadas as seguintes tecnologias: Java, Spring boot, JPA, Banco de dados temporario H2, Postgresql, Html, css, javaScript e Postman

#### Detalhes das requisições e teste da API

Para realizar o teste e uso da aplicação se faz necessario uma tecnologia que posso entrar em contato com a Api no backend, sendo essa o Postman. Abaixo se encontra os detalhes das requisições em cada cenario apresentado

**Nota:** O testes foram realizados no Postman, mas não significa que não é possivel de ser feito em um navegador, entretanto não será abordado nesse guia, assim espera-se que o usuario final tenha ciência disso e realize a instalação da ferramenta no site oficial clicando [aqui](https://www.postman.com/downloads/) para acessar à página do postman.

## Requisições referentes ao Usuario

- Requisição para listar todos os usuarios:


![image](https://github.com/user-attachments/assets/f2143a63-1913-4e81-9708-d8518c548749)


- Requisição para encontrar usuario por ID

![image](https://github.com/user-attachments/assets/e61fa01b-7805-4416-a272-87efb238ae1c)

- Requisição para criar um usuario

![image](https://github.com/user-attachments/assets/333c56ca-3233-4f54-9b09-323ce4ef9837)

- Requisição para deletar um usuario por ID

![image](https://github.com/user-attachments/assets/e61b70d1-6ffb-4f32-b5f1-b0fac7653bc3)

- Requisição para atualizar um usuario por ID

![image](https://github.com/user-attachments/assets/ea5c269a-a19a-4552-9dc2-8fb3715828be)

## Requisições referentes a Pauta (shedule)

- Requisição para criar uma pauta

![image](https://github.com/user-attachments/assets/354df718-6ebd-4a7d-af6c-a29fcf40afdb)

- Requisição para pegar uma pauta por ID

![image](https://github.com/user-attachments/assets/e63d8324-98fc-411b-a4db-6f3ca8fab839)

- Requisição para criar uma sessão com o ID da pauta

![image](https://github.com/user-attachments/assets/11968150-68d7-4c9b-90bd-3b9d9eb529f6)

## Requisições referentes ao Voto

- Realizar um Voto

![image](https://github.com/user-attachments/assets/5a6fdb82-aff1-478d-a8bc-7f0c63b2a033)

- Encontrar voto por ID

![image](https://github.com/user-attachments/assets/2c95d3e4-71e1-4086-bbf1-4da55a07f3a0)

- Pesquisar por resultado da votação

![image](https://github.com/user-attachments/assets/7175b17e-8086-44d6-a33a-3d676cd353b7)

![image](https://github.com/user-attachments/assets/1c395932-1e73-436c-b962-553b89f84baf)


### Documentação com swagger

Toda a API foi documentada com o Swagger. Após iniciar a aplicação acesse a seguinte url:

http://localhost:8080/swagger-ui/index.html

Para a visualização de todos os endpoints 

![image](https://github.com/user-attachments/assets/794282e5-77fa-4d3d-bfa2-be68cae0c3dc)



> Se eu vi mais longe, foi por estar sobre ombros de gigantes, Isaac Newton 

![java](https://th.bing.com/th/id/OIP.jap_cRszSOiPk-lu65mFLwHaEK?w=272&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7) ![spring boot](https://th.bing.com/th/id/OIP.0T_CaH2TNe3dTcI8zYyLjgHaHa?w=181&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7) 









