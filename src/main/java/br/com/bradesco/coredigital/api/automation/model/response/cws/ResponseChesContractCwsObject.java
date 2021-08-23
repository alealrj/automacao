package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseChesContractCwsObject extends Response implements Serializable {

    private BigDecimal numeroContrato;

    private String nomeProdutoBradesco;

    private String dataFimContrato;

    private String chaveIpoc;

    private int produtoBacen;

    private int subprodutoBancen;

    private String dataContratacao;

    private String dataLiberacContr;

    private BigDecimal valorLimite;

    private String moeda;

    private String dataRenovacaoLimite;

    private int periodicidadePgto;

    private BigDecimal percentCetAno;

    private int tipoAmortizacao;

    private int tipoTaxa;

    private int tipoJuros;

    private int periodicidadeTaxa;

    private int calculoCobrTaxa;

    private int tipoTaxaReferenc;

    private int subtipoTaxaReferenc;

    private BigDecimal valorTaxaPrefixada;

    private int descricaoTarifa;

    private int siglaTarifa;

    private int tipoCobrancaTarira;

    private int ocorrenciaTarifa;

    private List<ContractOperationContractFee> occursTarifas;

    private int ocorrenciaEncargos;

    private List<ContractOperationContractCharge> occursEncargos;
}
