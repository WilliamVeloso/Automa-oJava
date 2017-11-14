#language:pt
Funcionalidade: Pesquisar Restaurante

  Narrativa:
  Como um cliente que adora comer gostaria de pesquisar um restaurante de minha preferência
  Para que possa visualizar as informações sobre o estabelecimento e o cardápio online.

    @WEB
    Cenário: Pesquisando um restaurante
      Dado que o usuário esteja na pagina de todos os restaurantes
      Quando o usuário pesquisa um restaurante
      Então o restaurante pesquisado é exibido

    @WEB
    Cenário: Exibir R$ em todos os valores
      Dado que o usuário esteja na pagina de todos os restaurantes
      Quando o usuário pesquisa um restaurante
      E o restaurante pesquisado é exibido
      E adicinou os produtos desejados
      Então todos os valores são exibidos com R$

    @WEB
    Cenário: Dados do estabelecimento
      Dado que o usuário esteja na pagina de todos os restaurantes
      Quando o usuário pesquisa um restaurante
      E que o usuário selecionou o restaurante desejado
      Então os dados do estabelecimento será exibido

    @WEB
    Cenario: Cardápio itens forma de lista
      Dado que o usuario esteja na pagina do restaurante desejado
      Quando verifica que existe mais de um item
      Então os itens devem ser exibidos em forma de lista

    @WEB
    Cenario: Cardápio alinhamento de imagem
      Dado que o usuario esteja na pagina do restaurante desejado
      Entao o usuário verifica o alinhamento da imagem a esquerda

    @WEB
    Cenario: Cardápio nome do prato
      Dado que o usuario esteja na pagina do restaurante desejado
      Então o nome do prato é exibido em caixa alta

    @WEB
    Cenario: Cardápio breve descrição
      Dado que o usuario esteja na pagina do restaurante desejado
      Entao logo abaixo do nome do prato é exibido uma breve descrição

    @WEB
    Cenario: Botão adicionar
      Dado que o usuario esteja na pagina do restaurante desejado
      Entao todos os botões adicionar devem estar sendo exibidos









