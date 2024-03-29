package dm.bl.productservice.service;

import dm.bl.productservice.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> getProductByClientId(UUID clientId);

    Product updateName(Integer id, String name);
}
