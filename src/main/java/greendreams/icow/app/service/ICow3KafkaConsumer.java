package greendreams.icow.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ICow3KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(ICow3KafkaConsumer.class);
    private static final String TOPIC = "topic_icow3";

    @KafkaListener(topics = "topic_icow3", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
