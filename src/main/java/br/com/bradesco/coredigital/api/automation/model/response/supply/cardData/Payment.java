package br.com.bradesco.coredigital.api.automation.model.response.supply.cardData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Payment implements Serializable{

    private long identificationNumber;

    @JsonProperty("isMultipleCreditCard")
    private boolean isMultipleCreditCard;
}
