package com.example.json_view.model;

import com.example.json_view.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.UserDetails.class)
    private Long id;
    @JsonView(Views.UserDetails.class)
    private String product;
    @JsonView(Views.UserDetails.class)
    private Double price;
    @JsonView(Views.UserDetails.class)
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
