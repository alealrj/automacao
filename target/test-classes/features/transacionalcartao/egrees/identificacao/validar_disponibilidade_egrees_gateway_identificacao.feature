@TID95073REV0.2.0
Feature: Validar disponibilidade Egrees Gateway de Identificação de Cartões

  Scenario: Validar disponibilidade Egrees Gateway de Identificação de Cartões
    Given que seja feito uma requisição POST no endpoint de Identificação de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200