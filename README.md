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

## Cliente Cadastro

Funcionalidade para listar todos os usuarios:

` http://localhost:8080/user `









> Se eu vi mais longe, foi por estar sobre ombros de gigantes, Isaac Newton 

![java](https://th.bing.com/th/id/OIP.jap_cRszSOiPk-lu65mFLwHaEK?w=272&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7) ![spring boot](https://th.bing.com/th/id/OIP.0T_CaH2TNe3dTcI8zYyLjgHaHa?w=181&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7) 









