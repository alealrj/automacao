package br.com.bradesco.coredigital.api.automation.model.response.supply.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InvoiceTransactionSupply implements Serializable {

    private String transactionId;

    private String identificationNumber;

    private String lineName;

    private String transactionName;

    private String billId;

    private String creditDebitType;

    private String transactionType;

    @JsonProperty("transactionalAddtionalInfo")
    private String transactionalAdditionalInfo;

    private String paymentType;

    private String feeType;

    private String feeTypeAdditionalInfo;

    private String otherCreditsType;

    private String otherCreditsAdditionalInfo;

    private String chargeIdentificator;

    private long chargeNumber;

    private long brazilianAmount;

    private long amount;

    private String currency;

    private String transactionDate;

    private String billPostDate;

    private long payeeMCC;
}
