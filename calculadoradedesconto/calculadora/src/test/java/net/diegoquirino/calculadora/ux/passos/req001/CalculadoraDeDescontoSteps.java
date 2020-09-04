package net.diegoquirino.calculadora.ux.passos.req001;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.diegoquirino.calculadora.pages.InicialPage;
import net.thucydides.core.annotations.Step;

public class CalculadoraDeDescontoSteps {

    InicialPage page;

    @Dado("que estou na pàgina inicial da Calculadora de Desconto")
    public void que_estou_na_pàgina_inicial_da_Calculadora_de_Desconto() {

        page.get("https://calculadora.diegoquirino.net/");

    }

    @Quando("selecionar um produto")
    public void selecionar_um_produto() {

        page.acessarCalculoDesconto();
    }

    @Quando("selecionar o tipo cliente {string}")
    public void selecionar_o_tipo_cliente(String string) {


    }

    @Quando("inserir a quantidade de itens igual a {string}")
    public void inserir_a_quantidade_de_itens_igual_a(String string) {

    }

    @Quando("confirmo o desconto")
    public void confirmo_o_desconto() {

    }

    @Então("deve ser apresentado o fator {double} \\({int}% de desconto) e a mensagem {string}")
    public void deve_ser_apresentado_o_fator_de_desconto_e_a_mensagem(Double double1, Integer int1, String string) {

    }
}
