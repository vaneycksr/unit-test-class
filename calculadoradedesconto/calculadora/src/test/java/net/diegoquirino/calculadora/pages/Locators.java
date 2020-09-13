package net.diegoquirino.calculadora.pages;

import org.openqa.selenium.By;

public interface Locators {
    /*Página inicial*/
    String ID_BTNCALCULARDESCONTO = "welcome.button.calculardesconto";
    String ID_BTNAJUDA = "welcome.button.ajuda";
    String ID_BTNCONTATO = "welcome.button.contato";

    /*Formulário de contato*/
    String NAME_NOME = "nome";
    String ID_EMAIL = "email";
    String ID_MENSAGEM = "mensagem";
    String CSS_SELECT_FAIXAIDADE = "#idade";
    String ID_BTNSUBMETERCONTATO = "contato.button.enviarMensagem";
    String XPATH_TOASTMSG = "//strong";
    String NAME_TIPOMENSAGEM = "tipoMsg";

    /*Página lista produto*/

    String XPATH_PRODUCT_NAME = "//a[@href='index.php?p=calcularDesconto&pid=1']";
    /*Página para calcular desconto*/
    String ID_TIPOCLIENTE = "tipoCliente";
    String ID_QUANTIDADE = "quantidade";
    String ID_BTN_CONFIRMAR = "calculardesconto.button.calcular";

    /*Página resultado*/
    String MSG = "//div[@class='container-fluid text-justify']/div/strong";
    String FATOR_OBTIDO = "//div[@class='panel panel-info']/div/p[3]";

}
