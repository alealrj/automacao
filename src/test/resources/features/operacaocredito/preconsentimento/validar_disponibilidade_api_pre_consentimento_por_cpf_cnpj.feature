@TID99583REV0.2.0
Feature: Validar disponibilidade API de Pre-Consentimento por CPF-CNPJ

  Scenario: Validar disponibilidade API de Pre-Consentimento por CPF-CNPJ
    Given que seja feito uma requisição GET por cpf-cnpj no endpoint de Pre-Consentimento
    When pegar o status code da requisição
    Then  o status code deve ser 200