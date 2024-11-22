# Projeto-Kotlin


Funcionalidades Principais
Cadastro de Clientes:

O aplicativo permite a criação de novos clientes, armazenando dados essenciais como:
Nome: O nome completo do cliente.
CPF: O número de CPF do cliente, usado para garantir a unicidade de cada cliente.
E-mail: Um campo adicional para o e-mail do cliente.
Os dados dos clientes são salvos no banco de dados local utilizando Room, garantindo persistência entre reinicializações do aplicativo.
Gerenciamento de Pedidos:

O sistema permite registrar os pedidos feitos pelos clientes com os seguintes dados:
Código do Produto: Um identificador único para o produto solicitado.
Nome do Produto: O nome do produto pedido pelo cliente.
Quantidade: O número de unidades do produto solicitado.
Preço: O preço unitário do produto.
Cada pedido está associado a um cliente através de uma chave estrangeira (relacionamento entre o Pedido e o Cliente).
O banco de dados Room gerencia a persistência dos pedidos de maneira eficiente.
Listagem Dinâmica:

A lista de clientes e pedidos é exibida de forma dinâmica na interface do usuário.
Usando LiveData e RecyclerView (ou LazyColumn no Jetpack Compose), a interface é automaticamente atualizada com qualquer mudança nos dados, como a adição de novos clientes ou pedidos.
As listas são paginadas e otimizadas para exibição de um grande número de registros, garantindo performance.
Busca e Filtros de Clientes:

A funcionalidade de pesquisa de clientes permite ao usuário procurar clientes de duas formas:
Por CPF: Busca de um cliente específico utilizando o número de CPF como parâmetro de consulta.
Por E-mail: Pesquisa de clientes com base no e-mail registrado no banco de dados.
Ambas as buscas são feitas de forma eficiente, retornando um único cliente, caso encontrado.
Busca e Filtros de Pedidos:

A funcionalidade de pesquisa de pedidos permite:
Buscar por código do produto: Encontra um pedido específico usando o código do produto.
Buscar por nome do produto: Permite filtrar pedidos com base no nome do produto, retornando uma lista de pedidos que correspondem ao critério de busca.
A busca por cliente também está disponível, permitindo listar todos os pedidos associados a um cliente específico.
Operações CRUD (Criar, Ler, Atualizar, Deletar):

Criar:
Adicionar novos clientes e pedidos através de formulários de entrada.
Ler:
Listar clientes e pedidos na interface de usuário.
Buscar clientes e pedidos com base em critérios específicos.
Atualizar:
Modificar os dados de clientes e pedidos já registrados. Por exemplo, você pode atualizar o nome, CPF ou e-mail de um cliente, ou atualizar as informações de um pedido.
Deletar:
Excluir clientes ou pedidos do banco de dados.
Caso um cliente seja removido, todos os pedidos associados a ele também são automaticamente excluídos devido à configuração de cascade delete no banco de dados.
Interface Responsiva:

A interface foi desenvolvida utilizando Jetpack Compose para garantir uma experiência de usuário moderna e fluida.
A navegação entre telas é feita de maneira simples, com botões e formulários bem posicionados para uma navegação intuitiva.
A tela de gestão de clientes permite adicionar, visualizar, atualizar e excluir clientes.
A tela de gestão de pedidos permite a visualização e modificação dos pedidos.
Notificações e Validação de Dados:

Validação de campos: Certificação de que todos os campos obrigatórios, como nome, CPF e e-mail, estão preenchidos antes de permitir a criação de um novo cliente ou pedido.
Notificações: Exibição de mensagens de erro e sucesso para ações como adicionar ou atualizar um cliente ou pedido.
Feedback visual: Exibição de informações claras sobre os dados inseridos e ações realizadas, garantindo a compreensão do estado do aplicativo pelo usuário.

Detalhamento das Responsabilidades
Nicolas Toaldo:
Conexão com o banco de dados usando Room:
Criação dos DAOs (ClienteDao e PedidoDao) para operações CRUD.
Configuração das entidades e relacionamentos.
Implementação das classes ViewModel:
ClienteViewModel: Gerenciamento de clientes com LiveData.
PedidoViewModel: Gerenciamento de pedidos e busca por filtros.
Gabriel Favalessa:
Interface do usuário e navegação:
Estruturação das telas em XML e Compose.
Implementação das Activities principais (MainActivity e ClienteActivity).
Estruturação das entidades:
Criação das classes Cliente e Pedido.
Integração da lógica de negócios:
Configuração dos repositórios para intermediação entre as ViewModels e os DAOs.
Implementação de operações como adição, edição, exclusão e listagem.
Design do fluxo de navegação:
Integração entre Activities e controle de navegação para melhor usabilidade.

