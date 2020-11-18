package poc.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.springboot.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
