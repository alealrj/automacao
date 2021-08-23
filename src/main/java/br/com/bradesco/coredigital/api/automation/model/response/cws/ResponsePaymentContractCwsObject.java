package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponsePaymentContractCwsObject implements Serializable {

    private BigDecimal sqtdPcelaPg;

    private String smoeda;

    private BigDecimal ssdoDvdor;

    private List<SOcorrenciaResponse> socorrencias;

    @Getter
    @Setter
    public static class SOcorrenciaResponse {

        private String sdtPgto;

        private BigDecimal svlrPgto;

        private BigDecimal scodPgto;

        private BigDecimal ssitPgto;

        private BigDecimal stpoPgto;

        private BigDecimal scodPcela;

        private BigDecimal scorrecao;

        private BigDecimal sjurusRemun;

        private BigDecimal sjurusMorat;

        private BigDecimal smulta;

        private BigDecimal siofAtraso;

        private String spgtoAvulso;
    }
}
