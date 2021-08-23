package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpgListContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpgListContractFactory {

    public EmpgListContractRequest buildEmpgListContractRequest(String agency, String account, String ownership,
                                                                String cpfCnpj, String digitCpfCnpj, String filialCnpj,
                                                                String brand, String requestDate, String startDate,
                                                                String endDate) {

       return EmpgListContractRequest.builder()
               .agency(agency)
               .account(account)
               .ownership(ownership)
               .cpfCnpj(cpfCnpj)
               .digitCpfCnpj(digitCpfCnpj)
               .filialCnpj(filialCnpj)
               .brand(brand)
               .requestDate(requestDate)
               .startDate(startDate)
               .endDate(endDate)
               .build();
    }
}
