@TID95078REV0.2.0
Feature: Validar schema API Adiantamento a Depositante ADPOS - Contrato (Core)

  Scenario: Validar schema API Adiantamento a Depositante ADPOS - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato
    When pegar o schema da API
    Then o schema deve ser válido