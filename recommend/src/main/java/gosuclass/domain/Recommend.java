package gosuclass.domain;

import gosuclass.RecommendApplication;
import gosuclass.domain.Recommended;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Recommend_table")
@Data
//<<< DDD / Aggregate Root
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long personId;

    private Long classId;

    private String className;

    @PostPersist
    public void onPostPersist() {
        Recommended recommended = new Recommended(this);
        recommended.publishAfterCommit();
    }

    public static RecommendRepository repository() {
        RecommendRepository recommendRepository = RecommendApplication.applicationContext.getBean(
            RecommendRepository.class
        );
        return recommendRepository;
    }
}
//>>> DDD / Aggregate Root
