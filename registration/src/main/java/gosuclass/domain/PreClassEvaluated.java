package gosuclass.domain;

import gosuclass.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PreClassEvaluated extends AbstractEvent {

    private Long id;
    private Integer classId;
    private Integer personId;
    private Integer preScore;

    // 기본 생성자
    public PreClassEvaluated() {}

    // PreClassEvaluate로부터 데이터를 받아서 초기화하는 생성자
    public PreClassEvaluated(PreClassEvaluated preClassEvaluate) {
        this.id = preClassEvaluate.getId();
        this.classId = preClassEvaluate.getClassId();
        this.personId = preClassEvaluate.getPersonId();
        this.preScore = preClassEvaluate.getPreScore();
    }

    // 이벤트 발행 메서드 (이 메서드를 통해 Kafka 등 메시지 브로커에 이벤트를 발행)
    public void publishAfterCommit() {
        // 메시지 브로커에 이벤트 발행하는 로직 구현
        // 예: Kafka, RabbitMQ 등의 이벤트 발행 메커니즘
        System.out.println("PreClassEvaluated event published: " + this.toString());
    }
}