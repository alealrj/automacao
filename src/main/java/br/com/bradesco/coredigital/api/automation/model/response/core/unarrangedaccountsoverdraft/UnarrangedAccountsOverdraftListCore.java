package br.com.bradesco.coredigital.api.automation.model.response.core.unarrangedaccountsoverdraft;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UnarrangedAccountsOverdraftListCore implements Serializable {

    private String sourceSystem;

    private String companyCnpj;

    private String brandName;

    private String productSubModality;

    private String type;

    private String productType;

    private String productSubType;

    private String ipocCode;

    private String contractSourceSystem;

    private String portfolio;
}
