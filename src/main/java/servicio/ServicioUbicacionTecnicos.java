package servicio;

import servicio.dto.PuntoDeColocacion;

import java.util.List;

public class ServicioUbicacionTecnicos {

    public PuntoDeColocacion obtenerTecnicoMasCercano(double latitudCentro, double longitudCentro, List<PuntoDeColocacion> ubicaciones) {
        PuntoDeColocacion tecnicoMasCercano = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (PuntoDeColocacion ubicacion : ubicaciones) {
            double distancia = calcularDistancia(latitudCentro, longitudCentro, ubicacion.getLatitud(), ubicacion.getLongitud());
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                tecnicoMasCercano = ubicacion;
            }
        }

        return tecnicoMasCercano;
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distancia en kilómetros
    }
}