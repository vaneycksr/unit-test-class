package net.diegoquirino.calculadora.service;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.model.TipoCliente;
import net.diegoquirino.calculadora.repository.ItemDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Nested
@DisplayName("Teste de Integração ItemService - MOCK")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ItemServiceMockTest {

    /** Stub para o Repositório de Produto **/
    @Mock
    ItemDAO itemDAO;

    /** Ponto de inicialização dos testes **/
    @InjectMocks
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
        this.itemPersonalizado = new Item(0L, TipoCliente.A, this.produto, 0);
    }

    /** Pós-processamento - executado antes de cada caso de teste */
    @AfterEach
    void tearDown() {
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum item é retornado quando informado um identificador inválido")
    void testFindByIdQuandoIdItemInexistenteEntaoNenhumItemRetornado() {
        /* Definindo os comportamentos (expectativas) */
        when(itemDAO.get(0l))
                .thenReturn(Optional.empty());
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
        /* Definindo os comportamentos (expectativas) */
        this.itemPersonalizado.setId(1L);
        this.itemPersonalizado.setQuantidade(this.totalDeItens);
        when(itemDAO.get(1L))
                .thenReturn(Optional.of(this.itemPersonalizado));
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
        /* Definindo os comportamentos (expectativas) */
        this.itemPersonalizado.setId(this.totalDeItens+1L);
        this.itemPersonalizado.setQuantidade(this.totalDeItens);
        when(itemDAO.get(this.totalDeItens+1L))
                .thenReturn(Optional.of(this.itemPersonalizado));
        when(itemDAO.save(this.itemPersonalizado))
                .thenReturn(this.totalDeItens+1L);
        /* Procedimento do caso de teste */
        Optional<Item> resultado = this.driver.add(this.itemPersonalizado);
        /* Verificar Resultados*/
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(this.totalDeItens+1L, resultado.get().getId());
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
        /* Definindo os comportamentos (expectativas) */
        this.itemPersonalizado.setTipoCliente(tipoCliente);
        this.itemPersonalizado.setQuantidade(quantidade);
        this.itemPersonalizado.setId(this.totalDeItens+1L);
        when(itemDAO.get(this.totalDeItens+1L))
                .thenReturn(Optional.of(this.itemPersonalizado));
        /* Procedimento do caso de teste */
        Optional<Double> resultado = this.driver.getValorComDesconto(this.totalDeItens+1L);
        /* Verificar Resultados*/
        assertEquals(valueExpected, resultado.get());
    }

    public Collection<Item> criarItens(Integer quantidade) {
        Collection<Item> itens = new ArrayList<>();
        Long nextId = 1L;
        for (int i = 0; i < quantidade; i++) {
            Produto prod = new Produto(i + 1L, faker.commerce().productName(),
                    faker.number().randomDouble(2, 123, 2876));
            TipoCliente tipo = TipoCliente.A;        // par
            if(i % 2 != 0) { tipo = TipoCliente.B; } // ímpar
            if(i % 3 == 0) { tipo = TipoCliente.C; } // múltiplo de 3
            itens.add(new Item(nextId++, tipo, prod, faker.random().nextInt(1,1500)));
        }
        return itens;
    }

}