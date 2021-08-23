@TID95125REV0.3.0
Feature: Validar schema API Adiantamento a Depositante - Lista (Core)

  Scenario: Validar schema API Adiantamento a Depositante - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Lista
    When pegar o schema da API
    Then o schema deve ser válido