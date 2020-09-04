package net.diegoquirino.calculadora.repository;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FakeProdutoDAO implements ProdutoDAO {

    Collection<Produto> produtos = criarProdutos(10);

    @Override
    public Optional<Produto> get(Long id) {
        return this.produtos.stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Produto> getAll() {
        return this.produtos.stream()
                .sorted((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Long save(Produto produto) {
        produto.setId(getNextId());
        this.produtos.add(produto);
        return produto.getId();
    }

    @Override
    public void update(Produto produto) {
        Produto oldProduto = get(produto.getId()).get();
        delete(oldProduto);
        this.produtos.add(produto);
    }

    @Override
    public void delete(Produto produto) {
        this.produtos.remove(produto);
    }

    private Collection<Produto> criarProdutos(Integer quantidade) {
        Collection<Produto> produtos = new ArrayList<Produto>();
        Faker faker = new Faker(new Locale("pt_BR"));
        for(int i = 0; i < quantidade; i++) {
            produtos.add(new Produto(
                    i+1l,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 100, 2000)
            ));
        }
        return produtos;
    }

    @Override
    public Long getNextId() {
        int size = this.produtos.size();
        List<Produto> ordenado = this.produtos.stream()
                .sorted((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .collect(Collectors.toList());
        if(size <= 0) {
            return 1L;
        } else {
            return ordenado.get(size-1).getId() + 1L;
        }
    }
}
