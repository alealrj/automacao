package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseScheduledInstalmentsDcomCwsObject extends Response implements Serializable {

    private String tipoPrazoTot;

    private BigDecimal prazoTot;

    private String tipoPrazoRest;

    private BigDecimal prazoRest;

    private BigDecimal qtdParcPag;

    private BigDecimal qtdParcAvcr;

    private BigDecimal qtdParcVenc;

    private BigDecimal qtdeParcela;

    private BigDecimal qtdeOcorr;

    private List<Ocorrencias> ocorrencias;

    @Getter
    @Setter
    public static class Ocorrencias {

        private String dataVenc;

        private String moeda;

        private BigDecimal valorParc;

        private BigDecimal numParc;
    }
}
