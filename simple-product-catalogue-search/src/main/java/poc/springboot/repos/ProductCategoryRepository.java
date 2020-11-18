package poc.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import poc.springboot.domain.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

}
