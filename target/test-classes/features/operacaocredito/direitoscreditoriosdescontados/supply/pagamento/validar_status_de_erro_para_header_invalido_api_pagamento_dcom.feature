@TID95159REV0.2.0
Feature: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Pagamento (Supply)

  Scenario: Validar status de erro para Authorization inválido API Direitos Creditorios Descontados DCOM - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento com header invalido
    When pegar o status code da requisição
    Then o status code deve ser 400