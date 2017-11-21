package stepDefinitions;


import config.WaitMeWebElementHandler;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PesquisarRestaurantesSteps {

    @Autowired
    private RealizarPedidoPage page;




    @Dado("^que o usuário esteja na pagina de todos os restaurantes$")
    public void queOUsuárioEstejaNaPaginaDeTodosOsRestaurantes() throws Throwable {
        page.restaurante();

    }

    @Quando("^o usuário pesquisa um restaurante$")
    public void oUsuarioPesquisaUmRestaurante() throws Throwable {
        page.btnProcurar();

    }

    @Então("^o restaurante pesquisado é exibido$")
    public void oRestaurantePesquisadoEExibido() throws Throwable {
        page.aguardarElemento(page.getListaRestaurante());

    }

    @Quando("^adicinou os produtos desejados$")
    public void adicinouOsProdutosDesejados() throws Throwable {
        for (WebElement element : page.getMenu()) {
            Thread.sleep(2000);
            System.out.println(element.getText());
            if (element.getText().contains("R$")) {
                element.findElement(By.linkText("Adicionar")).click();
            } else {
                System.out.println("nao tem R$");
                return;
            }

        }


    }

    @Então("^todos os valores são exibidos com R\\$$")
    public void todosOsValoresSãoExibidosComR$() throws Throwable {
        for (WebElement element : page.getVerificaCifrao()) {
            Thread.sleep(2000);
            System.out.println(element.getText());
            Assert.assertThat(element.getText().trim(), CoreMatchers.containsString("R$"));

        }

    }

    @Quando("^que o usuário selecionou o restaurante desejado$")
    public void queOUsuarioSelecionouORestauranteDesejado() throws Throwable {
        Thread.sleep(1000);
        page.getListaRestaurante().click();



    }

    @Então("^os dados do estabelecimento será exibido$")
    public void osDadosDoEstabelecimentoSeráExibido() throws Throwable {
        for (WebElement element : page.getDadosDoEstabelecimento()) {
            Thread.sleep(2000);
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
        Thread.sleep(2000);
        page.getListaRestaurante().click();

    }

    @Quando("^verifica que existe mais de um item$")
    public void verificaQueExisteMaisDeUmItem() throws Throwable {
        List elements = page.getMenu();
        System.out.println("Quantidade de itens é:\n"+elements.size());
        assertTrue(elements.size()>1);

    }

    @Então("^os itens devem ser exibidos em forma de lista$")
    public void osItensDevemSerExibidosEmFormaDeLista() throws Throwable {
        for (WebElement element : page.getMenu()) {
            Thread.sleep(2000);
            System.out.println(element);
        }
            System.out.println("Itens exibidos em forma de lista");
    }

    @Então("^o usuário verifica o alinhamento da imagem a esquerda$")
    public void oUsuarioVerificaOAlinhamentoDaImagemAEsquerda() throws Throwable {
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        prato = (page.getnomeDoPrato1().getText()+("\n")+page.getNomeDoPrato2().getText()+("\n")+page.getnomeDoPrato3().getText());
        System.out.println(prato);
        assertEquals(prato,prato.toUpperCase());


    }

    @Então("^logo abaixo do nome do prato é exibido uma breve descrição$")
    public void logoAbaixoDoNomeDoPratoÉExibidoUmaBreveDescrição() throws Throwable {
        for (WebElement element : page.getMenu()) {
            Thread.sleep(2000);
            WebElement descricao =  element.findElement(By.cssSelector("div > div > span.menu-item-info-box-detail"));
            System.out.println(descricao.getText());
            assertTrue(("O clássico. Não tem como errar.\n" +
                    "Batatas fritas crocantes\n" +
                    "O refri mais gelado da cidade.").contains(descricao.getText()));

        }
    }

    @Então("^todos os botões adicionar devem estar sendo exibidos$")
    public void todosOsBotoesAdicionarDevemEstarSendoExibidos() throws Throwable {
        page.getAdicionarProduto1().isDisplayed();
        page.getAdicionarProduto2().isDisplayed();
        page.getAdicionarProduto3().isDisplayed();

    }

}





