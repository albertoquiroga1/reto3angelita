package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Reservation;
import com.reto3.reto3.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")
public class ReservationControlador {

    @Autowired
    private ReservationService reservationService;

    //  /api/Reservation/all para traerlos todos
    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
}
