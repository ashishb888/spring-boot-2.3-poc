package poc.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import poc.springboot.domain.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {

}
