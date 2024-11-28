package servicio.dto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

public class PuntoDeColocacion {
    private Double latitud;
    private Double longitud;


    public PuntoDeColocacion() {
    }

    // Constructor
    public PuntoDeColocacion(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters y Setters
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


}