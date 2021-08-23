@TID95135REV0.2.0
Feature: Validar schema Egrees Gateway de Transação por Fatura de Cartões

  Scenario: Validar schema Egrees Gateway de Transação por Fatura de Cartões
    Given que seja feito uma requisição POST no endpoint de Transação por Fatura de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido
