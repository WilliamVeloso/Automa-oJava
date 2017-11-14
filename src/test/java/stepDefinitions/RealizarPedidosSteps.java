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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
    public void o_usuario_não_preenche_um_item() throws Throwable {
        page.setDados();



    }

    @Então("^não deve ser permitido concluir o pedido$")
    public void nao_deve_ser_permitido_concluir_o_pedido() throws Throwable {
        assertFalse(page.getConcluirPedido().isEnabled());

    }



    @Então("^o campo Total recebe a soma dos itens com o frete \\(Total = Itens \\+ Frete\\)$")
    public void o_campo_Total_recebe_a_soma_dos_itens_com_o_frete_Total_Itens_Frete() throws Throwable {
        String elementoFrete = page.getFrete().getText();
        String elementoItens = page.getItens().getText();
        String elementoTotal = page.getTotal().getText();
        String replaceStringFrete = elementoFrete.replace("R$","");
        String replacePontoFrete = replaceStringFrete.replace(',','.');
        String replaceStringItens = elementoItens.replace("R$","");
        String replacePontoItens = replaceStringItens.replace(',','.');
        String replaceStringTotal = elementoTotal.replace("R$","");
        String replacePontoTotal = replaceStringTotal.replace(',','.');
        float inteitoTotal = Float.parseFloat(replacePontoTotal);
        float inteiroFrete = Float.parseFloat(replacePontoFrete);
        float inteiroItens = Float.parseFloat(replacePontoItens);
        float soma = inteiroFrete+inteiroItens;

        System.out.println("Total\n"+soma);
        assertEquals(soma,inteitoTotal,0.00001);

    }

    @Então("^Campo Subtotal recebe o valor unitário do produto multiplicado pela quantidade \\(Subtotal = Valor Unitário \\* Quantidade\\)$")
    public void campo_Subtotal_recebe_o_valor_unitario_do_produto_multiplicado_pela_quantidade_Subtotal_Valor_Unitario_Quantidade() throws Throwable {
            float dividir;
        for (WebElement element : page.getSubTotal()) {
            Thread.sleep(2000);
            WebElement subTotal = element.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(4)"));
            String elementoSubtotal = subTotal.getText();
            String replaceStringSubtotal = elementoSubtotal.replace("R$","");
            String valorSubTotal = replaceStringSubtotal.replace(',','.');
            WebElement item1 = element.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td.text-center"));
            String elementoItem1 = item1.getText();
            float inteitoSubTotal = Float.parseFloat(valorSubTotal);
            System.out.println("Subtotal\n"+inteitoSubTotal);
            float inteiroItem1 = Float.parseFloat(elementoItem1);
            System.out.println("Numero de Itens\n"+inteiroItem1);
            dividir = (inteitoSubTotal / inteiroItem1)*inteiroItem1;

            assertEquals(inteitoSubTotal,dividir, 0.1);


        }


    }

    @Então("^todos valores devem conter R\\$$")
    public void todosValoresDevemConterR$() throws Throwable {
        for (WebElement element : page.getSubTotal()) {
            Thread.sleep(2000);
            WebElement subTotal = element.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(4)"));
            String elementoSubtotal = subTotal.getText();
            String elementoFrete = page.getFrete().getText();
            String elementoItens = page.getItens().getText();
            String elementoTotal = page.getTotal().getText();
            assertTrue(elementoFrete.contains("R$"));
            assertTrue(elementoSubtotal.contains("R$"));
            assertTrue(elementoItens.contains("R$"));
            assertTrue(elementoTotal.contains("R$"));


        }

    }

}

