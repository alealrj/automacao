@TID100202REV0.2.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Cws)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Parcelas (Cws)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas
    When pegar o status code da requisição
    Then o status code deve ser 200