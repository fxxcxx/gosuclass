package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Recommended extends AbstractEvent {

    private Long id;

    public Recommended(Recommend aggregate) {
        super(aggregate);
    }

    public Recommended() {
        super();
    }
}
//>>> DDD / Domain Event
