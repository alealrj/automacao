package br.com.bradesco.coredigital.api.automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PostalAddress implements Serializable {

    @JsonProperty("isMain")
    private boolean isMain;

    private String address;

    private String additionalInfo;

    private String districtName;

    private String townName;

    private String ibgeTownCode;

    private String countrySubDivision;

    private String postCode;

    private String country;

    private String countryCode;

    private GeographicCoordinatesCore geographicCoordinates;

    @Getter
    @Setter
    public static class GeographicCoordinatesCore {

        private String latitude;

        private String longitude;
    }
}
