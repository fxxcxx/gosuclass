package gosuclass.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import gosuclass.config.kafka.KafkaProcessor;
import gosuclass.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RegistrationRepository registrationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PreClassEvaluate'"
    )
    public void wheneverPreClassEvaluate_UpdateStatus(
        @Payload PreClassEvaluate preClassEvaluate
    ) {
        PreClassEvaluate event = preClassEvaluate;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + preClassEvaluate + "\n\n"
        );

        // Sample Logic //
        Registration.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClassDeleted'"
    )
    public void wheneverClassDeleted_UpdateStatus(
        @Payload ClassDeleted classDeleted
    ) {
        ClassDeleted event = classDeleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + classDeleted + "\n\n"
        );

        // Sample Logic //
        Registration.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
