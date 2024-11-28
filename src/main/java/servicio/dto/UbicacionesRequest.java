package servicio.dto;

import java.util.List;

public class UbicacionesRequest {
    private PuntoDeColocacion centro;
    private List<PuntoDeColocacion> ubicaciones;

    // Getters y Setters
    public PuntoDeColocacion getCentro() {
        return centro;
    }

    public void setCentro(PuntoDeColocacion centro) {
        this.centro = centro;
    }

    public List<PuntoDeColocacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<PuntoDeColocacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}