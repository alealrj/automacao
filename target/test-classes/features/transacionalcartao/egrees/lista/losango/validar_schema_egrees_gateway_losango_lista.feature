@TID99297REV0.2.0
Feature: Validar schema Egrees Gateway Losango de Lista de Cartões

  Scenario: Validar schema Egrees Gateway Losango de Lista de Cartões
    Given que seja feito uma requisição GET no endpoint de Lista de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido