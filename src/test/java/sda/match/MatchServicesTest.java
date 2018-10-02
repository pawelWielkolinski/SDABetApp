package sda.match;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sda.db.data.DatabaseAccess;
import sda.db.data.generated.tables.records.MatchesRecord;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MatchServicesTest extends DatabaseAccess {

    private static final MatchesRecord VISIBLE_DATE_MATCH = new MatchesRecord();
    private static final MatchesRecord VISIBLE_TIME_MATCH = new MatchesRecord();
    private static final MatchesRecord NOT_VISIBLE_DATE_MATCH = new MatchesRecord();
    private static final MatchesRecord NOT_VISIBLE_TIME_MATCH = new MatchesRecord();
    private static final String DATE_FROM = LocalDate.now().minusDays(4).toString();
    private static final String DATE_TO = LocalDate.now().plusDays(4).toString();


    static {


        VISIBLE_DATE_MATCH.setAwayTeam("AwayTeam1");
        VISIBLE_DATE_MATCH.setAwayTeamGoals(1);
        VISIBLE_DATE_MATCH.setHomeTeam("HomeTeam1");
        VISIBLE_DATE_MATCH.setAwayTeamGoals(0);
        VISIBLE_DATE_MATCH.setIdMatch(1);
        VISIBLE_DATE_MATCH.setStartDate(Date.valueOf(LocalDate.now().plusDays(2)));
        VISIBLE_DATE_MATCH.setStartTime(Time.valueOf(LocalTime.now().plusHours(2)));

        VISIBLE_TIME_MATCH.setAwayTeam("AwayTeam2");
        VISIBLE_TIME_MATCH.setAwayTeamGoals(1);
        VISIBLE_TIME_MATCH.setHomeTeam("HomeTeam2");
        VISIBLE_TIME_MATCH.setAwayTeamGoals(0);
        VISIBLE_TIME_MATCH.setIdMatch(2);
        VISIBLE_TIME_MATCH.setStartDate(Date.valueOf(LocalDate.now()));
        VISIBLE_TIME_MATCH.setStartTime(Time.valueOf(LocalTime.now().plusHours(2)));

        NOT_VISIBLE_DATE_MATCH.setAwayTeam("AwayTeam3");
        NOT_VISIBLE_DATE_MATCH.setAwayTeamGoals(1);
        NOT_VISIBLE_DATE_MATCH.setHomeTeam("HomeTeam3");
        NOT_VISIBLE_DATE_MATCH.setAwayTeamGoals(0);
        NOT_VISIBLE_DATE_MATCH.setIdMatch(3);
        NOT_VISIBLE_DATE_MATCH.setStartDate(Date.valueOf(LocalDate.now().minusDays(2)));
        NOT_VISIBLE_DATE_MATCH.setStartTime(Time.valueOf(LocalTime.now().minusHours(2)));

        NOT_VISIBLE_TIME_MATCH.setAwayTeam("AwayTeam4");
        NOT_VISIBLE_TIME_MATCH.setAwayTeamGoals(1);
        NOT_VISIBLE_TIME_MATCH.setHomeTeam("HomeTeam4");
        NOT_VISIBLE_TIME_MATCH.setAwayTeamGoals(0);
        NOT_VISIBLE_TIME_MATCH.setIdMatch(4);
        NOT_VISIBLE_TIME_MATCH.setStartDate(Date.valueOf(LocalDate.now()));
        NOT_VISIBLE_TIME_MATCH.setStartTime(Time.valueOf(LocalTime.now().minusHours(2)));
    }

    @Mock
    private MatchRepository matchRepository;
    private MatchServices matchServices;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        matchServices = new MatchServices(matchRepository);
    }

    @Test
    public void shouldShowMatchesThatTakePlaceFromDateToDate() throws IOException {


//        when(matchRepository.getByDate(DATE_FROM, DATE_TO)).thenReturn();
//TODO return jooq Result with matches records (error while trying to return ArrayList) or mock Table, idk how

        List<MatchesRecord> matchesFromService = matchServices.show(DATE_FROM, DATE_TO);

        assertEquals(4, matchesFromService.size());

    }

    @Test
    public void shouldGetTrueForVisibleMatchesAndFalseForNotVisibleOnes(){
        List<MatchesRecord> matchesRecords = new ArrayList<>();
        matchesRecords.add(VISIBLE_DATE_MATCH);
        matchesRecords.add(VISIBLE_TIME_MATCH);
        matchesRecords.add(NOT_VISIBLE_DATE_MATCH);
        matchesRecords.add(NOT_VISIBLE_TIME_MATCH);

        Map<Integer, Boolean> visibleMatches = matchServices.getVisibleMatches(matchesRecords);

        assertEquals(true,visibleMatches.get(1));
        assertEquals(true,visibleMatches.get(2));
        assertEquals(false,visibleMatches.get(3));
        assertEquals(false,visibleMatches.get(4));
    }
}