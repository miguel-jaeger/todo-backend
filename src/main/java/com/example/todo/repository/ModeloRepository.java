package com.example.todo.repository;

import java.util.List;
import com.example.todo.model.modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository <modelo, Long> {
    List<modelo> findByStatus (String status);

}
