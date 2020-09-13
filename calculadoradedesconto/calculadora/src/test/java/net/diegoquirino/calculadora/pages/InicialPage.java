package net.diegoquirino.calculadora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InicialPage extends MyPageObject {

    @FindBy(id=Locators.ID_BTNCALCULARDESCONTO)
    WebElement botaoCalcularDesconto;
    @FindBy(id=Locators.ID_BTNAJUDA)
    WebElement botaoAjuda;
    @FindBy(id=Locators.ID_BTNCONTATO)
    WebElement botaoContato;
    @FindBy(xpath = Locators.XPATH_PRODUCT_NAME)
    WebElement botaoProduto;


    public void acessarCalculoDesconto() {
        clicar(botaoCalcularDesconto);
    }

    public void acessarProduto() {
        clicar(botaoProduto);
    }

    public void acessarAjuda() {
        clicar(botaoAjuda);
    }

    public void acessePaginaContato() {
        clicar(botaoContato);
    }

    public void get(String url) {
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

}
