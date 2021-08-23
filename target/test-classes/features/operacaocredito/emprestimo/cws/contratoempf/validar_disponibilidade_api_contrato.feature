
Feature: Validar disponibilidade API de Empréstimos - Contrato EMPF (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Contrato EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPF
    When pegar o status code da requisição
    Then o status code deve ser 200