package br.com.bradesco.coredigital.api.automation.model.response.supply.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class LimitSupply implements Serializable {

    private BigDecimal overdraftLimitContracted;

    private String overdraftContractedLimitCurrency;

    private BigDecimal overdraftLimitUsed;

    private String overdraftLimitUsedCurrency;
}

