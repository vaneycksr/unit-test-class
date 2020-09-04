package net.diegoquirino.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contato {
    private String nome;
    private String email;
    private String mensagem;
    private String tipo;
    private String idade;
}
