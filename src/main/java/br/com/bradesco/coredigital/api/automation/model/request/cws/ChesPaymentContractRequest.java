package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ChesPaymentContractRequest implements Serializable {

    private BigDecimal ccontr;

    private String dsoltcConsDados;

    private String dinicConsent;

    private String dfnalConsent;
}