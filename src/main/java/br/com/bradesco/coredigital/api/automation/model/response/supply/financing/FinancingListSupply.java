package br.com.bradesco.coredigital.api.automation.model.response.supply.financing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FinancingListSupply implements Serializable {

    private String brandName;

    private String companyCnpj;

    private String productType;

    private String productSubType;

    private String ipocCode;

    private String contractId;
}
