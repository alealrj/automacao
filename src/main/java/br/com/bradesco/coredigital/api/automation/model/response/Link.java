package br.com.bradesco.coredigital.api.automation.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Link implements Serializable {

    private String self;

    private String first;

    private String prev;

    private String next;

    private String last;
}
