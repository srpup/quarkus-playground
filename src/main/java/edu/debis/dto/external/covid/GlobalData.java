package edu.debis.dto.external.covid;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class GlobalData {

    @Getter
    @Setter
    @JsonbProperty(value = "NewConfirmed")
    private String newConfirmed;
    @Getter
    @Setter
    @JsonbProperty(value = "TotalConfirmed")
    private String totalConfirmed;
    @Getter
    @Setter
    @JsonbProperty(value = "NewDeaths")
    private String newDeaths;
    @Getter
    @Setter
    @JsonbProperty(value = "TotalDeaths")
    private String totalDeaths;
    @Getter
    @Setter
    @JsonbProperty(value = "NewRecovered")
    private String newRecovered;
    @Getter
    @Setter
    @JsonbProperty(value = "TotalRecovered")
    private String totalRecovered;
}
