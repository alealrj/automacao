@TID95080REV0.2.0
Feature: Validar schema API Adiantamento a Depositante ADPOS - Lista (Supply)

  Scenario: Validar schema API Adiantamento a Depositante ADPOS - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Lista
    When pegar o schema da API
    Then o schema deve ser válido