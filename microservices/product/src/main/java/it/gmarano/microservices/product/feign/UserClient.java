package it.gmarano.microservices.product.feign;

import it.gmarano.microservices.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user", url = "${feign.user.url}")
public interface UserClient {

    @GetMapping("/user")
    ResponseEntity<List<User>> getUsers();

}