package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CwsAdposRequest implements Serializable {

    private String agency;

    private String account;

    private String groupAccount;

    private String subGroupAccount;

    private String startDate;

    private String endDate;
}