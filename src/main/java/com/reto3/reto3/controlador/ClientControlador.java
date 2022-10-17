package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Client;
import com.reto3.reto3.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientControlador {

    @Autowired
    private ClientService clientService;

    //  /api/Client/all para traerlos todos
    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }
    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client) {
        return clientService.save(client);
    }

}
