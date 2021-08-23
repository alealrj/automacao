package br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomerrelation;

import br.com.bradesco.coredigital.api.automation.model.AccountPersonal;
import br.com.bradesco.coredigital.api.automation.model.ProcuratorCpf;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PersonalCustomerRelationSupply implements Serializable {

    private String updateDateTime;

    private String startDate;

    private List<String> productsServicesType;

    private String productsServicesTypeAdditionalInfo;

    private List<ProcuratorCpf> procurators;

    private List<AccountPersonal> accounts;
}