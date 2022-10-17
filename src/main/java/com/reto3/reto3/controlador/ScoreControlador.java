package com.reto3.reto3.controlador;

import com.reto3.reto3.entidad.Score;
import com.reto3.reto3.servicio.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")

public class ScoreControlador {

    @Autowired
    private ScoreService scoreService;

    //  /api/Score/all para traerlos todos
    @GetMapping("/all")
    public List<Score> getAll() {
        return scoreService.getAll();
    }

    // para traerlos por id
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id) {
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return scoreService.save(score);
    }
}
