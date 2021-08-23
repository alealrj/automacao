@TID95062REV0.3.0
Feature: Validar disponibilidade API de Transação por Fatura de Cartões (Supply)

  Scenario Outline: Validar disponibilidade API de Transação por Fatura de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Transação por Fatura de Cartões informando o <creditCardNumber> e o <billId>
    When pegar o status code da requisição
    Then  o status code deve ser 200

    Examples:
      | creditCardNumber | billId           |
      | "178582x8582199" | "MTIwNTIwMjE=" |
      | "178582x8582199" | "MTIwNTIwMjE=" |
      | "178582x8582199" | "MTIwNTIwMjE=" |