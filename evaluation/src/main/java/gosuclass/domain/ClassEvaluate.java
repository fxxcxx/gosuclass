package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClassEvaluate extends AbstractEvent {

    private Long id;

    public ClassEvaluate(Evaluation aggregate) {
        super(aggregate);
    }

    public ClassEvaluate() {
        super();
    }
}
//>>> DDD / Domain Event
