package gosuclass.domain;

import gosuclass.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ClassOpened extends AbstractEvent {

    private Long id;
}
