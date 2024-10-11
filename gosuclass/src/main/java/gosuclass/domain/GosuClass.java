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

     
    }

    @PostRemove
    public void onPostRemove() {
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
// 1. classId를 사용하여 해당 GosuClass 조회
    repository().findById(classRegistDone.getClassId()).ifPresent(gosuClass -> {
        
        // 2. personCount를 1 증가
        gosuClass.setPersonCount(gosuClass.getPersonCount() + 1);
        
        // 3. 변경된 GosuClass 엔티티를 저장
        repository().save(gosuClass);
    });

    }

    public static void updateCountMinus(ClassCancelled classCancelled) {
        // 1. classId를 사용하여 해당 GosuClass 조회
            repository().findById(classCancelled.getClassId()).ifPresent(gosuClass -> {
                
                // 2. personCount를 1 감소
                gosuClass.setPersonCount(gosuClass.getPersonCount() - 1);
                
                // 3. 변경된 GosuClass 엔티티를 저장
                repository().save(gosuClass);
            });
        
            }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
