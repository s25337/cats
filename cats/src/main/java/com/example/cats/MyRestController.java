package com.example.cats;

import com.example.cats.Exceptions.CatNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MyRestController {

    private MyRestService service;


    @Autowired
    public MyRestController(MyRestService Service) {
        this.service = Service;
    }

    @GetMapping("/cat/races/{race}")
    public ArrayList<Cat> getRace(@PathVariable("race") String race) {

       // if(service.findAllByRace(race).isEmpty()) throw new CatNotFound();
        return service.findAllByRace(race);
    }

    @GetMapping("/cat/id/{id}")
    public Cat getId(@PathVariable("id") long id) {
        return service.findCatById(id);
    }

    @GetMapping("/cats")
    public ArrayList<Cat> getAll() {
        return service.getAll();
    }

    @PostMapping("/send")
    public Cat sendCat(@RequestBody Cat cat) {
        service.sendCat(cat);
        return service.findCatById(cat.getId());
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable long id) {
        service.deleteCatById(id);
    }
    @PutMapping("/edit")
    public Cat editCat(@RequestBody Cat cat) {return service.editCat(cat);}


}