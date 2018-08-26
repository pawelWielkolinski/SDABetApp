package getmatchinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private LocalDate utcDate;
    private String stage;
    private String group;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;
    private Score score;



}
