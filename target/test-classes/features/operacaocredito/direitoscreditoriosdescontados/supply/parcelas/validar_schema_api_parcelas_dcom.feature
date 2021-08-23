@TID95114REV0.4.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Pacelas (Supply)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Pacelas (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o schema da API
    Then o schema deve ser válido