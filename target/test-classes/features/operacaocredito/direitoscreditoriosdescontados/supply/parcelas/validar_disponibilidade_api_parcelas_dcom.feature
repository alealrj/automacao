@TID95068REV0.4.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Supply)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o status code da requisição
    Then o status code deve ser 200