package dm.bl.productservice.kafka;


import dm.bl.productservice.events.NewName;
import dm.bl.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {

    private static final String topicCreateOrder = "${topic.send-order}";
    private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";

    private final ProductService productService;


    @Transactional
    @KafkaListener(topics = topicCreateOrder, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=dm.bl.productservice.events.NewName"})
    public void createOrder(NewName event) {
        log.info("Message consumed {}", event);
        productService.updateName(event.getId(), event.getNewName());
    }
}
