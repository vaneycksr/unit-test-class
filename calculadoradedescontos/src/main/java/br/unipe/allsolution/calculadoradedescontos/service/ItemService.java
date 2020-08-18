package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Item;
import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import br.unipe.allsolution.calculadoradedescontos.repository.ItemRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    @Setter
    ItemRepository itemRepository;

    public Optional<Double> getValorComDesconto(Long id) {
        if (itemRepository.get(id).isPresent()){
            Item item = itemRepository.get(id).get();
            return Optional.of(item.getValorComDesconto());
        }
        return Optional.empty();
    }

    public Collection<Item> findAll(){
        return this.itemRepository.getAll();
    }

    public Optional<Item> findById(Long id){
        return this.itemRepository.get(id);
    }

}

