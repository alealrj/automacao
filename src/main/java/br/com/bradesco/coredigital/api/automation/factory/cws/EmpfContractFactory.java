package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpfContractFactory {

    public EmpfContractRequest buildEmpfContractRequest(long contractNumber, long productCode, long familyContractCode,
                                     String requestDate, String startConsentDate, String endConsentDate) {

       return EmpfContractRequest.builder()
                .contractNumber(contractNumber)
               .productCode(productCode)
               .familyContractCode(familyContractCode)
               .requestDate(requestDate)
               .startConsentDate(startConsentDate)
               .endConsentDate(endConsentDate)
               .build();
    }
}
