@TID95163REV0.4.0
Feature: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Contrato (Supply)

  Scenario: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Contrato sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 503