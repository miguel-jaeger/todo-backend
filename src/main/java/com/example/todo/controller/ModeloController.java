package com.example.todo.controller;


import com.example.todo.model.modelo;
import com.example.todo.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    ModeloService svc;

    @PostMapping
    public modelo create (@RequestBody Map<String, String> body) {
        return svc.create(body.get("title"), body.get("description"), body.get("owner"));
    }

}
