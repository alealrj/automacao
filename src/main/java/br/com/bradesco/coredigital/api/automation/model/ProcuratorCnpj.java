package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProcuratorCnpj implements Serializable {

    private String type;

    private String cnpjCpfNumber;

    private String civilName;

    private String socialName;
}
