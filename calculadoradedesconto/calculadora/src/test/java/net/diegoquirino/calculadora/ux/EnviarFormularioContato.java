package net.diegoquirino.calculadora.ux;

import net.diegoquirino.calculadora.pages.FormularioContatoPage;
import net.diegoquirino.calculadora.pages.InicialPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@Nested
@DisplayName("REQ003: Enviar Formulário de Contato")
public class EnviarFormularioContato {
/*
    WebDriver driver;
    WebDriverWait wait;
    InicialPage page;

    final String msgSucesso = "Mensagem enviada com sucesso!";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        page = new InicialPage(driver);
        driver.manage().window().maximize();
        page.get("https://calculadora.diegoquirino.net/");
    }
    @AfterEach
    void tearDown() {
        driver.close();
        driver = null;
        wait = null;
        page = null;
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemDuvidaFaixaIdadeMenor18EntaoSucesso() {
        procedimentoCompleto(
                "Dúvida",
                "Menor que 18 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemDuvidaFaixaIdadeEntre18e60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Dúvida",
                "Entre 18 e 60 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemDuvidaFaixaIdadeAcima60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Dúvida",
                "Acima de 60 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemSugestaoFaixaIdadeMenor18EntaoSucesso() {
        procedimentoCompleto(
                "Sugestão",
                "Menor que 18 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemSugestaoFaixaIdadeEntre18e60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Sugestão",
                "Entre 18 e 60 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemSugestãoFaixaIdadeAcima60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Sugestão",
                "Acima de 60 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemReclamacaoFaixaIdadeMenor18EntaoSucesso() {
        procedimentoCompleto(
                "Reclamação",
                "Menor que 18 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemReclamacaoFaixaIdadeEntre18e60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Reclamação",
                "Entre 18 e 60 anos");
    }
    @Test
    @Tags({@Tag("all"),@Tag("req003")})
    void testEnviarFormularioQuandoTipoMensagemReclamacaoFaixaIdadeAcima60AnosEntaoSucesso() {
        procedimentoCompleto(
                "Reclamação",
                "Acima de 60 anos");
    }

    private void procedimentoCompleto(String tipoMensagem, String faixaIdade) {
        // Procedimento do Teste
        FormularioContatoPage contatoPage =
                page.acessePaginaContato()
                    .preenchaFormularioContato(tipoMensagem, faixaIdade)
                    .submeta();

        // Verificações do Teste
        String resultado = contatoPage.extrairTextoDaPagina(By.xpath("//strong"));
        assertThat(resultado, is(msgSucesso));
    }

*/

}
