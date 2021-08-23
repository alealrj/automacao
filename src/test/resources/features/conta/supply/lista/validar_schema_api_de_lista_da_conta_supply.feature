@TID95124REV0.2.1
Feature: Validar Schema API Lista de Contas Supply

  Scenario: Validar Schema API Lista de Contas
    Given que seja feito uma requisição GET no endpoint de Lista de Contas
    When pegar o schema da API
    Then  o schema deve ser válido