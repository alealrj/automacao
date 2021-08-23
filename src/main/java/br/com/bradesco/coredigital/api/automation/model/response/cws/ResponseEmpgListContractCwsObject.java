package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ResponseEmpgListContractCwsObject implements Serializable {

    private List<ContractList> contracts;

    @Getter
    @Setter
    public static class ContractList {

        private String scsistOrig;

        private long sccontr;

        private String scarteira;

        private long scmodldRzCtbil;

        private String swidPdraoOper;

        private String sdexparaMod;

        private String sdataFimContrato;
    }
}
