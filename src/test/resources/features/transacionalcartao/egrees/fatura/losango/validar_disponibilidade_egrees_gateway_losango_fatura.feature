@TID99283REV0.2.0
Feature: Validar disponibilidade Egrees Gateway Losango de Fatura de Cartões

  Scenario: Validar disponibilidade Egrees Gateway Losango de Fatura de Cartões
    Given que seja feito uma requisição GET no endpoint de Fatura de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200