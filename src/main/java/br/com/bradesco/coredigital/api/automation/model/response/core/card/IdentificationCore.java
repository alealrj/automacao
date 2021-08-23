package br.com.bradesco.coredigital.api.automation.model.response.core.card;

import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.Payment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IdentificationCore implements Serializable {

    private String creditCardAccountId;

    private String requestDateTime;

    private String name;

    private String productType;

    private String creditCardNetwork;

    private Payment paymentMethod;
}
