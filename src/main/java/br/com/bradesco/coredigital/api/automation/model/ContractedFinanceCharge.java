package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ContractedFinanceCharge implements Serializable {

    private String chargeType;

    private String chargeAdditionalInfo;

    private BigDecimal chargeRate;
}
