package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customer = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveNewCustomer() {
        UUID id = UUID.randomUUID();
        System.out.println("UUID save id: " + id);
        CustomerDto customer = CustomerDto.builder().name("New Name").id(id).build();
        URI uri = customerClient.saveNewCustomer(customer);
        assertNotNull(uri);
        System.out.println("The Customer client URI is: " + uri);
    }

    @Test
    void updateCustomer() {
        UUID id = UUID.randomUUID();
        System.out.println("UUID update id: " + id);
        CustomerDto customer = CustomerDto.builder().id(id).name("McDonald").build();
        customerClient.updateCustomer(id, customer);
    }

    @Test
    void deleteCustomer() {
        UUID id = UUID.randomUUID();
        System.out.println("UUID delete id: " + id);
        customerClient.deleteCustomer(id);
    }
}