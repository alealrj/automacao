@TID95021REV0.2.0
Feature: Validar disponibilidade API Adiantamento a Depositante ADPOS - Lista (Supply)

  Scenario: Validar disponibilidade API Adiantamento a Depositante ADPOS - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Lista
    When pegar o status code da requisição
    Then o status code deve ser 200