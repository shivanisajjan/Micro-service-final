package com.stackroute.movieservice.LogicOnStartup;
import com.stackroute.movieservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.Model.Movie;
import com.stackroute.movieservice.Repository.MovieRepository;
import com.stackroute.movieservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UsingCommandLineRunner implements CommandLineRunner {
    @Autowired
    private static MovieRepository movieRepository;
    private static Movie movie=new Movie(1,"Bangalore Days","Malayalam",null);
    @Override
    public void run(String... args) {
        movieRepository.deleteAll();
        movieRepository.save(movie);
    }

}
