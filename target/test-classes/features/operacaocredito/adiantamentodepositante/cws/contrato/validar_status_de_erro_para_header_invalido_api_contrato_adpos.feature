@TID95758REV0.3.0
Feature: Validar status de erro para Authorization inválido API Adiantamento a Depositante - Contrato (Cws)

  Scenario: Validar status de erro para Authorization inválido API Adiantamento a Depositante - Contrato (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Contrato com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 500