package br.com.bradesco.coredigital.api.automation.model.response.supply.cardData;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FinanceCharge implements Serializable{

    private String type;

    private String additionalInfo;

    private long amount;

    private String currency;
}
