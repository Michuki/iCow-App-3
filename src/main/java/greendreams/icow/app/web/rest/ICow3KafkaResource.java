package greendreams.icow.app.web.rest;

import greendreams.icow.app.service.ICow3KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/i-cow-3-kafka")
public class ICow3KafkaResource {

    private final Logger log = LoggerFactory.getLogger(ICow3KafkaResource.class);

    private ICow3KafkaProducer kafkaProducer;

    public ICow3KafkaResource(ICow3KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
