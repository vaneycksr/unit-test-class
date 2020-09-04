package net.diegoquirino.calculadora.model;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Unidade ItemTest")
class ItemTest {

    Item driver;

    final Faker faker = new Faker();
    final Double valor = 1000.00;
    final Produto produto = new Produto(1L, faker.commerce().productName(), valor);
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
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente A e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteAQuantidadeInferior100EntaoValorSera900() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.A, this.produto, this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(900.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar que o valor do item com desconto é 950.00 quando Cliente A e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteAQuantidadeInferior1000EntaoValorSera950() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.A, this.produto, this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(950.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar que o valor do item com desconto é 1000.00 quando Cliente A e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteAQuantidadeAPartirDe1000EntaoValorSera1000() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.A, this.produto, this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(1000.00, this.driver.getValorComDesconto());
    }

    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 850.00 quando Cliente B e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteBQuantidadeInferior100EntaoValorSera850() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.B, this.produto, this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(850.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente B e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteBQuantidadeInferior1000EntaoValorSera900() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.B, this.produto, this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(900.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 950.00 quando Cliente B e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteBQuantidadeAPartirDe1000EntaoValorSera950() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.B, this.produto, this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(950.00, this.driver.getValorComDesconto());
    }

    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 800.00 quando Cliente C e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteCQuantidadeInferior100EntaoValorSera800() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.C, this.produto, this.quantidade_menor_que_100);
        /* Verificar Resultados*/
        assertEquals(800.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 850.00 quando Cliente C e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteCQuantidadeInferior1000EntaoValorSera850() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.C, this.produto, this.quantidade_a_partir_de_100_menor_que_1000);
        /* Verificar Resultados*/
        assertEquals(850.00, this.driver.getValorComDesconto());
    }
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente C e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoValorSera900() {
        /* Procedimento do caso de teste */
        this.driver = new Item(1L, TipoCliente.C, this.produto, this.quantidade_a_partir_de_1000);
        /* Verificar Resultados*/
        assertEquals(900.00, this.driver.getValorComDesconto());
    }
}