@TID99667REV0.2.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Core)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o status code da requisição
    Then o status code deve ser 200