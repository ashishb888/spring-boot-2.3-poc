package poc.springboot;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Brand;
import poc.springboot.domain.Product;
import poc.springboot.domain.ProductCategory;
import poc.springboot.repos.BrandRepository;
import poc.springboot.repos.ProductCategoryRepository;
import poc.springboot.repos.ProductRepository;

@Slf4j
@SpringBootApplication
public class SimpleProductCatalogueSearchApplication {

	@Autowired
	private BrandRepository br;
	@Autowired
	private ProductRepository pr;
	@Autowired
	private ProductCategoryRepository pcr;

	public static void main(String[] args) {
		SpringApplication.run(SimpleProductCatalogueSearchApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			Set<Product> products1 = IntStream.range(1, 11).boxed().map(i -> new Product(i, "p" + i, 10 + i))
					.collect(Collectors.toSet());

			br.save(new Brand("ABC", products1));
			pcr.save(new ProductCategory("Garments", products1));

			Set<Product> products2 = IntStream.range(101, 111).boxed().map(i -> new Product(i, "p" + i, 10 + i))
					.collect(Collectors.toSet());

			br.save(new Brand("XYZ", products2));
			pcr.save(new ProductCategory("Electronics", products2));

			log.debug("BrandRepository");
			br.findAll().forEach(r -> {
				log.debug("r: " + r);
			});

			log.debug("ProductRepository");
			pr.findAll().forEach(r -> {
				log.debug("r: " + r);
			});

			log.debug("ProductCategoryRepository");
			pcr.findAll().forEach(r -> {
				log.debug("r: " + r);
			});

		};
	}
}
