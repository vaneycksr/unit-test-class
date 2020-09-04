package net.diegoquirino.calculadora.ux;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@Nested
@DisplayName("Teste de Sistema - Calcular Fator de Desconto")
public class CalcularFatorDeDescontoTest {

    WebDriver driver;
    final String URL_BASE = "http://calculadora.diegoquirino.net/";

    @BeforeEach
    void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }
    @AfterEach
    void tearDown() {
        driver.close();
        driver = null;
    }
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar o fator de desconto quando Cliente C e Quantidade a partir de 1000 Então será igual a 0.90")
    public void verificarFatorDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoFatorIgualA090() {
        /* Procedimento do Caso de Teste */
        clicar_por_id("welcome.button.calculardesconto");
        clicar_por_cssSelector("tr:nth-child(1) .btn-primary > .glyphicon");
        escolher_item_combo_por_id_e_label("tipoCliente", "C");
        inserir_texto_por_id("quantidade", "1000");
        submeter_formulario("calculardesconto.button.calcular");

        /* Verificações do Caso de Teste */
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".panel-body > p:nth-child(3)")));
        assertThat(driver.findElement(By.cssSelector(".panel-body > p:nth-child(3)")).getText(), is("Fator obtido: 0.9 (ou seja, 10% de desconto)"));
    }

    private void submeter_formulario(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)),
                ExpectedConditions.presenceOfElementLocated(By.id(id))
        ));
        driver.findElement(By.id(id)).submit();
    }

    private void inserir_texto_por_id(String id, String texto) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)),
                ExpectedConditions.presenceOfElementLocated(By.id(id))
        ));
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(texto);
    }

    private void escolher_item_combo_por_id_e_label(String id, String label) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)),
                ExpectedConditions.presenceOfElementLocated(By.id(id))
        ));
        WebElement tipoCliente = driver.findElement(By.id("tipoCliente"));
        Select combo = new Select(tipoCliente);
        combo.selectByVisibleText(label);
    }

    private void clicar_por_cssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)),
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))
        ));
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    private void clicar_por_id(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)),
                ExpectedConditions.presenceOfElementLocated(By.id(id))
        ));
        driver.findElement(By.id(id)).click();
    }

}
