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
public static void updateStatus(PreClassEvaluated preClassEvaluate) {
    // preClassEvaluate에서 classId를 가져와 해당 클래스에 대한 Registration을 찾음
    repository().findById(Long.valueOf(preClassEvaluate.getClassId())).ifPresent(registration -> {
        
        // 평가 상태를 업데이트하는 로직 (예: status를 "preEvaluated"로 변경)
        registration.setStatus("preEvaluated");
        
        // 변경된 등록 정보를 저장
        repository().save(registration);
        
        preClassEvaluate.publishAfterCommit();
    });
}

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(ClassDeleted classDeleted) {
 // classDeleted에서 classId를 가져와 관련된 Registration을 찾음
    repository().findById(classDeleted.getId()).ifPresent(registration -> {
        
        // 등록 상태를 "deleted"로 변경
        registration.setStatus("삭제됨");
        
        // 변경된 등록 정보를 저장
        repository().save(registration);

        // 필요시 이벤트를 발행할 수 있음 (예: ClassRegistrationDeleted 이벤트 발행)
        classDeleted.publishAfterCommit();  
    });
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
