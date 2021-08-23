@TID95136REV0.2.0
Feature: Validar schema Egrees Gateway de Transações de Cartões

  Scenario: Validar schema Egrees Gateway de Transações de Cartões
    Given que seja feito uma requisição POST no endpoint de Transações de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido