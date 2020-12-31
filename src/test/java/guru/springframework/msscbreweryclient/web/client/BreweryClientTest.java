package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beer = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }

    @Test
    void saveNewBeer() {
        BeerDto beer = BeerDto.builder().id(UUID.randomUUID()).beerName("New Name").build();
        URI uri = breweryClient.saveNewBeer(beer);
        assertNotNull(uri);
        System.out.println("The Beer client URI is: " + uri);
    }

    @Test
    void updateBeer() {
        BeerDto beer = BeerDto.builder().id(UUID.randomUUID()).beerName("King Fisher").build();
        breweryClient.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}