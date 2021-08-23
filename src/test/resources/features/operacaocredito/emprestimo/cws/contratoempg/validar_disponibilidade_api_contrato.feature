@TID95026REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Contrato EMPG (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Contrato EMPG (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPG
    When pegar o status code da requisição
    Then o status code deve ser 200