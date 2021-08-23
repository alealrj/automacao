@TID107903REV0.3.0
Feature: Validar saúde API Direitos Creditorios Descontados DCOM - Contrato (Core)
  Scenario: Validar saúde API Direitos Creditorios Descontados DCOM - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint Health Check de Direitos Creditorios Descontados DCOM - Contrato
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP