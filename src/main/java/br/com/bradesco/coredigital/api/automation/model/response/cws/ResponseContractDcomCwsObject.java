package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseContractDcomCwsObject extends Response implements Serializable {

    private List<ListaEncargos> listaEncargos;

    private BigDecimal soperacao;

    private String swidPdraoOper;

    private String sdexparaMod;

    private BigDecimal scmodldRzCtbil;

    private String sdtOperacao;

    private String sdtInicOper;

    private String sdtQuitacao;

    private String svlOperacao;

    private String stpMoeda;

    private String sdtFnalOper;

    private String speriodicidade;

    private String sdtVctoInicial;

    private BigDecimal svlCet;

    private String stpAmortizacao;

    private String stpTaxa;

    private String stpRate;

    private String srateFreq;

    private BigDecimal stpCalc;

    private String stpIndex;

    private String sstpIndex;

    private String sindexInfo;

    private BigDecimal svlPreRate;

    private BigDecimal svlPosRate;

    private String sinfo;

    private String snmTarifa;

    private String scdTarifa;

    private String stpTarifa;

    private String sregraTarifa;

    private BigDecimal svlTarifa;

    private BigDecimal svlTarifaPerc;

    @Getter
    @Setter
    public static class ListaEncargos {

        private String stpEncargo;

        private String sinfoAdicional;

        private BigDecimal svlEngargo;
    }

}
