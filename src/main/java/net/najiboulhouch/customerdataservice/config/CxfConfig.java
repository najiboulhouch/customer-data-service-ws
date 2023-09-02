package net.najiboulhouch.customerdataservice.config;

import lombok.AllArgsConstructor;
import net.najiboulhouch.customerdataservice.web.CustomerSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {


    private final Bus bus ;
    private final CustomerSoapService customerSoapService ;

    @Bean
    public EndpointImpl endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus , customerSoapService);
        endpoint.publish("/CustomerService");
        return endpoint;
    }
}
