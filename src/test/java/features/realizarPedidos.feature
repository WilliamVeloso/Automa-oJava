#language: pt
Funcionalidade: Realizar Pedido

    Narrativa:
    Como um cliente que adora comer gostaria de realizar o pedido do meu prato favorito
    Para que possa ser entregue no endereço desejado e seja pago na forma de pagamento de minha escolha.

    @API
    Cenário: O usuário faz um pedido
        Dado que o usuário fechou o pedido
        Quando o usuário preenche os campos obrigatórios
        Então o pedido do usuário é concluido

    @WEB
    Esquema do Cenário: A quantidade minima de caracteres no campo
        Dado que esteja na pagina de finalizacao de pedido
        Quando informo menos de cinco caracteres no campo "<Campo>": "<Valor>"
        Então o sistema deve informar "<Mensagem>"

        Exemplos:
            | Campo    | Valor | Mensagem                             |
            | nome     | A     | Campo obrigatório e com 5 caracteres |
            | endereço | Rua   | Campo obrigatório e com 5 caracteres |

    Cenário: Item não preenchido
        Dado que o usuário fechou o pedido
        Quando o usuário não preenche um item
        Então não deve ser permitido concluir o pedido

    Cenário: Verificar valores
        Dado que o usuário fechou o pedido
        Quando o usuário verifica os valores nos campos subtotal e total
        Então o campo Total recebe a soma dos itens com o frete (Total = Itens + Frete)
        E Campo Subtotal recebe o valor unitário do produto multiplicado pela quantidade (Subtotal = Valor Unitário * Quantidade)
        E todos valores devem conter R$