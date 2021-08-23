@TID95861REV0.3.0
Feature: Validar status de erro para body request inválido API Adiantamento a Depositante - Lista (Cws)

  Scenario: Validar status de erro para body request inválido API Adiantamento a Depositante - Lista (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Lista com body request invalido
    When pegar o status code da requisição
    Then o status code deve ser 500