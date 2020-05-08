## Web Service com Java

Web service REST com Java utilizando persistência de dados com JPA, disponibilizando uma lista de cursos, utilizando os métodos GET, PUT, POST e DELETE.

Projeto `CursosWebserviceRest`: Web service REST

Projeto `ClienteWebserviceCurso`: Client que consome a web service

## Tecnologias utilizadas

- JDK 13
- JEE 7
- JPA
- EJB
- [GlassFish 4](https://download.oracle.com/glassfish/4.0/release/index.html)
- [Gson 2.8.6](https://github.com/google/gson/releases/tag/gson-parent-2.8.6)
- [MySql Connector 5.1.30](https://downloads.mysql.com/archives/c-j/)

## Configuração inicial

Ao abrir o projeto importar como library o arquivo jar do Gson nos dois projetos.

## Criação do banco de dados

Execute o script `criar_tabela_curso.sql` para inicializar o banco de dados. Para estabelecer conexão com o banco de dados utilizei o [Wamp](https://sourceforge.net/projects/wampserver/) e o [MySQL Workbench](https://www.mysql.com/products/workbench/).

## Configurar connector MySql

Baixar a versão Platform independend 5.1.30 do connectos e copiar o jar para a pasta `C:\<glassfish-install-path>\domains\<domain-name>\lib`

Para a persistência dos dados é necessário criar um pool de conexões no GlassFish, e um recurso que utilize o pool.

Para criar o Pool é preciso ir até aba Serviços do NetBeans, na opção Servidores, selecionar a opção Exibir Console do Admin do Domínio.

### Configurar Pool

Na tela do Console Admin do GlassFish ir até a opção `JDBC > Connection Pools`
Crie uma nova pool com o nome `CursosPool`, resource type `javax.sql.DataSource` e Database Drive Vendor `MySql`.

Na página seguinte:

- Marcar a opção **Ping**
- Em **Additional Properties**:
  - Adicionar a propriedade `driverClass` com o valor `com.mysql.jdbc.Driver`
  - Alterar o valor das propriedades `URL` e `Url` para `jdbc:mysql://:3306/db_cursos` (3306 é o número da porta do mysql)
  - Na propriedade `User` inserir o nome do usuário do banco de dados.
  - Na propriedade `Password` inserir a senha
  - Na propriedade `DatabaseName` inseris o nome da base a ser utilizada: `db_cursos`

Após isso, concluir a configuração, clicando em Finish.

Se tudo for configurado corretamente será exibida a mensagem "Ping Succeded".

### Configurar Resource

Na tela do Console Admin do GlassFish ir até a opção `JDBC > JDBC Resources`

Crie um novo recurso com o nome `CursosResource`, selecionando a pool criada anteriormente.

## Acesso

Após ser iniciado, o web service pode ser acessado a partir de [http://localhost:8080/GerenciadorCursos/resources/cursos](http://localhost:8080/GerenciadorCursos/resources/cursos)
