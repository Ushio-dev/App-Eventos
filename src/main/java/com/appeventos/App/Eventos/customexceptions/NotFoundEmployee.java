package com.appeventos.App.Eventos.customexceptions;

public class NotFoundEmployee extends Exception {
    public NotFoundEmployee(String errorMsg) {
        super(errorMsg);
    }
}
