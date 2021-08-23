package br.com.bradesco.coredigital.api.automation.model.response.supply.cardData;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PaymentBill implements Serializable{

    private String valueType;

    private String paymentDate;

    private String paymentMode;

    private long amount;

    private String currency;
}
