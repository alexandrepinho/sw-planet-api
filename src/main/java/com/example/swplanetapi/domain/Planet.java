package com.example.swplanetapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getClimate() {
        return climate;
    }
    public String getTerrain() {
        return terrain;
    }


}
