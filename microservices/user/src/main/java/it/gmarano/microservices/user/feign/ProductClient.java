package it.gmarano.microservices.user.feign;

import it.gmarano.microservices.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product", url = "${feign.product.url}")
public interface ProductClient {

    @GetMapping("/product")
    ResponseEntity<List<Product>> getProducts();
}
