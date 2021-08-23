@TID95112REV0.2.0
Feature: Validar schema API de Transação de Cartões (Supply)

  Scenario Outline: Validar schema API de Transação de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Transação de Cartões informando a <brand> e o <creditCardNumber>
    When pegar o schema da API
    Then  o schema deve ser válido

    Examples:
      | brand        | creditCardNumber |
      | "bradesco"   | "178582x8582199" |
      | "bradescard" | "178582x8582199" |
      | "next"       | "178582x8582199" |