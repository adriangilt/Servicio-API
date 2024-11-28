package servicio;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import servicio.dto.PuntoDeColocacion;
import servicio.dto.UbicacionesRequest;

import java.util.List;

public class ServicioTecnicoCercanoController implements Handler {

    private ServicioUbicacionTecnicos servicioUbicacionTecnicos;

    public ServicioTecnicoCercanoController() {
        super();
        this.servicioUbicacionTecnicos = new ServicioUbicacionTecnicos();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        // Parsear el JSON de entrada
        UbicacionesRequest request = context.bodyAsClass(UbicacionesRequest.class);

        PuntoDeColocacion centro = request.getCentro();
        List<PuntoDeColocacion> ubicaciones = request.getUbicaciones();

        double latitudCentro = centro.getLatitud();
        double longitudCentro = centro.getLongitud();

        // Llamada al servicio de ubicación para obtener el técnico más cercano
        PuntoDeColocacion tecnicoMasCercano = servicioUbicacionTecnicos.obtenerTecnicoMasCercano(latitudCentro, longitudCentro, ubicaciones);

        // Enviar la respuesta en formato JSON
        context.json(tecnicoMasCercano);
    }
}