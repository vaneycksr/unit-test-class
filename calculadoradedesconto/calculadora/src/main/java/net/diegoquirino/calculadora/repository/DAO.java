package net.diegoquirino.calculadora.repository;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(Long id);
    Collection<T> getAll();
    Long save(T t);
    void update(T t);
    void delete(T t);
    Long getNextId();
}
