package br.com.bradesco.coredigital.api.automation.model.response.supply.invoiceFinancings;

import br.com.bradesco.coredigital.api.automation.model.BalloonPayment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class InvoiceFinancingsScheduledInstalmentsSuply implements Serializable {

    private String typeNumberOfInstalments;

    private BigDecimal totalNumberOfInstalments;
    
    private String typeContractRemaining;
    
    private BigDecimal contractRemainingNumber;
    
    private BigDecimal paidInstalments;
    
    private BigDecimal dueInstalments;

    private BigDecimal pastDueInstalments;
    
    private List<BalloonPayment> balloonPayments;
}
