package com.city.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name = "district_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String districtName;
    private Long population;

    @JsonBackReference
    @JoinColumn(name = "city_id")
    @ManyToOne
    private City city;
}
