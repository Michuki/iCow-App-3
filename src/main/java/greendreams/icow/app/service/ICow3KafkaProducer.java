package greendreams.icow.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ICow3KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(ICow3KafkaProducer.class);
    private static final String TOPIC = "topic_icow3";

    private KafkaTemplate<String, String> kafkaTemplate;

    public ICow3KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
