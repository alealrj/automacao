@TID102378REV0.2.0
Feature: Validar status de erro para body request inválido API Adiantamento a Depositante - Pagamento (Cws)

  Scenario: Validar status de erro para body request inválido API Adiantamento a Depositante - Pagamento (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento com body request invalido
    When pegar o status code da requisição
    Then o status code deve ser 500