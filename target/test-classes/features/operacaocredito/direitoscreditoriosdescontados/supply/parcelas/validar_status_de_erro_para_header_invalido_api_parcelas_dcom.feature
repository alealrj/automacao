@TID95157REV0.4.0
Feature: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Parcelas (Supply)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Parcelas (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400