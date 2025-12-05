package com.example.todo.controller;


import com.example.todo.model.modelo;
import com.example.todo.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    ModeloService svc;

    @PostMapping("/crear")
    public modelo create(@RequestBody Map<String, String> body) {

        String title = body.get("title");
        String desc = body.get("description");
        String owner = body.get("owner");

        LocalDateTime dateBegin = body.get("dateBegin") != null
                ? LocalDateTime.parse(body.get("dateBegin"))
                : null;

        LocalDateTime dateEnd = body.get("dateEnd") != null
                ? LocalDateTime.parse(body.get("dateEnd"))
                : null;

        return svc.create(title, desc, owner, dateBegin, dateEnd);
    }





}
