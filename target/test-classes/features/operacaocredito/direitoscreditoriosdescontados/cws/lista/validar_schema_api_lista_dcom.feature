@TID97096REV0.2.1
Feature: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Cws)

  Scenario: Validar schema API Direitos Creditorios Descontados DCOM - Lista (Cws)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista
    When pegar o schema da API
    Then o schema deve ser válido