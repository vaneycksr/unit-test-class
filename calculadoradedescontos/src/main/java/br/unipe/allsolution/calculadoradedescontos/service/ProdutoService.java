package br.unipe.allsolution.calculadoradedescontos.service;

import br.unipe.allsolution.calculadoradedescontos.model.Produto;
import br.unipe.allsolution.calculadoradedescontos.repository.ProdutoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {

    // o spring que instancia
    @Autowired
            @Setter
    ProdutoRepository produtoRepository;

    public Collection<Produto> findAll(){
        return this.produtoRepository.getAll();
    }

    public Optional<Produto> findById(Long id){
        return this.produtoRepository.get(id);
    }
}
