@TID95076REV0.2.0
Feature: Validar disponibilidade Egrees Gateway de Transação de Cartões

  Scenario: Validar disponibilidade Egrees Gateway de Transação de Cartões
    Given que seja feito uma requisição POST no endpoint de Transação de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200