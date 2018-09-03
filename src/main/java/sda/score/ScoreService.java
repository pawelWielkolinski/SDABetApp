package sda.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.records.UsersRecord;

import java.util.ArrayList;
import java.util.List;


@Service
public class ScoreService {

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository){
        this.scoreRepository = scoreRepository;
    }

    public List<UsersRecord> showScores(){
        return scoreRepository.getUsersScores();
    }
}
