package com.workintech.proje18.controller;

import com.workintech.proje18.dao.BurgerDao;
import com.workintech.proje18.entity.Burger;
import com.workintech.proje18.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin("*")
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private  final BurgerDao burgerDao;  //burgerdao bir interface aslında bir sını olusturuluyor, new BurgerDaoImpl deki kodları almak icin

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger)   ;                     // entity ve interface alarak olustuyıruz...
    }


    @GetMapping
    public List<Burger> findAll(){;
        return burgerDao.findAll()

    }



    @GetMapping("/{id}")
    public Burger get(@PathVariable("id") long id){
        return burgerDao.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }


    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price){
        return burgerDao.findByPrice(price);
    }
}
