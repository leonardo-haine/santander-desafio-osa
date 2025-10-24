Desafio: API REST de Agências com Spring Boot & OAuth2
================================================================================================================
# Contexto

Este projeto consiste na criação de uma API REST utilizando Spring Boot com autenticação via OAuth2, cujo objetivo é:

Realizar o cadastro de agências com suas respectivas coordenadas geográficas (X e Y).
Permitir que o usuário consulte a distância entre sua localização e as agências cadastradas.
Utilizar cache para otimizar as consultas de distância, com fallback para o banco de dados caso o cache expire.


Funcionalidades
================================================================================================================
1. Cadastro de Agências

    Endpoint: POST /desafio/cadastrar.

    Descrição: Cadastra uma nova agência informando suas coordenadas geográficas.

2. Consulta de Distâncias

    Endpoint: GET /desafio/distancia?posX=5&posY=15.

    Descrição: Retorna a lista de agências com a distância entre a localização do usuário e cada agência cadastrada.
  
## Funcionamento:

Se houver dados válidos no cache, eles serão utilizados.
Caso contrário, os dados serão buscados no banco de dados e o cache será recriado.

Autenticação
================================================================================================================
A API utiliza OAuth2 para autenticação. É necessário obter um token válido para acessar os endpoints protegidos.


Armazenamento
================================================================================================================

Para armazenar os dados está utilizando banco H2.


Tecnologias Utilizadas
================================================================================================================
- Java 17+
- Spring Boot
- Spring Security + OAuth2
- Spring Data JPA
- Cache Caffeine
- Banco de dados H2 /data/agenciasdb
