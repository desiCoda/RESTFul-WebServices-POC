package demo.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.domain.Category;
import demo.domain.Customer;
import demo.repositories.CategoryRepository;
import demo.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;

	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	public void saveCatrgories() {
		Category fruits = new Category();
		fruits.setName("Fruits");
		Category dried = new Category();
		dried.setName("Dried");
		Category fresh = new Category();
		fresh.setName("Fresh");
		Category exotic = new Category();
		exotic.setName("Exotic");
		Category nuts = new Category();
		nuts.setName("Nuts");
		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(nuts);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		System.out.println("category data loaded +++++++" + categoryRepository.count());

	}

	public void saveCutomers() {

		Customer customer1 = new Customer();
		customer1.setFirstname("Peter");
		customer1.setLastname("parker");

		Customer customer2 = new Customer();
		customer2.setFirstname("Tony");
		customer2.setLastname("Stark");

		Customer customer3 = new Customer();
		customer3.setFirstname("Thor");
		customer3.setLastname("Odinson");

		Customer customer4 = new Customer();
		customer4.setFirstname("Wanda");
		customer4.setLastname("Maximoff");
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		System.out.println("customer data loaded +++++++" + customerRepository.count());
	}

	@Override
	public void run(String... args) throws Exception {
		saveCatrgories();
		saveCutomers();

	}

}
