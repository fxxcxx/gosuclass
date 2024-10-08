package gosuclass.domain;

import gosuclass.ClassApplication;
import gosuclass.domain.ClassDeleted;
import gosuclass.domain.ClassOpened;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Class_table")
@Data
//<<< DDD / Aggregate Root
public class Class {

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

    public static ClassRepository repository() {
        ClassRepository classRepository = ClassApplication.applicationContext.getBean(
            ClassRepository.class
        );
        return classRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateCount(ClassRegistDone classRegistDone) {
        //implement business logic here:

        /** Example 1:  new item 
        Class class = new Class();
        repository().save(class);

        */

        /** Example 2:  finding and process
        
        repository().findById(classRegistDone.get???()).ifPresent(class->{
            
            class // do something
            repository().save(class);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
