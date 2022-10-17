package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Message;
import com.reto3.reto3.servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageControlador {

    @Autowired
    private MessageService messageService;

    //  /api/Message/all para traerlos todos
    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message message) {
        return messageService.save(message);
    }
}
