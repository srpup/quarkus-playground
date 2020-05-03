package edu.debis.dto.external.covid;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class CovidData {

    @Getter
    @Setter
    @JsonbProperty(value = "Global")
    private GlobalData globalData;

    @Getter
    @Setter
    @JsonbProperty(value = "Countries")
    private List<CountryData> countries;

    @Getter
    @Setter
    @JsonbProperty(value = "Date")
    private String Date;
}
