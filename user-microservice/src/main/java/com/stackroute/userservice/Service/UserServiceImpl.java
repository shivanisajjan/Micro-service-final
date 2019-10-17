package com.stackroute.userservice.Service;
import com.stackroute.userservice.Exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.Exceptions.UserNotFoundException;
import com.stackroute.userservice.Model.User;
import com.stackroute.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException();
        }
        User result=userRepository.save(user);
        if(result==null){
            throw new UserAlreadyExistsException();

        }
            return true;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(long id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        else throw new UserNotFoundException();

    }

    @Override
    public boolean updateUser(User user) throws UserAlreadyExistsException {
           User user1 = userRepository.save(user);
            if(user1 ==null){
                throw new UserAlreadyExistsException();
            }
            return true;
    }

    @Override
    public List<User> findByName(String string) throws UserNotFoundException {
            List<User> result=userRepository.findByName(string);
            if(result.isEmpty()){
                throw new UserNotFoundException();
            }
            else return result;

    }


}
