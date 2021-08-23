@TID95077REV0.2.0
Feature: Validar disponibilidade Egrees Gateway de Transação por Fatura de Cartões

  Scenario: Validar disponibilidade Egrees Gateway de Transação por Fatura de Cartões
    Given que seja feito uma requisição POST no endpoint de Transação por Fatura de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200