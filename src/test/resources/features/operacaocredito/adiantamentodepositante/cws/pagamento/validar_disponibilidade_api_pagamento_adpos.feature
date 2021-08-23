@TID101731REV0.2.0
Feature: Validar disponibilidade API Adiantamento a Depositante - Pagamento (Cws)

  Scenario: Validar disponibilidade API Adiantamento a Depositante - Pagamento (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento
    When pegar o status code da requisição
    Then o status code deve ser 200