@TID97285REV0.3.0
Feature: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Lista (Core)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400