package it.gmarano.microservices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"product\"")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
