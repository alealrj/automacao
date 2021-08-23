package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmpgContractRequest implements Serializable {

    private String ccontr;

    private String cprodtBdsco;

    private String cfamlContr;

    private String dsoltcConsDados;

    private String dinicConsent;

    private String dfnalConsent;
}
