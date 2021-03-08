package Com.customer.model.dao;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomer();
	public void addCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
	public Customer getCustomerById(int id);
	

}
