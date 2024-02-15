package com.workintech.proje18.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity //veri tabanı yönetimi
@Data
@AllArgsConstructor
@Table(name = "burger", schema = "denemey")
public class Burger {

    @Id
    @GeneratedValue
    private  long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "is_vegan")
    private Boolean isVegan;

    @Column(name = "bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name = "contents")
    private String contents;


    public String getName() {
        this.name=name;
    }
}
