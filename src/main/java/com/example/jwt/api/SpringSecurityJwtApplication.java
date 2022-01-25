package com.example.jwt.api;

import com.example.jwt.api.entity.User;
import com.example.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUsers() {
        userRepository.saveAll(Stream.of(
                        new User(101, "kiran", "password", "kiran@abc.com"),
                        new User(102, "user1", "pwd1", "user1@abc.com"),
                        new User(103, "user2", "pwd2", "user2@abc.com"),
                        new User(104, "user3", "pwd3", "user3@abc.com")
        ).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
