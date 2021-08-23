@TID95107REV0.3.0
Feature: Validar schema API de Identificação de Cartões (Supply)

  Scenario Outline: Validar schema API de Identificação de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Identificação de Cartões informando a <brand> e o <creditCardNumber>
    When pegar o schema da API
    Then  o schema deve ser válido

    Examples:
      | brand        | creditCardNumber |
      | "bradesco"   | "178582x8582199" |
      | "bradescard" | "178582x8582199" |
      | "next"       | "178582x8582199" |
      | "losango"    | "178582x8582199" |