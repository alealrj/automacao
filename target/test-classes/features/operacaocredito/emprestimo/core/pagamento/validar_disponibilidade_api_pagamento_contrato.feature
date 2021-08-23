@TID97777REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Pagamento (Core)

  Scenario: Validar disponibilidade API de Empréstimos - Pagamento (Core)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Pagamento
    When pegar o status code da requisição
    Then  o status code deve ser 200