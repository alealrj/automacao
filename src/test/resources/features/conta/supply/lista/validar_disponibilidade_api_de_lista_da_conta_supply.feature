@TID95058REV0.2.1
Feature: Validar disponibilidade API de Lista de Contas Supply

  Scenario: Validar disponibilidade API de Lista de Contas
    Given que seja feito uma requisição GET no endpoint de Lista de Contas
    When pegar o status code da requisição
    Then  o status code deve ser 200