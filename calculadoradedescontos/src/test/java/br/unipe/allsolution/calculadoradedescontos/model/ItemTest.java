package br.unipe.allsolution.calculadoradedescontos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    Item driver;
    private TipoCliente tipoCliente;

    Integer quantidadeInferiorA1000, quantidadeInferiorA100, quantidadeAPartirDe1000;

    @BeforeEach
    public void setUp() {

        this.quantidadeInferiorA100 = 99;
        this.quantidadeInferiorA1000 = 999;
        this.quantidadeAPartirDe1000 = 1000;
    }

    @AfterEach
    public void tearDown() {
        this.driver = null;
    }


    @Test
    public void testGetValorComDescontoQuandoClienteAQuantidadeInferiorA100EntaoDescontoSera010(){

        this.driver.setTipoCliente(TipoCliente.A);
        this.driver.getProduto().setValor(4.783);
        this.driver.setQuantidade(12);

        Double resultado = driver.getValorComDesconto();

        assertEquals(4.304,resultado);
    }


}
