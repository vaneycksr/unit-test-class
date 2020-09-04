package net.diegoquirino.calculadora.ux.passos.req003;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class Req003GWT {

    @Steps
    Req003Steps steps;

    @Quando("^preencho com dados válidos o formulário$")
    public void preencho_com_dados_válidos_o_formulário(DataTable tabela) throws Exception {
        Map<String, String> dados = tabela.asMap(String.class, String.class);

        steps.informar_nome(dados.get("nome"));
        steps.informar_emais(dados.get("email"));
        steps.informar_tipo_mensagem(dados.get("tipo"));
        steps.informar_faixa_idade(dados.get("idade"));
        steps.informar_mensagem(dados.get("msg"));
    }

    @Quando("^submeto o formulário$")
    public void submeto_o_formulário() throws Exception {
        steps.submeta();
    }

    @Então("^verifico que a mensagem de sucesso foi exibida$")
    public void verifico_que_a_mensagem_de_sucesso_foi_exibida() throws Exception {
        steps.verificar_mensagem_sucesso();
    }

    @Quando("preencho com dados inválidos o formulário")
    public void preencho_com_dados_inválidos_o_formulário(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Então("verifico que a mensagem de erro foi exibida")
    public void verifico_que_a_mensagem_de_erro_foi_exibida() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
