package br.com.bradesco.coredigital.api.automation.model.response.supply.businessrelation;

import br.com.bradesco.coredigital.api.automation.model.AccountBusiness;
import br.com.bradesco.coredigital.api.automation.model.ProcuratorCnpj;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BusinessRelationSupply implements Serializable {

    private String updateDateTime;

    private String startDate;

    private List<String> productsServicesType;

    private List<ProcuratorCnpj> procurators;

    private List<AccountBusiness> accounts;
}
