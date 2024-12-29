package org.core.adapters;

import org.core.adapters.exceptions.IncorrectPassword;
import org.core.adapters.exceptions.InvalidRequest;
import org.core.adapters.exceptions.NotFound;
import org.core.models.AuthModel;
import org.core.config.Register;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.core.models.StudentModel;
import org.json.JSONObject;


public class AuthAdapter {

    private final StringBuilder authURl = new StringBuilder(Register.API_URL).append("/auth/login");
    private final HttpClient client = HttpClient.newHttpClient();

    public boolean post(String username, String password)
            throws IOException, NotFound, IncorrectPassword, InvalidRequest, InterruptedException {
        String authModel = new AuthModel(username, password).toJSON();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authURl.toString()))
                .version(HttpClient.Version.HTTP_1_1)
                .POST(HttpRequest.BodyPublishers.ofString(authModel))
                .build();
        responseHandler(client.send(request, HttpResponse.BodyHandlers.ofString()));

        return true;
    }

    private void responseHandler(HttpResponse<String> response)
            throws NotFound, IncorrectPassword, InvalidRequest {

        switch (response.statusCode()) {
            case 200 -> transformResponse(response.body());
            case 401 -> throw new IncorrectPassword("Contraseña Incorrecta");
            case 404 -> throw new NotFound("El estudiante no existe");
            case 422 -> throw new InvalidRequest("Problema en la solicitud");
            default -> throw new IllegalStateException("Error en la aplicación");
        }
    }

    private void transformResponse(String responseBody) {
        JSONObject responseJSON = new JSONObject(responseBody);
        Register.ACCESS_TOKEN = "Bearer " + responseJSON.getString("token");
        JSONObject data = responseJSON.getJSONObject("student_data");

        StudentModel.getInstance()
                .setEnrollment(data.getString("MATRICULA"))
                .setNames(data.getString("NOMBRES"))
                .setLastNames(data.getString("APELLIDOS"))
                .setDni(data.getString("CURP"))
                .setGrade(data.getString("GRADO"))
                .setGroup(data.getString("GRUPO"))
                .setStatus(data.getString("STATUSA"));
    }
}
