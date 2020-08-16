package br.unipe.allsolution.calculadoradedescontos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    Item driver;
    private TipoCliente tipoCliente;

    Integer quantidadeInferiorA1000, quantidadeInferiorA100, quantidadeAPartirDe1000;
    Double valorDoProduto;

    @BeforeEach
    public void setUp() {
        driver = new Item();
        this.quantidadeInferiorA100 = 99;
        this.quantidadeInferiorA1000 = 999;
        this.quantidadeAPartirDe1000 = 1000;
        this.valorDoProduto = 4.78300;
    }

    @AfterEach
    public void tearDown() {
        this.driver = null;
    }

    /** CLIENTE A **/

    @Test
    public void testGetValorComDescontoQuandoClienteAQuantidadeInferiorA100EntaoDescontoSera010PorCento(){

        this.driver.setTipoCliente(TipoCliente.A);
        this.driver.setProduto(new Produto(valorDoProduto)); // ja funciona assim
        this.driver.setQuantidade(quantidadeInferiorA100);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.30470,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteAQuantidadeInferiorA1000EntaoDescontoSera005PorCento(){

        this.driver.setTipoCliente(TipoCliente.A);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeInferiorA1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.54385,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteAQuantidadeInferiorA1000EntaoDescontoSera000PorCento(){

        this.driver.setTipoCliente(TipoCliente.A);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeAPartirDe1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.78300,resultado);
    }

    /** CLIENTE B **/

    @Test
    public void testGetValorComDescontoQuandoClienteBQuantidadeInferiorA100EntaoDescontoSera015PorCento(){

        this.driver.setTipoCliente(TipoCliente.B);
        this.driver.setProduto(new Produto(valorDoProduto)); // ja funciona assim
        this.driver.setQuantidade(quantidadeInferiorA100);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.06555,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteBQuantidadeInferiorA1000EntaoDescontoSera010PorCento(){

        this.driver.setTipoCliente(TipoCliente.B);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeInferiorA1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.30470,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteBQuantidadeInferiorA1000EntaoDescontoSera005PorCento(){

        this.driver.setTipoCliente(TipoCliente.B);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeAPartirDe1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.54385,resultado);
    }

    /** CLIENTE C **/

    @Test
    public void testGetValorComDescontoQuandoClienteCQuantidadeInferiorA100EntaoDescontoSera020PorCento(){

        this.driver.setTipoCliente(TipoCliente.C);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeInferiorA100);

        Double resultado = driver.getValorComDesconto();

        // converte para string para pegar apenas até as casas decimais necessarias
        String string = String.valueOf(resultado).substring(0,7);

        // transformando novamento para double
        resultado = Double.valueOf(string);

        assertEquals(3.82640,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteCQuantidadeInferiorA1000EntaoDescontoSera015PorCento(){

        this.driver.setTipoCliente(TipoCliente.C);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeInferiorA1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.06555,resultado);
    }

    @Test
    public void testGetValorComDescontoQuandoClienteCQuantidadeInferiorA1000EntaoDescontoSera010PorCento(){

        this.driver.setTipoCliente(TipoCliente.C);
        this.driver.setProduto(new Produto(valorDoProduto));
        this.driver.setQuantidade(quantidadeAPartirDe1000);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.30470,resultado);
    }

}
