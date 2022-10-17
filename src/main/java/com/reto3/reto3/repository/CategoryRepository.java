package com.reto3.reto3.repository;

import com.reto3.reto3.entidad.Category;
import com.reto3.reto3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    //el optional me permite evitar errores si se mandan datos nulos o id que no existen
    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }

    public void delete(Category category) {
       categoryCrudRepository.delete(category);
    }

}
