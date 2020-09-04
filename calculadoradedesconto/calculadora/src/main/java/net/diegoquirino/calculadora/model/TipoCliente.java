package net.diegoquirino.calculadora.model;

import lombok.NoArgsConstructor;

public enum TipoCliente {
    A {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.90;
            } else if (quantidade < 1000) {
                return 0.95;
            } else {
                return 1.00;
            }
        }
    },
    B {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.85;
            } else if (quantidade < 1000) {
                return 0.90;
            } else {
                return 0.95;
            }
        }
    },
    C {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.80;
            } else if (quantidade < 1000) {
                return 0.85;
            } else {
                return 0.90;
            }
        }
    };

    public abstract Double getFatorDesconto(Integer quantidade);

}
