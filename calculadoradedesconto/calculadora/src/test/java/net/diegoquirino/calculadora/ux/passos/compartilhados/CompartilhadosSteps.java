package net.diegoquirino.calculadora.ux.passos.compartilhados;

import net.diegoquirino.calculadora.pages.InicialPage;
import net.thucydides.core.annotations.Step;

public class CompartilhadosSteps {
    // Comunica com o PageObject
    InicialPage page;

    @Step
    public void acesse_pagina_inicial() {
        page.get("https://calculadora.diegoquirino.net/");
    }
    @Step
    public void acesse_pagina_contato() {
        page.acessePaginaContato();
    }
}
