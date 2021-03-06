package sda.match.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import sda.match.model.Match;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Matches {

    private int count;
    private List<Match> matches = new ArrayList<>();
}
