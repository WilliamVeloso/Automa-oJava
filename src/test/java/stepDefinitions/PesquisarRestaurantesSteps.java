package stepDefinitions;


import config.ScreenShot;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PesquisarRestaurantesSteps {

    @Autowired
    private RealizarPedidoPage page;

    @Dado("^que o usuário esteja na pagina de todos os restaurantes$")
    public void queOUsuarioEstejaNaPaginaDeTodosOsRestaurantes() throws Throwable {
        page.restaurante();

    }

    @Quando("^o usuário pesquisa um restaurante$")
    public void oUsuarioPesquisaUmRestaurante() throws Throwable {
        page.btnProcurar();

    }

    @Então("^o restaurante pesquisado é exibido$")
    public void oRestaurantePesquisadoEExibido() throws Throwable {
        page.aguardarElemento(page.getRestauranteSelecionado());
        System.out.println(page.getRestauranteSelecionado());



    }

    @Quando("^adicinou os produtos desejados$")
    public void adicinouOsProdutosDesejados() throws Throwable {
        for (WebElement element : page.getMenu()) {
            page.aguardarElemento(element);
            System.out.println(element.getText());
            if (element.getText().contains("R$")) {
                element.findElement(By.linkText("Adicionar")).click();
            }

        }


    }

    @Então("^todos os valores são exibidos com R\\$$")
    public void todosOsValoresSaoExibidosComR$() throws Throwable {
        for (WebElement element : page.getVerificaCifrao()) {
            page.aguardarElemento(element);
            System.out.println(element.getText());
            Assert.assertThat(element.getText().trim(), CoreMatchers.containsString("R$"));

        }

    }

    @Quando("^que o usuário selecionou o restaurante desejado$")
    public void queOUsuarioSelecionouORestauranteDesejado() throws Throwable {
        page.aguardarElemento(page.getRestauranteSelecionado());



    }

    @Então("^os dados do estabelecimento será exibido$")
    public void osDadosDoEstabelecimentoSeráExibido() throws Throwable {
        for (WebElement element : page.getDadosDoEstabelecimento()) {
            page.aguardarElemento(element);
            System.out.println(element.getText());
            assertEquals(("Categoria\n" +
                    "Hamburgers\n" +
                    "Quem somos\n" +
                    "40 anos se especializando em trash food.\n" +
                    "Horários\n" +
                    "Funciona todos os dias, de 10h às 22h"), element.getText());
        }

    }

    @Dado("^que o usuario esteja na pagina do restaurante desejado$")
    public void queOUsuarioEstejaNaPaginaDoRestauranteDesejado() throws Throwable {
        page.restaurante();
        page.btnProcurar();
        page.aguardarElemento(page.getRestauranteSelecionado());

    }

    @Então("^os itens devem ser exibidos em forma de lista$")
    public void osItensDevemSerExibidosEmFormaDeLista() throws Throwable {
        List elements = page.getMenu();
        System.out.println("Quantidade de itens é:\n"+elements.size());
        assertTrue(elements.size()>1);
    }

    @Então("^o usuário verifica o alinhamento da imagem a esquerda$")
    public void oUsuarioVerificaOAlinhamentoDaImagemAEsquerda() throws Throwable {
        Thread.sleep(1000);
        page.aguardarElemento(page.getImagem1());
        page.aguardarElemento(page.getImagem2());
        page.aguardarElemento(page.getImagem3());
        int imagem1 = page.getImagem1().getLocation().x;
        int imagem2 = page.getImagem2().getLocation().x;
        int imagem3 = page.getImagem3().getLocation().x;
        assertEquals(imagem1,imagem2,imagem3);
        System.out.println("localização imagem1"+(" = ")+imagem1);
        System.out.println("localização imagem2"+(" = ")+imagem2);
        System.out.println("localização imagem3"+(" = ")+imagem3);


    }

    @Então("^o nome do prato é exibido em caixa alta$")
    public void oNomeDoPratoÉExibidoEmCaixaAlta() throws Throwable {
        String prato;
        page.aguardarElemento(page.getnomeDoPrato1());
        page.aguardarElemento(page.getNomeDoPrato2());
        page.aguardarElemento(page.getnomeDoPrato3());
        prato = (page.getnomeDoPrato1().getText()+("\n")+page.getNomeDoPrato2().getText()+("\n")+page.getnomeDoPrato3().getText());
        System.out.println(prato);
        assertEquals(prato,prato.toUpperCase());


    }

    @Então("^logo abaixo do nome do prato é exibido uma breve descrição$")
    public void logoAbaixoDoNomeDoPratoÉExibidoUmaBreveDescrição() throws Throwable {
        for (WebElement element : page.getMenu()) {
            page.aguardarElemento(element);
            WebElement descricao =  element.findElement(By.cssSelector("div > div > span.menu-item-info-box-detail"));
            System.out.println(descricao.getText());
            assertTrue(("O clássico. Não tem como errar.\n" +
                    "Batatas fritas crocantes\n" +
                    "O refri mais gelado da cidade.").contains(descricao.getText()));

        }
    }

    @Então("^todos os botões adicionar devem estar sendo exibidos$")
    public void todosOsBotoesAdicionarDevemEstarSendoExibidos() throws Throwable {
        page.aguardarElemento(page.getnomeDoPrato3());
        page.getAdicionarProduto1().isDisplayed();
        page.getAdicionarProduto2().isDisplayed();
        page.getAdicionarProduto3().isDisplayed();

    }

}





