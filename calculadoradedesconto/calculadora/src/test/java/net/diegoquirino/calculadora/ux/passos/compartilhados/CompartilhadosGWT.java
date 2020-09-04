package net.diegoquirino.calculadora.ux.passos.compartilhados;

import io.cucumber.java.pt.Dado;
import net.thucydides.core.annotations.Steps;

public class CompartilhadosGWT {
    // Comunica com a tela (interface do usuário) Given, When, Then

    @Steps
    CompartilhadosSteps steps;

    @Dado("^que estou na página inicial do sistema$")
    public void que_estou_na_página_inicial_do_sistema() throws Exception {
        steps.acesse_pagina_inicial();
    }
    @Dado("^acesso o menu para o formulário de contato$")
    public void acesso_o_menu_para_o_formulário_de_contato() throws Exception {
        steps.acesse_pagina_contato();
    }

}
