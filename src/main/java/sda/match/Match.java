package sda.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    public String getDate () {
        return utcDate.substring(0,10);
    }

    public String getTime(){
        return utcDate.substring(11,19);
    }

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
