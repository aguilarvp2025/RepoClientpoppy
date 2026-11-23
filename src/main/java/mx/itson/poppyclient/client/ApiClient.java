/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.poppyclient.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import mx.itson.poppyclient.entities.Empleado;

public class ApiClient {

    private static final String BASE_URL = "http://127.0.0.1:8000/api/empleados/";
    private final HttpClient http = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public List<Empleado> listar() throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
        verificar(res);
        return gson.fromJson(res.body(), new TypeToken<List<Empleado>>() {}.getType());
    }

    public Empleado crear(Empleado e) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(e)))
                .build();
        HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
        verificar(res);
        return gson.fromJson(res.body(), Empleado.class);
    }

    public Empleado editar(Empleado e) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + e.getId() + "/"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(e)))
                .build();
        HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
        verificar(res);
        return gson.fromJson(res.body(), Empleado.class);
    }

    public void eliminar(int id) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + id + "/"))
                .DELETE()
                .build();
        HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
        verificar(res);
    }

    // Si la API respondió con error (400, 404...), lanza una excepción con su mensaje
    private void verificar(HttpResponse<String> res) throws Exception {
        if (res.statusCode() >= 400) {
            String mensaje = "Error " + res.statusCode();
            try {
                JsonObject obj = gson.fromJson(res.body(), JsonObject.class);
                if (obj.has("error")) {
                    mensaje = obj.get("error").getAsString();
                }
            } catch (Exception ignorada) { }
            throw new Exception(mensaje);
        }
    }
}
    
