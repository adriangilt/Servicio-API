# Servicio de Recomendación de Donación

Este proyecto proporciona un servicio que recomienda lugares cercanos para acercar donaciones basándose en una ubicación geográfica. El sistema está diseñado para ayudar a la ONG a expandir su red de donaciones a otras comunidades.

## Descripción del Servicio

El servicio recibe las coordenadas geográficas (latitud y longitud) a través de un parámetro de consulta en una solicitud HTTP y devuelve una lista de lugares cercanos donde se pueden realizar donaciones. La lógica de negocio está basada en un radio de búsqueda de 10 km alrededor de las coordenadas proporcionadas.

## Endpoint

### `GET /api/recomendacion/locaciones`

Este endpoint recibe dos parámetros en la URL (`lat` y `long`) que representan la latitud y longitud de la ubicación desde la cual se buscarán los lugares de donación cercanos.

#### Parámetros

- **lat** (requerido): Latitud de la ubicación de referencia.
- **long** (requerido): Longitud de la ubicación de referencia.

#### Ejemplo de uso

```bash
GET /api/recomendacion/locaciones?lat=13.000001&long=13.000002
```

==========================================================================================================
==========================================================================================================
==========================================================================================================

**Servicio: `Servicio de Ubicacion mas Cercana`**
### Documentación Funcional

**Descripción:**
El `ServicioTecnicoCercanoController` es responsable de manejar las solicitudes a la API que recibe un JSON con varias latitudes y longitudes. El objetivo es identificar el punto central y encontrar la ubicación más cercana a este punto central.

**Entradas:**
- JSON con la estructura:
  ```json
  {
    "centro": {
      "latitud": double,
      "longitud": double
    },
    "ubicaciones": [
      {
        "latitud": double,
        "longitud": double
      },
      ...
    ]
  }
  ```

**Salidas:**
- JSON con la ubicación más cercana al punto central:
  ```json
  {
    "latitud": double,
    "longitud": double
  }
  

**Flujo de Trabajo:**
1. El cliente envía una solicitud HTTP POST con un JSON que contiene el punto central y una lista de ubicaciones.
2. El `ServicioTecnicoCercanoController` procesa la solicitud y deserializa el JSON.
3. Se llama al servicio `ServicioUbicacionTecnicos` para calcular la ubicación más cercana al punto central.
4. El controlador devuelve la ubicación más cercana en formato JSON.
