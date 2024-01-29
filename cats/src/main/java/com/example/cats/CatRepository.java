package com.example.cats;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    public ArrayList<Cat> findAllByRace(String race);

    public ArrayList<Cat> findAllById(long id);
   // public Cat findCatById(long id);
    public Cat getCatById(long id);
    public void deleteCatById(long id);
   // public ArrayList<Cat> findCatsByNameContainingIgnoreCase(String race);
}
