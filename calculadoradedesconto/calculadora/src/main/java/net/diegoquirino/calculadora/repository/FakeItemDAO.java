package net.diegoquirino.calculadora.repository;

import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

@Repository
public class FakeItemDAO implements ItemDAO {

    Collection<Item> itens = new ArrayList<>();

    @Override
    public Optional<Item> get(Long id) {
        return this.itens.stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Item> getAll() {
        return this.itens.stream()
                .sorted((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Long save(Item item) {
        item.setId(getNextId());
        this.itens.add(item);
        return item.getId();
    }

    @Override
    public void update(Item item) {
        Item oldItem = get(item.getId()).get();
        delete(oldItem);
        this.itens.add(item);
    }

    @Override
    public void delete(Item item) {
        this.itens.remove(item);
    }

    @Override
    public Long getNextId() {
        int size = this.itens.size();
        List<Item> ordenado = this.itens.stream()
                .sorted((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .collect(Collectors.toList());
        if(size <= 0) {
            return 1L;
        } else {
            return ordenado.get(size-1).getId() + 1L;
        }
    }
}
