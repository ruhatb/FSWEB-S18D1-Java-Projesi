package com.workintech.proje18.dao;

import com.workintech.proje18.entity.BreadType;
import com.workintech.proje18.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(long id);

    Burger update(Burger burger);

    Burger remove(long id);

    List<Burger> findByContent(String content);

    List<Burger> findByPrice(Integer price);

    List<Burger> findByBreadType(BreadType breadType);



}
