package br.com.bradesco.coredigital.api.automation.model.request.egrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EgreesChaveIdentificationRequest implements Serializable {

    private String b2k;
}