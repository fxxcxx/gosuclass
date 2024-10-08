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
    GosuClassRepository gosuClassRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClassRegistDone'"
    )
    public void wheneverClassRegistDone_UpdateCount(
        @Payload ClassRegistDone classRegistDone
    ) {
        ClassRegistDone event = classRegistDone;
        System.out.println(
            "\n\n##### listener UpdateCount : " + classRegistDone + "\n\n"
        );

        // Sample Logic //
        GosuClass.updateCount(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
