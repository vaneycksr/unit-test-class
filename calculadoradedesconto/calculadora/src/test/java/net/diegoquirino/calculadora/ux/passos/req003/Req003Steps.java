package net.diegoquirino.calculadora.ux.passos.req003;

import net.diegoquirino.calculadora.pages.FormularioContatoPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Req003Steps {

    FormularioContatoPage page;

    @Step
    public void informar_nome(String nome) {
        page.solicitarNomeDoCliente(nome);
    }

    @Step
    public void informar_emais(String email) {
        page.solicitarEmailDoCliente(email);
    }

    @Step
    public void informar_tipo_mensagem(String tipo) {
        page.solicitarTipoMensagem(tipo);
    }

    @Step
    public void informar_faixa_idade(String idade) {
        page.informarFaixaIdade(idade);
    }

    @Step
    public void informar_mensagem(String msg) {
        page.informarConteudoMensagem(msg);
    }

    @Step
    public void submeta() {
        page.submeta();
    }

    @Step
    public void verificar_mensagem_sucesso() {
        assertThat(
                page.getToastMsg(),
                is("Mensagem enviada com sucesso!"));
    }
}
