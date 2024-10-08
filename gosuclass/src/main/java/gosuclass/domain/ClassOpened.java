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
    private String className;
    private String gosuName;
    private String description;
    private Integer personCount;
    private List<String> preExam;
    private List<String> afterExam;

    public ClassOpened(GosuClass aggregate) {
        super(aggregate);
    }

    public ClassOpened() {
        super();
    }
}
//>>> DDD / Domain Event
