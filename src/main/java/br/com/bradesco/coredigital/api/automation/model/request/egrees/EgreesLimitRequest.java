package br.com.bradesco.coredigital.api.automation.model.request.egrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class EgreesLimitRequest implements Serializable {

    private String origens;

    private String marca;

    private String numeroCartao;

    private String contaFaturamento;

    private String canal;

    private String usuario;
}