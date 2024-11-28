package com.example.universitytesttask.repository;

import com.example.universitytesttask.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT l FROM Lector l WHERE CONCAT(l.firstName, ' ', l.lastName) LIKE %:query%")
    List<Lector> findLectorsContainingString(String query);
}
