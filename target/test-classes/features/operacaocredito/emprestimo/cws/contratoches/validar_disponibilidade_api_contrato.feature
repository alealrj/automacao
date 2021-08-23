@TID95025REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Contrato CHES (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Contrato CHES (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Contrato CHES
    When pegar o status code da requisição
    Then o status code deve ser 200