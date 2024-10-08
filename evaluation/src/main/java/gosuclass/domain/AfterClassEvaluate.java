package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AfterClassEvaluate extends AbstractEvent {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer afterScore;

    public AfterClassEvaluate(Evaluation aggregate) {
        super(aggregate);
    }

    public AfterClassEvaluate() {
        super();
    }
}
//>>> DDD / Domain Event
