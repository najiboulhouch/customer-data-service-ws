package net.najiboulhouch.customerdataservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.najiboulhouch.customerdataservice.dto.CustomerRequest;
import net.najiboulhouch.customerdataservice.entities.Customer;
import net.najiboulhouch.customerdataservice.mapper.CustomerMapper;
import net.najiboulhouch.customerdataservice.repository.CustomerRepository;
import net.najiboulhouch.customerdataservice.service.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "customerWS")
public class CustomerSoapService {

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    @WebMethod
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @WebMethod
    public Customer customerById(@WebParam(name = "id") Long id){
        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Customer %s not found" , id)));
    }

    @WebMethod
    public Customer saveCustomer(CustomerRequest customerRequest){
        Customer customer =  customerMapper.from(customerRequest);
        return customerRepository.save(customer);
    }

}
