# language: pt

@all @req001 @desconto
Funcionalidade: REQ001 - Calcular Desconto de Produto

  Esquema do Cenario: Quantidade de produto abaixo de 100 com cliente B
    Dado que estou na pàgina inicial da Calculadora de Desconto
    Quando selecionar um produto
    E selecionar o tipo cliente "<tipo>"
    E inserir a quantidade de itens igual a "<qnt>"
    E confirmo o desconto
    Então deve ser apresentado o fator <ft> e a mensagem "<msg>"

    Exemplos:
      | tipo | qnt  | ft                     | msg                                                       |
      | A    | 99   | 0.9 (10% de desconto)  | Operação ralizada com sucesso!                            |
      | A    | 101  | 0.95 (5% de desconto)  | Operação ralizada com sucesso!                            |
      | A    | 1001 | 1.5 (0% de desconto)   | Operação ralizada com sucesso!                            |
      | A    | -1   | null                   | A quantidade informada deve ser maior ou igual a 01 (um)! |
      | B    | 99   | 0.85 (15% de desconto) | Operação ralizada com sucesso!                            |
      | B    | 101  | 0.9 (10% de desconto)  | Operação ralizada com sucesso!                            |
      | B    | 1001 | 0.95 (5% de desconto)  | Operação ralizada com sucesso!                            |
      | B    | -1   | null                   | A quantidade informada deve ser maior ou igual a 01 (um)! |
      | C    | 99   | 0.8 (20% de desconto)  | Operação ralizada com sucesso!                            |
      | C    | 101  | 0.85 (15% de desconto) | Operação ralizada com sucesso!                            |
      | C    | 1001 | 0.9 (10% de desconto)  | Operação ralizada com sucesso!                            |
      | C    | -1   | null                   | A quantidade informada deve ser maior ou igual a 01 (um)! |