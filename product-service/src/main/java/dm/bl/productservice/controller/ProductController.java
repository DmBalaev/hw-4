package dm.bl.productservice.controller;

import dm.bl.productservice.entity.Product;
import dm.bl.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("auth/products/")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/byClientId")
    public ResponseEntity<List<Product>> getProductByClientId(@RequestParam UUID clientId){
        return ResponseEntity.ok(productService.getProductByClientId(clientId));
    }
}
