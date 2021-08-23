package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CwsScheduledInstalmentsDcomRequest implements Serializable {

    private String requestDate;

    private String requestDatePeriodBegin;

    private String requestDatePeriodEnd;

    private String contractId;
}