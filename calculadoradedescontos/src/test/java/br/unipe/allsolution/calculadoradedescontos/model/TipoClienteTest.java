package br.unipe.allsolution.calculadoradedescontos.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TipoClienteTest {

    TipoCliente driver;

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
    @Tags({@Tag("All"),@Tag("ClienteA")})
    void testGetFatorDescontoQuandoClienteAQuantidadeInferiorA100EntaoFatorSera090() {

        this.driver = TipoCliente.A;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA100);

        assertEquals(0.90,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteA")})
    void testGetFatorDescontoQuandoClienteAQuantidadeInferiorA1000EntaoFatorSera095() {

        this.driver = TipoCliente.A;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA1000);

        assertEquals(0.95,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteA")})
    void testGetFatorDescontoQuandoClienteAQuantidadeAPartirDe1000EntaoFatorSera100() {

        this.driver = TipoCliente.A;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeAPartirDe1000);

        assertEquals(1.0,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteB")})
    void testGetFatorDescontoQuandoClienteBQuantidadeInferiorA100EntaoFatorSera085() {

        this.driver = TipoCliente.B;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA100);

        assertEquals(0.85,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteB")})
    void testGetFatorDescontoQuandoClienteBQuantidadeInferiorA1000EntaoFatorSera090() {

        this.driver = TipoCliente.B;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA1000);

        assertEquals(0.90,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteB")})
    void testGetFatorDescontoQuandoClienteBQuantidadeAPartirDe1000EntaoFatorSera095() {

        this.driver = TipoCliente.B;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeAPartirDe1000);

        assertEquals(0.95,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteC")})
    void testGetFatorDescontoQuandoClienteCQuantidadeInferiorA100EntaoFatorSera080() {

        this.driver = TipoCliente.C;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA100);

        assertEquals(0.80,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteC")})
    void testGetFatorDescontoQuandoClienteCQuantidadeInferiorA1000EntaoFatorSera085() {

        this.driver = TipoCliente.C;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeInferiorA1000);

        assertEquals(0.85,resultado);
    }

    @Test
    @Tags({@Tag("All"),@Tag("ClienteC")})
    void testGetFatorDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoFatorSera090() {

        this.driver = TipoCliente.C;

        Double resultado = this.driver.getFatorDesconto(this.quantidadeAPartirDe1000);

        assertEquals(0.90,resultado);
    }

}