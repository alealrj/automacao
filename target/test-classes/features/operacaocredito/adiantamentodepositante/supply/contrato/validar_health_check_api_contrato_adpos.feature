@TID108034REV0.2.0
Feature: Validar saúde API Adiantamento a Depositante ADPOS - Contrato (Supply)

  Scenario: Validar saúde API Adiantamento a Depositante ADPOS - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint Health Check de Adiantamento a Depositante ADPOS - Contrato
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP