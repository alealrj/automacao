package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ResponseEmpfContractCwsObject implements Serializable {

    private BigDecimal ccontr;

    private String widPdraoOper;

    private int cmodlRzCtbil;

    private String dfimVgciaContr;

    private String rrsumoProdtServc;

    private int csprod;

    private int ctpoSitContr;

    private BigDecimal vcontr;

    private BigDecimal vprincContr;

    private BigDecimal vbemFincd;

    private String dcelebContr;

    private String dvctoPrimPcela;

    private String dvctoContr;

    private int prazo;

    private int qpcela;

    private int qpcelaPg;

    private int cbco;

    private int cjuncDepdc;

    private int cpssoaDcfi;

    private int cseqTtlar;

    private BigDecimal ccgcCpf;

    private int cflialCgc;

    private int cctrlCpfCgc;

    private int cfamlContrMae;

    private BigDecimal ccontrMae;

    private BigDecimal ccgcCpfConv;

    private int cflialCgcConv;

    private int cctrlCpfCgcConv;

    private int cplanoPgto;

    private int cincidJuro;

    private int cincidCm;

    private int qperTempoPrinc;

    private int cundTempoPrinc;

    private int ctpoFreqPrinc;

    private int qperTempoJuro;

    private int cundTempoJuro;

    private int ctpoFreqJuro;

    private int qperTempoCm;

    private int cundTempoCm;

    private int ctpoFreqCm;

    private int cformaCalc;

    private String ccalcEquivTx;

    private int ctpoTxDcfi;

    private int cperdcApresTx;

    private int cmodldAtulz;

    private int cidtfdIndcdTaxaJuros;

    private int ctpoJuro;

    private int ctpoDiaCalcVcto;

    private BigDecimal ptxJuro;

    private BigDecimal putlzdIndcdDesc;

    private BigDecimal vpgtoAutrzTribt;

    private int cfinanIof;

    private BigDecimal vpgtoAutrzSegur;

    private int cfinanSegur;

    private BigDecimal vpgtoAutrzTarif;

    private int cfinanTxContr;

    private BigDecimal vpgtoServcTerc;

    private int cfinanServcTerc;

    private BigDecimal vpgtoRegCartr;

    private int cfinanReg;

    private BigDecimal pcustoEfetvMes;

    private BigDecimal pcustoEfetvAno;

    private int cregraMora;

    private int cutilzTxContr;

    private int cidtfdIndcdPermc;

    private int ctpoCalcPermc;

    private BigDecimal pspreadCdi;

    private BigDecimal pjuroPermcFixa;

    private int cidtfdIndcdRegraMora;

    private int cincidMulta;

    private BigDecimal ptxMulta;

    private BigDecimal pjuroMoraMes;

    private int ctribPcelaVencd;

    private BigDecimal piof;

    private int tpRegraTac;

    private BigDecimal vlTarifaTac;

    private BigDecimal pcTarifaTac;
}
