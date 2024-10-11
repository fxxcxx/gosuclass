![로컬 이미지](https://github.com/user-attachments/assets/9f12f80a-fe6d-4328-8891-90f8f4394a9f)

# 고수의클래스 전용 지니어스

## Table of Contents

- [서비스 시나리오](#서비스시나리오)
- [분석/설계](#분석/설계)
- [구현](#구현)
- [운영](#운영)

# 서비스 시나리오

KT 교육플랫폼 지니어스에서 "고수의 클래스" 부분 커버하기

**기능적요구사항**

1. 강사가 강의를 개설한다.
2. 강사가 강의개설을 취소한다.
3. 강사가 강의개설을 취소하면 수강자들도 신청이 취소된다.
4. 수강자가 특정 강의를 신청한다.
5. 수강자가 강의를 신청하면 사전평가를 응시한다.
6. 수강자가 특정 강의 신청을 취소한다.
7. 수강자가 신청한 강의를 조회한다.
8. 강사가 수강자 수를 조회한다.
9. 강사가 수강자의 사전평가 결과를 조회한다.
10. 수강자가 사후평가를 응시한다.
11. 수강자가 사후평가에 응시하면 수강이력에 기록된다.

**비기능적 요구사항**

1. 트랜잭션: 사전평가나 신청이 완료되지 않은 경우 강의 신청이 성립되지 않아야 한다.
2. 장애 격리: 강의 개설 기능이 중단되더라도 수강 신청은 항상 가능해야 한다.
3. 성능 요구사항: 강사가 관리하는 정보를 수강자가 실시간으로 확인할 수 있어야 한다.

# 분석/설계

## Event Storming 결과

- MSAEz 로 모델링한 이벤트스토밍 결과: https://www.msaez.io/#/storming/gosuclass

### 요구사항 도출에 따른 1차 모형 초안

![image](https://github.com/user-attachments/assets/89db8af5-1b2d-4bf8-b255-3de9744d5b07)

### 1차 모형 초안에 대한 기능적/비기능적 요구사항을 커버하는지 검증

    - 강사가 강의를 개설한다. (오케이)
    - 강사가 강의개설을 취소한다. (오케이)
    - 강사가 강의개설을 취소하면 수강자들도 신청이 취소된다. (오케이)
    - 수강자가 특정 강의를 신청한다. (오케이)
    - 수강자가 강의를 신청하면 사전평가를 응시한다. (오케이)
    -수강자가 특정 강의 신청을 취소한다. (오케이)
    - 수강자가 신청한 강의를 조회한다.
    - 강사가 수강자 수를 조회한다. (view)
    - 강사가 수강자의 사전평가 결과를 조회한다.
    - 수강자가 사후평가를 응시한다.
    - 수강자가 사후평가에 응시하면 수강이력에 기록된다.
    - 수강자는 자신의 강의 수강내역에 따른 추천 강의를 조회한다.

### 1차 모형 초안에서 요구사항을 커버하도록 모델링 수정

![image](https://github.com/user-attachments/assets/7d627088-207b-4dfd-b365-74bef0022ba2)

    - 강사가 강의를 개설한다. (오케이)
    - 강사가 강의개설을 취소한다. (오케이)
    - 강사가 강의개설을 취소하면 수강자들도 신청이 취소된다. (오케이)
    - 수강자가 특정 강의를 신청한다. (오케이)
    - 수강자가 강의를 신청하면 사전평가를 응시한다. (오케이)
    - 수강자가 특정 강의 신청을 취소한다. (오케이)
    - 수강자가 신청한 강의를 조회한다. (view)
    - 강사가 수강자 수를 조회한다. (view)
    - 강사가 수강자의 사전평가 결과를 조회한다. (view)
    - 수강자가 사후평가를 응시한다. (오케이)
    - 수강자가 사후평가에 응시하면 수강이력에 기록된다. (오케이)
    - 수강자는 자신의 강의 수강내역에 따른 추천 강의를 조회한다. (view)

### 1차 모형 초안에서 추가요구사항을 더한 2차 모델링

![image](https://github.com/user-attachments/assets/42560e86-56a5-417d-a94d-592f2b200ea9)

    - 강사가 강의를 개설한다. (오케이)
    - 강사가 강의개설을 취소한다. (오케이)
    - 강사가 강의개설을 취소하면 수강자들도 신청이 취소된다. (오케이)
    - 수강자가 특정 강의를 신청한다. (오케이)
    - 수강자가 강의를 신청하면 사전평가를 응시한다. (오케이)
    - 신청 후 일정 시간동안 사전평가를 응시하지 않으면 자동으로 강의 상태가 취소로 변경된다.(오케이)
    - 수강자가 특정 강의 신청을 취소한다. (오케이)
    - 수강자가 신청한 강의를 조회한다. (view)
    - 강사가 수강자 수를 조회한다. (view)
    - 강사가 수강자의 사전평가 결과를 조회한다. (view)
    - 수강자가 사후평가를 응시한다. (오케이)
    - 수강자가 사후평가에 응시하면 수강이력에 기록된다. (오케이)
    - 수강자는 자신의 강의 수강내역에 따른 추천 강의를 조회한다. (view)

# 구현

분석/설계 단계에서 도출된 아키텍처에 따라, 각 BC별로 대변되는 마이크로 서비스들을 스프링부트로 구현하였다. 구현한 각 서비스를 로컬에서 실행하는 방법은 아래와 같다 (각자의 포트넘버는 8081 ~ 808n 이다)

```
cd gosuclass
mvn spring-boot:run

cd registration
mvn spring-boot:run

cd evaluation
mvn spring-boot:run

cd history
mvn spring-boot:run

cd recommend
mvn spring-boot:run
```

## DDD 의 적용

- 각 서비스내에 도출된 핵심 Aggregate Root 객체를 Entity 로 선언하였다. 이때 가능한 현업에서 사용하는 언어 (유비쿼터스 랭귀지)를 그대로 사용하였다.

```
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

}
```

- Entity Pattern 과 Repository Pattern 을 적용하여 JPA 를 통하여 다양한 데이터소스 유형 (RDB) 에 대한 별도의 처리가 없도록 데이터 접근 어댑터를 자동 생성하기 위하여 Spring Data REST 의 RestRepository 를 적용하였다

```
package gosuclass.domain;

import gosuclass.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "gosuClasses",
    path = "gosuClasses"
)
public interface GosuClassRepository
    extends PagingAndSortingRepository<GosuClass, Long> {
    @Query(
        value = "select gosuClass " +
        "from GosuClass gosuClass " +
        "where(:id is null or gosuClass.id = :id) and (:className is null or gosuClass.className like %:className%) and (:gosuName is null or gosuClass.gosuName like %:gosuName%) and (:description is null or gosuClass.description like %:description%) and (:personCount is null or gosuClass.personCount = :personCount)"
    )
    GosuClass findByClassPage(
        Long id,
        String className,
        String gosuName,
        String description,
        Integer personCount
    );
}

```

- 적용 후 REST API 의 테스트

```
# gosuClass 서비스의 강의등록 처리
 http POST localhost:8083/gosuClasses className="test"
```

![image](https://github.com/user-attachments/assets/cf2be451-9fe3-4ce7-a2e8-c0e74dbc43cb)

## 비동기식 호출 / 장애격리 / CQRS

우리 모델에서 비동기식 호출 및 장애격리를 처리한 방식은 Pub/Sub 메시징 패턴과 이벤트 기반 비즈니스 로직을 활용하여 시스템의 유연성을 극대화하고, 개별 서비스 간의 의존성을 줄이는 데 중점을 두었음 <br>
이를 통해 하나의 서비스가 장애를 겪더라도 전체 시스템이 영향을 받지 않도록 설계

### 1. 비동기식 호출(Asynchronous Communication)

- Pub/Sub 메시징 패턴

  • 여러 도메인 이벤트들이 발생하면, 이를 다른 서비스들이 비동기적으로 구독하고 처리할 수 있음. <br> 예를 들어, Registration에서 발생한 ClassRegistDone 이벤트는 GosuClass에서 수강자 수를 업데이트하는 updateCount 정책과 연결

  • 이 흐름은 Pub/Sub 방식으로 이루어지며, 이벤트가 발생할 때마다 관련 서비스가 해당 이벤트를 비동기적으로 수신하고 처리할 수 있음. <br> 이를 통해 서비스 간의 강한 결합을 피하고, 메시지가 비동기적으로 전달되므로 각 서비스가 독립적으로 운영 가능

- 이벤트 발행과 처리

  • Registration에서의 ClassRegistered, ClassCancelled, ClassRegistDone 등의 이벤트가 발생한 후, 각 이벤트는 다른 서비스에 의해 비동기적으로 처리됨. <br> 예를 들어, ClassRegistDone 이벤트는 GosuClass 서비스로 전달되어, 수강자의 수를 증가시키는 updateCount 로직이 비동기적으로 실행

  • 평가가 완료되면 Evaluation에서 AfterClassEvaluate 이벤트가 발행되고, 이를 History 서비스가 구독하여 수강 이력을 비동기적으로 추가

### 2. 장애격리 (Fault Isolation)

- 이벤트 기반의 느슨한 결합

  • 각 서비스는 이벤트를 통해 연결되어 있으며, 동기식 호출 없이 이벤트 발행 후 다른 서비스의 응답을 기다리지 않음. <br> 예를 들어, Registration 서비스에서 수강 신청이 완료된 후, ClassRegistDone 이벤트가 GosuClass 서비스로 전달될 때 두 서비스 간의 의존성이 없으므로, GosuClass 서비스가 일시적으로 장애를 겪더라도 Registration 서비스는 정상적으로 작동 <br> 이로 인해 각 서비스는 독립적으로 유지보수가 가능하고, 장애가 다른 서비스로 전파되지 않음

- 타이머를 활용한 장애격리 모델링

  • 타이머 정책(startTimer, timerEnded)이 사용되어, 평가가 시간 내에 완료되지 않았을 때 자동으로 수강 신청을 취소하는 로직 모델링 <br> Timer 서비스가 독립적으로 작동하여, 사용자가 응답하지 않거나 시스템 장애가 있을 때도 자동으로 처리가 진행되며, 타이머가 종료되면 등록된 수강 신청을 자동으로 취소하는 timerEnded 이벤트 발생을 시나리오로 작성

### 3. CQRS (Command Query Responsibility Segregation) 및 이벤트 모델링

- Read Model과 Eventual Consistency

  • 각 서비스는 독립적으로 데이터를 관리하며, 특정 서비스에서 변경된 사항은 이벤트를 통해 다른 서비스의 Read Model에 반영됨. <br> 예를 들어, GosuClass 서비스에서 수강 인원 변경 시, ClassPage Read Model이 업데이트

# 운영

## CI/CD 설정

프로젝트의 운영은 확장성, 안정성, 그리고 자동화를 최우선으로 설계<br>최신 컨테이너 기술과 클라우드 인프라를 활용하여 원활한 배포, 오케스트레이션, 그리고 서비스 관리를 보장

- Docker를 통한 컨테이너화 및 Docker Hub로 이미지 관리
  ![image](https://github.com/user-attachments/assets/d084114d-3b9d-49b3-99f8-2fd34a86648d)

- 아래와 같이 pod 가 정상적으로 올라간 것을 확인하였다.
  ![image](https://github.com/user-attachments/assets/8ad16311-6453-4304-8c1d-a23166aa98da)

- 아래와 같이 쿠버네티스에 모두 서비스로 등록된 것을 확인할 수 있다.
  ![image](https://github.com/user-attachments/assets/01f57260-de9f-4340-ba43-5d2f57f83be8)
  ![image](https://github.com/user-attachments/assets/01a36ba0-f0d4-42f9-b616-bcc2e567cd4b)
