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
        //implement business logic here:

        /** Example 1:  new item 
        History history = new History();
        repository().save(history);

        */

        /** Example 2:  finding and process
        
        repository().findById(afterClassEvaluate.get???()).ifPresent(history->{
            
            history // do something
            repository().save(history);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
