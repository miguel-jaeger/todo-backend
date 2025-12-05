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
    public modelo create(String title, String desc, String ow, LocalDateTime dateBegin, LocalDateTime dateEnd) {
        modelo mod = new modelo();
        mod.setTitle(title);
        mod.setDescription(desc);
        mod.setOwner(ow);
        mod.setStatus("PENDIENTE");

        // Asignar fechas si vienen, si no usar fecha actual
        mod.setDateBegin(dateBegin != null ? dateBegin : LocalDateTime.now());
        mod.setDateEnd(dateEnd != null ? dateEnd : LocalDateTime.now());

        return repo.save(mod);
    }


    // Listar
    public List<modelo> listAll() {
        return repo.findAll();
    }

    // Buscar por id
    public modelo findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Incident not found with id " + id));
    }

    // Eliminar
    public void delete(Long id){
        repo.deleteById(id);
    }

    // Actualizar
    public modelo update(Long id, modelo datos) {
        modelo mod = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el ID " + id));

        mod.setTitle(datos.getTitle());
        mod.setDescription(datos.getDescription());
        mod.setStatus(datos.getStatus());
        mod.setOwner(datos.getOwner());

        if ("COMPLETADO".equalsIgnoreCase(datos.getStatus())) {
            mod.setDateEnd(LocalDateTime.now());
        }

        return repo.save(mod);
    }


}
