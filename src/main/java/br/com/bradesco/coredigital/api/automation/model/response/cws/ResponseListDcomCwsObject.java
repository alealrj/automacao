package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseListDcomCwsObject extends Response implements Serializable {

    private List<ContractList> contracts;

    @Getter
    @Setter
    public static class ContractList {

        private BigDecimal cmodldRzCtbil;

        private String sdexparaMod;

        private String swidPdraoOper;

        private String ssistOrigem;

        private BigDecimal soperacao;

        private String sdtQuitacao;

        private String scarteira;
    }
}
