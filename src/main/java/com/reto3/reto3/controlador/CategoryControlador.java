package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Category;
import com.reto3.reto3.servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Category")
public class CategoryControlador {
    @Autowired
    private CategoryService categoryService;

    //  /api/Category/all para traerlos todos
    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

@PostMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
public Category save (@RequestBody Category category) {
        return categoryService.save(category);
        }
}





