#language: pt
Funcionalidade: Realizar Pedido

    Narrativa:
    Como um cliente que adora comer gostaria de realizar o pedido do meu prato favorito
    Para que possa ser entregue no endereço desejado e seja pago na forma de pagamento de minha escolha.

    @WEB
    Esquema do Cenário: Forma de pagamento
        Dado que o usuário realizou seu pedido
        Quando o usuário preenche todos os campos obrigatórios
        E seleciona o tipo de pagamento "<Tipo>"
        E o pedido do usuário foi concluido
        Então uma frase sera apresentada "<Frase>"

        Exemplos:
            | Tipo         | Frase                |
            | Dinheiro     | Pedido Conluído  Seu pedido foi recebido pelo restaurante. Prepare a mesa que a comida está chegando!     |

