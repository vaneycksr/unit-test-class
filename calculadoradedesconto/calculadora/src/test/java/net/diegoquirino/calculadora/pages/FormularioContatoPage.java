package net.diegoquirino.calculadora.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class FormularioContatoPage extends MyPageObject {

    @FindBy(name = Locators.NAME_NOME)
    WebElement inputNome;
    @FindBy(id = Locators.ID_EMAIL)
    WebElement inputEmail;
    @FindBy(name = Locators.NAME_TIPOMENSAGEM)
    List<WebElement> radioTipoMensagem;
    @FindBy(css = Locators.CSS_SELECT_FAIXAIDADE)
    WebElement selectFaixaIdade;
    @FindBy(id = Locators.ID_MENSAGEM)
    WebElement textMensagem;
    @FindBy(id = Locators.ID_BTNSUBMETERCONTATO)
    WebElement botaoSubmeterCotato;
    @FindBy(xpath = Locators.XPATH_TOASTMSG)
    WebElement toastMsg;

    public void preenchaFormularioContato(String tipoMensagem, String faixaIdade) {
        Faker faker = new Faker(new Locale("pt_BR"));
        solicitarNomeDoCliente(faker.name().fullName());
        solicitarEmailDoCliente(faker.internet().emailAddress());
        solicitarTipoMensagem(tipoMensagem);
        informarFaixaIdade(faixaIdade);
        informarConteudoMensagem(faker.dragonBall().character());
        
    }

    public void informarFaixaIdade(String faixaIdade) {
        verificarPresenca(selectFaixaIdade);
        selecionarNoCombobox(selectFaixaIdade, faixaIdade);
    }

    public void solicitarTipoMensagem(String tipoMensagem) {
        clicar(radioTipoMensagem.stream()
                .filter(tipo -> {
                    String msg = normalizar(tipoMensagem.toLowerCase());
                    System.out.println("Tipo Mensagem Normalizado >>> " + msg);
                    return tipo.getAttribute("value").equals(msg);
                })
                .findFirst()
                .get());
    }

    public void solicitarNomeDoCliente(String nomeCompleto) {
        verificarPresenca(inputNome);
        preencher(inputNome, nomeCompleto);
        
    }
    public void solicitarEmailDoCliente(String email) {
        verificarPresenca(inputEmail);
        preencher(inputEmail, email);
        
    }
    public void informarConteudoMensagem(String mensagem) {
        verificarPresenca(textMensagem);
        preencher(textMensagem, mensagem);
        
    }
    public void submeta() {
        submeterFormulario(botaoSubmeterCotato);
        
    }
    public String getToastMsg() {
        return toastMsg.getText();
    }

}
