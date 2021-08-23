package br.com.bradesco.coredigital.api.automation.model.response.egrees.card;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LimitEgrees extends Response implements Serializable {

    private String origem;

    private String codigoRetorno;

    private String mensagem;

    private String usoLimiteUnificadoGlobal;

    private String tipoLimite;

    private String tipoLimiteConsolidado;

    private String sinalLimiteTotal;

    private long valorLimiteTotal;

    private String sinalLimiteTotalDisponivel;

    private long valorLimiteTotalDisponivel;

    private String sinalLimiteTotalUso;

    private long valorLimiteTotalUso;

    private String sinalCompraNacional;

    private long valorCompraNacional;

    private String sinalCompraNacionalDisponivel;

    private long valorCompraNacionalDisponivel;

    private String sinalCompraNacionalUso;

    private long valorCompraNacionalUso;

    private String sinalCompraExterior;

    private long valorCompraExterior;

    private String sinalCompraExteriorDisponivel;

    private long valorCompraExteriorDisponivel;

    private String sinalCompraExteriorUso;

    private long valorCompraExteriorUso;

    private String sinalSaqueNacional;

    private long valorSaqueNacional;

    private String sinalSaqueNacionalDisponivel;

    private long valorSaqueNacionalDisponivel;

    private String sinalSaqueNacionalUso;

    private long valorSaqueNacionalUso;

    private String sinalSaqueExterior;

    private long valorSaqueExterior;

    private String sinalSaqueExteriorDisponivel;

    private long valorSaqueExteriorDisponivel;

    private String sinalSaqueExteriorUso;

    private long valorSaqueExteriorUso;

    private String sinalCompraVista;

    private long valorCompraVista;

    private String sinalCompraVistaDisponivel;

    private long valorCompraVistaDisponivel;

    private String sinalCompraVistaUso;

    private long valorCompraVistaUso;

    private String sinalCompraParcelado;

    private long valorCompraParcelado;

    private String sinalCompraParceladoDisponivel;

    private long valorCompraParceladoDisponivel;

    private String sinalCompraParceladoUso;

    private long valorCompraParceladoUso;

    private String sinalSaqueParcelado;

    private long valorSaqueParcelado;

    private String sinalSaqueParceladoDisponivel;

    private long valorSaqueParceladoDisponivel;

    private String sinalSaqueParceladoUso;

    private long valorSaqueParceladoUso;
}
