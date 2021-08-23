package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccountListCws implements Serializable {

    private String ccpfCnpj;

    private String cflialCpfCnpj;

    private String cctrlCpfCnpj;

    private String seqTitularClie;

    private String cpssoa;

    private String codGrupoRz;

    private String codSubGpRz;

    private String cpssoaJuridContr;

    private String ctpoContrNegoc;

    private String nseqContrNegoc;

    private String scsgmtoCliCta;

    private String srsgmtoCliCta;
}