package dm.bl.erpservice.controller;

import dm.bl.erpservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/erp/orders")
@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrdersById(@RequestParam UUID clientId){
        return ResponseEntity.ok(orderService.getOrdersByClient(clientId));
    }

    @PostMapping
    public ResponseEntity<?> updateNameProduct(@RequestParam String name, @RequestParam Integer id){
        orderService.updateNameProduct(id, name);
        return ResponseEntity.noContent().build();
    }

}