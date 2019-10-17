package com.stackroute.movieservice.LogicOnStartup;
import com.stackroute.movieservice.Model.Movie;
import com.stackroute.movieservice.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
public class UsingApplicationListener implements ApplicationListener<ContextRefreshedEvent>   {
    @Autowired
    private static MovieRepository movieRepository;
    private static Movie movie=new Movie(1,"Bangalore Days","Malayalam",null);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieRepository.deleteAll();
        movieRepository.save(movie);
    }
}
