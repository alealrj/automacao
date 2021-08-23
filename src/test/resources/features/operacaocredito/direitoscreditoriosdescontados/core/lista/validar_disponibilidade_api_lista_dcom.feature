@TID96447REV0.2.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Lista (Core)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Lista (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista
    When pegar o status code da requisição
    Then o status code deve ser 200