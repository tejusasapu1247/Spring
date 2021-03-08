package Com.customer.model.dao;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7863778402740391518L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
