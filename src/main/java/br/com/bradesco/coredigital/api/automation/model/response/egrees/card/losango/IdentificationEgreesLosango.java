package br.com.bradesco.coredigital.api.automation.model.response.egrees.card.losango;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class IdentificationEgreesLosango extends Response implements Serializable {

    private String name;

    private String productType;

    private String productAdditionalInfo;

    private String creditCardNetwork;

    private String networkAdditionalInfo;

    private List<Payment> paymentMethod;
}
