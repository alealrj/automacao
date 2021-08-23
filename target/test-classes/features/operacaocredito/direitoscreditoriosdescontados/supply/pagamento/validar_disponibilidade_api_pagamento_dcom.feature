@TID95070REV0.2.0
Feature: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Pagamento (Supply)

  Scenario: Validar disponibilidade API Direitos Creditorios Descontados DCOM - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento
    When pegar o status code da requisição
    Then o status code deve ser 200