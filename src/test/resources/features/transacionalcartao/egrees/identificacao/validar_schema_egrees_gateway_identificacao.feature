@TID95132REV0.2.0
Feature: Validar schema Egrees Gateway de Identificação de Cartões

  Scenario: Validar schema Egrees Gateway de Identificação de Cartões
    Given que seja feito uma requisição POST no endpoint de Identificação de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido