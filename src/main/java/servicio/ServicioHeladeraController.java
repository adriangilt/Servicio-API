package servicio;

import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import io.javalin.http.Context;
import servicio.dto.PuntoDeColocacion;


import java.util.List;

public class ServicioHeladeraController implements Handler {

    private ServicioUbicacionHeladeras servicioUbicacionHeladeras;


    public ServicioHeladeraController() {
        super();

        this.servicioUbicacionHeladeras = new ServicioUbicacionHeladeras();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        double latitud= Double.parseDouble(context.queryParam("lat"));
        double longitud = Double.parseDouble(context.queryParam("long"));

        Double radio = 10.0;

        // Llamada al servicio de ubicación para obtener heladeras cercanas
        List<PuntoDeColocacion> puntosHeladerasCercanas = servicioUbicacionHeladeras.obtenerHeladerasCercanas(latitud, longitud, radio);

        // Enviar la respuesta en formato JSON
        context.json(puntosHeladerasCercanas);

    }

}
