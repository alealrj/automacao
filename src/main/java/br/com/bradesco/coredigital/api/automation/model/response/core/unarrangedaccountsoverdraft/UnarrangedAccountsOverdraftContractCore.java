package br.com.bradesco.coredigital.api.automation.model.response.core.unarrangedaccountsoverdraft;

import br.com.bradesco.coredigital.api.automation.model.ContractedFee;
import br.com.bradesco.coredigital.api.automation.model.ContractedFinanceCharge;
import br.com.bradesco.coredigital.api.automation.model.InterestRate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class UnarrangedAccountsOverdraftContractCore implements Serializable {

    private String contractNumber;

    private String ipocCode;

    private String productName;

    private String productType;

    private String productSubType;

    private String contractDate;

    private String disbursementDate;

    private String settlementDate;

    private BigDecimal contractAmount;

    private String currency;

    private String dueDate;

    private String instalmentPeriodicity;

    private String instalmentPeriodicityAdditionalInfo;

    private String firstInstalmentDueDate;

    @JsonProperty("CET")
    private BigDecimal CET;

    private String amortizationScheduled;

    private List<InterestRate> interestRates;

    private List<ContractedFee> contractedFees;

    private List<ContractedFinanceCharge> contractedFinanceCharges;
}