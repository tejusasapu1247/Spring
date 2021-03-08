package Com.customer.model.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Com.customer.model.dao.Customer;
import Com.customer.model.dao.CustomerDao;
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=customerDao.getAllCustomer();
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);		
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);		
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		customerDao.updateCustomer(id, customer);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public List<Customer> getBookOnCondition(Predicate<Customer> predicate) {
		return getAllCustomers().stream().filter(predicate).collect(Collectors.toList());
	}

}
