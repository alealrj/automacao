package br.com.bradesco.coredigital.api.automation.model.response.egrees.card.losango;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.Payment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LimitEgreesLosango extends Response implements Serializable {

    private String creditLineLimitType;

    private String consolidationType;

    private String identificationNumber;

    private String lineName;

    private String lineNameAdditionalInfo;

    private boolean isLimitFlexible;

    private String limitAmountCurrency;

    private long limitAmount;

    private String usedAmountCurrency;

    private long usedAmount;

    private String availableAmountCurrency;

    private long availableAmount;
}
