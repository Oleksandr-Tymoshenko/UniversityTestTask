package com.example.universitytesttask.service;

import com.example.universitytesttask.model.Lector;
import java.util.List;

public interface LectorService {
    List<Lector> getLectorsContainingQuery(String query);
}
