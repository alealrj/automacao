package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OverParcel implements Serializable {

    private List<OverParcelFee> fees;

    private List<OverParcelCharge> charges;
}
