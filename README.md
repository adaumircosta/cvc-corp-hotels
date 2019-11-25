# Prova CVC

## Como executar a API

##### 1º Instale o docker
É necessário instalar em sua maquina:
- [Docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/) 
- [Docker-Compose](https://docs.docker.com/compose/install/)

##### 2º Realize o clone do projeto
```bash
git clone https://gitlab.com/adaumir-testes/cvc-corp/hotels-cvc.git
```
##### 3º No diretorio raiz do projeto clonado **ws-uol-client** execute o comando
```bash
docker-compose up
```

no arquivo **docker-compose.yaml** esta configurados o serviço:
- hotels-cvc

### Sobre o serviço
#### hotels-cvc
Serviço feito com Java 8 e Spring Boot 
Responsável por direcionar as chamadas para micro serviços especificos de acordo com a requisição recebida através da url
[Repositório do projeto](https://gitlab.com/adaumir-testes/cvc-corp/hotels-cvc.git)

Apos realizar o comando **docker-compose up** para consultar os endpoints basta acessar a [url](http://localhost:8085/swagger-ui.html)
```bash
http://localhost:8085/swagger-ui.html
```

### Sobre as tecnologias utilizadas

- spring-boot
- java 8
- lombok
- maven
- docker
- docker-compose
- swagger
