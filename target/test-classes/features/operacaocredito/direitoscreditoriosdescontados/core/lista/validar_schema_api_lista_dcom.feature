@TID96448REV0.2.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Core)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista
    When pegar o schema da API
    Then o schema deve ser válido