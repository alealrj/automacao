@TID107901REV0.2.0
Feature: Validar saúde API Adiantamento a Depositante ADPOS - Lista (Core)

  Scenario: Validar saúde API Adiantamento a Depositante ADPOS - Lista (Core)
    Given que seja feito uma requisição GET no endpoint Health Check de Adiantamento a Depositante ADPOS - Lista
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP