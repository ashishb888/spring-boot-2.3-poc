package poc.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.springboot.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
