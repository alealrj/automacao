@TID95134REV0.2.0
Feature: Validar schema Egrees Gateway de Lista de Cartões

  Scenario: Validar schema Egrees Gateway de Lista de Cartões
    Given que seja feito uma requisição POST no endpoint de Lista de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido
