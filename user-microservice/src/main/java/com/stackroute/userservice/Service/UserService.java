package com.stackroute.userservice.Service;

import com.stackroute.userservice.Exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.Exceptions.UserNotFoundException;
import com.stackroute.userservice.Model.User;

import java.util.List;
public interface UserService {
    public boolean saveUser(User user) throws UserAlreadyExistsException;
    public List<User> getAllUsers();
    public boolean deleteUser(long id) throws UserNotFoundException;
    public boolean updateUser(User user) throws UserAlreadyExistsException;
    public List<User> findByName(String string) throws UserNotFoundException;
}
