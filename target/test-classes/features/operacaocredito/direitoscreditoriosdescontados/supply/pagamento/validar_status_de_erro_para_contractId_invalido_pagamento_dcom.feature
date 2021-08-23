@TID95165REV0.2.0
Feature: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Pagamento (Supply)

  Scenario: Validar status de erro para contractId inválido API Direitos Creditorios Descontados DCOM - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 503
    And a mensagem de erro deve ser "GATEWAY_ERROR Error when trying to get consent invoice financings payments on feign client "