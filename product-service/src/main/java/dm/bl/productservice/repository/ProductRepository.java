package dm.bl.productservice.repository;

import dm.bl.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getProductByClientId(UUID clientId);

    Optional<Product> findByNameProduct(String name);
}
