package net.diegoquirino.calculadora.service;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.model.TipoCliente;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Teste de Integração ItemService - STUB")
class ItemServiceTest {

    /** Stub para o Repositório de Produto **/
    ItemDAOStub stub;

    /** Ponto de inicialização dos testes **/
    ItemService driver;

    /** Parâmetros de entrada úteis para os testes **/
    final Integer totalDeItens = 10;
    final Long idProdutoValido = 1l;

    final Faker faker = new Faker();
    final Double valor = 1000.00;
    final Produto produto = new Produto(1L, faker.commerce().productName(), this.valor);
    final Integer quantidade_menor_que_100 = 99;
    final Integer quantidade_a_partir_de_100_menor_que_1000 = 100;
    final Integer quantidade_a_partir_de_1000 = 1000;

    Item itemPersonalizado;

    /** Pré-processamento - executado antes de cada caso de teste */
    @BeforeEach
    void setUp() {
        this.driver = new ItemService();
        this.stub = new ItemDAOStub();
        this.driver.setItemDAO(this.stub);
        this.itemPersonalizado = new Item(0L, TipoCliente.A, this.produto, 0);
    }

    /** Pós-processamento - executado antes de cada caso de teste */
    @AfterEach
    void tearDown() {
        this.stub = null;
        this.driver = null;
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum item é retornado quando informado um identificador inválido")
    void testFindByIdQuandoIdItemInexistenteEntaoNenhumItemRetornado() {
        this.stub.criarItens(this.totalDeItens);
        /* Procedimento do caso de teste */
        Optional<Item> resultado = this.driver.findById(0l);
        /* Verificar Resultados*/
        assertTrue(resultado.isEmpty());
        assertFalse(resultado.isPresent());
        assertThrows(NoSuchElementException.class, () -> {
            resultado.get();
        });
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que o item é retornado quando o identificador válido é utilizado")
    void testFindByIdQuandoIdItemValidoEntao1ItemRetornado() {
        this.stub.criarItens(this.totalDeItens);
        /* Procedimento do caso de teste */
        Optional<Item> resultado = this.driver.findById(this.idProdutoValido);
        /* Verificar Resultados*/
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que o item é salvo e um novo identificador válido é atribuído")
    void testAddQuandoIdItemInexistenteEntao1ItemRetornadoComIdValido() {
        this.stub.criarItens(this.totalDeItens);
        /* Procedimento do caso de teste */
        Optional<Item> resultado = this.driver.add(this.itemPersonalizado);
        /* Verificar Resultados*/
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(this.totalDeItens+1, resultado.get().getId());
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente A e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteAQuantidadeInferior100EntaoValorSera900() {
        this.verify(TipoCliente.A, this.quantidade_menor_que_100, 900.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar que o valor do item com desconto é 950.00 quando Cliente A e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteAQuantidadeInferior1000EntaoValorSera950() {
        this.verify(TipoCliente.A, this.quantidade_a_partir_de_100_menor_que_1000, 950.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("A")})
    @DisplayName("Verificar que o valor do item com desconto é 1000.00 quando Cliente A e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteAQuantidadeAPartirDe1000EntaoValorSera1000() {
        this.verify(TipoCliente.A, this.quantidade_a_partir_de_1000, 1000.00);
    }

    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 850.00 quando Cliente B e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteBQuantidadeInferior100EntaoValorSera850() {
        this.verify(TipoCliente.B, this.quantidade_menor_que_100, 850.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente B e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteBQuantidadeInferior1000EntaoValorSera900() {
        this.verify(TipoCliente.B, this.quantidade_a_partir_de_100_menor_que_1000, 900.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("B")})
    @DisplayName("Verificar que o valor do item com desconto é 950.00 quando Cliente B e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteBQuantidadeAPartirDe1000EntaoValorSera950() {
        this.verify(TipoCliente.B, this.quantidade_a_partir_de_1000, 950.00);
    }

    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 800.00 quando Cliente C e Quantidade < 100")
    void testGetValorComDescontoQuandoClienteCQuantidadeInferior100EntaoValorSera800() {
        this.verify(TipoCliente.C, this.quantidade_menor_que_100, 800.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 850.00 quando Cliente C e Quantidade >=100 e < 1000")
    void testGetValorComDescontoQuandoClienteCQuantidadeInferior1000EntaoValorSera850() {
        this.verify(TipoCliente.C, this.quantidade_a_partir_de_100_menor_que_1000, 850.00);
    }

    /** Casos de teste - de acordo com os requisitos */
    @Test
    @Tags({@Tag("all"),@Tag("C")})
    @DisplayName("Verificar que o valor do item com desconto é 900.00 quando Cliente C e Quantidade >= 1000")
    void testGetValorComDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoValorSera900() {
        this.verify(TipoCliente.C, this.quantidade_a_partir_de_1000, 900.00);
    }

    private void verify(TipoCliente tipoCliente, Integer quantidade, Double valueExpected) {
        this.itemPersonalizado.setTipoCliente(tipoCliente);
        this.itemPersonalizado.setQuantidade(quantidade);
        this.stub.criarItens(this.totalDeItens);
        /* Procedimento do caso de teste */
        Optional<Double> resultado = this.driver.getValorComDesconto(this.stub.save(this.itemPersonalizado));
        /* Verificar Resultados*/
        assertEquals(valueExpected, resultado.get());
    }
}