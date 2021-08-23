@TID108039REV0.2.0
Feature: Validar saúde API Direitos Creditorios Descontados DCOM - Contrato (Supply)

  Scenario: Validar saúde API Direitos Creditorios Descontados DCOM - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint Health Check de Direitos Creditorios Descontados DCOM - Contrato
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP