@TID95111REV0.3.0
Feature: Validar schema API de Transação por Fatura de Cartões (Supply)

  Scenario Outline: Validar schema API de Transação por Fatura de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Transação por Fatura de Cartões informando o <creditCardNumber> e o <billId>
    When pegar o schema da API
    Then  o schema deve ser válido

    Examples:
      | creditCardNumber | billId           |
      | "178582x8582199" | "MTIwNTIwMjE=" |
      | "178582x8582199" | "MTIwNTIwMjE=" |
      | "178582x8582199" | "MTIwNTIwMjE=" |
