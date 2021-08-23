package br.com.bradesco.coredigital.api.automation.model.response.core.financing;

import br.com.bradesco.coredigital.api.automation.model.BalloonPayment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FinancingScheduleInstalmentCore implements Serializable {

    private long contractRemainingDays;

    private long dueInstalments;

    private long pastDueInstalments;

    private List<BalloonPayment> balloonPayments;
}
