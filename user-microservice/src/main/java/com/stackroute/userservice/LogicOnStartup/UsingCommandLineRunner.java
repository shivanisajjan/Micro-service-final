package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.Model.User;
import com.stackroute.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UsingCommandLineRunner implements CommandLineRunner {
    @Autowired
    private static UserRepository userRepository;
    private static User user =new User(1,"Haripriya","1234","haripriya1234");
    @Override
    public void run(String... args) throws UserAlreadyExistsException {
        userRepository.deleteAll();
        userRepository.save(user);
    }
}
