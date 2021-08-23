package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseEmpfListContractCwsObject implements Serializable {

    private List<ContractList> contracts;

    @Getter
    @Setter
    public static class ContractList {

        private long sccontr;

        private String scsistOrig;

        private BigDecimal scmodldRzCtbil;

        private String swidPdraoOper;

        private String sdexparaMod;

        private String scarteira;

        private String dfimVgcia;
    }
}
