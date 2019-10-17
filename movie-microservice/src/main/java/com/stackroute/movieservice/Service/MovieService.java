package com.stackroute.movieservice.Service;

import com.stackroute.movieservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.Exceptions.MovieNotFoundException;
import com.stackroute.movieservice.Model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public boolean deleteMovie(long id) throws MovieNotFoundException;
    public boolean updateMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> findByName(String string) throws MovieNotFoundException;
    public Movie findById(long id) throws MovieNotFoundException;
}
