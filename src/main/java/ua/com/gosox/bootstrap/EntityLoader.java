package ua.com.gosox.bootstrap;

import ua.com.gosox.repositories.RoleRepository;
import ua.com.gosox.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EntityLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Role role = new Role();
//        role.setName("ADMIN");
//        roleRepository.save(role);
//
//
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("Mlgame.ru");
//        user.setRole(roleRepository.findByName("ADMIN"));
//        userService.save(user);

//        NetHost netHost = new NetHost();
//        netHost.setMacAddress("er:er:er:er:er");
//        netHost.setIpAddress("192.168.0.1");
//        netHost.setHostname("Hostname");
//        netHostRepository.save(netHost);

    }
}

