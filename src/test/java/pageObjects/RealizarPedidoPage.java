package pageObjects;

import config.Page;
import config.WaitMe;
import config.WebDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static config.WebDriverWrapper.getWebDriver;

@Page
public class RealizarPedidoPage {

    @Autowired
    private WebDriver driver;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement name;

    @FindBy(css = "input[formcontrolname='email']")
    private WebElement email;

    @FindBy(css = "input[formcontrolname='emailConfirmation']")
    private WebElement emailConfirmation;

    @FindBy(css = "input[formcontrolname='address']")
    private WebElement endereco;

    @FindBy(css = "input[formcontrolname='number']")
    private WebElement numero;

    @FindBy(css = "input[formcontrolname='optionalAddress']")
    private WebElement complemento;

    @FindBy(css = "body > mt-app > div > div > div > mt-order > section.content > section > form > div:nth-child(5) > div:nth-child(1) > div > mt-radio > div:nth-child(1) > label > div > ins")
    private WebElement formaPagamento;

    @FindBy(css = "body > mt-app > div > div > div > mt-order > section.content > section > form > div:nth-child(5) > div:nth-child(2) > mt-delivery-costs > div > table > tbody > tr:nth-child(3) > td")
    private WebElement total;

    @FindBy(linkText = "Ver Restaurantes")
    private WebElement verRestaurantes;

    @FindBy(css = "a[class='search-link pull-right']")
    private WebElement btnProcurar;

    @FindBy(css = "input[formcontrolname='searchControl']")
    private WebElement campoProcurar;

    @FindBy(css = "body > mt-app > div > div > div > mt-restaurants > section.content > div > div > mt-restaurant > a > div")
    private WebElement listaRestaurante;

    @FindBy(css = "i[class='fa fa-plus-circle']")
    private WebElement adicionarProduto1;

    @FindBy(css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(2) > div > div > a > i")
    private WebElement adicionarProduto2;

    @FindBy(css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(3) > div > div > a > i")
    private WebElement adicionarProduto3;

    @FindBy(css = "a[class='btn btn-success']")
    private WebElement fecharPedido;

    @FindBy(css = "span[class='help-block']")
    private WebElement campoObrigatorioMsg;

    @FindBy(css = "body > mt-app > div > div > div > mt-order > section.content > section > div > div > button")
    private WebElement concluirPedido;

    @FindBy(css = "body > mt-app > div > div > div > mt-order-summary > section.content > div > h2")
    private WebElement mensagemSistema;

    @FindBy (css = "body > mt-app > div > div > div > mt-order-summary > section.content > div > p:nth-child(2)")
    private WebElement mensagemSistema2;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item")
    private List<WebElement> menu;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-3.col-xs-12 > mt-shopping-cart > div > div.box-body > div > table > tbody > tr")
    private List<WebElement> verificaCifrao;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(1) > div > div > div.box-body > dl")
    private List<WebElement> dadosDoEstabelecimento;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(1) > div > span > img")
    private WebElement imagem1;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(2) > div > span > img")
    private WebElement imagem2;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(3) > div > span > img")
    private WebElement imagem3;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(1) > div > div > span.menu-item-info-box-text")
    private WebElement nomeDoPrato1;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(2) > div > div > span.menu-item-info-box-text")
    private WebElement nomeDoPrato2;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurant-detail > section.content > div:nth-child(2) > mt-menu > div.col-md-9.col-xs-12 > mt-menu-item:nth-child(3) > div > div > span.menu-item-info-box-text")
    private WebElement nomeDoPrato3;

    @FindBy (css = "body > mt-app > div > div > div > mt-order > section.content > section > form > div:nth-child(4) > mt-order-items > div")
    private List<WebElement> subTotal;

    @FindBy (css = "body > mt-app > div > div > div > mt-order > section.content > section > form > div:nth-child(5) > div:nth-child(2) > mt-delivery-costs > div > table > tbody > tr:nth-child(1) > td")
    private WebElement itens;

    @FindBy (css = "body > mt-app > div > div > div > mt-order > section.content > section > form > div:nth-child(5) > div:nth-child(2) > mt-delivery-costs > div > table > tbody > tr:nth-child(2) > td")
    private WebElement frete;

    @FindBy (css = "body > mt-app > div > div > div > mt-restaurants > section.content > div > div:nth-child(2)")
    private  WebElement restauranteSelecionado;

    @Autowired
    private WebDriverWait wait;



    public WebElement getFecharPedido() {return fecharPedido;}

    public WebElement getTotal() {return total;}

    public List<WebElement> getSubTotal() {return subTotal;}

    public WebElement getItens() {return itens;}

    public WebElement getFrete() {return frete;}

    public WebElement getConcluirPedido() {return concluirPedido;}

    public WebElement getImagem1() {return imagem1;}

    public WebElement getImagem2() {return imagem2;}

    public WebElement getImagem3() {return imagem3;}

    public WebElement getnomeDoPrato1() {return nomeDoPrato1;}

    public WebElement getNomeDoPrato2() {return nomeDoPrato2;}

    public WebElement getnomeDoPrato3() {return nomeDoPrato3;}

    public List<WebElement> getDadosDoEstabelecimento() {return dadosDoEstabelecimento;}

    public List<WebElement> getVerificaCifrao() {return verificaCifrao;}

    public List<WebElement> getMenu() {return menu;}

    public WebElement getCampoObrigatorioMsg(){ return campoObrigatorioMsg;}

    public WebElement getName(){return name;}

    public WebElement getEndereco(){return endereco;}

    public WebElement getMensagemSistema() {return mensagemSistema;}

    public WebElement getMensagemSistema2() {return mensagemSistema2;}

    public WebElement getCampoProcurar() {return campoProcurar;}

    public WebElement getListaRestaurante() {return listaRestaurante;}

    public WebElement getAdicionarProduto1() {return adicionarProduto1;}

    public WebElement getAdicionarProduto2() {return adicionarProduto2;}

    public WebElement getAdicionarProduto3() {return adicionarProduto3;}

    public WebElement getRestauranteSelecionado() {return restauranteSelecionado;}

    public void restaurante() throws InterruptedException{
        verRestaurantes.click();
    }

    public void btnProcurar() throws InterruptedException{
        btnProcurar.click();
        campoProcurar.sendKeys("House");
        btnProcurar.click();
        btnProcurar.click();
    }

    public void aguardarElemento(WebElement elemento) throws InterruptedException{
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
        element.click();
    }



    public void fecharPedido() throws InterruptedException {
        verRestaurantes.click();
        btnProcurar();
        Thread.sleep(2000);
        listaRestaurante.click();
        Thread.sleep(2000);
        adicionarProduto1.click();
        fecharPedido.click();
    }


    public void setDados() throws InterruptedException {
        name.sendKeys("Rodrigo Soares");
        email.sendKeys("RodrigoSoares@gmail.com");
        emailConfirmation.sendKeys("RodrigoSoares@gmail.com");
        endereco.sendKeys("Rua Alfredo Romero");
        numero.sendKeys("271");
        complemento.sendKeys("2B");


    }

    public void selecionarFormaPagamento() throws InterruptedException {
        formaPagamento.click();

    }

    public void concluirPedido() throws InterruptedException {
        concluirPedido.click();
    }

    public void verificarCifrao() throws InterruptedException {
        adicionarProduto1.click();
        adicionarProduto2.click();
        adicionarProduto3.click();
    }

}
