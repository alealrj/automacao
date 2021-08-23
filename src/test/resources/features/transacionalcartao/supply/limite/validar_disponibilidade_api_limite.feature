@TID95054REV0.4.0
Feature: Validar disponibilidade API de Limites de Cartões (Supply)

  Scenario Outline: Validar disponibilidade API de Limites de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Limite de Cartões informando a <brand> e o <creditCardNumber>
    When pegar o status code da requisição
    Then  o status code deve ser 200

    Examples:
      | brand        | creditCardNumber |
      | "bradesco"   | "HdcmcXa19UDAHAd_8KE3sbYrj36XZ1lWsg6BDJIOWitDX7Gq0TEgDuqI-ITKx71-weKUDOb3WMQtsxmMz-S3Eg" |
      | "bradesco"   | "U4mFA8o-Xsc-_-rnaQZBvbCDK8h-0Lv5-MPyIFgvBSgw_ROr5R12XVzqUsPEPr1gVeBL1n2pvPxQEgCZFKJDNA" |
      | "bradescard"       | "C_Bhth48W7Y5RYLjgi8W4xrAn61vPKo_prtmzWRUcTk2ocUwhchHHF8dquT380mM3FFpS12hwR_PXLqHreQG6w" |
      | "next" | "dCzr9e9_CpTC7BYbxA8jVUqufC1CFjxuUnCA204IldDXKNU7sg7FA_AEh25GBU9VYeuu5a-G9cfSvGVdtN3ASQ" |