@TID95153REV0.2.1
Feature: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Contrato (Supply)

  Scenario: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400