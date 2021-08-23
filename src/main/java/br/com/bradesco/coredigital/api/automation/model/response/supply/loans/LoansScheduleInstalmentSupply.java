package br.com.bradesco.coredigital.api.automation.model.response.supply.loans;

import br.com.bradesco.coredigital.api.automation.model.BalloonPayment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LoansScheduleInstalmentSupply implements Serializable {

    private String typeNumberOfInstalments;

    private long totalNumberOfInstalments;

    private String typeContractRemaining;

    private long contractRemainingNumber;

    private long paidInstalments;

    private long dueInstalments;

    private long pastDueInstalments;

    private List<BalloonPayment> balloonPayments;
}
