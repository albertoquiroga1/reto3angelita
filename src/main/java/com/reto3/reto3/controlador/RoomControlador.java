package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Room;
import com.reto3.reto3.servicio.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Room")

public class RoomControlador {

    @Autowired
    private RoomService roomService;

    //  /api/Room/all para traerlos todos
    @GetMapping("/all")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int id){
        return roomService.getRoom(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save (@RequestBody Room room) {
        return roomService.save(room);
    }

}
