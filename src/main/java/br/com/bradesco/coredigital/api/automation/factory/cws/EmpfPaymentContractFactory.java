package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfPaymentContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpfPaymentContractFactory {

    public EmpfPaymentContractRequest buidEmpfPaymentContractRequest(String ccontr, String cprodtBdsco,
                                                                     String cfamlContr, String dsoltcConsDados,
                                                                     String dinicPgto, String dfnalPgto) {
        return EmpfPaymentContractRequest.builder()
                .ccontr(ccontr)
                .cprodtBdsco(cprodtBdsco)
                .cfamlContr(cfamlContr)
                .dsoltcConsDados(dsoltcConsDados)
                .dinicPgto(dinicPgto)
                .dfnalPgto(dfnalPgto)
                .build();
    }
}
