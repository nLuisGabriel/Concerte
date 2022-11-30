package com.centersound;

import com.centersound.entities.*;
import com.centersound.enums.Category;
import com.centersound.enums.Gender;
import com.centersound.enums.GeographicRegion;
import com.centersound.enums.OrderStatus;
import com.centersound.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class CenterSound {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    MusicalCategoryRepository musicalCategoryRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ConcertRepository concertRepository;

    @Autowired
    CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CenterSound.class);

    public static void main(String[] args) {
        SpringApplication.run(CenterSound.class, args);
    }
    @PostConstruct
    private void check(){

        if(concertRepository.count()!=2){
            Concert concert = new Concert();
            concert.setName("Concert 2");
            MusicalCategory musicalCategory = new MusicalCategory();
            musicalCategory.setCategory(Category.POP);
            concert.setCategory(musicalCategory);


            concert.setDate(LocalDateTime.now());
            Location location = new Location();
            location.setCountry("Country");
            location.setCounty("County");
            location.setTown("Town");
            location.setStreet("Street");
            location.setStreetNumber(10);
            concert.setLocation(location);


            concert.setPrice(BigDecimal.valueOf(1000));
            Set<Artist> artists = new HashSet<>(artistRepository.findAll());
            concert.setArtists(artists);


            concertRepository.save(concert);
        }

        if(customerRepository.count()==0){
            Customer customer = new Customer();
            customer.setName("First Customer");
            customer.setAge(20);
            customer.setPassword("ParolaDeTest");
            customer.setPhoneNumber("8312312");
            customer.setEmail("email@Test.ro");
            customer = customerRepository.save(customer);
        }

        if(orderRepository.count()==0){
            Concert concert = concertRepository.findAll().get(0);

            Order order = new Order();
            order.setConcert(concert);
            order.setOrderStatus(OrderStatus.ACCEPTED);
            order.setCustomer(customerRepository.findByEmail("email@Test.ro"));

            orderRepository.save(order);
        }
        // add artist to concert
        if(false){
            Artist artist = new Artist();
            artist.setName("Artist 4");
            artist.setBirthDate(LocalDate.now());
            artist.setGender(Gender.MASCULINE);
            artist.setDescription("Description");
            artist.setGeographicRegion(GeographicRegion.EUROPE);
            artist.setBirthDate(LocalDate.now());
            artist = artistRepository.save(artist);

            Concert concert = concertRepository.findAll().get(0);
            concert.getArtists().add(artist);
            concertRepository.save(concert);
        }
        // add concert to artist
        if(false) {
            Artist artist = artistRepository.findById(9L).get();
            Concert concert = concertRepository.findAll().get(0);
            artist.getConcerts().add(concert);
            artistRepository.save(artist);
        }
        var x= concertRepository.concertsByArtistId(0L);
        String xz = "sd";
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
