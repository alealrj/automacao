package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfInstallmentContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpfInstallmentContractFactory {

    public EmpfInstallmentContractRequest buildEmpfInstallmentContractRequest(long cprodtBdsco, long cfamlContr,
                                                                              long ccontr, String dsoltcConsDados,
                                                                              String dinicPgto, String dfnalPgto) {
        return EmpfInstallmentContractRequest.builder()
                .cprodtBdsco(cprodtBdsco)
                .cfamlContr(cfamlContr)
                .ccontr(ccontr)
                .dsoltcConsDados(dsoltcConsDados)
                .dinicConsent(dinicPgto)
                .dfnalConsent(dfnalPgto)
                .build();
    }
}
