package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClassRegistDone extends AbstractEvent {

    private Long id;
    private Long classId;
    private String status;
}
