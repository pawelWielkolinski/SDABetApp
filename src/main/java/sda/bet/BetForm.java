package sda.bet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetForm {

    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private String homeTeamName;
    private String awayTeamName;
    private Integer userId;
    private Integer matchId;
}
