package com.stackroute.movieservice.Repository;

import com.stackroute.movieservice.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
}
