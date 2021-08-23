package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccountTransactionTypeCws  implements Serializable {

    private String cbco;

    private String cidtfdLcto;

    private String cidtfdSnalLcto;

    private String ccategLcto;

    private String icateg;
}
