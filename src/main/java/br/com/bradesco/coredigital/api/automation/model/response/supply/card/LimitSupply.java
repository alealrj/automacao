package br.com.bradesco.coredigital.api.automation.model.response.supply.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LimitSupply implements Serializable {

    private String creditLineLimitType;

    private String consolidationType;

    private String identificationNumber;

    private String lineName;

    private String lineNameAdditionalInfo;

    @JsonProperty("isLimitFlexible")
    private boolean isLimitFlexible;

    private String limitAmountCurrency;

    private long limitAmount;

    private String usedAmountCurrency;

    private long usedAmount;

    private String availableAmountCurrency;

    private long availableAmount;
}
