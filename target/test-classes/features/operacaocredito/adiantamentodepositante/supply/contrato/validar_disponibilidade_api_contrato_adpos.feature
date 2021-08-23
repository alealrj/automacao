@TID95020REV0.2.0
Feature: Validar disponibilidade API Adiantamento a Depositante ADPOS - Contrato (Supply)

  Scenario: Validar disponibilidade API Adiantamento a Depositante ADPOS - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato
    When pegar o status code da requisição
    Then o status code deve ser 200