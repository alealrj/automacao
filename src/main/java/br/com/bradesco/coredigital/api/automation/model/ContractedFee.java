package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ContractedFee implements Serializable {

    private String feeName;

    private String feeCode;

    private String feeChargeType;

    private String feeCharge;

    private BigDecimal feeAmount;

    private BigDecimal feeRate;
}
