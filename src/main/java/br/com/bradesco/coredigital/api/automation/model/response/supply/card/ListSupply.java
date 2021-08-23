package br.com.bradesco.coredigital.api.automation.model.response.supply.card;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListSupply implements Serializable {

    private String creditCardAccountId;

    private String brandName;

    private String companyCnpj;

    private String name;

    private String productType;

    private String productAdditionalInfo;

    private String creditCardNetwork;

    private String networkAdditionalInfo;
}
