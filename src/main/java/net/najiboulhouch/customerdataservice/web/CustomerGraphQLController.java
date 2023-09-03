package net.najiboulhouch.customerdataservice.web;


import lombok.RequiredArgsConstructor;
import net.najiboulhouch.customerdataservice.dto.CustomerRequest;
import net.najiboulhouch.customerdataservice.entities.Customer;
import net.najiboulhouch.customerdataservice.mapper.CustomerMapper;
import net.najiboulhouch.customerdataservice.repository.CustomerRepository;
import net.najiboulhouch.customerdataservice.service.ResourceNotFoundException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerGraphQLController {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @QueryMapping
    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id ){
        System.out.println("Add a text for test");
        System.out.println("Adding a texts");
        System.out.println("message in feature branch");
        return customerRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException(String.format("Customer %s not found" , id)));
    }

    @MutationMapping
    public Customer saveCustomer(@Argument CustomerRequest customer) {
        Customer cst = customerMapper.from(customer);
        return customerRepository.save(cst);
    }

}
