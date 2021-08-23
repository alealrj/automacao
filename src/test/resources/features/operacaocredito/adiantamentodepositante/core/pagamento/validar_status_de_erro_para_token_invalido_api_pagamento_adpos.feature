@TID102469REV0.2.0
Feature: Validar status de erro para Token inválido API Adiantamento a Depositante - Pagamento (Core)

  Scenario: Validar status de erro para Token inválido API Adiantamento a Depositante - Pagamento (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento com token invalido
    When pegar o status code da requisição
    Then o status code deve ser 400