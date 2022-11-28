package com.centersound;

import com.centersound.entities.Artist;
import com.centersound.entities.Customer;
import com.centersound.entities.Location;
import com.centersound.entities.MusicalCategory;
import com.centersound.enums.Category;
import com.centersound.enums.Gender;
import com.centersound.enums.GeographicRegion;
import com.centersound.repositories.ArtistRepository;
import com.centersound.repositories.CustomerRepository;
import com.centersound.repositories.LocationRepository;
import com.centersound.repositories.MusicalCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class CenterSound {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    MusicalCategoryRepository musicalCategoryRepository;

    @Autowired
    CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CenterSound.class);

    public static void main(String[] args) {
        SpringApplication.run(CenterSound.class, args);
    }
    @PostConstruct
    private void check(){
        if(artistRepository.count()==0){
            Artist artist = new Artist();
            artist.setName("First Artist");
            artist.setBirthDate(LocalDate.now());
            artist.setGender(Gender.MASCULINE);
            artist.setDescription("Description");
            artist.setGeographicRegion(GeographicRegion.EUROPE);
            artistRepository.save(artist);
        }
        if(locationRepository.count()==0){
            Location location = new Location();
            location.setCountry("Country");
            location.setCounty("County");
            location.setTown("Town");
            location.setStreet("Street");
            location.setStreetNumber(10);
            locationRepository.save(location);
        }
        if(musicalCategoryRepository.count()==0){
            MusicalCategory musicalCategory = new MusicalCategory();
            musicalCategory.setCategory(Category.POP);
            musicalCategoryRepository.saveAndFlush(musicalCategory);
        }
        if(customerRepository.count()==0){
            Customer customer = new Customer();
            customer.setEmail("nedelculuisgabriel@gmail.com");
            customer.setPassword("parola1234");
            customer.setName("Luis Gabriel");
            customer.setAge(21);
            customer.setPhoneNumber("0760252777");
            customerRepository.save(customer);
            customer = customerRepository.findByEmail("nedelculuisgabriel@gmail.com");
        }
    }
}
