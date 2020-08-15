package br.unipe.allsolution.calculadoradedescontos.model;

public enum TipoCliente {

    A() {
        @Override
        public Double getFatorDesconto(Integer quantidade) {

            if (quantidade < 100){
                return 0.90;
            }else if (quantidade < 1000){
                return 0.95;
            }
            return 1.00;
        }
    },
    B(){
        @Override
        public Double getFatorDesconto(Integer quantidade){

            if (quantidade < 100){
                return 0.85;
            }else if (quantidade < 1000){
                return 0.90;
            }
            return 0.95;
        }
    },
    C(){
        @Override
        public Double getFatorDesconto(Integer quantidade){

            if (quantidade < 100){
                return 0.80;
            }else if (quantidade < 1000){
                return 0.85;
            }

            return 0.90;
        }
    };

    public abstract Double getFatorDesconto(Integer quantidade);

}
