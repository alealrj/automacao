package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class BalloonPayment implements Serializable {

    private String dueDate;

    private String currency;

    private BigDecimal amount;
}
