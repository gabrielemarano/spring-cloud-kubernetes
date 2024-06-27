package it.gmarano.microservices.product.controller;

import it.gmarano.microservices.model.Product;
import it.gmarano.microservices.model.User;
import it.gmarano.microservices.product.feign.UserClient;
import it.gmarano.microservices.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserClient userClient;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> products = this.productService.findAll();

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feign/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = this.userClient.getUsers().getBody();

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
