package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CwsPaymentAdposRequest implements Serializable {

    private String contractId;

    private String startDate;

    private String endDate;
}
