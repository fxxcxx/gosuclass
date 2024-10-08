package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClassDeleted extends AbstractEvent {

    private Long id;
    private String className;
    private String gosuName;
    private String description;
    private Integer personCount;
    private Object preExam;
    private Object afterExam;
}
