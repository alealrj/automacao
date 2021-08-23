@TID96950REV0.2.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Contrato (Core)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Contrato
    When pegar o schema da API
    Then o schema deve ser válido