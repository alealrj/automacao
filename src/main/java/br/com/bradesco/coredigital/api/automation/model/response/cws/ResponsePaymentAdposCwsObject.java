package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponsePaymentAdposCwsObject  implements Serializable {

    private BigDecimal ncontrAdepos;

    private BigDecimal npgtoAdepos;

    private String dpgtoAdepos;

    private BigDecimal saldoDev;

    private BigDecimal qtdeParcPgto;

    private String descTarifa;

    private String siglaTarifa;

    private BigDecimal ctpoEncargo;

    private String infoAdic;

    private BigDecimal qtdePagamentos;

    private List<OcorrPgto> ocorrPgto;

    @Getter
    @Setter
    public static class OcorrPgto {

        private String pgtoPacto;

        private String dataPgto;

        private BigDecimal valorPgto;

        private BigDecimal qtdeTarifas;

        private List<OcorrTarifa> ocorrTarifa;

        private BigDecimal qtdeEncargos;

        private List<OcorrEncargo> ocorrEncargo;
    }

    @Getter
    @Setter
    public static class OcorrTarifa {

        private BigDecimal valorPgtoTarif;
    }

    @Getter
    @Setter
    public static class OcorrEncargo {

        private BigDecimal valorPgtoEnc;
    }
}
