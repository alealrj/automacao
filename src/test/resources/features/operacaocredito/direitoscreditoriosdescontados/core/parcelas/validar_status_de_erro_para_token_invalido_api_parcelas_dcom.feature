@TID100474REV0.3.0
Feature: Validar status de erro para Token inválido API Direitos Creditorios Descontados DCOM - Parcelas (Core)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Parcelas (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Parcelas com token invalido
    When pegar o status code da requisição
    Then o status code deve ser 400