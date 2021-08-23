package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmpfInstallmentContractRequest implements Serializable {

    private long cprodtBdsco;

    private long cfamlContr;

    private long ccontr;

    private String dsoltcConsDados;

    private String dinicConsent;

    private String dfnalConsent;
}