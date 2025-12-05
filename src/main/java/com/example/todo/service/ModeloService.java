package com.example.todo.service;

import com.example.todo.model.modelo;
import com.example.todo.repository.ModeloRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository repo;

    @PersistenceContext
    private EntityManager em;

    // Crear
    public modelo create(String title, String desc, String ow) {
        modelo mod = new modelo();
        mod.setTitle(title);
        mod.setDescription(desc);
        mod.setStatus("PENDIENTE");
        mod.setDateBegin(LocalDateTime.now());
        mod.setDateEnd(LocalDateTime.now());
        mod.setOwner(ow);
        return repo.save(mod);
    }







}
