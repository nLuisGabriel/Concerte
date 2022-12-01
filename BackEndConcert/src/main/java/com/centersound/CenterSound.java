package com.centersound;

import com.centersound.entities.*;
import com.centersound.enums.Category;
import com.centersound.enums.Gender;
import com.centersound.enums.GeographicRegion;
import com.centersound.repositories.*;
import com.github.javafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CenterSound {
    private Random random;
    private Faker faker = new Faker();


    List<String> descriptions = new ArrayList<String>();
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

    public static void main(String[] args) {
        SpringApplication.run(CenterSound.class, args);
    }

    @PostConstruct
    private void populare() throws FileNotFoundException {
        if (concertRepository.count() == 0) {
            try {
                File myObj = new File("D:\\\\WEB Project\\\\BackEndConcert\\\\src\\\\main\\\\resources\\\\cv-unique-has-end-punct-sentences.csv");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    descriptions.add(myReader.nextLine());
                }
                myReader.close();
            } catch (
                    FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            ;
        }
        generateArtist();
        generateMusicCategory();
        generateLocations();
        generateConcerts();
        generateCustomer();
    }

    private void generateCustomer() {
        if (customerRepository.count() == 0) {
            for (int i = 0; i < 15; i++) {
                Customer customer = new Customer();
                customer.setEmail(faker.name().username() + "@mail.com");
                customer.setAge(faker.random().nextInt(8, 50));
                customer.setPassword("defaultPassword123!");
                customer.setPhoneNumber(faker.phoneNumber().phoneNumber());
                customer.setName(faker.name().fullName());
                customerRepository.save(customer);
            }
        }
    }

    private void generateConcerts() {
        if (concertRepository.count() == 0) {
            List<Location> locations = locationRepository.findAll();
            List<MusicalCategory> categories = musicalCategoryRepository.findAll();
            List<Artist> artists = artistRepository.findAll();
            for (int i = 0; i < 30; i++) {
                Concert concert = new Concert();
                concert.setName(faker.funnyName().name() + " " + faker.music().instrument());
                concert.setPrice(BigDecimal.valueOf(faker.number().randomDouble(10, 10, 100)));
                concert.setDate(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                concert.setLocation(locations.get(faker.number().numberBetween(0, locations.size())));
                concert.setCategory(categories.get(faker.number().numberBetween(0, categories.size())));
                Set<Artist> artistSet = new HashSet<>();
                int randomArtistNumber = faker.random().nextInt(4, artists.size() - 2);
                for (int j = 0; j < randomArtistNumber; j++) {
                    artistSet.add(artists.get(faker.random().nextInt(0, artists.size() - 1)));
                }
                concert.setArtists(artistSet);
                concertRepository.save(concert);
            }
        }
    }

    private void generateLocations() {
        if (locationRepository.count() == 0) {
            for (int i = 0; i < 30; i++) {
                Location location = new Location();
                location.setTown(faker.address().city());
                location.setCountry(faker.address().country());
                location.setStreetNumber(faker.random().nextInt(10, 100));
                location.setCounty(faker.address().state());
                location.setStreet(faker.address().streetAddress());
                locationRepository.save(location);
            }
        }
    }

    private void generateMusicCategory() {
        if (musicalCategoryRepository.count() == 0) {
            Category[] categories = Category.values();
            for (int i = 0; i < categories.length; i++) {
                MusicalCategory musicalCategory = new MusicalCategory();
                musicalCategory.setCategory(categories[i]);
                musicalCategory.setDetails(descriptions.get(faker.number().numberBetween(1, 47)));
                musicalCategoryRepository.save(musicalCategory);
            }
        }
    }

    private void generateArtist() {
        if (artistRepository.count() == 0) {
            List<Artist> artists = new ArrayList<Artist>();
            for (int i = 0; i < 35; i++) {
                Artist artist = new Artist();
                artist.setGender(Gender.random());
                artist.setBirthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                artist.setGeographicRegion(GeographicRegion.random());
                artist.setName(faker.name().fullName());
                artist.setDescription(descriptions.get((faker.number().numberBetween(1, 47))));
                artists.add(artist);
            }
            artistRepository.saveAll(artists);
        }
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
