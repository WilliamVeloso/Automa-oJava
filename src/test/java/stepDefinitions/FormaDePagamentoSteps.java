package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import data.RealizarPedidoData;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;

import static org.junit.Assert.assertEquals;

public class FormaDePagamentoSteps {

    @Autowired
    private RealizarPedidoPage page;
    private RealizarPedidoData dados;


    @Dado("^que o usuário realizou seu pedido$")
    public void queousuáriorealizouseupedido() throws InterruptedException {
        page.fecharPedido();


    }

    @Quando("^o usuário preenche todos os campos obrigatórios$")
    public void o_usuário_preenche_todos_os_campos_obrigatórios() throws Throwable {
        page.setDados();

    }

    @Quando("^seleciona o tipo de pagamento \"([^\"]*)\"$")
    public void seleciona_o_tipo_de_pagamento(String args1) throws Throwable {
        page.selecionarFormaPagamento();

    }

    @Quando("^o pedido do usuário foi concluido$")
    public void o_pedido_do_usuário_foi_concluido() throws Throwable {
        page.concluirPedido();
    }

    @Então("^uma frase sera apresentada \"([^\"]*)\"$")
    public void umaFraseSeraApresentada(String arg1) throws Throwable {
        assertEquals(arg1, ((page.getMensagemSistema().getText().trim())+("  ")+(page.getMensagemSistema2().getText().trim())));

    }

}
