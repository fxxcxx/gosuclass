package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClassOpened extends AbstractEvent {

    private Long id;

    public ClassOpened(Class aggregate) {
        super(aggregate);
    }

    public ClassOpened() {
        super();
    }
}
//>>> DDD / Domain Event
