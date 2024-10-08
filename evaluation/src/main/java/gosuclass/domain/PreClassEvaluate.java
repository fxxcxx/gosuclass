package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PreClassEvaluate extends AbstractEvent {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer preScore;

    public PreClassEvaluate(Evaluation aggregate) {
        super(aggregate);
    }

    public PreClassEvaluate() {
        super();
    }
}
//>>> DDD / Domain Event
