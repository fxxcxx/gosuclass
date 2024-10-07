package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClassDeleted extends AbstractEvent {

    private Long id;

    public ClassDeleted(Class aggregate) {
        super(aggregate);
    }

    public ClassDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
