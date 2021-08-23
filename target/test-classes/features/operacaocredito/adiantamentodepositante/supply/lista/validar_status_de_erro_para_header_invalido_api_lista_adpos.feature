@TID95154REV0.4.0
Feature: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Lista (Supply)

  Scenario: Validar status de erro para Authorization inválido API Adiantamento a Depositante ADPOS - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Lista com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400