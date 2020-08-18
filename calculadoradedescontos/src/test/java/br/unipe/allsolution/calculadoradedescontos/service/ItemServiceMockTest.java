package br.unipe.allsolution.calculadoradedescontos.service;

import org.junit.jupiter.api.Test;
import br.unipe.allsolution.calculadoradedescontos.repository.ItemRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Nested
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ItemServiceMockTest {

    @Mock // cria uma copia dessa classe
    private ItemRepository itemRepository;

    @InjectMocks // classe que sera testada
    private ItemService itemService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        when(itemRepository.get(0l))
                .thenReturn(Optional.empty());
        // Procedimento
        Optional<Double> resultado = this.itemService.getValorComDesconto(0L);
        // Verificação
        assertTrue(resultado.isEmpty());
        assertFalse(resultado.isPresent());

    }


}
