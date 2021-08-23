package br.com.bradesco.coredigital.api.automation.model.response.supply.unarrangedaccountsoverdraft;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UnarrangedAccountsOverdraftListSupply implements Serializable {

    private String contractId;

    private String brandName;

    private String companyCnpj;

    private String productType;

    private String productSubType;

    private String ipocCode;
}
