package com.rateandreview;

import com.rateandreview.models.ApplicationUser;
import com.rateandreview.models.Post;
import com.rateandreview.models.Role;
import com.rateandreview.repository.RoleRepository;
import com.rateandreview.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
        return args ->{
            if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            Set<Post> posts = new HashSet<>();

            ApplicationUser admin = new ApplicationUser("admin", passwordEncode.encode("password"), roles, posts);

            userRepository.save(admin);
        };
    }

}
