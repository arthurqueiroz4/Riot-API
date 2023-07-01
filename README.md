# Riot API
- Projeto feito utilizando a <a href='https://developer.riotgames.com/apis'>API da Riot Games</a>. Fiz as requisições, tratei os dados e salvei no banco com Java.
- Consiste em pegar uma lista de Invocadores (player de LoL) e retornar dados que eu achei relevante das últimas 100 partidas na fila SOLO/DUO daqueles que foram passados. Esses dados são salvos em um banco PostgreSQL.
## Como usar:
- Use o Java 19.
- Baixe as dependências do Maven.
- Ao baixar o repositório, você precisa ter um database no PostgreSQL. Você modificará os atributos da classe ConnectionDB de acordo com o seu database.
- Caso não queira salvar no banco, comente a linha 59 do método main da classe Application pois ela é a parte que chama o método para salvar no banco.
- Agora, para passar os Invocadores que você quer receber os dados, é só modificar o array de String da linha 55 do método main da classe Application.
