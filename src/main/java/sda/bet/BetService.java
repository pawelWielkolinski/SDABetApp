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

        betsRecord.setHomeTeamBet(betInfo.getHomeTeamScore());
        betsRecord.setAwayTeamBet(betInfo.getAwayTeamScore());
        betsRecord.setIdMatch(betInfo.getMatchId());
        betsRecord.setIdUser(betInfo.getUserId());
        betsRecord.setCreateDate(Date.valueOf(LocalDate.now()));

        betRepository.storeBet(betsRecord);

    }
}
