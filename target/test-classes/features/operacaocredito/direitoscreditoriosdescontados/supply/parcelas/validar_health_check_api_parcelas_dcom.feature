@TID108040REV0.2.0
Feature: Validar saúde API Direitos Creditorios Descontados DCOM - Parcelas (Supply)
  Scenario: Validar saúde API Direitos Creditorios Descontados DCOM - Parcelas (Supply)
    Given que seja feito uma requisição GET no endpoint Health Check de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o status de saude da requisição
    Then o status de saúde da API deve ser UP