@TID95164REV0.6.0
Feature: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Parcelas (Supply)

  Scenario: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Parcelas (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 400