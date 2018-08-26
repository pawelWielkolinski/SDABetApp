package getmatchinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private String utcDate;
    private String stage;
    private String group;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;
    private Score score;



}
