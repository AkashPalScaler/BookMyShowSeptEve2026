package com.scaler.bmsseptevening2026;

import com.scaler.bmsseptevening2026.Models.*;
import com.scaler.bmsseptevening2026.Repositories.MovieRepository;
import com.scaler.bmsseptevening2026.Repositories.RegionRepository;
import com.scaler.bmsseptevening2026.Repositories.ScreenRepository;
import com.scaler.bmsseptevening2026.Repositories.TheatreRepository;
import com.scaler.bmsseptevening2026.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class BmsSeptEvening2026Application implements CommandLineRunner {
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BmsSeptEvening2026Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Region region = new Region();
//        region.setName("Mumbai");
//        regionRepository.save(region);
//
//        Region region2 = new Region();
//        region2.setName("Chennai");
//        regionRepository.save(region2);
//
//        Theatre theatre = new Theatre();
//        theatre.setName("Phoenix");
//        theatre.setRegion(region);
//
//        Theatre theatre2 = new Theatre();
//        theatre2.setName("BKC_INOX");
//        theatre2.setRegion(region);
//
//        Theatre theatre3 = new Theatre();
//        theatre3.setName("POWAI_CINEMAX");
//        theatre3.setRegion(region);
//
//        Theatre theatre4 = new Theatre();
//        theatre4.setName("ANDHERI_PVR");
//        theatre4.setRegion(region2);
//
//        theatreRepository.save(theatre);
//        theatreRepository.save(theatre2);
//        theatreRepository.save(theatre3);
//        theatreRepository.save(theatre4);
//
//
//        Screen screen1A = new Screen();
//        screen1A.setName("1A");
//        screen1A.setTheatre(theatre);
//        screenRepository.save(screen1A);
//        Screen screen2A = new Screen();
//        screen2A.setName("2A");
//        screen2A.setTheatre(theatre);
//        screenRepository.save(screen2A);
//        Screen screen1B = new Screen();
//        screen1B.setName("1B");
//        screen1B.setTheatre(theatre);
//        screenRepository.save(screen1B);
//        Screen screen2B = new Screen();
//        screen2B.setName("2B");
//        screen2B.setTheatre(theatre);
//        screenRepository.save(screen2B);
//
//        Movie movie1 = new Movie();
//        movie1.setName("Batman");
//        movieRepository.save(movie1);

//        Movie movie1 = new Movie();
//        movie1.setName("Superman");
//        movie1.setRating(5);
//        movie1.setGenre("Superhero");
//        movieRepository.save(movie1);
//
//        List<Screen> screens1 = screenRepository.findAll();
//        List<Screen> screens2 = screenRepository.findAllById(List.of(1l,2l));
//        Screen screen3 = screenRepository.findById(1l).orElse(null);
//
//        Movie movie2 = movieRepository.findByName("BatmanP");
//        System.out.println("Movie -" + movie2);
//
//        Movie movie3 = movieRepository.findByNameAndGenre("Superman", "Superhero");
//        System.out.println("Movie -" + movie3.getName());

        // Region -> Theatre -> Screen -> Shows -> Movies

        // findByTheatre_Region_Name(Mumbai)
        // findByTheatre_Name
//        List<Screen> allScreens = screenRepository.findByTheatre_Name("Phoenix");
//        for(Screen screen : allScreens) {
//            System.out.println(screen.getName());
//        }
        // select s1_0.id,s1_0.created_at,s1_0.name,s1_0.theatre_id,s1_0.updated_at from screen s1_0 left join theatre t1_0 on t1_0.id=s1_0.theatre_id left join region r1_0 on r1_0.id=t1_0.region_id where r1_0.name=?
//        List<Screen> allScreensInMumbai = screenRepository.findByTheatre_Region_Name("Mumbai");
//        for(Screen screen : allScreensInMumbai) {
//            System.out.println(screen.getName());
//        }

//        User user2  = userService.signup("Akash2", "akash2@gmail.com", "passpass2");
//        User user3  = userService.signup("Akash3", "akash3@gmail.com", "passpass2");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.matches("passpass2", "$2a$10$J9s72zqIc6MlZBgvt/0EEuyi66Di1AahYn/vtZIraCfeMLqO4r.3G"));
        System.out.println(passwordEncoder.matches("passpass2", "$2a$10$9zL1WeRS6ZL55.iMNefOFefM4J9jN/eoOlshTkrK0AYwzhTsD7a0."));
        System.out.println(passwordEncoder.matches("passpass1", "$2a$10$9zL1WeRS6ZL55.iMNefOFefM4J9jN/eoOlshTkrK0AYwzhTsD7a0."));
        System.out.println(passwordEncoder.matches("passpass3", "$2a$10$9zL1WeRS6ZL55.iMNefOFefM4J9jN/eoOlshTkrK0AYwzhTsD7a0."));


    }
}

// AND - Condition where clauses on multiple primary attributes on the entity
// UNDERSCORE -  Where clauses on foreign tables through join

// Hash(one-way, meaning original value can't be recovered from hashedValue)
// Same raw string passed through same hash function results into same hashedString
// vs
// encryption(two-way, original value can be recovered by decryption)
//

// To check the password : User logs in with rawPassword
// 1) Hash(rawPassword) == hashedPassword [easier to implement, faster]
// 2) Decrypt(encryptedPassword) == rawPassword [complex, slower]

//$2a$10$N9qo8uLOickgx2ZMRZoMye.IjZAgcfl7p92ldGxad68LJZdL17lhWy
//    └──────── salt ─────────┘ └────────── hash ──────────┘
// Salt : A 22 character random string

// User 1 : "passpass" -> Hash(passpass) -> ***hashed_passpass***
// User 1 signs up: "passpass" -> Hash(passpass_randomsalt1) -> ***hashed_passpass_randomsalt1*** -> Store in DB version_cost_randomsalt1_***hashed_passpass_randomsalt1***
// User 1 logs in: "passpass" -> Fetch the salt value from DB (version_cost_randomsalt1_***hashed_passpass_randomsalt1***)
//                    -> randomsalt1 -> Hash("passpass" + randomSalt1) -> ***hashed_passpass_randomsalt1***

// passpass12-38r7woebo38rg -> sameHash
// passpassqejofh9u892439-8 -> sameHash