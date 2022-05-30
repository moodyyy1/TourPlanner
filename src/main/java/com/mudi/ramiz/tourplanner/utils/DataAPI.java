package com.mudi.ramiz.tourplanner.utils;

import com.google.gson.Gson;
import com.mudi.ramiz.tourplanner.models.DirectionsModel;
import com.mudi.ramiz.tourplanner.models.RouteJSONModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class DataAPI {

    public static String key = "a6cF2uMW2EfkpxTisTewwk6z2vSt49yG";

    public static DirectionsModel getDirectionsModel(String fromLocation, String toLocation) {
        HttpClient httpClient = HttpClient.newHttpClient();

        String jsonReq = new Gson().toJson(new RouteJSONModel(fromLocation, toLocation));

        HttpRequest httpRequest = getHTTPRequestWithKey("http://www.mapquestapi.com/directions/v2/route?key=" + key, jsonReq);

        try {
            HttpResponse<String> httpResponse = getCompletableFuture(httpClient, httpRequest).get();

            System.out.println(httpResponse.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpRequest getHTTPRequestWithKey(String url, String jsonReq) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(jsonReq))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    private static CompletableFuture<HttpResponse<String>> getCompletableFuture(HttpClient client, HttpRequest httpRequest) {
        final CompletableFuture<HttpResponse<String>> call = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        call.thenApply(extractBody())
                .thenAccept((body) -> System.out.println(body));

        return call;
    }

    private static Function<HttpResponse<String>, String> extractBody() {
        return HttpResponse::body;
    }

}
