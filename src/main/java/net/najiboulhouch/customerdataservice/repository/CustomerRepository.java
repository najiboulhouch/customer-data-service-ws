package net.najiboulhouch.customerdataservice.repository;

import net.najiboulhouch.customerdataservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
