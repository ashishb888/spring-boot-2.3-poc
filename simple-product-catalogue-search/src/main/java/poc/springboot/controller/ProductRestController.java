package poc.springboot.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Product;
import poc.springboot.repos.ProductRepository;

@Slf4j
@RequestMapping("/products")
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository pr;

	@GetMapping
	public Iterable<Product> findAll() {
		pr.findAll().forEach(r->{
			log.debug("r: " + r);
		});
		return pr.findAll();
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable long id) {
		return pr.findById(id).orElseThrow(NoSuchElementException::new);
	}
}
