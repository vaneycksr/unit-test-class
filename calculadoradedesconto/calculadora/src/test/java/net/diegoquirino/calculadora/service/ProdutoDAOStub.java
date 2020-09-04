package net.diegoquirino.calculadora.service;

import com.github.javafaker.Faker;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.repository.ProdutoDAO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProdutoDAOStub implements ProdutoDAO {

    private Collection<Produto> produtos = new ArrayList<>();

    public void criarProdutos(Integer quantidade) {
        Faker faker = new Faker(new Locale("pt-BR"));
        this.produtos = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            produtos.add(new Produto(i + 1L, faker.commerce().productName(),
                    faker.number().randomDouble(2, 123, 2876)));
        }
    }

    @Override
    public Optional<Produto> get(Long id) {
        try {
            return Optional.ofNullable(
                    produtos.stream()
                            .filter(prod -> prod.getId().equals(id))
                            .collect(Collectors.toList())
                            .get(0)
            );
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<Produto> getAll() {
        return this.produtos;
    }

    @Override
    public Long save(Produto produto) {
        return null;
    }

    @Override
    public void update(Produto o) {

    }

    @Override
    public void delete(Produto o) {

    }

    @Override
    public Long getNextId() {
        return null;
    }
}
