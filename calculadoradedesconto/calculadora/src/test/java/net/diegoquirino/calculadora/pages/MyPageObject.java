package net.diegoquirino.calculadora.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.Normalizer;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPageObject extends PageObject {

    private Integer tempoDeEspera = 10;

    public String extrairTextoDaPagina(WebElement element) {
        verificarPresenca(element);
        return element.getText();
    }


    public void submeterFormulario(WebElement element) {
        verificarPresenca(element);
        element.submit();
    }

    public void clicar(WebElement element) {
        verificarPresenca(element);
        element.click();
    }

    public void aguardar(Integer segundos) {
        await().atLeast(segundos, TimeUnit.SECONDS);
    }

    public void preencher(WebElement element, String nomeCompleto) {
        element.clear();
        // await().atLeast(500,TimeUnit.MILLISECONDS).until();
        element.sendKeys(nomeCompleto);
    }

    public void selecionarNoCombobox(WebElement select, String label) {
        Select combobox = new Select(select);
        combobox.selectByVisibleText(label);
    }

    public void verificarPresenca(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempoDeEspera);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElements(element)
        ));
    }

    public String normalizar(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return texto.replaceAll("[^\\p{ASCII}]", "");
    }

}
