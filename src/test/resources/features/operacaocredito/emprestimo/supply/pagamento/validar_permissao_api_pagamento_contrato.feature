@TID99594REV0.2.0
Feature: Validar permissão API de Empréstimos - Pagamento (Supply)

  Scenario: Validar permissão API de Empréstimos - Pagamento (Supply)
    Given que seja feito uma requisição GET sem permissão no endpoint de Empréstimos - Pagamento
    When pegar o status code da requisição
    Then  o status code deve ser 403
    And detalhe deve ser "Permissão de acesso não foi encontrada na requisição"