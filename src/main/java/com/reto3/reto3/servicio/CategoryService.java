package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Category;
import com.reto3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired

    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save (Category category) {
        if(category.getId()== null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> categoryEncontrado = categoryRepository.getCategory(category.getId());
            if(categoryEncontrado.isEmpty()){
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

}
