package gosuclass.domain;

import gosuclass.EvaluationApplication;
import gosuclass.domain.ClassEvaluate;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Evaluation_table")
@Data
//<<< DDD / Aggregate Root
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer classId;

    private Integer personId;

    private Integer score;

    @PostPersist
    public void onPostPersist() {
        ClassEvaluate classEvaluate = new ClassEvaluate(this);
        classEvaluate.publishAfterCommit();
    }

    public static EvaluationRepository repository() {
        EvaluationRepository evaluationRepository = EvaluationApplication.applicationContext.getBean(
            EvaluationRepository.class
        );
        return evaluationRepository;
    }
}
//>>> DDD / Aggregate Root
