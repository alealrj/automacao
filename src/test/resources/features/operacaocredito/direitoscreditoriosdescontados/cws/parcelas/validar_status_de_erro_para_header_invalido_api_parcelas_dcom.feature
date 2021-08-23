@TID100204REV0.2.0
Feature: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Parcelas (Cws)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Parcelas (Cws)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 500