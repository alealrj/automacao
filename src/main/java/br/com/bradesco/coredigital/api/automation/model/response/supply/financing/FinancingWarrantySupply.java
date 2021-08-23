package br.com.bradesco.coredigital.api.automation.model.response.supply.financing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class FinancingWarrantySupply implements Serializable {

    private String currency;

    private String warrantyType;

    private String warrantySubType;

    private BigDecimal warrantyAmount;
}
