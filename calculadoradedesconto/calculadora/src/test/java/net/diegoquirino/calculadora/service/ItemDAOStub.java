package net.diegoquirino.calculadora.service;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.model.TipoCliente;
import net.diegoquirino.calculadora.repository.ItemDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ItemDAOStub implements ItemDAO {

    private Collection<Item> itens = new ArrayList<>();

    private Long nextId = 1L;

    public void criarItens(Integer quantidade) {
        Faker faker = new Faker(new Locale("pt-BR"));
        this.itens = new ArrayList<>();
        this.nextId = 1L;
        for (int i = 0; i < quantidade; i++) {
            Produto prod = new Produto(i + 1L, faker.commerce().productName(),
                    faker.number().randomDouble(2, 123, 2876));
            TipoCliente tipo = TipoCliente.A;        // par
            if(i % 2 != 0) { tipo = TipoCliente.B; } // ímpar
            if(i % 3 == 0) { tipo = TipoCliente.C; } // múltiplo de 3
            this.itens.add(new Item(this.nextId++, tipo, prod, faker.random().nextInt(1,1500)));
        }
    }

    @Override
    public Optional<Item> get(Long id) {
        try {
            return Optional.ofNullable(
                    itens.stream()
                            .filter(item -> item.getId().equals(id))
                            .collect(Collectors.toList())
                            .get(0)
            );
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<Item> getAll() {
        return null;
    }

    @Override
    public Long save(Item item) {
        if(item.getId() <= 0) {
            item.setId(nextId++);
        }
        this.itens.add(item);
        return item.getId();
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(Item item) {

    }

    @Override
    public Long getNextId() {
        return null;
    }
}
