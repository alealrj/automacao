package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Contact implements Serializable {

    private List<PostalAddress> postalAddresses;

    private List<Phone> phones;

    private List<Email> emails;

}