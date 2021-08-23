package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class InterestRate implements Serializable {

    private String taxType;

    private String interestRateType;

    private String taxPeriodicity;

    private String calculation;

    private String referentialRateIndexerType;

    private String referentialRateIndexerSubType;

    private String referentialRateIndexerAdditionalInfo;

    private BigDecimal preFixedRate;

    private BigDecimal postFixedRate;

    private String additionalInfo;
}
