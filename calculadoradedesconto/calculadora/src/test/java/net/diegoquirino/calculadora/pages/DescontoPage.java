package net.diegoquirino.calculadora.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static net.diegoquirino.calculadora.pages.Locators.*;

public class DescontoPage extends MyPageObject {

    @FindBy(id = ID_TIPOCLIENTE)
    WebElement tipoCliente;
    @FindBy(id = ID_QUANTIDADE)
    WebElement quantidade;
    @FindBy(id = ID_BTN_CONFIRMAR)
    WebElement botao;
    @FindBy(xpath = FATOR_OBTIDO)
    WebElement fator;
    @FindBy(xpath = MSG)
    WebElement mensagem;


    public void selecionarTipoCliente(String tipo) {
        selecionarNoCombobox(tipoCliente,tipo);
    }

    public void preencherQuantidade(String qty) {
        preencher(quantidade,qty);
    }

    public void clicarConfirmar() {
        clicar(botao);
    }

    public String capturaFator(){

        return extrairTextoDaPagina(fator);
    }

    public String capturaMensagem(){

        return extrairTextoDaPagina(mensagem);
    }

}
