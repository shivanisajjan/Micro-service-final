package com.stackroute.movieservice.Controller;
import com.stackroute.movieservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.Exceptions.MovieNotFoundException;
import com.stackroute.movieservice.Model.Movie;
import com.stackroute.movieservice.Service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
@Api(value="Movie Management System", description="Operations pertaining to movie in Movie Management System")
@RestController
@RequestMapping("/movieservice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {
    @Inject
    private Environment environment;
    @Autowired
    private MovieService movieService;
    @ApiOperation(value = "View the list")
    @GetMapping
    public ResponseEntity<?> getAllMoviesController(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a movie")
    @PostMapping
    public ResponseEntity<?> saveMovieController(@RequestBody Movie movie)throws MovieAlreadyExistsException  {
        System.out.println(movie);
        return new ResponseEntity<Boolean>(movieService.saveMovie(movie),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a movie")
    @PutMapping
    public ResponseEntity<?> updateMovieController(@RequestBody Movie movie) throws MovieAlreadyExistsException {
            return new ResponseEntity<Boolean>(movieService.updateMovie(movie),HttpStatus.CREATED);
    }
    @ApiOperation(value = "Delete a movie")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovieController(@PathVariable int id) throws MovieNotFoundException {
            return new ResponseEntity<Boolean>(movieService.deleteMovie(id),HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get a movie by title")
    @GetMapping("{title}")
    public ResponseEntity<?> searchByNameController(@PathVariable String title) throws MovieNotFoundException{
            return new ResponseEntity<List<Movie>>(movieService.findByName(title),HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get a movie by id")
    @GetMapping("id/{id}")
    public ResponseEntity<?> searchByIdController(@PathVariable long id) throws MovieNotFoundException{
        return new ResponseEntity<Movie>(movieService.findById(id),HttpStatus.CREATED);
    }
}
