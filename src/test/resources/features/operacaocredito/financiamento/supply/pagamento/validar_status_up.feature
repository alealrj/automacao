@TID99087REV0.2.0
Feature: Validar status UP API de Financiamento - Pagamento (Supply)

  Scenario: Validar status UP API de Financiamento - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Pagamento
    When pegar o status da API
    Then  status deve ser "UP"