package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Admin;
import com.reto3.reto3.servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminControlador {

    @Autowired
    private AdminService adminService;

    //  /api/Admin/all para traerlos todos
    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin admin) {
        return adminService.save(admin);
    }
}
