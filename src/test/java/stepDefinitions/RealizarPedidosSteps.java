package stepDefinitions;

import data.RealizarPedidoData;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class RealizarPedidosSteps {
    @Autowired
    public RealizarPedidoPage page;


    RealizarPedidoData pedidoData = new RealizarPedidoData();

    @Dado("^que o usuário fechou o pedido$")
    public void que_o_usuário_fechou_o_pedido() throws Throwable {
        RestAssured.basePath = pedidoData.getordersApi();
    }

    @Quando("^o usuário preenche os campos obrigatórios$")
    public void o_usuário_preenche_os_campos_obrigatórios() throws Throwable {


        pedidoData.setName("Tiago");
        pedidoData.setEmail("Koubo@yahoo.com.br");
        pedidoData.setEmailConfirmation("koubo@yahoo.com.br");
        pedidoData.setAddress("Rua Florida");
        pedidoData.setNumber("195");

    }

    @Então("^o pedido do usuário é concluido$")
    public void o_pedido_do_usuário_é_concluido() throws Throwable {
                 given()
                .contentType(ContentType.JSON)
                .when()
                .body(pedidoData)
                .post()
                .then()
                .statusCode(201);
    }

    @Dado("^que esteja na pagina de finalizacao de pedido$")
    public void que_esteja_na_pagina_de_finalizacao_de_pedido() throws Throwable {
          page.fecharPedido();
    }

    @Quando("^informo menos de cinco caracteres no campo \"([^\"]*)\": \"([^\"]*)\"$")
    public void informo_menos_de_cinco_caracteres_no_campo(String campo, String valor) throws Throwable {
           if(campo.equals("nome")){
              page.getName().sendKeys(valor);
           }else if(campo.equals("endereço")){
               page.getEndereco().sendKeys(valor);
           }
    }

    @Então("^o sistema deve informar \"([^\"]*)\"$")
    public void o_sistema_deve_informar(String msg) throws Throwable {
         assertEquals(msg,page.getCampoObrigatorioMsg().getText().trim());
    }

    @Quando("^o usuário não preenche um item$")
    public void o_usuário_não_preenche_um_item() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^não deve ser permitido concluir o pedido$")
    public void não_deve_ser_permitido_concluir_o_pedido() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Quando("^o usuário verifica os valores nos campos subtotal e total$")
    public void o_usuário_verifica_os_valores_nos_campos_subtotal_e_total() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^o campo Total recebe a soma dos itens com o frete \\(Total = Itens \\+ Frete\\)$")
    public void o_campo_Total_recebe_a_soma_dos_itens_com_o_frete_Total_Itens_Frete() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^Campo Subtotal recebe o valor unitário do produto multiplicado pela quantidade \\(Subtotal = Valor Unitário \\* Quantidade\\)$")
    public void campo_Subtotal_recebe_o_valor_unitário_do_produto_multiplicado_pela_quantidade_Subtotal_Valor_Unitário_Quantidade() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^todos valores devem conter R\\$$")
    public void todos_valores_devem_conter_R$() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}

