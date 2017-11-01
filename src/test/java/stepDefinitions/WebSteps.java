package stepDefinitions;

import config.WebDriverWrapper;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import config.WebDriverWrapper.*;
public class WebSteps {

    @Autowired
    public WebDriver driver;

    @Before("@WEB")
    @Dado("^que acesso a aplicação pelo navegador$")
    public void que_acesso_a_aplicação_pelo_navegador() throws Throwable {
        driver.get("http://localhost:4200/");
    }
}
