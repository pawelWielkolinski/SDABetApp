package sda.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.records.BetsRecord;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class BetService {

    public void saveBet(BetForm betInfo) {

        BetRepository betRepository = new BetRepository();
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
}
