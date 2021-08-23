package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.GranWarrantyContractRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GranWarrantyListContractFactory {

    public GranWarrantyContractRequest buildGranWarrantyContractRequest(BigDecimal eCpssoaJuridContr, int eCtpoContrNego,
                                                                        BigDecimal eNseqContrNego, int eCbco, int eCagBcria,
                                                                        BigDecimal eCctaBcriaCli, String eCcart,
                                                                        BigDecimal eCcontrFincd) {

       return GranWarrantyContractRequest.builder()
               .ecpssoaJuridContr(eCpssoaJuridContr)
               .ectpoContrNego(eCtpoContrNego)
               .enseqContrNego(eNseqContrNego)
               .ecbco(eCbco)
               .ecagBcria(eCagBcria)
               .ecctaBcriaCli(eCctaBcriaCli)
               .eccart(eCcart)
               .eccontrFincd(eCcontrFincd)
               .build();
    }
}
