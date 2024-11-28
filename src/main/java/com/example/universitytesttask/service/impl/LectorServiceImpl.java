package com.example.universitytesttask.service.impl;

import com.example.universitytesttask.model.Lector;
import com.example.universitytesttask.repository.LectorRepository;
import com.example.universitytesttask.service.LectorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public List<Lector> getLectorsContainingQuery(String query) {
        return lectorRepository.findLectorsContainingString(query);
    }
}
