package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmpfPaymentContractRequest implements Serializable {

    private String cprodtBdsco;

    private String cfamlContr;

    private String ccontr;

    private String dsoltcConsDados;

    private String dinicPgto;

    private String dfnalPgto;
}