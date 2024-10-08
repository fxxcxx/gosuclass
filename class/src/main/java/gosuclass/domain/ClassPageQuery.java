package gosuclass.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ClassPageQuery {

    private Long id;
    private String className;
    private Long classId;
    private String gosuName;
    private String description;
    private String personCount;
}
