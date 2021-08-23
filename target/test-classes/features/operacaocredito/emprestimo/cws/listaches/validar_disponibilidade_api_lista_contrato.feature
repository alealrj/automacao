@TID95030REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Lista CHES (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Lista CHES (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Lista CHES
    When pegar o status code da requisição
    Then  o status code deve ser 200