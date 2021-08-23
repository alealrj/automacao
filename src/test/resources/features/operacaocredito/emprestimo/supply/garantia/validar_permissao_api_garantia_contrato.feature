@TID99591REV0.2.0
Feature: Validar permissão API de Empréstimos - Garantia Contrato (Supply)

  Scenario: Validar permissão API de Empréstimos - Garantia Contrato (Supply)
    Given que seja feito uma requisição GET sem permissão no endpoint de Empréstimos - Garantia Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 403
    And detalhe deve ser "Permissão de acesso não foi encontrada na requisição"