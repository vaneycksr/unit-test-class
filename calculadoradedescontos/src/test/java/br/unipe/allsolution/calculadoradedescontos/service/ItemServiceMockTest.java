package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Item;
import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import br.unipe.allsolution.calculadoradedescontos.model.TipoCliente;
import com.github.javafaker.Faker;
import br.unipe.allsolution.calculadoradedescontos.repository.ItemRepository;
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
@DisplayName("Teste de Integração da Classe Item utilizando Mockito")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ItemServiceMockTest {

    @Mock // cria uma copia dessa classe
    private ItemRepository itemRepository;

    @InjectMocks // classe que sera testada
    private ItemService itemService;

    private Integer totalDeProdutos = 10;
    private static final TipoCliente TIPO_CLIENTE = TipoCliente.A;
    private Long idItemValido,idProdutoValido = 1l;

    Produto produto = new Produto(this.idProdutoValido,"Caixa de Som",1000.00);
    Item item = new Item(this.idItemValido,TIPO_CLIENTE,this.produto,2);

    @Test
    @DisplayName("Verificar que 10 produtos são retornados quando tenho 10 produtos cadastrados")
    public void testFindAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {
        when(this.itemRepository.getAll())
                .thenReturn(criarItens(10,TIPO_CLIENTE));

        Collection<Item> resultados = this.itemService.findAll();

        assertEquals(this.totalDeProdutos, resultados.size());
    }

    @Test
    @DisplayName("Verificar que nenhum produto é retornado quando o repositório está vazio")
    public void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        when(this.itemRepository.getAll())
                .thenReturn(criarItens(0,TIPO_CLIENTE));

        Collection<Item> resultados = this.itemService.findAll();

        assertEquals(0, resultados.size());
    }


    @Test
    public void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        when(itemRepository.get(0l))
                .thenReturn(Optional.empty());

        Optional<Double> resultado = this.itemService.getValorComDesconto(0L);

        assertTrue(resultado.isEmpty());
        assertFalse(resultado.isPresent());

    }

    @Test
    @DisplayName("Verificar que o produto é retornado quando o identificador válido é utilizado")
    public void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {

        when(itemRepository.get(this.idItemValido))
                .thenReturn(Optional.of(this.item));

        Optional<Item> resultado = this.itemService.findById(this.idItemValido);

        assertFalse(resultado.isEmpty());
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    private Collection<Item> criarItens(Integer quantidade, TipoCliente tipoCliente) {
        Collection<Item> itens = new ArrayList<Item>();
        Faker faker = new Faker(new Locale("pt_BR"));
        Produto produto = new Produto(1l,faker.commerce().productName(), faker.number().randomDouble(2, 100, 2000));
        for(int i = 0; i < quantidade; i++) {
            itens.add(new Item(
                    i+1l,
                    tipoCliente,
                    produto,
                    faker.number().numberBetween(1, 1001)
            ));
        }
        return itens;
    }

}
