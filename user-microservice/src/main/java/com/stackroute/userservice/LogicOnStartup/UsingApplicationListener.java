package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Model.User;
import com.stackroute.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
public class UsingApplicationListener implements ApplicationListener<ContextRefreshedEvent>   {
    @Autowired
    private static UserRepository userRepository;
    private static User user =new User(1,"Haripriya","1234","haripriya1234");

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.deleteAll();
        userRepository.save(user);
    }
}
