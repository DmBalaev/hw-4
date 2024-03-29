package dm.bl.erpservice.service;

import dm.bl.erpservice.dto.OrderDto;

import java.util.UUID;

public interface OrderService {

    OrderDto getOrdersByClient(UUID clientId);

    void updateNameProduct(Integer clientId, String name);
}
