package com.example.universitytesttask.exception;

public class UniversityEntityNotFound extends RuntimeException {
    public UniversityEntityNotFound(String entityName) {
        super(String.format("Couldn't find department %s", entityName));
    }
}
