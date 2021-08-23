@TID95071REV0.3.0
Feature: Validar disponibilidade API Adiantamento a Depositante - Lista (Core)

  Scenario: Validar disponibilidade API Adiantamento a Depositante - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Lista
    When pegar o status code da requisição
    Then o status code deve ser 200