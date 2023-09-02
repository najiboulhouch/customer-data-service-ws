package net.najiboulhouch.customerdataservice.mapper;


import net.najiboulhouch.customerdataservice.dto.CustomerRequest;
import net.najiboulhouch.customerdataservice.entities.Customer;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
@Component
public class CustomerMapper {

    private ModelMapper modelMapper = new ModelMapper();


    public Customer from(CustomerRequest customerRequest){
       return  modelMapper.map(customerRequest , Customer.class);
    }
}
