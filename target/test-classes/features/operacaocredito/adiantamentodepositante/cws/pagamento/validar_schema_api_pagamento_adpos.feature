@TID102376REV0.2.0
Feature: Validar schema API Adiantamento a Depositante - Pagamento (Cws)

  Scenario: Validar schema API Adiantamento a Depositante - Pagamento (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento
    When pegar o schema da API
    Then o schema deve ser válido