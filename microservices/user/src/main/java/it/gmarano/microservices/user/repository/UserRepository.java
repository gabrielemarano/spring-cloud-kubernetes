package it.gmarano.microservices.user.repository;

import it.gmarano.microservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
