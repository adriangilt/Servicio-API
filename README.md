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
