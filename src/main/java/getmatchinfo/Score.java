package getmatchinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {
    private String winner;
    private String duration;
    private FullTime fullTime;
}
