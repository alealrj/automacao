package br.com.bradesco.coredigital.api.automation.model.response.supply.card;

import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.Payment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IdentificationSupply implements Serializable {

    private String name;

    private String productType;

    private String productAdditionalInfo;

    private String creditCardNetwork;

    private String networkAdditionalInfo;

    private Payment paymentMethod;
}
