package br.unipe.allsolution.calculadoradedescontos.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {

    Collection<T> getAll();
    Optional<T> get(Long id);

}
