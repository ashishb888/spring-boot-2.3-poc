package poc.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import poc.springboot.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
