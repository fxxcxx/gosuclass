package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClassRegistered extends AbstractEvent {

    private Long id;
    private Long classId;
    private String status;

    public ClassRegistered(Registration aggregate) {
        super(aggregate);
    }

    public ClassRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
