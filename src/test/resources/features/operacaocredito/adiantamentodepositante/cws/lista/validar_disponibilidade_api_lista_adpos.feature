@TID96149REV0.3.0
Feature: Validar disponibilidade API Adiantamento a Depositante - Lista (Cws)

  Scenario: Validar disponibilidade API Adiantamento a Depositante - Lista (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Lista
    When pegar o status code da requisição
    Then o status code deve ser 200