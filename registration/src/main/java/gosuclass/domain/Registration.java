package gosuclass.domain;

import gosuclass.RegistrationApplication;
import gosuclass.domain.ClassCancelled;
import gosuclass.domain.ClassRegistDone;
import gosuclass.domain.ClassRegistered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Registration_table")
@Data
//<<< DDD / Aggregate Root
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long classId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        gosuclass.external.Evaluation evaluation = new gosuclass.external.Evaluation();
        // mappings goes here
        RegistrationApplication.applicationContext
            .getBean(gosuclass.external.EvaluationService.class)
            .preevaluate(evaluation);

        ClassRegistered classRegistered = new ClassRegistered(this);
        classRegistered.publishAfterCommit();

        ClassCancelled classCancelled = new ClassCancelled(this);
        classCancelled.publishAfterCommit();

        ClassRegistDone classRegistDone = new ClassRegistDone(this);
        classRegistDone.publishAfterCommit();
    }

    public static RegistrationRepository repository() {
        RegistrationRepository registrationRepository = RegistrationApplication.applicationContext.getBean(
            RegistrationRepository.class
        );
        return registrationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(PreClassEvaluate preClassEvaluate) {
        //implement business logic here:

        /** Example 1:  new item 
        Registration registration = new Registration();
        repository().save(registration);

        */

        /** Example 2:  finding and process
        
        repository().findById(preClassEvaluate.get???()).ifPresent(registration->{
            
            registration // do something
            repository().save(registration);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(ClassDeleted classDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Registration registration = new Registration();
        repository().save(registration);

        */

        /** Example 2:  finding and process
        
        repository().findById(classDeleted.get???()).ifPresent(registration->{
            
            registration // do something
            repository().save(registration);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
