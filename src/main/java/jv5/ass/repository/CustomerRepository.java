/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.repository;

import jv5.ass.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hotua
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
    Customer findByUsername(String user);
    
    Customer findByMakh(Integer makh);
}
