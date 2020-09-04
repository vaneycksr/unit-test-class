package net.diegoquirino.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private Long id;
    private TipoCliente tipoCliente;
    private Produto produto;
    private Integer quantidade;

    public Double getValorComDesconto() {
        return this.produto.getValor() * tipoCliente.getFatorDesconto(this.quantidade);
    }

}
