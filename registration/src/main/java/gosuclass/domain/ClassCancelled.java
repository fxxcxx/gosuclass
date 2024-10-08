package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClassCancelled extends AbstractEvent {

    private Long id;
    private Long classId;
    private String status;

    public ClassCancelled(Registration aggregate) {
        super(aggregate);
    }

    public ClassCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
