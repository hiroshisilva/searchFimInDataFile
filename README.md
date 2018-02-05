# search moves in file #

Esse projeto faz buscas de filmes indexando os dados apartir de arquivos.

# pré requisitos #
- Java (JDK-8)
- Pasta data dentro do diretório de execução do Jar


### Build.
Para efetuar o Build basta digitar a linha abaixo dentro do diretório do projeto.

Linux:
`./gradlew build packageJar`

Windows:
`gradle.bat build packageJar`


### Execução: ###

* Executar o projeto:
    * Copie os arquivos a serem indexados para a pasta data dentro do mesmo diretório a onde o jar será executado.
    * Copie o jar gerado dentro do diretório build lib para o mesmo diretório da pasta data.
    * Execute o código abaixo:
    ` java -jar SearchMovieInDataFile-1.0-SNAPSHOT.jar "walt disney"`

### Analise de tempo de execução ###
 Após a execução do jar será gerado um arquivo searchMovie.log no mesmo diretório do jar.
 O arquivo searchMovie.log contem o log com os tempos de execução tanto do carregamento dos dados, quanto da busca,
 a busca estará tagada como `search data`.

 ### Dados de Teste ###

 Os dados de teste estão armazenados no diretório data dentro do repositório.
