@TID108036REV0.2.0
Feature: Validar saúde API Adiantamento a Depositante ADPOS - Pagamento (Supply)

  Scenario: Validar saúde API Adiantamento a Depositante ADPOS - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint Health Check de Adiantamento a Depositante ADPOS - Pagamento
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP