package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    ProdutoService driver;
    // Stub para o Repository
    ProdutoRepositoryStub stub;

    Integer totalDeProdutos = 10;
    Long idProdutoValido = 1l;

    @BeforeEach
    void setUp() {
        this.driver = new ProdutoService();
        this.stub = new ProdutoRepositoryStub();
        this.driver.setProdutoRepository(this.stub);
    }

    // executa apos cada teste
    @AfterEach
    void tearDown() {
        this.driver = null;
        this.stub = null;
    }

    @Test
    void testFindAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {

        this.stub.criarProdutos(10);

        Collection<Produto> resultados = this.driver.findAll();

        assertEquals(10,resultados.size());

        resultados.stream().forEach(
                p -> System.out.println(p.toString())
        );
    }

    @Test
    void testFindAllQuandoQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {

        this.stub.criarProdutos(0);

        Collection<Produto> resultados = this.driver.findAll();

        assertEquals(0,resultados.size());

    }

    @Test
    void testFindByIdQuandoIdInexistenteEntaoNenhumProdutoRetornado() {

        Optional<Produto> resultados = this.driver.findById(0l);

        assertTrue(resultados.isEmpty());
//        assertThrows(NoSuchElementException.class, resultados.get());
    }

    @Test
    void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {

        Optional<Produto> resultados = this.driver.findById(1l);

        assertFalse(resultados.isEmpty());
        assertNotNull(resultados.get());
    }
}