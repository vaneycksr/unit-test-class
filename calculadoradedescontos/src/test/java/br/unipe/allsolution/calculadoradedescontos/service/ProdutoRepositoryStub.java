package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import br.unipe.allsolution.calculadoradedescontos.repository.ProdutoRepository;
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
public class ProdutoRepositoryStub implements ProdutoRepository {

    private Collection<Produto> produtos;
    private Faker faker = new Faker(new Locale("pt_br"));

    @Override
    public Collection<Produto> getAll() {
        return this.produtos;
    }

    @Override
    public Optional<Produto> get(Long id) {
        if (id == 1){
            return Optional.of(new Produto(id,"teste",1000.00));
        }
        return Optional.empty();
    }

    public void criarProdutos(Integer quantidade){
        this.produtos = new ArrayList<Produto>();
        for (int i = 0; i < quantidade;i++){
            this.produtos.add(new Produto(
                    i+1l,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2,100,2000)
            ));
        }
    }
}
