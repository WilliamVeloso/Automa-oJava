package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import pageObjects.RealizarPedidoPage;

public class PesquisarRestaurantesSteps {

    @Autowired
    private RealizarPedidoPage page;

    @Dado("^que o usuário esteja na pagina de todos os restaurantes$")
    public void queOUsuárioEstejaNaPaginaDeTodosOsRestaurantes() throws Throwable {
        page.verRestaurantes().click();

    }

    @Quando("^o usuário pesquisa um restaurante$")
    public void oUsuárioPesquisaUmRestaurante() throws Throwable {
        page.getBtnProcurar().click();
        page.getCampoProcurar().sendKeys("House");
        Thread.sleep(2000);
    }

    @Então("^o restaurante pesquisado é exibido$")
    public void oRestaurantePesquisadoÉExibido() throws Throwable {
        page.getListaRestaurante().click();
    }
}
