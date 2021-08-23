@TID95148REV0.2.0
Feature: Validar status de erro para Authorization com permissão inválida API Limites

  Scenario: Validar status de erro para Authorization com permissão inválida API Limites
    Given que seja feito uma requisição GET no endpoint de Limites Cartões com permissão inválida
    When pegar o status code da requisição
    Then  o status code deve ser 403