package poc.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<>();

	public Brand() {
	}

	public Brand(String name, Set<Product> products) {
		this.name = name;
		this.products = products;
	}

	public Brand(String name) {
		this.name = name;
	}

	public void addProduct(Product p) {
		products.add(p);
		p.setBrand(this);
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
