#@TID95063REV0.2.1
#Feature: Validar disponibilidade API de Transações da Conta Supply
#
#  Scenario: Validar disponibilidade API de Transações da Conta
#    Given que seja feito uma requisicao GET no endpoint de Transacoes da Conta
#    When pegar o status code da requisição
#    Then  o status code deve ser 200