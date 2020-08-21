package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Item;
import br.unipe.allsolution.calculadoradedescontos.model.TipoCliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemServiceStubTest {
    
    private ItemService driver;
    private ItemRepositoryStub stub;
    private static final TipoCliente TIPO_CLIENTE_A = TipoCliente.A;
    
    @BeforeEach
    public void setUp(){
        this.driver = new ItemService();
        this.stub = new ItemRepositoryStub();
        this.driver.setItemRepository(this.stub);
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
        this.stub = null;
    }

    @Test
    void testFindAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {

        this.stub.criarItens(10,TIPO_CLIENTE_A);

        Collection<Item> resultados = this.driver.findAll();

        assertEquals(10,resultados.size());

//        resultados.stream().forEach(
//                p -> System.out.println(p.toString())
//        );
    }

    @Test
    void testFindAllQuandoQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {

        this.stub.criarItens(0,TIPO_CLIENTE_A);

        Collection<Item> resultados = this.driver.findAll();

        assertEquals(0,resultados.size());

    }

    @Test
    void testFindByIdQuandoIdInexistenteEntaoNenhumProdutoRetornado() {

        Optional<Item> resultados = this.driver.findById(0l);

        assertTrue(resultados.isEmpty());
    }

    @Test
    void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {

        Optional<Item> resultados = this.driver.findById(1l);

        assertFalse(resultados.isEmpty());
        assertNotNull(resultados.get());
    }

}
