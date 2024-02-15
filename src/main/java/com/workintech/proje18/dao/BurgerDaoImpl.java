package com.workintech.proje18.dao;

import com.workintech.proje18.entity.BreadType;
import com.workintech.proje18.entity.Burger;
import com.workintech.proje18.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;


@AllArgsConstructor
@Repository
public class BurgerDaoImpl implements  BurgerDao{

    private final EntityManager entityManager; //Spring Boot data Jpa icinden geliyor


//alttaraftaki consturactrdır @autowier yazılınca injections yapıyoruz..

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional  //geriye dönük rollback
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> foundAll  =entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
      return  foundAll.getResultList();
    }

    @Override
    public Burger findById(long id) {
        Burger burger = entityManager.find(Burger.class, id);
        if (burger == null){
            throw new BurgerException("Burger is not found", HttpStatus.NOT_FOUND);
        }
        return burger;
    }
    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);


    }

    @Transactional
    @Override
    public Burger remove(long id) {
        Burger found = findById(id);
        entityManager.remove(found);
        return found;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }

    @Override
    public List<Burger> findByPrice(Integer price) {
        TypedQuery<Burger> query = entityManager.createQuery(
                "SELECT b FROM Burger b WHERE b.price > :price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType btype) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType = : bType ORDER BY b.name desc", Burger.class);
     query.setParameter("breadType", btype);
     return query.getResultList();
    }
}
