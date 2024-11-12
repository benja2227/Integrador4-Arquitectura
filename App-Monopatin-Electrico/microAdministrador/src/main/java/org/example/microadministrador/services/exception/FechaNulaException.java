package org.example.microadministrador.services.exception;



public class FechaNulaException extends RuntimeException {
    public FechaNulaException() {
        super("La fecha proporcionada no puede ser nula.");
    }
}
