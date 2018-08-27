package getmatchinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private Integer id;
    private String utcDate;
    private String stage;
    private String group;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;
    private Score score;

    @Override
    public String toString() {
        return "UEFA Champions League \n"+
                "Stage: "+stage+ "\n"+
                "Group: "+group+ "\n"+
                "Date of match: "+utcDate+ "\n"+
                "Home Team - "+homeTeam.getName()+", goals: "+score.getFullTime().getHomeTeam()+ "\n"+
                "Away Team - "+awayTeam.getName()+", goals: "+score.getFullTime().getAwayTeam()+ "\n"+
                "WINNER: "+score.getWinner()+ "\n"+"\n";
    }
}
