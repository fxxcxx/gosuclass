package gosuclass.infra;

import gosuclass.config.kafka.KafkaProcessor;
import gosuclass.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class GosuPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private GosuPageRepository gosuPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenClassOpened_then_CREATE_1(
        @Payload ClassOpened classOpened
    ) {
        try {
            if (!classOpened.validate()) return;

            // view 객체 생성
            GosuPage gosuPage = new GosuPage();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            gosuPageRepository.save(gosuPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
