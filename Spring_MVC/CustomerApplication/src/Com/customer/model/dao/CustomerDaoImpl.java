package Com.customer.model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // @Component + exception wrapping (PersistenceExceptionTranslationPostProcessor)
public class CustomerDaoImpl implements CustomerDao{
	private SessionFactory factory;
	@Autowired
	public CustomerDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	

	@Override
	public List<Customer> getAllCustomer() {
		return  getSession().createQuery("from customer").list();
	}

	@Override
	public void addCustomer(Customer customer) {
		getSession().save(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer = getCustomerById(id);
		getSession().delete(customer);
		
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		Customer customerToUpdated = getCustomerById(id);
		customerToUpdated.setName(customer.getName());
		getSession().update(customerToUpdated);		
	}
	@Override
	public Customer getCustomerById(int id) {

		Customer customer = getSession().get(Customer.class, id);

		if (customer != null)
			return customer;
		else
			throw new CustomerNotFoundException("customer with id:" + id + " is not found");
	}

	
	}


