package org.core.adapters;

import org.core.adapters.exceptions.IncorrectPassword;
import org.core.adapters.exceptions.InvalidRequest;
import org.core.adapters.exceptions.NotFound;
import org.core.models.AuthModel;
import org.core.config.Context;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.core.models.StudentModel;
import org.json.JSONObject;


public class AuthAdapter {

    private final StringBuilder authURl = new StringBuilder(Context.API_URL).append("/auth/login");
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
            case 401 -> throw new IncorrectPassword("Incorrect password");
            case 404 -> throw new NotFound("Student Not Found");
            case 422 -> throw new InvalidRequest("Problem in the request body");
            default -> throw new IllegalStateException("Unexpected value");
        }
    }

    private void transformResponse(String responseBody) {
        JSONObject responseJSON = new JSONObject(responseBody);
        JSONObject data = responseJSON.getJSONObject("student_data");

        StudentModel.getInstance()
                .setAccessToken("Bearer " + responseJSON.getString("token"))
                .setEnrollment(data.getString("MATRICULA"))
                .setNames(data.getString("NOMBRES"))
                .setLastNames(data.getString("APELLIDOS"))
                .setDni(data.getString("CURP"))
                .setGrade(data.getString("GRADO"))
                .setGroup(data.getString("GRUPO"))
                .setStatus(data.getString("STATUSA"));
    }
}

