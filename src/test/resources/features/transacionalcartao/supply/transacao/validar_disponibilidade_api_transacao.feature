@TID95066REV0.2.0
Feature: Validar disponibilidade API de Transação de Cartões (Supply)

  Scenario Outline: Validar disponibilidade API de Transação de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Transação de Cartões informando a <brand> e o <creditCardNumber>
    When pegar o status code da requisição
    Then  o status code deve ser 200

    Examples:
      | brand        | creditCardNumber |
      | "bradesco"   | "178582x8582199" |
      | "bradescard" | "178582x8582199" |
      | "next"       | "178582x8582199" |