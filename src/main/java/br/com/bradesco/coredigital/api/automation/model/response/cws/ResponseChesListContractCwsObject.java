package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseChesListContractCwsObject extends Response implements Serializable {

    private List<ContractList> contracts;

    @Getter
    @Setter
    public static class ContractList {

        private String scsistOrig;

        private BigDecimal sccontr;

        private String scarteira;

        private int scmodldRzCtbil;

        private String swidPdraoOper;

        private String sdexparaMod;

        private String sdataFimContrato;
    }
}
