package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AfterClassEvaluate extends AbstractEvent {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer afterScore;
}
