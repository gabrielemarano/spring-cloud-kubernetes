package it.gmarano.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"it.gmarano.microservices"})
@EntityScan({"it.gmarano.microservices.model"})
@EnableJpaRepositories(basePackages= "it.gmarano.microservices.user.repository")
@EnableFeignClients(basePackages= "it.gmarano.microservices.user.feign")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
