# language: pt

@all @req003 @sucesso @fb

Funcionalidade: REQ003 - Formulário de Contato

  @all @req003 @falha @fb

  Esquema do Cenario: Enviar contato sem sucesso (fluxo básico)

      # Pré condições iniciais
    Dado    que estou na página inicial do sistema
    E       acesso o menu para o formulário de contato

      # Procedimento
    Quando  preencho com dados inválidos o formulário
      | nome  | <nome>  |
      | email | <email> |
      | tipo  | <tipo>  |
      | idade | <idade> |
      | msg   | <msg>   |
    E       submeto o formulário

      #Verificação
    Então   verifico que a mensagem de erro foi exibida

    Exemplos:
      | nome          | email          | tipo       | idade              | msg                    |
      | Maria         | Maria          | Dúvida     | Acima de 60 anos   | Reclamação de Maria    |
      | Ana@gmail.com | Ana            | Sugestão   | Menor de 18 anos   | Dúvida de Ana          |
      | null          | jose@gmail.com | Sugestão   | Menor de 18 anos   | Dúvida de José         |
      | Fernando      | null           | Reclamação | Entre 18 e 60 anos | Reclamação de Fernando |