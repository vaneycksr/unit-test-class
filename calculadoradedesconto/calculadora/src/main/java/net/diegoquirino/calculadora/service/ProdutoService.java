package net.diegoquirino.calculadora.service;

import lombok.Setter;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.repository.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    @Setter
    ProdutoDAO produtoDAO;

    public Collection<Produto> findAll() {
        return produtoDAO.getAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoDAO.get(id);
    }

    public Long getNextId() {
        return this.produtoDAO.getNextId();
    }

    public Long createEdit(Produto produto) {
        if(findById(produto.getId()).isEmpty()) {
            return this.produtoDAO.save(produto);
        } else {
            this.produtoDAO.update(produto);
            return produto.getId();
        }
    }

    public Long delete(Produto produto) {
        this.produtoDAO.delete(produto);
        return produto.getId();
    }
}
