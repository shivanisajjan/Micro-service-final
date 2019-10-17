package com.stackroute.movieservice.Service;
import com.stackroute.movieservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.Exceptions.MovieNotFoundException;
import com.stackroute.movieservice.Model.Movie;
import com.stackroute.movieservice.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,MongoTemplate mongoTemplate) {
        this.movieRepository = movieRepository;
        this.mongoTemplate=mongoTemplate;
    }

    @Override
    public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException();
        }
        Movie result=movieRepository.save(movie);
        if(result==null){
            throw new MovieAlreadyExistsException();

        }
            return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(long id) throws MovieNotFoundException {
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return true;
        }
        else throw new MovieNotFoundException();

    }

    @Override
    public boolean updateMovie(Movie movie) throws MovieAlreadyExistsException {
           Movie movie1= movieRepository.save(movie);
            if(movie1==null){
                throw new MovieAlreadyExistsException();
            }
            return true;
    }

    @Override
    public List<Movie> findByName(String string) throws MovieNotFoundException{
        Query query=new Query();
        query.addCriteria(Criteria.where("title").is(string));
        List<Movie> result=mongoTemplate.find(query,Movie.class);
         if(result==null){
             throw new MovieNotFoundException();
         }
         else return result;

    }

    @Override
    public Movie findById(long id) throws MovieNotFoundException {
        Movie movie=this.movieRepository.findById(id).get();
        return movie;
    }

}
