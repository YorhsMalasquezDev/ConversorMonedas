package com.aluracursos.challenge.principal;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaServidor {
    public Moneda buscarMonedas(String monedaBase, String monedaConvertir, double monto){


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/87f1f5679b1c2a18c71a1acd/pair/" + monedaBase + "/" + monedaConvertir + "/" + monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
           // return response.body();
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa moneda");
        }
    }
}
