package org.example.microadministrador.services.exception;


public class TarifaNoEncontradaException extends RuntimeException {
    public TarifaNoEncontradaException() {
        super("No se encontró una tarifa anterior o igual a la fecha proporcionada.");
    }
}