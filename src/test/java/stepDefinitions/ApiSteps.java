package stepDefinitions;

import com.jayway.restassured.RestAssured;
import config.WebDriverWrapper;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import config.WebDriverWrapper.*;

public class ApiSteps {

    @Before("@API")
    @Dado("^que acesso a api da aplicação$")
    public void que_acesso_a_api_da_aplicação() throws Throwable {
        RestAssured.baseURI= "http://localhost";
        RestAssured.port=3000;
    }
}
