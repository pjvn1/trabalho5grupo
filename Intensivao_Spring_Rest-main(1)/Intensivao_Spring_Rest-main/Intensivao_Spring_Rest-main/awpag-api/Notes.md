# Implementando Endpoints para Operações no Cliente: Um Guia Passo a Passo

## Introdução
- Neste guia, vamos abordar a implementação de endpoints para realizar operações no catalogador da nossa aplicação. 
  Começaremos desenvolvendo os endpoints relacionados à entidade catalogador, já que é uma entidade relativamente 
  simples para iniciar. Utilizaremos o Postman, uma ferramenta amplamente utilizada para fazer chamadas HTTP, para 
  testar nossos endpoints.    

## Configurando o Postman
- Antes de criar nossos endpoints, configuraremos o Postman para realizar as requisições HTTP. Criaremos uma nova 
  coleção no Postman chamada "clientes" para organizar nossas requisições.   

## Criando o Endpoint para Listar Clientes
- Vamos começar criando o endpoint para listar clientes. Primeiramente, precisamos criar uma classe controladora 
  para receber as requisições HTTP relacionadas aos clientes. Esta classe, geralmente chamada de Controller, será 
  responsável por mapear os endpoints e processar as requisições.   

## Configurando a Classe Controller
- Dentro do pacote adequado em nosso projeto, criaremos uma classe chamada "ClienteController". Nesta classe, 
  definiremos métodos para lidar com as requisições relacionadas aos clientes. Para começar, implementaremos um 
  método simples chamado "listar" que retornará uma lista de clientes.    

## Mapeando o Endpoint
- Utilizaremos anotações do Spring MVC, como @GetMapping, para mapear nosso método "listar" ao endpoint "/clientes". 
  Isso significa que quando uma requisição GET for feita para "/clientes", o método "listar" será acionado para 
  processar a requisição.    

## Retornando uma Lista de Clientes
- Dentro do método "listar", iremos criar instâncias de clientes e retorná-las como uma lista. Para isso, 
  utilizaremos uma classe utilitária do Java para criar a lista de clientes.  

## Testando o Endpoint
- Após reiniciar nossa aplicação, podemos testar o endpoint utilizando o Postman. Ao enviar uma requisição GET para 
  "/clientes", devemos receber uma resposta com o código 200 OK e uma representação da lista de clientes em formato 
  JSON.   

## Considerações Finais
- Neste guia, implementamos com sucesso um endpoint para listar clientes em nossa aplicação. Este é apenas o primeiro 
passo na construção de uma API REST completa. Nos próximos passos, podemos expandir nossos endpoints para incluir 
operações como adição, atualização e exclusão de clientes, bem como melhorar a representação dos recursos retornados.
O JSON é amplamente utilizado para representar recursos em APIs REST devido à sua simplicidade e interoperabilidade, 
mas outras opções, como XML, também são viáveis dependendo dos requisitos do projeto.      


# Métodos HTTP e Códigos de Status: Entendendo a Comunicação na Web
## Introdução
- A comunicação na web é regida por protocolos e convenções bem definidas. Entre essas convenções, os métodos HTTP e 
  os códigos de status desempenham papéis fundamentais. Neste artigo, exploraremos detalhadamente os métodos HTTP, 
  também conhecidos como verbos HTTP, e os códigos de status associados a esses métodos.   

## Métodos HTTP: Conceitos Fundamentais
- Os métodos HTTP definem a semântica das operações a serem realizadas sobre um recurso específico. Eles indicam ao 
  servidor qual ação deve ser executada no recurso identificado pela URI. Vamos analisar alguns dos principais 
  métodos:    
- - GET: Utilizado para obter a representação de um recurso. Este método não modifica o recurso, sendo considerado 
    idempotente. 
- - POST: Utilizado para enviar dados para serem processados por um recurso específico. Diferentemente do GET, o 
    POST pode causar efeitos colaterais. 
- - Outros métodos: Existem diversos outros métodos HTTP, cada um com sua própria finalidade, como PUT, DELETE, 
    PATCH, entre outros. 

## Idempotência e Efeitos Colaterais
- Um aspecto importante dos métodos HTTP é a idempotência. Um método é considerado idempotente quando requisições 
  repetidas não geram efeitos colaterais. Por exemplo, o método GET é idempotente, pois apenas recupera informações 
  sem modificar o recurso.  

## Códigos de Status HTTP: Entendendo as Respostas do Servidor
- Os códigos de status HTTP são retornados pelo servidor para indicar o resultado de uma requisição. Alguns dos 
  principais códigos incluem: 
- - 200 (OK): Indica que a requisição foi bem-sucedida e o servidor retornou os dados solicitados.
- - 201 (Created): Indica que a requisição foi bem-sucedida e resultou na criação de um novo recurso.
- - 204 (No Content): Indica que a requisição foi bem-sucedida, mas o servidor não retornou nenhum conteúdo no corpo 
    da resposta. 

## Utilizando Códigos de Status Corretamente
- É essencial utilizar os códigos de status HTTP corretamente para garantir uma comunicação eficaz entre catalogador e 
servidor. Os códigos de status são agrupados em níveis, como: 
- - Nível 200: Indica sucesso na requisição. 
- - Nível 300: Indica redirecionamento.
- - Nível 400: Indica erros por parte do catalogador.
- - Nível 500: Indica erros no servidor.

## Conclusão 
- Compreender os métodos HTTP e os códigos de status é fundamental para o desenvolvimento de aplicações web robustas 
  e eficientes. Ao utilizar esses conceitos de forma adequada, é possível garantir uma comunicação confiável entre 
  catalogador e servidor, proporcionando uma melhor experiência para os usuários finais.   


# Negociação de Conteúdo em APIs REST: Personalizando Formatos de Resposta
# Introdução
- Quando lidamos com requisições GET em APIs REST, geralmente recebemos recursos de coleção com representação em 
  formato JSON. No entanto, é possível ter várias representações para o mesmo recurso, permitindo que ele seja 
  visualizado de diferentes formas pelo consumidor da API.   

## Especificando Formatos de Resposta
- Ao fazer uma requisição, o consumidor da API pode especificar o formato que deseja receber como resposta. Isso é 
  feito através do cabeçalho Accept na requisição HTTP, onde é possível indicar o tipo de mídia desejado. Por padrão,
  se nenhum formato for especificado, o servidor retornará JSON. No entanto, é possível especificar outros formatos, 
  como XML.   
- - Adicionando cabeçalho Accept no Postman 
- - Especificando formatos como JSON ou XML

## Adicionando Suporte a Novos Formatos
- Para adicionar suporte a novos formatos, como XML, na aplicação, é necessário configurar as dependências corretas. 
  No exemplo dado, é utilizado o Jackson, uma biblioteca para serialização e desserialização de objetos, para lidar 
  com XML.       
- - Adicionando dependências no arquivo pom.xml
- - Configurando o projeto para suportar XML

## Melhorando a Produtividade com Dev Tools
- As ferramentas de desenvolvimento, como o Spring Boot Dev Tools, podem aumentar a produtividade ao permitir que as 
  alterações no código sejam refletidas automaticamente, sem a necessidade de reiniciar toda a aplicação.       
- - Adicionando dependência do Spring Boot Dev Tools
- - Utilizando o recurso de restart automático da aplicação

## Próximos Passos
- Com os fundamentos de APIs REST estabelecidos, é possível avançar para conceitos mais avançados, como persistência 
  de dados, validação, tratamento de exceções e boas práticas de design e desenvolvimento. Esses tópicos serão 
  abordados nas próximas aulas.  

## Conclusão
- A negociação de conteúdo em APIs REST permite personalizar os formatos de resposta de acordo com as necessidades 
  do consumidor da API. Ao entender como especificar e adicionar suporte a diferentes formatos, é possível criar 
  APIs mais flexíveis e adaptáveis. Além disso, ferramentas como o Spring Boot Dev Tools podem aumentar a 
  produtividade do desenvolvedor durante o ciclo de desenvolvimento. É importante continuar aprendendo e 
  compartilhando conhecimento para se tornar um desenvolvedor de APIs REST bem-sucedido.      

# Desenvolvimento de APIs REST com Spring: Implementação da Persistência de Dados
## Introdução
- Neste artigo, abordaremos a implementação da persistência de dados em uma API REST desenvolvida com Spring. Na 
  segunda aula do intensivão Spring Rest, realizada por Thiago Faria da AlgaWorks, focaremos na utilização do 
  Jakarta Persistence, Spring Data JPA e Flyway para gerenciar a persistência de dados de forma profissional e 
  eficiente.    

## Configuração do Projeto
- Para começar, é essencial configurar o projeto para que ele possa buscar e manipular dados em um banco de dados 
  MySQL. Serão adicionadas dependências do Spring Boot Starter Data JPA e do MySQL Connector/J ao arquivo pom.xml. 
  Além disso, faremos as configurações necessárias no arquivo application.properties para estabelecer a conexão com 
  o banco de dados, definindo a URL de conexão, nome do esquema, usuário e senha.     

 ## Utilização do Flyway para Gerenciamento de Migrações
- Uma abordagem eficaz para gerenciar as migrações do banco de dados é utilizando ferramentas como o Flyway. Com o 
  Flyway, podemos manter um controle preciso das alterações no esquema do banco de dados ao longo do tempo. Ele nos 
  permite versionar e executar automaticamente scripts SQL para criar, modificar ou excluir tabelas, colunas e 
  outros objetos do banco de dados.    

## Criação das Tabelas do Banco de Dados
- Com as configurações iniciais concluídas, podemos criar as tabelas do banco de dados necessárias para nossa 
  aplicação. Utilizando scripts SQL compatíveis com o Flyway, definiremos a estrutura do banco de dados, incluindo 
  as tabelas, colunas, chaves primárias e estrangeiras, além de quaisquer restrições de integridade referencial 
  necessárias.

## Implantação em Ambiente de Produção
- Ao utilizar o Flyway em conjunto com o Spring Boot, garantimos que as migrações do banco de dados sejam aplicadas 
  de forma consistente em diferentes ambientes, incluindo ambientes de desenvolvimento, teste e produção. Isso 
  simplifica o processo de implantação, garantindo que a estrutura do banco de dados esteja sempre atualizada e em 
  conformidade com a versão mais recente da aplicação.    

## Considerações Finais
- A implementação da persistência de dados em uma API REST com Spring é uma etapa fundamental no desenvolvimento de 
  aplicações robustas e escaláveis. Ao utilizar ferramentas como o Jakarta Persistence, Spring Data JPA e Flyway, 
  podemos garantir um gerenciamento eficiente e profissional dos dados da aplicação, facilitando sua manutenção e 
  evolução ao longo do tempo.     

- Por fim, é importante ressaltar a importância de seguir boas práticas de desenvolvimento e design de banco de dados, 
garantindo a integridade, segurança e desempenho do sistema como um todo. Com as ferramentas e técnicas adequadas, 
podemos criar APIs REST poderosas e confiáveis que atendam às necessidades de nossos usuários e clientes.    

# Simplificando Persistência de Dados em Aplicações Java com Jakarta Persistence e Spring Data JPA
- Nos últimos anos, o desenvolvimento de aplicações Java empresariais tem sido facilitado pela utilização de 
  especificações e frameworks que simplificam tarefas complexas, como persistência de dados. Entre essas tecnologias,
  destacam-se o Jakarta Persistence (JPA) e o Spring Data JPA, que oferecem ferramentas poderosas para mapeamento 
  objeto-relacional (ORM) e operações de banco de dados em aplicações Java.    
- Neste artigo, exploraremos como utilizar o Jakarta Persistence em conjunto com o Spring Data JPA para simplificar 
  a persistência de dados em aplicações Java. Para isso, vamos acompanhar um exemplo prático de implementação de 
  persistência de dados em uma aplicação Spring Boot.   

## Introdução ao Jakarta Persistence e Spring Data JPA
- O Jakarta Persistence, anteriormente conhecido como Java Persistence API (JPA), é uma especificação do Jakarta EE 
  que define uma API para mapeamento objeto-relacional em aplicações Java. Essa especificação permite que 
  desenvolvedores trabalhem com objetos Java de forma transparente, mapeando-os para tabelas em um banco de dados 
  relacional.    
- O Spring Data JPA, por sua vez, é um projeto do Spring que simplifica ainda mais o uso do JPA em aplicações Spring.
  Ele fornece funcionalidades adicionais e abstrai muitas das tarefas repetitivas associadas à implementação de 
  repositórios de dados.   

## Implementando Persistência de Dados em uma Aplicação Spring Boot
- Vamos agora acompanhar um exemplo prático de como implementar persistência de dados em uma aplicação Spring Boot 
  usando o Jakarta Persistence e o Spring Data JPA. 

### Configuração do Projeto:
- Primeiramente, criamos um projeto Spring Boot e adicionamos as dependências necessárias para o Spring Data JPA. Em 
  seguida, configuramos o arquivo application.properties para definir as propriedades de conexão com o banco de 
  dados e ativar a exibição de SQLs gerados pelo Hibernate.   

### Definição da Entidade JPA:
- Em seguida, definimos uma classe Java que representará uma entidade persistente. Utilizamos a anotação @Entity do 
  Jakarta Persistence para marcar a classe como uma entidade JPA. Além disso, utilizamos outras anotações, como @Id 
  e @Column, para definir a chave primária e mapear propriedades para colunas específicas no banco de dados.     

### Consulta com JPQL:
- Para realizar consultas em nossas entidades, utilizamos a Java Persistence Query Language (JPQL), uma linguagem de 
  consulta semelhante ao SQL, mas que opera em objetos Java. Com o uso do método createQuery, podemos executar 
  consultas JPQL e obter resultados tipados.   

### Injeção do EntityManager:
- Para interagir com o banco de dados, fazemos uso do EntityManager, uma interface do Jakarta Persistence que nos 
  permite realizar operações de persistência, como consultas, inserções, atualizações e exclusões. No Spring Boot, 
  podemos injetar o EntityManager automaticamente usando a anotação @PersistenceContext.    

## Conclusão
- O Jakarta Persistence e o Spring Data JPA são ferramentas poderosas para simplificar a persistência de dados em 
  aplicações Java. Com essas tecnologias, desenvolvedores podem focar mais na lógica de negócios de suas aplicações 
  e menos na complexidade de interagir com bancos de dados relacionais.   
- Neste artigo, exploramos como implementar persistência de dados em uma aplicação Spring Boot, utilizando o Jakarta 
  Persistence e o Spring Data JPA. Com a ajuda dessas tecnologias, é possível criar aplicações robustas e eficientes,
  com uma camada de persistência de dados simples e de fácil manutenção. 
- Em resumo, o uso do Jakarta Persistence e do Spring Data JPA é altamente recomendado para desenvolvedores que 
  desejam simplificar o desenvolvimento de aplicações Java empresariais, tornando o processo de persistência de 
  dados mais eficiente e menos propenso a erros.  

# Repositórios com Spring Data JPA
## O Problema do Código Spaghetti
- Em aplicações pequenas ou protótipos, pode ser aceitável implementar operações de persistência diretamente no 
  Controller. No entanto, em aplicações maiores, isso pode levar a um código confuso e difícil de manter, conhecido 
  como 'código spaghetti'.    

## Separação de Responsabilidades
- Para evitar esse problema, é recomendado separar as responsabilidades. Um componente dedicado será responsável pelo 
acesso aos dados, enquanto o Controller usará esse componente para executar operações de persistência.    

## Repositórios com Spring Data JPA
- O Spring Data JPA é uma biblioteca que facilita a criação de repositórios com Jakarta Persistence. Ele fornece uma 
  interface genérica (JPARepository) que traz várias funcionalidades pré-definidas para trabalhar com entidades e 
  persistência de dados.   

## Criando um Repositório
- Para criar um repositório, basta estender a interface JPARepository com a entidade que será gerenciada e seu tipo 
  de identificador. Isso adiciona automaticamente vários métodos comuns para consultar e gerenciar a entidade.   

````java
public interface ClienteRepository extends JPARepository<Cliente, Long> {
}
````
## Anotação @Repository
- A anotação @Repository do Spring Framework é usada para marcar o repositório como um componente do Spring, 
  indicando sua responsabilidade de persistência de dados.   

````java
@Repository
public interface ClienteRepository extends JPARepository<Cliente, Long> {
}
````

## Injeção de Dependência
- O Spring gerencia instâncias do repositório, permitindo que elas sejam injetadas em outros objetos usando injeção 
  de dependência. 

````java
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // ...
}
````

## Métodos Customizados
- Além dos métodos pré-definidos, é possível definir métodos customizados no repositório seguindo uma convenção de 
  nomenclatura. Por exemplo, findByNome criará um método que busca clientes por nome.   

````java
public interface ClienteRepository extends JPARepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

}
````

## Implementação Automática
- O Spring Data JPA implementa automaticamente esses métodos em tempo de execução, dispensando a necessidade de 
  criar classes de implementação. Essa implementação é baseada em JPQL e SQL.   

## Consultas Exatas e Não Exatas
- Consultas exatas usam o operador = para comparar valores. Consultas não exatas podem usar palavras-chave como 
  containing para buscar valores que contêm uma determinada substring.   

````java
public interface ClienteRepository extends JPARepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

}
````

## Resumo
- Os repositórios com Spring Data JPA fornecem uma maneira fácil e flexível de gerenciar a persistência de dados, 
  separando as responsabilidades e automatizando a implementação de métodos comuns. Eles são uma ferramenta 
  essencial para o desenvolvimento de aplicações Java robustas e escaláveis.   

# Implementação de Endpoints para Gerenciamento de Clientes
## Introdução
- Nesta seção, implementaremos novos endpoints para trabalhar com o recurso de clientes. Já implementamos o endpoint 
  para listar clientes e agora abordaremos a busca de um catalogador específico e o cadastro, atualização e exclusão de 
  clientes.   

## Buscar Cliente
- Para buscar um catalogador específico, criamos um método buscar no controlador ClienteController. Este método recebe o 
  ID do catalogador como argumento e retorna um ResponseEntiy do tipo Cliente. O código do método é o seguinte:   
````
@GetMapping('/clientes/{clienteId}')
public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Optional<Cliente> catalogador = clienteRepository.findById(clienteId);
        if (catalogador.isPresent()) {
        return ResponseEntity.ok(catalogador.get());
        } else {
        return ResponseEntity.notFound().build();
        }
        }
````

## Cadastrar Cliente
- Para cadastrar um novo catalogador, criamos um método adicionar no controlador ClienteController. Este método recebe um 
objeto Cliente no corpo da requisição e retorna o catalogador salvo como um ResponseEntity. O código do método é o 
seguinte:   

````
@PostMapping('/clientes')
public ResponseEntity<Cliente> adicionar(@RequestBody Cliente catalogador) {
    Cliente clienteSalvo = clienteRepository.save(catalogador);
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
}

````

## Atualizar Cliente
- Para atualizar um catalogador, criamos um método atualizar no controlador ClienteController. Este método recebe o ID 
  do catalogador na URL e o objeto Cliente atualizado no corpo da requisição. O código do método é o seguinte:    

````
@PutMapping('/clientes/{clienteId}')
public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente catalogador) {
    if (!clienteRepository.existsById(clienteId)) {
        return ResponseEntity.notFound().build();
    }
    catalogador.setId(clienteId);
    Cliente catalogadorAtualizado = clienteRepository.save(catalogador);
    return ResponseEntity.ok(catalogadorAtualizado);
}
````
## Excluir Cliente
- Por fim, para excluir um catalogador, criamos um método excluir no controlador ClienteController. Este método recebe o 
  ID do catalogador na URL e retorna um ResponseEntity do tipo Void. O código do método é o seguinte:   

````
@DeleteMapping('/clientes/{clienteId}')
public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
    if (!clienteRepository.existsById(clienteId)) {
        return ResponseEntity.notFound().build();
    }
    clienteRepository.deleteById(clienteId);
    return ResponseEntity.noContent().build();
}
````

# Validações de Objetos Java com Jacarta Bean Validation
## Introdução
- Ao criar APIs REST com Spring Boot, é importante validar os dados recebidos para garantir sua integridade e evitar 
  erros. O Jacarta Bean Validation é uma especificação que oferece recursos para validação de objetos Java

## Adicionando a Dependência do Validation
- Para utilizar o Jacarta Bean Validation, adicione a dependência 'spring-boot-starter-validation' ao seu projeto 
  Maven: 
````markdown

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
````

- Isso adicionará a implementação Hibernate Validator, que atende à especificação Jacarta Bean Validation.

## Anotações de Validação
- Para validar propriedades de um objeto Java, use anotações do Jacarta Bean Validation:

- - @NotNull: Verifica se a propriedade não é nula.
- - @NotBlank: Verifica se a propriedade não é nula, vazia ou contém apenas espaços em branco.
- - @Size: Limita o tamanho da propriedade (máximo ou mínimo).
- - @Email: Verifica se a propriedade está no formato de e-mail.

## Aplicando Validações em Controllers

- Para aplicar validações aos dados recebidos em um método do controlador, use a anotação @Valid no parâmetro do 
  objeto a ser validado:  
````markdown

@PostMapping('/clientes')
public ResponseEntity<?> criarCliente(@Valid @RequestBody Cliente catalogador) {
    // ...
}
````

## Erros de Validação
- Se a validação falhar, o Spring Boot retornará um código de status HTTP 400 (Bad Request) e uma mensagem de erro 
  que indica os campos inválidos.

## Personalizando Mensagens de Erro
- As mensagens de erro padrão podem ser customizadas usando a anotação @MessageCodes:
````markdown

@NotBlank(message = 'O nome do catalogador é obrigatório.')
private String nome;
````

## Conclusão
- O Jacarta Bean Validation oferece uma maneira poderosa e fácil de validar dados de objetos Java em APIs REST. Ao 
  usar as anotações de validação e aplicá-las adequadamente em seus controllers, você pode garantir a integridade 
  dos dados recebidos e melhorar a experiência do usuário.   
- 

# Como Organizar as Regras de Negócio em Java com Spring Framework
## Introdução
- À medida que um projeto cresce, é comum que as regras de negócio sejam espalhadas pelo controlador, o que pode 
dificultar a manutenção e levar a um código 'espaguete'. Para evitar isso, é crucial organizar as regras de negócio 
em classes com responsabilidades bem definidas. 

## Opções para Organizar as Regras de Negócio
- Existem duas principais abordagens para organizar as regras de negócio:

### Classes de Entidade
- Nessa abordagem, as regras de negócio são colocadas dentro das classes de entidade. No entanto, isso pode resultar 
em classes com alta coesão, o que pode dificultar a manutenção.

### Classes de Serviço de Domínio
- Essa abordagem envolve a criação de classes separadas para representar regras de negócio. Essas classes são 
chamadas de classes de serviço de domínio e podem conter regras que trabalham com várias entidades ou precisam 
injetar objetos como repositórios. 

## Criação de Classes de Serviço de Domínio
- Para criar uma classe de serviço de domínio, siga estes passos:
- - Crie um pacote dentro do pacote de domínio chamado 'service'.
- - Crie uma classe dentro do pacote de serviço, como CadastroClienteService.
- - Anote a classe com a anotação @Service do Spring Framework.

## Chamando Classes de Serviço de Domínio no Controlador
- Para usar classes de serviço de domínio no controlador, siga estes passos:
- - Declare uma variável de instância para a classe de serviço, como cadastroClienteService.
- - No construtor do controlador, injete a classe de serviço e o repositório correspondente.
- - Nos métodos do controlador, chame os métodos da classe de serviço em vez do repositório diretamente.

## Adicionando Regras de Negócio
- Para adicionar uma regra de negócio, como impedir o cadastro de clientes com e-mails duplicados:
- - No método da classe de serviço responsável pela operação, verifique se existe algum catalogador com o e-mail 
    informado usando o repositório. 
- - Se um catalogador com o e-mail informado já existir, lance uma exceção customizada, como NegocioException. 
- - No método do controlador que chama o serviço, capture a NegocioException e retorne uma resposta HTTP adequada, 
    como um erro 400 (Bad Request) com uma mensagem de erro amigável. 

## Exemplo:

````Java
// Classe de Serviço de Domínio
@Service
public class CadastroClienteService {

    private final ClientRepository clientRepository;

    public CadastroClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Cliente salvar(Cliente catalogador) {
        if (clientRepository.findByEmail(catalogador.getEmail()).isPresent()) {
            throw new NegocioException('Já existe um catalogador cadastrado com este e-mail.');
        }

        return clientRepository.save(catalogador);
    }

    public void excluir(Long clienteId) {
        clientRepository.deleteById(clienteId);
    }
}

````

````Java
// Controlador
@RestController
public class ClienteController {

    private final CadastroClienteService cadastroClienteService;
    private final ClientRepository clientRepository;

    public ClienteController(CadastroClienteService cadastroClienteService, ClientRepository clientRepository) {
        this.cadastroClienteService = cadastroClienteService;
        this.clientRepository = clientRepository;
    }

    @PostMapping('/clientes')
    public ResponseEntity<String> adicionar(@RequestBody Cliente catalogador) {
        try {
            cadastroClienteService.salvar(catalogador);
        } catch (NegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping('/clientes')
    public List<Cliente> listar() {
        return clientRepository.findAll();
    }
}
````
````Java
// Exceção Customizada
public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }
}
````

# Implementação do Cadastro e Consulta de Parcelamentos
## Criação da Tabela no Banco de Dados
- Para armazenar os parcelamentos, precisamos criar a tabela respectiva no banco de dados. O código DDL para criar a 
  tabela é: 
````sql
CREATE TABLE parcelamentos (
        id INT NOT NULL AUTO_INCREMENT,
        cliente_id INT NOT NULL,
        descricao VARCHAR(20) NOT NULL,
        valor_total DECIMAL(10,2) NOT NULL,
        quantidade_parcelas INT NOT NULL,
        data_criacao DATETIME NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (cliente_id) REFERENCES clientes (id)
        );
````

## Entidade Parcelamento e Mapeamento Objeto-Relacional
- Criamos a classe de entidade Parcelamento e as anotações para mapear os atributos da classe para as colunas da 
  tabela: 

````Java
import javax.persistence.*;

@Entity
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = 'cliente_id')
    private Cliente catalogador;

    private String descricao;

    private BigDecimal valorTotal;

    private Integer quantidadeParcelas;

    private LocalDateTime dataCriacao;
}
````
## Repositório Parcelamento
- Criamos o repositório ParcelamentoRepository com os métodos padrão do Spring Data JPA:
````Java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelamentoRepository extends JpaRepository<Parcelamento, Long> {
} 
````

## Controladora Parcelamento
- A controladora ParcelamentoController contém os endpoints para listar e buscar parcelamentos:
````Java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping('/parcelamentos')
public class ParcelamentoController {

  @Autowired
  private ParcelamentoRepository parcelamentoRepository;

  @GetMapping
  public List<Parcelamento> listar() {
    return parcelamentoRepository.findAll();
  }

  @GetMapping('/{id}')
  public ResponseEntity<Parcelamento> buscar(@PathVariable Long id) {
    return parcelamentoRepository.findById(id)
            .map(parcelamento - > ResponseEntity.ok(parcelamento))
            .orElse(ResponseEntity.notFound().build());
  }
} 
````
## Serviço Parcelamento
- A classe de serviço ParcelamentoService inclui o método para cadastrar um parcelamento:
````Java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParcelamentoService {

    @Autowired
    private ParcelamentoRepository parcelamentoRepository;

    @Transactional
    public Parcelamento cadastrarNovoParcelamento(Parcelamento parcelamento) {
        parcelamento.setDataCriacao(LocalDateTime.now());
        return parcelamentoRepository.save(parcelamento);
    }
}
````
## Implementação do Cadastro
- Na controladora ParcelamentoController, o método cadastrar recebe um Parcelamento e delega a persistência para o 
  serviço ParcelamentoService: 

````Java
@PostMapping
public ResponseEntity<Parcelamento> cadastrar(@RequestBody Parcelamento parcelamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelamentoService.cadastrarNovoParcelamento(parcelamento));
}
````

## Tratamento de Erros
- Para tratar o erro de cadastro de parcelamento com um catalogador inexistente, adicionamos a anotação @ResponseStatus 
  no método cadastrarNovoParcelamento do serviço ParcelamentoService:  
````Java
@Transactional
@ResponseStatus(HttpStatus.BAD_REQUEST)
public Parcelamento cadastrarNovoParcelamento(Parcelamento parcelamento) {
    parcelamento.setDataCriacao(LocalDateTime.now());
    return parcelamentoRepository.save(parcelamento);
}
````

# Validação em APIs REST com Java e Spring Rest
## Introdução
- Esta aula aborda técnicas e boas práticas para aprimorar a profissionalização das APIs REST desenvolvidas com 
  Spring Rest. É essencial para se diferenciar de outros programadores que ainda não dominam esses conhecimentos.    

## Validação em Cascata com Jacarta Bean Validation
- Para validar objetos Java em cascata, podemos utilizar o Jacarta Bean Validation. Ao definir restrições nas 
  propriedades das classes, como @Max, @NotNull, @NotBlank e @Size, podemos garantir dados válidos.  
- 

#  Boas práticas para Exception Handler
## Introdução
- O problema abordado é a necessidade de um componente Spring para capturar exceções globais em uma aplicação. Isso 
  evitaria a duplicação de códigos de tratamento de exceções em cada controlador.   

## Criação do Componente ExceptionHandler
- O componente apiExceptionHandler é criado no pacote api.exceptionhandler para capturar exceções em toda a 
  aplicação. A anotação @RestControllerAdvice é usada para torná-lo um componente Spring com a capacidade de tratar 
  exceções.   

## Melhoria das Respostas de Erro
- O formato de resposta de erro é melhorado usando a especificação RFC 7807, que padroniza a representação de 
  informações de erro em respostas HTTP. O objeto problemDetails do Spring MVC é usado para retornar mensagens de 
  erro no formato RFC.   

## Customização das Mensagens de Erro
- O método handleMethodArgumentNotValidException é sobrescrito para personalizar as mensagens de erro para exceções 
  de validação. Um campo 'Fields' é adicionado ao objeto problemDetails para fornecer informações específicas sobre 
  os campos inválidos.    

## Integração com Internacionalização
- As mensagens de erro são internacionalizadas usando códigos de erro. Esses códigos podem ser usados para 
  customizar as mensagens de erro para diferentes idiomas. 

## Conclusão
- O uso de um componente Spring para tratar exceções globais e a implementação da especificação RFC 7807 melhoram a 
  qualidade e a consistência das mensagens de erro na aplicação. Isso facilita o trabalho dos consumidores da API, 
  pois eles podem identificar e resolver problemas com mais facilidade.    

# Implementando Offset no Spring
- Para armazenar datas e horas com offset no Spring, use o tipo OffsetDateTime em vez de LocalDateTime. O 
  OffsetDateTime armazena a data e hora junto com o offset, garantindo que a informação seja sempre clara e 
  facilmente convertível.  

# Separação do Modelo de Domínio e Modelo de Representação de Recursos
## Introdução
- O modelo de domínio representa as entidades e regras de negócio do sistema, enquanto o modelo de representação de 
  recursos define como os recursos do sistema são expostos na API. Compartilhar o mesmo modelo para ambas as funções 
  pode levar a problemas, como:   
- - Exposição de propriedades sensíveis na API
- - Alterações no modelo de domínio afetando inadvertidamente a API
- - Conflitos ao representar recursos de forma diferente do modelo de domínio

## Modelo de Transferência de Dados (DTO)
- Para evitar esses problemas, é recomendado o uso de DTOs, que são classes usadas exclusivamente para transferir 
  dados entre diferentes camadas do sistema. Os DTOs possuem as seguintes características:   
- - Contêm apenas as propriedades necessárias para representação
- - Não possuem comportamentos
- - Permitem personalizar a representação dos recursos

## Criando DTOs
- Para criar DTOs, é necessário:

- - Criar um pacote para os modelos de representação
- - Dentro do pacote, criar uma classe para cada DTO
- - Definir as propriedades do DTO com os nomes e tipos desejados

## Conversão de Entidades para DTOs
- Para converter entidades de domínio em DTOs, é possível utilizar o método map() do Java:
````java
ParcelamentoModel parcelamentoModel = new ParcelamentoModel()
        .setId(parcelamento.getId())
        .setNomeCliente(parcelamento.getCliente().getNome()); 
````

## Atualização dos Controladores
- Nos controladores, é necessário retornar os DTOs em vez das entidades:
````Java
@GetMapping('/parcelamentos/{id}')
public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long id) {
    Optional<Parcelamento> parcelamento = parcelamentoRepository.findById(id);
    return parcelamento.map(p - > new ParcelamentoModel(p)).orElse(ResponseEntity.notFound().build());
}
 ````
## Conclusão
- Separar o modelo de domínio do modelo de representação de recursos permite maior flexibilidade e proteção, 
  evitando alterações indesejadas na API e exposição de dados sensíveis.  

# Melhorando a Gerenciabilidade do Código com Mapeamento de Objetos usando Model Mapper
## Introdução
- O código boilerplate é aquele código repetitivo que não agrega muito valor ao negócio da aplicação, mas ainda 
  precisa ser implementado. Isso dificulta a manutenção do código. 
- No método buscar do controlador parcelamento, temos código boilerplate para transformar objetos da entidade 
  parcelamento em objetos do parcelamentoModel (modelo de representação do recurso).   

## Usando o Model Mapper
- Para evitar escrever código boilerplate, vamos usar o Model Mapper.
### Adicionando a Dependência
- Vamos adicionar a dependência do Model Mapper ao pom.xml:
````xml
<dependency>
  <groupId>org.modelmapper</groupId>
  <artifactId>modelmapper</artifactId>
  <version>3.0.0</version>
</dependency>
````

## Refatorando o Código
- Vamos refatorar o código para usar o Model Mapper:
````Java
@RestController
@RequestMapping('parcelamentos')
public class ParcelamentoController {
  @Autowired
  private ParcelamentoRepository parcelamentoRepository;
  @Autowired
  private ParcelamentoService parcelamentoService;

  @PostMapping
  public ParcelamentoModel cadastrar(@RequestBody Parcelamento parcelamento) {
    Parcelamento cadastrado = parcelamentoService.cadastrar(parcelamento);
    return parcelamentoAssembler.toModel(cadastrado);
  }

  @GetMapping('{id}')
  public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long id) {
    return ResponseEntity.ok(parcelamentoAssembler.toModel(parcelamentoRepository.findById(id)));
  }

  @GetMapping
  public List<ParcelamentoModel> listar() {
    return parcelamentoAssembler.toCollectionModel(parcelamentoRepository.findAll());
  }
}
````

## Criando o Assembler
- Vamos criar um assembler para abstrair a responsabilidade de transformação:
````Java
-@Component
public class ParcelamentoAssembler {
  @Autowired
  private ModelMapper modelMapper;

  public ParcelamentoModel toModel(Parcelamento parcelamento) {
    return modelMapper.map(parcelamento, ParcelamentoModel.class);
  }

  public List<ParcelamentoModel> toCollectionModel(List<Parcelamento> parcelamentos) {
    return parcelamentos.stream()
        .map(this::toModel)
        .toList();
  }
}
````
## Como funciona o Model Mapper
- O Model Mapper usa estratégias de correspondência de propriedades para atribuir propriedades de um objeto a outro, 
  mesmo que os nomes das propriedades sejam diferentes. 

- Por exemplo, no ParcelamentoModel, temos o atributo 'nomeCliente', enquanto na entidade Parcelamento, temos um 
objeto 'catalogador' com o atributo 'nome'. O Model Mapper consegue atribuir o nome do catalogador corretamente.     

## Conclusão
- Usando o Model Mapper e criando um assembler, reduzimos o código boilerplate, melhoramos a legibilidade do código 
  e abstraímos a responsabilidade de transformação de objetos. 


