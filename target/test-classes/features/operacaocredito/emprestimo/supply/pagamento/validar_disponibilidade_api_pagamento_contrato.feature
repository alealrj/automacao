@TID95033REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Pagamento (Supply)

  Scenario: Validar disponibilidade API de Empréstimos - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Pagamento
    When pegar o status code da requisição
    Then  o status code deve ser 200