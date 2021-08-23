@TID95155REV0.2.0
Feature: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Pagamento (Supply)

  Scenario: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Pagamento com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400