@TID97009REV0.3.0
Feature: Validar status de erro para Token inválido API Adiantamento a Depositante - Lista (Core)

  Scenario: Validar status de erro para Token inválido API Adiantamento a Depositante - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Lista com token invalido
    When pegar o status code da requisição
    Then o status code deve ser 400
    And a mensagem de erro deve ser "Authorization não pode ser recuperado ou não está no formato esperado"