package gosuclass.domain;

import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AfterClassEvaluate extends AbstractEvent {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer afterScore;
}
