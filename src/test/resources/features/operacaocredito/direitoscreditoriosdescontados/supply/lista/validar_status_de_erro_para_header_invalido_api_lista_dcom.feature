@TID95158REV0.4.0
Feature: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Lista (Supply)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400