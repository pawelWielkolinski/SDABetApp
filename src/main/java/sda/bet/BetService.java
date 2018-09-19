package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.match.MatchRepository;
import sda.match.MatchServices;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchServices matchServices;

    public void givePoints() {
        List<MatchesRecord> matchesWithPresentScore = matchRepository.getByPresentScore();
        for (MatchesRecord matchWitchScore : matchesWithPresentScore) {

            List<BetsRecord> betsWithoutPoints = betRepository.getBetsByMatchId(matchWitchScore.getIdMatch());
            for (BetsRecord betToGivePoints : betsWithoutPoints) {
                givePointsToBets(matchWitchScore, betToGivePoints);

                betRepository.insert(betToGivePoints);

            }

        }
    }

    public void givePointsToBets(MatchesRecord matchWitchScore, BetsRecord betToGivePoints) {
        Integer homeTeamGoals = matchWitchScore.getHomeTeamGoals();
        Integer homeTeamBet = betToGivePoints.getHomeTeamBet();
        Integer awayTeamGoals = matchWitchScore.getAwayTeamGoals();
        Integer awayTeamBet = betToGivePoints.getAwayTeamBet();

        boolean fivePoints = homeTeamGoals.compareTo(homeTeamBet)==0 &&
                awayTeamGoals.compareTo(awayTeamBet)==0;

        if(fivePoints) {
            betToGivePoints.setPoints(5);
        }

        boolean twoPoints = homeTeamGoals > awayTeamGoals && homeTeamBet > awayTeamBet
                || homeTeamGoals < awayTeamGoals && homeTeamBet < awayTeamBet
                || homeTeamGoals.compareTo(awayTeamGoals)==0 && homeTeamBet.compareTo(awayTeamBet)==0;

        if(twoPoints && !fivePoints) {
            betToGivePoints.setPoints(2);
        }
    }

    public void saveBet(BetForm betInfo) {

        BetsRecord betsRecord = new BetsRecord();

        if(betRepository.getBetByMatchIdAndUserId(betInfo.getMatchId(),betInfo.getUserId())==null) {

            betsRecord.setHomeTeamBet(betInfo.getHomeTeamScore());
            betsRecord.setAwayTeamBet(betInfo.getAwayTeamScore());
            betsRecord.setIdMatch(betInfo.getMatchId());
            betsRecord.setIdUser(betInfo.getUserId());
            betsRecord.setCreateDate(Date.valueOf(LocalDate.now()));

        }else{
            betsRecord = betRepository.getBetByMatchIdAndUserId(betInfo.getMatchId(),betInfo.getUserId());
            betsRecord.setCreateDate(Date.valueOf(LocalDate.now()));
            betsRecord.setHomeTeamBet(betInfo.getHomeTeamScore());
            betsRecord.setAwayTeamBet(betInfo.getAwayTeamScore());
        }

        betRepository.storeBet(betsRecord);

    }

    public List<BetsRecord> getUserBetsToShowInScore(Integer idUser) {

        List<BetsRecord> userBetsWithPoints = betRepository.getBetsByUserId(idUser);

        return userBetsWithPoints.stream()
                .filter(betsRecord -> !matchServices.isVisible(matchRepository.getById(betsRecord.getIdMatch())))
                .collect(Collectors.toList());
    }
}
