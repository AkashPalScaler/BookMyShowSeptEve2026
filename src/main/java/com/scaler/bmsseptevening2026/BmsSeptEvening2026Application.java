package com.scaler.bmsseptevening2026;

import com.scaler.bmsseptevening2026.Models.Movie;
import com.scaler.bmsseptevening2026.Models.Region;
import com.scaler.bmsseptevening2026.Models.Screen;
import com.scaler.bmsseptevening2026.Models.Theatre;
import com.scaler.bmsseptevening2026.Repositories.MovieRepository;
import com.scaler.bmsseptevening2026.Repositories.RegionRepository;
import com.scaler.bmsseptevening2026.Repositories.ScreenRepository;
import com.scaler.bmsseptevening2026.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
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
        List<Screen> allScreensInMumbai = screenRepository.findByTheatre_Region_Name("Mumbai");
        for(Screen screen : allScreensInMumbai) {
            System.out.println(screen.getName());
        }
    }
}

// AND - Condition where clauses on multiple primary attributes on the entity
// UNDERSCORE -  Where clauses on foreign tables through join
