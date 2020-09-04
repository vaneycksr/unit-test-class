package net.diegoquirino.calculadora.service;

import net.diegoquirino.calculadora.model.Produto;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Teste de Integração ProdutoService - STUB")
class ProdutoServiceTest {

    /** Stub para o Repositório de Produto **/
    ProdutoDAOStub stub;

    /** Ponto de inicialização dos testes **/
    ProdutoService driver;

    /** Parâmetros de entrada úteis para os testes **/
    Integer totalDeProdutos = 10;
    Long idProdutoValido = 1l;

    /** Pré-processamento - executado antes de cada caso de teste */
    @BeforeEach
    void setUp() {
        this.driver = new ProdutoService();
        this.stub = new ProdutoDAOStub();
        this.driver.setProdutoDAO(this.stub);
    }

    /** Pós-processamento - executado antes de cada caso de teste */
    @AfterEach
    void tearDown() {
        this.stub = null;
        this.driver = null;
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que 10 produtos são retornados quando tenho 10 produtos cadastrados")
    void testFindAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {
        this.stub.criarProdutos(this.totalDeProdutos);
        /* Procedimento do caso de teste */
        Collection<Produto> resultados = this.driver.findAll();
        /* Verificar Resultados*/
        assertEquals(this.totalDeProdutos, resultados.size());
        resultados.stream().forEach(
                p -> System.out.println(p.toString())
        );
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum produto é retornado quando o repositório está vazio")
    void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        this.stub.criarProdutos(0);
        /* Procedimento do caso de teste */
        Collection<Produto> resultados = this.driver.findAll();
        /* Verificar Resultados*/
        assertEquals(0, resultados.size());
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum produto é retornado quando informado um identificador inválido")
    void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        this.stub.criarProdutos(this.totalDeProdutos);
        /* Procedimento do caso de teste */
        Optional<Produto> resultado = this.driver.findById(0l);
        /* Verificar Resultados*/
        assertTrue(resultado.isEmpty());
        assertFalse(resultado.isPresent());
        assertThrows(NoSuchElementException.class, () -> {
            resultado.get();
        });
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que o produto é retornado quando o identificador válido é utilizado")
    void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {
        this.stub.criarProdutos(this.totalDeProdutos);
        /* Procedimento do caso de teste */
        Optional<Produto> resultado = this.driver.findById(this.idProdutoValido);
        /* Verificar Resultados*/
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }
}