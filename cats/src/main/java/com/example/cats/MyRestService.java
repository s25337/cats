package com.example.cats;


import com.example.cats.Exceptions.CatNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class MyRestService {
    // List mocked = mock(List.class);


    CatRepository repository;

    public MyRestService(CatRepository repository) {
        this.repository = repository;
        this.repository.save(new Cat(1, "black", "John"));
        this.repository.save(new Cat(2, "white", "Mike"));
        this.repository.save(new Cat(3, "grey", "Mili"));
        this.repository.save(new Cat(4, "grey", "Milian"));
        this.repository.save(new Cat(5, "grey", "Emilian"));
        this.repository.save(new Cat(6, "tabby", "Luna"));
    }




    public ArrayList<Cat> findAllByRace(String race) {
        if (this.repository.findAllByRace(race).isEmpty()) throw new CatNotFound();
        return this.repository.findAllByRace(race);
    }


    public Cat findCatById(long id) {
        Optional<Cat> cat = Optional.ofNullable(this.repository.getCatById(id));
        if (cat.isPresent()) return this.repository.getCatById(id);
      //  return this.repository.getCatById(id);
        throw new CatNotFound();
    }

    public ArrayList<Cat> getAll() {
        return (ArrayList<Cat>) this.repository.findAll();
    }


    public void sendCat(Cat cat) {
        if
        this.repository.save(cat);
    }

    public void deleteCatById(long id) {
        this.repository.deleteById(id);
    }

    public Cat editCat(Cat cat) {
        this.repository.deleteCatById(cat.getId());
         this.repository.save(cat);
        return cat;
    }

}

