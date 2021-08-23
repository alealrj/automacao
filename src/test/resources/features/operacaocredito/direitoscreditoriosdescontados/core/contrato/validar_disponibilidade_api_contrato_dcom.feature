@TID97487REV0.2.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Contrato (Core)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Contrato
    When pegar o status code da requisição
    Then o status code deve ser 200