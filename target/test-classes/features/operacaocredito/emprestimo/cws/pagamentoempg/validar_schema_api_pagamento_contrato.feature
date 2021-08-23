@TID102706REV0.1.0
Feature: Validar schema API de Empréstimos - Pagamento EMPG (CWS)

  Scenario: Validar schema API de Empréstimos - Pagamento EMPG (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Pagamento EMPG
    When pegar o schema da API
    Then o schema deve ser válido