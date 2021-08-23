@TID98324REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Parcelamento Contrato (Core)

  Scenario: Validar disponibilidade API de Empréstimos - Parcelamento Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Parcelamento Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200