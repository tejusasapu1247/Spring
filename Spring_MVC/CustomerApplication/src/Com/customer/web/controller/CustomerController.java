package Com.customer.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import Com.customer.model.dao.Customer;
import Com.customer.model.service.CustomerService;



@Controller
public class CustomerController {
	
	private CustomerService customerservice;
	@Autowired
	public CustomerController(CustomerService customerservice) {
		this.customerservice= customerservice;
	}
	@GetMapping("/")
	public String home() {
		
		return "redirect:/allcustomers";
	}
	@GetMapping("allcustomers")
	public ModelAndView allcustomers(ModelAndView mv) {
		mv.setViewName("showall");
		mv.addObject("customers",customerservice.getAllCustomers());
		return mv;
	}
	
	// add an new customer
		@GetMapping("addcustomer")
		public String addCustomerGet(ModelMap map) {
			// we are binding a form bean ( a poj ie used to collect the data from ui) with
			// the form
			map.addAttribute("customer", new Customer());
			return "addcustomer";
		}
		// del the customer
		@GetMapping("deletecustomer")
		public String delCustomer(HttpServletRequest req) {
			int id = Integer.parseInt(req.getParameter("id"));
			customerservice.deleteCustomer(id);
			return "redirect:/allcustomer";
		}
		
		// update the customer: get and post

		// add an new customer
		@GetMapping("updatecustomer")
		public String addCustomerGet(HttpServletRequest req, ModelMap map) {
			int id = Integer.parseInt(req.getParameter("id"));
			Customer customer = customerservice.getCustomerById(id);
			map.addAttribute("customer", customer);
			return "updatecustomer";
		}
		//post part of addcustomer/updatecustomer
		@PostMapping("addcustomer")
		public String addCustomerPost(@ModelAttribute(name = "customer") Customer customer) {
			if (customer.getId() == 0) {
				customerservice.addCustomer(customer);
			} else {
				customerservice.updateCustomer(customer.getId(), customer);
			}
			return "redirect:/allcustomer";
		}
	

	
	
}