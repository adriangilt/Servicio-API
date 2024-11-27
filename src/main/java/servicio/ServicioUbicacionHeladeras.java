package servicio;


import servicio.dto.PuntoDeColocacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ServicioUbicacionHeladeras {


    // Método de Haversine para calcular la distancia en km
    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int RADIO_TIERRA = 6371; // Radio de la Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIO_TIERRA * c;
    }

    // Método para obtener heladeras cercanas
    public List<PuntoDeColocacion> obtenerHeladerasCercanas(double latitud, double longitud, double radio) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();

        try {
            // Consulta nativa que devuelve resultados crudos
            List<Object[]> resultados = em.createNativeQuery("SELECT latitud, longitud FROM punto_estrategico")
                    .getResultList();

            // Mapear los resultados crudos a objetos PuntoDeColocacion
            List<PuntoDeColocacion> puntos = resultados.stream()
                    .map(row -> new PuntoDeColocacion(((Number) row[0]).doubleValue(), ((Number) row[1]).doubleValue()))
                    .collect(Collectors.toList());

            System.out.println(puntos.get(0).getLatitud());

            // Filtrar y ordenar los puntos
            List<PuntoDeColocacion> puntosFiltrados = new ArrayList<>();
            for (PuntoDeColocacion punto : puntos) {
                if (calcularDistancia(latitud, longitud, punto.getLatitud(), punto.getLongitud()) <= radio) {
                    puntosFiltrados.add(punto);
                }
            }

            puntosFiltrados.sort((p1, p2) -> Double.compare(
                    calcularDistancia(latitud, longitud, p1.getLatitud(), p1.getLongitud()),
                    calcularDistancia(latitud, longitud, p2.getLatitud(), p2.getLongitud())
            ));

            return puntosFiltrados;
        } finally {
            em.close();
            emf.close();
        }
    }


}