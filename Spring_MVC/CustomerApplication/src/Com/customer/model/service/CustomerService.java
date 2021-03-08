package Com.customer.model.service;

import java.util.List;
import java.util.function.Predicate;


import Com.customer.model.dao.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
	public Customer getCustomerById(int id);
	public List<Customer> getBookOnCondition(Predicate<Customer>predicate);

	

}
