@TID99582REV0.2.0
Feature: Validar schema API de Pre-Consentimento por CPF-CNPJ

  Scenario: Validar schema API de Pre-Consentimento por CPF-CNPJ
    Given que seja feito uma requisição GET por cpf-cnpj no endpoint de Pre-Consentimento
    When pegar o schema da API
    Then  o schema deve ser válido