package dm.bl.erpservice.kafka;

import dm.bl.erpservice.dto.event.UpdateNameEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ErpServiceProducer {

    @Value("${topic.send-order}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUpdateProductStatus(UpdateNameEvent event){
        log.info("ERP-producer: send message with new product status");
        kafkaTemplate.send(sendClientTopic, event);
    }
}
