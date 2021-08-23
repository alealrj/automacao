@TID97943REV0.2.0
Feature: Validar status UP API de Empréstimos - Pagamento (Supply)

  Scenario: Validar status UP API de Empréstimos - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Pagamento
    When pegar o status da API
    Then  status deve ser "UP"