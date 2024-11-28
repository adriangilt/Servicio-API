
import static io.javalin.apibuilder.ApiBuilder.*;


import io.javalin.Javalin;
import servicio.ServicioHeladeraController;
import servicio.ServicioTecnicoCercanoController;


public class Router {
    private static Javalin app = Application.app();

    public static void init(){

        // ------------------------------------   RUTAS   ------------------------------------------------
        app.routes(() -> {

            path("/api/recomendacion/locaciones", () -> {
                get(new ServicioHeladeraController());
            });

            path("/api/recomendacion/tecnicoCercano", () -> {
                get(new ServicioTecnicoCercanoController());
            });

            path("/404Error", () -> {
                //get(new MostrarErrorPermisosController()); //TODO
            });

        });

        // EXCEPCION
        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
        });
    }
}

// http://localhost:8080/home

// API REST
//app.get("/api/mascotas", new GetMascotasHandler());
//app.get("/api/mascotas/{id}", new GetMascotaIdHandler());
//app.get("/api/mascotas/{id}/imagen", new GetMascotaImgHandler());
//app.post("/api/mascotas", new PostMascotaHandler());
//app.get("/api/mis-datos", new GetPerfilSesionHandler());

//app.post("/api/login", new LoginHandler());

// VISTA
//app.get("/home", new IndexHandler());
//app.get("/info-mascota", new InfoMascotaHandler());
