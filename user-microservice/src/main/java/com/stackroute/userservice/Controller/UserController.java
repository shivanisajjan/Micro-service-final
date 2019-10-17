package com.stackroute.userservice.Controller;
import com.stackroute.userservice.Exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.Exceptions.UserNotFoundException;
import com.stackroute.userservice.Model.User;
import com.stackroute.userservice.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(value="User Management System", description="Operations pertaining to movie in User Management System")
@RestController
@RequestMapping("/userservice")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "View the list")
    @GetMapping
    public ResponseEntity<?> getAllUsersController(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a user")
    @PostMapping
    public ResponseEntity<?> saveUserController(@RequestBody User user)throws UserAlreadyExistsException {
        System.out.println(user);
        return new ResponseEntity<Boolean>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a user")
    @PutMapping
    public ResponseEntity<?> updateUserController(@RequestBody User user) throws UserAlreadyExistsException {
            return new ResponseEntity<Boolean>(userService.updateUser(user),HttpStatus.CREATED);
    }
    @ApiOperation(value = "Delete a user")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserController(@PathVariable int id) throws UserNotFoundException {
            return new ResponseEntity<Boolean>(userService.deleteUser(id),HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get a user by title")
    @GetMapping("{title}")
    public ResponseEntity<?> searchByNameController(@PathVariable String title) throws UserNotFoundException {
            return new ResponseEntity<List<User>>(userService.findByName(title),HttpStatus.CREATED);
    }
}
