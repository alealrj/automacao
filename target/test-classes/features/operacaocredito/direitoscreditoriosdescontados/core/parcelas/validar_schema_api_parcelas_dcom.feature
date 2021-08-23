@TID99669REV0.2.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Parcelas (Core)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Parcelas (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o schema da API
    Then o schema deve ser válido