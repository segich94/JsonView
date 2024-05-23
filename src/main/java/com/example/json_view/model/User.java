package com.example.json_view.model;

import com.example.json_view.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.UserSummary.class)
    private Long id;
    @JsonView(Views.UserSummary.class)
    private String name;
    @JsonView(Views.UserDetails.class)
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(Views.UserDetails.class)
    private List<Order> orders;

}
