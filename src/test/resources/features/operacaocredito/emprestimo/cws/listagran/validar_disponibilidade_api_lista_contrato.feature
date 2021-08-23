@TID95032REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Lista Garantia Contrato GRAN (CWS)

  Scenario: Validar disponibilidade API de Empréstimos - Lista Garantia Contrato GRAN (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Lista Garantia Contrato GRAN
    When pegar o status code da requisição
    Then  o status code deve ser 200