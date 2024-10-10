package gosuclass.domain;

import gosuclass.HistoryApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "History_table")
@Data
//<<< DDD / Aggregate Root
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long personId;

    private Long classId;

    private Integer afterScore;

    public static HistoryRepository repository() {
        HistoryRepository historyRepository = HistoryApplication.applicationContext.getBean(
            HistoryRepository.class
        );
        return historyRepository;
    }

    //<<< Clean Arch / Port Method
    public static void appendClass(AfterClassEvaluate afterClassEvaluate) {
    // afterClassEvaluate에서 classId와 personId를 가져와 History를 조회
    repository().findByClassIdAndPersonId(afterClassEvaluate.getClassId(), afterClassEvaluate.getPersonId())
        .ifPresentOrElse(history -> {
            // 이미 존재하는 History의 afterScore를 업데이트
            history.setAfterScore(afterClassEvaluate.getAfterScore());
            // 변경된 History 정보를 저장
            repository().save(history);
        }, () -> {
            // History 엔티티가 없을 경우 새로 생성
            History newHistory = new History();
            newHistory.setClassId(afterClassEvaluate.getClassId());
            newHistory.setPersonId(afterClassEvaluate.getPersonId());
            newHistory.setAfterScore(afterClassEvaluate.getAfterScore());

            // 새롭게 생성된 History 정보를 저장
            repository().save(newHistory);
        });
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
