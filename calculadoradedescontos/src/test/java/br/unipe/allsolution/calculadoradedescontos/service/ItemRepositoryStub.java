package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Item;
import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import br.unipe.allsolution.calculadoradedescontos.model.TipoCliente;
import br.unipe.allsolution.calculadoradedescontos.repository.ItemRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRepositoryStub implements ItemRepository {

    private Collection<Item> items;
    private Faker faker = new Faker();
    private Produto produto = new Produto();


    @Override
    public Collection<Item> getAll() {
        return this.items;
    }

    @Override
    public Optional<Item> get(Long id) {
        if (id == 1){
            return Optional.of(new Item(id, TipoCliente.A,produto,faker.number().numberBetween(1,1001)));
        }
        return Optional.empty();
    }




}
