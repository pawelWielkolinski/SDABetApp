package sda.match.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import sda.match.model.FullTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {
    private String winner;
    private String duration;
    private FullTime fullTime;
}
