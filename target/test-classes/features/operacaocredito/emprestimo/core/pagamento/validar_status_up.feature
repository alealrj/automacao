@TID98522REV0.2.0
Feature: Validar status UP API de Empréstimos - Pagamento (Core)

  Scenario: Validar status UP API de Empréstimos - Pagamento (Core)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Pagamento
    When pegar o status da API
    Then  status deve ser "UP"