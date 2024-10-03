package com.shops.dreamshops.data;

import com.shops.dreamshops.model.User;
import com.shops.dreamshops.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createDefaultUserNotExists();
    }

    private void createDefaultUserNotExists() {
        for(int i=0;i<=5;i++){
            String defaultEmail="user"+i+"@email.com";
            if(userRepository.existsByEmail(defaultEmail)){
                continue;
            }
            User user=new User();
            user.setFirstName("The User");
            user.setLastName("User"+i);
            user.setEmail("user"+i+"@email.com");
            user.setPassword("123456");
            userRepository.save(user);

        }


    }
}
