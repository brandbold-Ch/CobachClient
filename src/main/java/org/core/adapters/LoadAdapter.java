package org.core.adapters;

import org.core.adapters.exceptions.InvalidRequest;
import org.core.config.Register;
import org.core.models.DetailsModel;
import org.core.models.LoadsModel;
import org.core.models.StudentModel;
import org.core.models.SubjectModel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class LoadAdapter {

    private final StringBuilder loadsURL = new StringBuilder(Register.API_URL).append("/students/S/loads/?partial=P");
    private final HttpClient client = HttpClient.newHttpClient();

    public ArrayList<LoadsModel> get(String enrollment, int partial) throws IOException,
            InterruptedException, InvalidRequest {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(loadsURL.toString()
                        .replace("S", enrollment)
                        .replace("P", String.valueOf(partial)))
                )
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", Register.ACCESS_TOKEN)
                .GET()
                .build();

        return responseHandler(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    private ArrayList<LoadsModel> responseHandler(HttpResponse<String> response) throws InvalidRequest {
        return switch (response.statusCode()) {
            case 200 -> transformResponse(response.body());
            case 422 -> throw new InvalidRequest("Problem in the request body");
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    private ArrayList<LoadsModel> transformResponse(String responseBody) {
        ArrayList<LoadsModel> list = new ArrayList<>();

        JSONObject responseJSON = new JSONObject(responseBody);
        JSONArray loadData = responseJSON.getJSONArray("CARGA");
        JSONObject detailData = responseJSON.optJSONObject("DETALLES");

        if (detailData != null) {
            StudentModel.getInstance()
                    .setDetails(new DetailsModel(
                    detailData.getInt("TOTAL_FALTAS"),
                    detailData.getDouble("PROMEDIO_FINAL")
            ));
        }

        for (int item = 0; item < loadData.length(); item++) {
            JSONObject loadParsed = loadData.getJSONObject(item);
            JSONObject subjectParsed = loadParsed.getJSONObject("DATOS_MATERIA");
            LoadsModel student = new LoadsModel();
            SubjectModel subject = new SubjectModel();

            subject.setSubject(subjectParsed.getString("ASIGNATURA"));
            subject.setClave(subjectParsed.getString("CLAVE"));
            subject.setClaveIn(subjectParsed.getString("CLAVE_IN"));

            student.setEnrollment(loadParsed.getString("MATRICULA"));
            student.setClaveIn(loadParsed.getString("CLAVE_IN"));
            student.setClaveMat(loadParsed.getString("CLAVEMAT"));
            student.setPartial1(loadParsed.getString("PARCIAL_1"));
            student.setFaults1(loadParsed.getString("FALTAS_1"));
            student.setPartial2(loadParsed.getString("PARCIAL_2"));
            student.setFaults2(loadParsed.getString("FALTAS_2"));
            student.setPartial3(loadParsed.getString("PARCIAL_3"));
            student.setFaults3(loadParsed.getString("FALTAS_3"));
            student.setAverage(loadParsed.getString("PROMEDIO"));
            student.setObservation(loadParsed.get("OBSERVA"));
            student.setWord(loadParsed.get("PALABRA"));
            student.setSubject(subject);

            list.add(student);
        }
        return list;
    }

    private void setFieldValueUnsafe() {}
}
