package br.com.bradesco.coredigital.api.automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Release implements Serializable {

    private String paymentId;

    @JsonProperty("isOverParcelPayment")
    private boolean isOverParcelPayment;

    private String instalmentId;

    private String paidDate;

    private String currency;

    private BigDecimal paidAmount;

    private OverParcel overParcel;
}
