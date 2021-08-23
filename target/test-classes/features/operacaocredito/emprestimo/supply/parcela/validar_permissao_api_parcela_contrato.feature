@TID100423REV0.2.0
Feature: Validar permissão API de Empréstimos - Parcelamento Contrato (Supply)

  Scenario: Validar permissão API de Empréstimos - Parcelamento Contrato (Supply)
    Given que seja feito uma requisição GET sem permissão no endpoint de Empréstimos - Parcelamento Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 403
    And detalhe deve ser "Permissão de acesso não foi encontrada na requisição"