package br.com.bradesco.coredigital.api.automation.model.request.egrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class EgreesIdentificationRequest implements Serializable {

    private List<String> origens;

    private String marca;

    private String numeroCartao;

    private String contaFaturamento;

    private String companyId;

    private String agenciaConta;

    private String canal;

    private String usuario;

    private EgreesChaveIdentificationRequest chavesRestart;
}