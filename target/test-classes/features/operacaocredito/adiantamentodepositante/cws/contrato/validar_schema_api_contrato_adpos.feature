@TID96042REV0.3.1
Feature: Validar schema API Adiantamento a Depositante - Contrato (Cws)

  Scenario: Validar schema API Adiantamento a Depositante - Contrato (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Contrato
    When pegar o schema da API
    Then o schema deve ser válido