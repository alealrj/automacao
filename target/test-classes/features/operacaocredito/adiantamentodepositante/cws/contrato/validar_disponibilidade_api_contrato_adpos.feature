@TID96041REV0.3.1
Feature: Validar disponibilidade API Adiantamento a Depositante - Contrato (Cws)

  Scenario: Validar disponibilidade API Adiantamento a Depositante - Contrato (Cws)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Contrato
    When pegar o status code da requisição
    Then o status code deve ser 200