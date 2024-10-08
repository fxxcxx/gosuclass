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
    HistoryRepository historyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AfterClassEvaluate'"
    )
    public void wheneverAfterClassEvaluate_AppendClass(
        @Payload AfterClassEvaluate afterClassEvaluate
    ) {
        AfterClassEvaluate event = afterClassEvaluate;
        System.out.println(
            "\n\n##### listener AppendClass : " + afterClassEvaluate + "\n\n"
        );

        // Sample Logic //
        History.appendClass(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
