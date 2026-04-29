<h1 align="center" style="font-weight: bold;">API de transações 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Execução</a> • 
  <a href="#routes">Endpoints da API</a> •
</p>

<p align="center">
    <b>Minha versão do desafio Spring Boot para criação de uma API REST: </b>
</p>
<p align="center">
        <b>https://github.com/feltex/desafio-itau-backend</b>
</p>

<h2 id="features">🚀 Funcionalidades</h2>

Aqui você descreve o que seu projeto faz

<h2 id="structure">🏗️ Estrutura do Projeto</h2>

```bash
src/main/java/com/kipperdev/orderhub/
├── controller/     # Controllers REST
├── dto/            # Data Transfer Objects
├── exception/      # Exceções
├── model/          # Entidade Transaction
├── service/        # Lógica de negócio
└── SpringBootApplication.java
```

<h2 id="technologies">💻 Tecnologias</h2>

- Java 17
- Spring Boot 4.0.6

<h2 id="started">🚀 Primeiros passos</h2>

<h3>Clonando</h3>

```bash
git clone https://github.com/PedroH-Lopes/desafio-springboot-api-transacoes.git
```

<h3>Iniciando</h3>

```bash
cd desafio-springboot-api-trasacoes
./mvnw spring-boot:run
```

<h2 id="routes">📍 Endpoints da API</h2>

​
| rota               | descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /transacao</kbd>     | cria uma transação [detalhes da resposta](#get-auth-detail)
| <kbd>GET /estatistica</kbd>     | retorna as estatisticas das transações nos últimos 60 segundos [detalhes da requisição](#post-auth-detail)
| <kbd>DELETE /transacao</kbd>     | deleta todas as transações (sem corpo) 

<h3 id="get-auth-detail">POST /transacao</h3>

**REQUISIÇÃO**
```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

<h3 id="post-auth-detail">GET /estatistica</h3>

**RESPOSTA**
```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

