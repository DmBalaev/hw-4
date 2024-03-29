package dm.bl.erpservice.openfeign;

import dm.bl.erpservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8093")
public interface ProductServiceClient {

    @GetMapping("auth/products/byClientId")
     ResponseEntity<List<Product>> getProductByClientId(@RequestParam UUID clientId);
}
