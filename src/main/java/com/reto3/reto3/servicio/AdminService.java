package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Admin;
import com.reto3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save (Admin admin) {
        if(admin.getIdAdmin()== null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if(adminEncontrado.isEmpty()){
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

}
