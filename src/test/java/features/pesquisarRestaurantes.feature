#language:pt

  Funcionalidade: Pesquisar Restaurante

    Como um cliente que adora comer
    Gostaria de pesquisar um restaurante de minha preferência
    Para que possa visualizar as informações sobre o estabelecimento
    assim como o cardápio online

    Critérios de aceite:

    - Campos obrigatórios:
    - Campo para busca do restaurante

    - Valores
    - Todos valores devem conter "R$"

    - Dados do estabelecimento
    - Categoria (para saber qual a especialidade)gym
    - Quem somos (para saber se tem know how no mercado)
    - Horários (para saber qual horário de funcionamento)

    - Cardápio
    - Itens devem ser exibidos em forma de lista
    - Imagem alinhada a esquerda
    - Nome do prato em caixa alta
    - Breve descrição do prato abaixo do nome
    - Botão adicionar deve estar sendo exibido

    @pesquisarRestaurantes
   Cenário: Posso pesquisar por um restaurante
     Dado que eu esteja na pagina de pesquisa de restaurantes
     Quando eu busco por um restaurante
     Então eu verifico que este restarante é listado

