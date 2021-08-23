@TID102702REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Pagamento CHES (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Pagamento CHES (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Pagamento CHES
    When pegar o status code da requisição
    Then o status code deve ser 200