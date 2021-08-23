package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesChaveIdentificationRequest;
import org.springframework.stereotype.Component;

@Component
public class EgreesChaveIdentificationFactory {

    public EgreesChaveIdentificationRequest buildEgreesChaveIdentificationRequest(String b2k) {

       return EgreesChaveIdentificationRequest.builder()
               .b2k(b2k)
               .build();
    }
}
