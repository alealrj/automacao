@TID99281REV0.2.0
Feature: Validar disponibilidade Egrees Gateway Losango de Identificação de Cartões

  Scenario: Validar disponibilidade Egrees Gateway Losango de Identificação de Cartões
    Given que seja feito uma requisição GET no endpoint de Identificação de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200