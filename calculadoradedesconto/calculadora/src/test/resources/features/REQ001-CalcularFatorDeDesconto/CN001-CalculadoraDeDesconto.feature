# language: pt

@all @req001 @desconto
Funcionalidade: REQ001 - Calcular Desconto de Produto

  Esquema do Cenario: Quantidade de produto abaixo de 100 com cliente B
    Dado que estou na pàgina inicial da Calculadora de Desconto
    Quando selecionar um produto
    E selecionar o tipo cliente "<tipo>"
    E inserir a quantidade de itens igual a "<qnt>"
    E confirmo o desconto
    Então deve ser apresentado o fator "<ft>"
    E a mensagem "<msg>"

    Exemplos:
      | tipo | qnt  | ft                                            | msg                                                       |
      | A    | 99   | Fator obtido: 0.9 (ou seja, 10% de desconto)  | Operação realizada com sucesso!                            |
      | A    | 101  | Fator obtido: 0.95 (ou seja, 5% de desconto)  | Operação realizada com sucesso!                            |
      | A    | 1001 | Fator obtido: 1.5 (ou seja, 0% de desconto)   | Operação realizada com sucesso!                            |
      | A    | -1   | null                                          | A quantidade informada deve ser maior ou igual a 01 (um)! |
      | B    | 99   | Fator obtido: 0.85 (ou seja, 15% de desconto) | Operação realizada com sucesso!                            |
      | B    | 101  | Fator obtido: 0.9 (ou seja, 10% de desconto)  | Operação realizada com sucesso!                            |
      | B    | 1001 | Fator obtido: 0.95 (ou seja, 5% de desconto)  | Operação realizada com sucesso!                            |
      | B    | -1   | null                                          | A quantidade informada deve ser maior ou igual a 01 (um)! |
      | C    | 99   | Fator obtido: 0.8 (ou seja, 20% de desconto)  | Operação realizada com sucesso!                            |
      | C    | 101  | Fator obtido: 0.85 (ou seja, 15% de desconto) | Operação realizada com sucesso!                            |
      | C    | 1001 | Fator obtido: 0.9 (ou seja, 10% de desconto)  | Operação realizada com sucesso!                            |
      | C    | -1   | null                                          | A quantidade informada deve ser maior ou igual a 01 (um)! |