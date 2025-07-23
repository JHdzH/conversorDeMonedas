import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultarAPI {

    public Moneda convertirMoneda(int opcion, double importe){

        List<String> codigos = new ArrayList<>();
        codigos.add("MXN/ARS");
        codigos.add("ARS/MXN");
        codigos.add("MXN/BRL");
        codigos.add("BRL/MXN");
        codigos.add("MXN/COP");
        codigos.add("COP/MXN");

        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/26addd48a5cda31854b6ef2b/pair/"+codigos.get(opcion-1)+"/"+importe);
        System.out.println("Direcion creada: "+direccion);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("\nNo encontré el tipo de Moneda.\n");
        }
    }
}
