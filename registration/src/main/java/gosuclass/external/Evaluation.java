package gosuclass.external;

import java.util.Date;
import lombok.Data;

@Data
public class Evaluation {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer preScore;
    private Integer afterScore;
}
