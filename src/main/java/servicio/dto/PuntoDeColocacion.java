package servicio.dto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

public class PuntoDeColocacion {
    private Double latitud;
    private Double longitud;

    // Constructor
    public PuntoDeColocacion(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters
    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }


}