package gosuclass.domain;

import gosuclass.GosuclassApplication;
import gosuclass.domain.ClassDeleted;
import gosuclass.domain.ClassOpened;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GosuClass_table")
@Data
//<<< DDD / Aggregate Root
public class GosuClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String className;

    private String gosuName;

    private String description;

    private Integer personCount;

    @ElementCollection
    private List<String> preExam;

    @ElementCollection
    private List<String> afterExam;

    @PostPersist
    public void onPostPersist() {
        ClassOpened classOpened = new ClassOpened(this);
        classOpened.publishAfterCommit();

        ClassDeleted classDeleted = new ClassDeleted(this);
        classDeleted.publishAfterCommit();
    }

    public static GosuClassRepository repository() {
        GosuClassRepository gosuClassRepository = GosuclassApplication.applicationContext.getBean(
            GosuClassRepository.class
        );
        return gosuClassRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateCount(ClassRegistDone classRegistDone) {
        //implement business logic here:

        /** Example 1:  new item 
        GosuClass gosuClass = new GosuClass();
        repository().save(gosuClass);

        */

        /** Example 2:  finding and process
        
        repository().findById(classRegistDone.get???()).ifPresent(gosuClass->{
            
            gosuClass // do something
            repository().save(gosuClass);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
