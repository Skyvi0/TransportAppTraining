package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LAGER")
public class Inventory {
    @Id
    private Long id;
    private Boolean zerbrechlich;
    private Float gewicht;
    private String create_time;
    private String name;
    // consturctor, getters and setters
 
    public Inventory(Long id, Boolean zerbrechlich, Float gewicht, String create_time, String name) {
        this.id = id;
        this.zerbrechlich = zerbrechlich;
        this.gewicht = gewicht;
        this.create_time = create_time;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getZerbrechlich() {
        return zerbrechlich;
    }
    public void setZerbrechlich(Boolean zerbrechlich) {
        this.zerbrechlich = zerbrechlich;
    }
    public Float getGewicht() {
        return gewicht;
    }
    public void setGewicht(Float gewicht) {
        this.gewicht = gewicht;
    }
    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
    