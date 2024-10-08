package gosuclass.domain;

import java.util.Date;
import lombok.Data;

@Data
public class RecommendPageQuery {

    private Long id;
    private Long personId;
    private Long classId;
    private String className;
}
