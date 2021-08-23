package br.com.bradesco.coredigital.api.automation.model.response.egrees.card.losango;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.FinanceCharge;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.Payment;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.PaymentBill;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BillEgreesLosango extends Response implements Serializable {

    private String billId;

    private String dueDate;

    private long billTotalAmount;

    private String billTotalAmountCurrency;

    private long billMinimumAmount;

    private String billMinimumAmountCurrency;

    @JsonProperty ("isInstalment")
    private boolean isInstalment;

    private List<FinanceCharge> financeCharges;

    private List<PaymentBill> payments;
}
