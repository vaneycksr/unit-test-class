package net.diegoquirino.calculadora.ux.passos.req001;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.diegoquirino.calculadora.pages.DescontoPage;
import net.diegoquirino.calculadora.pages.InicialPage;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraDeDescontoSteps {

    InicialPage page;
    DescontoPage descontoPage;

    @Dado("que estou na pàgina inicial da Calculadora de Desconto")
    public void que_estou_na_pàgina_inicial_da_Calculadora_de_Desconto() {

        page.get("https://calculadora.diegoquirino.net/");


    }

    @Quando("selecionar um produto")
    public void selecionar_um_produto() {

        page.acessarCalculoDesconto();
        page.acessarProduto();

    }

    @Quando("selecionar o tipo cliente {string}")
    public void selecionar_o_tipo_cliente(String tipoCliente) {

        descontoPage.selecionarTipoCliente(tipoCliente);

    }

    @Quando("inserir a quantidade de itens igual a {string}")
    public void inserir_a_quantidade_de_itens_igual_a(String quantidade) {
        descontoPage.preencherQuantidade(quantidade);
    }

    @Quando("confirmo o desconto")
    public void confirmo_o_desconto() {
        descontoPage.clicarConfirmar();
    }

    @Então("deve ser apresentado o fator {string}")
    public void deve_ser_apresentado_o_fator(String fator) {
        assertEquals(fator,descontoPage.capturaFator());
    }

    @Então("a mensagem {string}")
    public void a_mensagem(String mensagem) {

        assertEquals(mensagem,descontoPage.capturaMensagem());
    }
}
