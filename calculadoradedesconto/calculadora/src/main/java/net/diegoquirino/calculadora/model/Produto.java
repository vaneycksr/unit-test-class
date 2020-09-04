package net.diegoquirino.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    private Long id;
    private String nome;
    private Double valor;
}
