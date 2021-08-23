package br.com.bradesco.coredigital.api.automation.model.response.core.financing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class FinancingWarrantyCore implements Serializable {

    private String currency;

    private String warrantyType;

    private String warrantySubType;

    private BigDecimal warrantyAmount;
}
