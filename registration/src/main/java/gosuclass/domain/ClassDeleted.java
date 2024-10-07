package gosuclass.domain;

import gosuclass.domain.*;
import gosuclass.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClassDeleted extends AbstractEvent {

    private Long id;
}
