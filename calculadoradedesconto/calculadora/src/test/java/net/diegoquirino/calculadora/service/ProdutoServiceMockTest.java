package net.diegoquirino.calculadora.service;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.repository.ProdutoDAO;
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
@DisplayName("Teste de Integração ProdutoService - MOCK")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ProdutoServiceMockTest {

    /** Objeto onde serão definidas as expectativas **/
    @Mock
    ProdutoDAO produtoDAO;

    /** Ponto de inicialização dos testes **/
    @InjectMocks
    ProdutoService driver;

    /** Parâmetros de entrada úteis para os testes **/
    Integer totalDeProdutos = 10;
    Long idProdutoValido = 1l;
    Produto produto = new Produto(this.idProdutoValido,"Caixa de Som",1000.00);

    /** Pré-processamento - executado antes de cada caso de teste */
    @BeforeEach
    void setUp() {
    }

    /** Pós-processamento - executado antes de cada caso de teste */
    @AfterEach
    void tearDown() {
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que 10 produtos são retornados quando tenho 10 produtos cadastrados")
    void testFindAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {
        when(this.produtoDAO.getAll())
                .thenReturn(criarProdutos(10));
        // Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        // Verificação
        assertEquals(this.totalDeProdutos, resultados.size());
        resultados.stream().forEach(
                p -> System.out.println(p.toString())
        );
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum produto é retornado quando o repositório está vazio")
    void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        when(this.produtoDAO.getAll())
                .thenReturn(criarProdutos(0));
        // Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        // Verificação
        assertEquals(0, resultados.size());
    }

    @Test
    @Tags({@Tag("all")})
    @DisplayName("Verificar que nenhum produto é retornado quando informado um identificador inválido")
    void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        when(produtoDAO.get(0l))
                .thenReturn(Optional.empty());
        // Procedimento
        Optional<Produto> resultado = this.driver.findById(0l);
        // Verificação
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
        when(produtoDAO.get(this.idProdutoValido))
                .thenReturn(Optional.of(this.produto));
        // Procedimento
        Optional<Produto> resultado = this.driver.findById(this.idProdutoValido);
        // Verificação
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    private Collection<Produto> criarProdutos(Integer quantidade) {
        Collection<Produto> produtos = new ArrayList<Produto>();
        Faker faker = new Faker(new Locale("pt_BR"));
        for(int i = 0; i < quantidade; i++) {
            produtos.add(new Produto(
                    i+1l,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 100, 2000)
            ));
        }
        return produtos;
    }

}
