@TID95022REV0.2.0
Feature: Validar disponibilidade API Adiantamento a Depositante ADPOS - Pagamento (Supply)

  Scenario: Validar disponibilidade API Adiantamento a Depositante ADPOS - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Pagamento
    When pegar o status code da requisição
    Then o status code deve ser 200