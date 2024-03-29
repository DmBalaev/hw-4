package dm.bl.productservice.service.impl;

import dm.bl.productservice.entity.Product;
import dm.bl.productservice.repository.ProductRepository;
import dm.bl.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductByClientId(UUID clientId) {
        return productRepository.getProductByClientId(clientId);
    }

    @Override
    public Product updateName(Integer id, String name) {
        var product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found"));

        product.setNameProduct(name);
        return productRepository.save(product);
    }
}
