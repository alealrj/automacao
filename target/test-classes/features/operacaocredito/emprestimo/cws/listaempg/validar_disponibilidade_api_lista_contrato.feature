@TID95031REV0.3.0
Feature: Validar disponibilidade API de Empréstimos - Lista EMPG (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Lista EMPG (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Lista EMPG
    When pegar o status code da requisição
    Then  o status code deve ser 200