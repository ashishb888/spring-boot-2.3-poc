package poc.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import poc.springboot.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
