@TID95115REV0.2.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Supply)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista
    When pegar o schema da API
    Then o schema deve ser válido