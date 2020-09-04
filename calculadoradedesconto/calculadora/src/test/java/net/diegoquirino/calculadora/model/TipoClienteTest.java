package net.diegoquirino.calculadora.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Unidade TipoCliente")
class TipoClienteTest {
    /** Driver do Teste - objetos da classe que está sendo testada*/
    TipoCliente driver;

    /** Dados de entrada do teste */
    Integer quantidade_menor_que_100;
    Integer quantidade_a_partir_de_100_menor_que_1000;
    Integer quantidade_a_partir_de_1000;

    /** Pré-processamento - executado antes de cada caso de teste */
    @BeforeEach
    void setUp() {
        this.quantidade_menor_que_100 = 99;
        this.quantidade_a_partir_de_100_menor_que_1000 = 100;
        this.quantidade_a_partir_de_1000 = 1000;
    }

    /** Pós-processamento - executado antes de cada caso de teste */
    @AfterEach
    void tearDown() {
        this.driver = null;
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar o fator de desconto igual a 0.90 quando Cliente A e Quantidade < 100")
    void testGetFatorDescontoQuandoClienteAQuantidadeInferior100EntaoFatorSera090() {
        this.driver = TipoCliente.A;
        /* Procedimento do caso de teste */
        Double fator = this.driver.getFatorDesconto(this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(fator, 0.90);
    }
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar o fator de desconto igual a 0.95 quando Cliente A e Quantidade >=100 e < 1000")
    void testGetFatorDescontoQuandoClienteAQuantidadeInferior1000EntaoFatorSera095() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.A;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 0.95);
    }
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar o fator de desconto igual a 1.00 quando Cliente A e Quantidade >= 1000")
    void testGetFatorDescontoQuandoClienteAQuantidadeAPartirDe1000EntaoFatorSera100() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.A;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 1.00);
    }

    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar o fator de desconto igual a 0.85 quando Cliente B e Quantidade < 100")
    void testGetFatorDescontoQuandoClienteBQuantidadeInferior100EntaoFatorSera085() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.B;
        Double fator = this.driver.getFatorDesconto(this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(fator, 0.85);
    }
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar o fator de desconto igual a 0.90 quando Cliente B e Quantidade >=100 e < 1000")
    void testGetFatorDescontoQuandoClienteBQuantidadeInferior1000EntaoFatorSera090() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.B;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 0.90);
    }
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar o fator de desconto igual a 0.95 quando Cliente B e Quantidade >= 1000")
    void testGetFatorDescontoQuandoClienteBQuantidadeAPartirDe1000EntaoFatorSera095() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.B;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 0.95);
    }

    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar o fator de desconto igual a 0.80 quando Cliente C e Quantidade < 100")
    void testGetFatorDescontoQuandoClienteCQuantidadeInferior100EntaoFatorSera080() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.C;
        Double fator = this.driver.getFatorDesconto(this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(fator, 0.80);
    }
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar o fator de desconto igual a 0.85 quando Cliente C e Quantidade >=100 e < 1000")
    void testGetFatorDescontoQuandoClienteCQuantidadeInferior1000EntaoFatorSera085() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.C;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 0.85);
    }
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar o fator de desconto igual a 0.90 quando Cliente C e Quantidade >= 1000")
    void testGetFatorDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoFatorSera090() {
        /* Procedimento do caso de teste */
        this.driver = TipoCliente.C;
        Double fator = this.driver.getFatorDesconto(this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(fator, 0.90);
    }
    
}