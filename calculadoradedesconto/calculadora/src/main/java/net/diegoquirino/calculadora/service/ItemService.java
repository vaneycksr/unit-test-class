package net.diegoquirino.calculadora.service;

import lombok.Setter;
import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.repository.FakeItemDAO;
import net.diegoquirino.calculadora.repository.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    @Setter
    ItemDAO itemDAO;

    public Optional<Double> getValorComDesconto(Long id) {
        if(itemDAO.get(id).isPresent()) {
            Item item = itemDAO.get(id).get();
            return Optional.of(item.getValorComDesconto());
        }
        return Optional.empty();
    }

    public Optional<Item> findById(Long id) {
        return itemDAO.get(id);
    }

    public Optional<Item> add(Item item) {
        return findById(itemDAO.save(item));
    }

    public Long getNextId() {
        return this.itemDAO.getNextId();
    }

    public Long createEdit(Item item) {
        if(findById(item.getId()).isEmpty()) {
            return this.itemDAO.save(item);
        } else {
            this.itemDAO.update(item);
            return item.getId();
        }
    }
}
