package dm.bl.erpservice.service.impl;

import dm.bl.erpservice.dto.OrderDto;
import dm.bl.erpservice.dto.event.UpdateNameEvent;
import dm.bl.erpservice.kafka.ErpServiceProducer;
import dm.bl.erpservice.openfeign.ProductServiceClient;
import dm.bl.erpservice.openfeign.UserServiceClient;
import dm.bl.erpservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserServiceClient userServiceClient;
    private final ProductServiceClient productServiceClient;
    private final ErpServiceProducer erpServiceProducer;
    @Override
    public OrderDto getOrdersByClient(UUID clientId) {
        var userInfo = userServiceClient.getClientInfoByClientId(clientId).getBody();
        var products = productServiceClient.getProductByClientId(clientId).getBody();
        return OrderDto.builder()
                .clientId(userInfo.getClientId())
                .firstName(userInfo.getFirstName())
                .middleName(userInfo.getMiddleName())
                .lastName(userInfo.getMiddleName())
                .products(products)
                .build();
    }

    @Override
    public void updateNameProduct(Integer id, String name) {
        erpServiceProducer.sendUpdateProductStatus(new UpdateNameEvent(id, name));
    }

}
