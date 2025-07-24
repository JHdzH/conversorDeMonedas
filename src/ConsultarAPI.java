import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultarAPI {

    public Moneda convertirMoneda( String codigo, double importe){



        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/26addd48a5cda31854b6ef2b/pair/"+codigo+"/"+importe);
        //System.out.println("Direccion creada: "+direccion);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("\nNo se logró la conversion.\n");
        }
    }
}
