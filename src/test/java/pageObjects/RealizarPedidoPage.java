package pageObjects;

import config.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

@Page
public class RealizarPedidoPage {

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

    @FindBy(css = "mt-delivery-costs>div>table>tbody>tr).eq(2)")
    private WebElement total;

    @FindBy(linkText = "Ver Restaurantes")
    private WebElement verRestaurantes;

    @FindBy(css = "a[class='search-link pull-right']")
    private WebElement btnProcurar;

    @FindBy(css = "input[formcontrolname='searchControl']")
    private WebElement campoProcurar;

    @FindBy(css = "div[class='place-info-box']")
    private WebElement listaRestaurante;

    @FindBy(css = "i[class='fa fa-plus-circle']")
    private WebElement adicionarProduto;

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

    public WebElement verRestaurantes() {
        return verRestaurantes;
    }

    public WebElement getCampoObrigatorioMsg(){ return campoObrigatorioMsg;}

    public WebElement getName(){return name;}

    public WebElement getEndereco(){return endereco;}

    public WebElement getMensagemSistema() {return mensagemSistema;}

    public WebElement getMensagemSistema2() {return mensagemSistema2;}

    public void fecharPedido() throws InterruptedException {
        verRestaurantes.click();
        btnProcurar.click();
        campoProcurar.sendKeys("House");
        Thread.sleep(2000);
        listaRestaurante.click();
        Thread.sleep(2000);
        adicionarProduto.click();
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

}
