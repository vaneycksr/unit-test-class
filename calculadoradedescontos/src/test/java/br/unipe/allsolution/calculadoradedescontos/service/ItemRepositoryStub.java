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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRepositoryStub implements ItemRepository {

    private Collection<Item> itens;
    private Faker faker = new Faker();
    private Produto produto = new Produto();


    @Override
    public Collection<Item> getAll() {
        return this.itens;
    }

    @Override
    public Optional<Item> get(Long id) {
        if (id == 1){
            return Optional.of(new Item(id, TipoCliente.A,produto,faker.number().numberBetween(1,1001)));
        }
        return Optional.empty();
    }

    public void criarItens(Integer quantidade, TipoCliente tipoCliente) {
        this.itens = new ArrayList<Item>();

        Produto produto = new Produto(1l,faker.commerce().productName(), faker.number().randomDouble(2, 100, 2000));
        for(int i = 0; i < quantidade; i++) {
            this.itens.add(new Item(
                    i+1l,
                    tipoCliente,
                    this.produto,
                    faker.number().numberBetween(1, 1001)
            ));
        }

    }


}
