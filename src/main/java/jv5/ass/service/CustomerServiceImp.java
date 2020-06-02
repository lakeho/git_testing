package jv5.ass.service;

import jv5.ass.entity.Customer;
import jv5.ass.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository CustomerRepo;

	@Override
	public Boolean BSave(Customer c) {
		try {
			CustomerRepo.save(c);
			return true;
		}catch(Throwable t) {
			t.printStackTrace();
			return false;
		}
	}
	
	
}
