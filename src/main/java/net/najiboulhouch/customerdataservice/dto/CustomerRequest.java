package net.najiboulhouch.customerdataservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CustomerRequest {

    private String name;
    private String email;
}
