package br.com.bradesco.coredigital.api.automation.model.request.egrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EgreesTransactionRequest implements Serializable {

    private String origens;

    private String marca;

    private String numeroCartao;

    private String contaFaturamento;

    private String dataVencimento;

    private String canal;

    private String usuario;

    private String chaveRestart;
}