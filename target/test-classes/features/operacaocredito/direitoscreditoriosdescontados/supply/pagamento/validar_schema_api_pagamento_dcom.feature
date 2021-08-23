@TID95116REV0.2.0
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Pagamento (Supply)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento
    When pegar o schema da API
    Then o schema deve ser válido

