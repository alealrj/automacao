package br.com.bradesco.coredigital.api.automation.model.response.supply.card;

import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.FinanceCharge;
import br.com.bradesco.coredigital.api.automation.model.response.supply.cardData.PaymentBill;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BillSupply implements Serializable {

    private String billId;

    private String dueDate;

    private long billTotalAmount;

    private String billTotalAmountCurrency;

    private long billMinimumAmount;

    private String billMinimumAmountCurrency;

    private boolean isInstalment;

    private List<FinanceCharge> financeCharges;

    private List<PaymentBill> payments;
}
