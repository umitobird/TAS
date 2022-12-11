package com.cht.tas.ap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CallOut {
    public static void IsTest() throws IOException, InterruptedException {

        String postEndpoint = "https://iot.cht.com.tw/apis/CHTIoT/phone-conn/v1/callout";

        String TAS = "{" + "\n" +
                "\"serviceNumber\" : \"0281920772\", " + "\n" +
                "\"phones\" : [\"0988795963\"], " + "\n" +
                "\"ivrData\" : { " + "\n" +
                "\"welcomeText\" : \"Trauma Red\", " + "\n" +
                "\"byeText\" : \"謝謝\", " + "\n" +
                "\"text\" : \"急救室\", " + "\n" +
                "\"repeat\" : 3, " + "\n" +
                "\"betweenTextRepeatDelay\" : 1, " + "\n" +
                "\"promptMode\" : \"M\" " + "\n" +
                "  }" + "\n" +
                "}";

        System.out.println(TAS);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type" , "application/json")
                .header("x-api-key" , "Thj8xPITx3Cd4DP1nUao9sUwahJKrb8D")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(TAS)))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void IsTest1() throws IOException, InterruptedException {

        String postEndpoint = "https://iot.cht.com.tw/apis/CHTIoT/phone-conn/v1/callout";

        String TAS = "{" + "\n" +
                "\"serviceNumber\" : \"0281920772\", " + "\n" +
                "\"phones\" : [\"0988795963\"], " + "\n" +
                "\"ivrData\" : { " + "\n" +
                "\"welcomeText\" : \"Trauma Red\", " + "\n" +
                "\"byeText\" : \"謝謝\", " + "\n" +
                "\"text\" : \"急診外科\", " + "\n" +
                "\"repeat\" : 3, " + "\n" +
                "\"betweenTextRepeatDelay\" : 1, " + "\n" +
                "\"promptMode\" : \"F\" " + "\n" +
                "  }" + "\n" +
                "}";

        System.out.println(TAS);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type" , "application/json")
                .header("x-api-key" , "Thj8xPITx3Cd4DP1nUao9sUwahJKrb8D")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(TAS)))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void IsTest2() throws IOException, InterruptedException {

        String postEndpoint = "https://iot.cht.com.tw/apis/CHTIoT/phone-conn/v1/callout";

        String TAS = "{" + "\n" +
                "\"serviceNumber\" : \"0281920772\", " + "\n" +
                "\"phones\" : [\"0988795963\"], " + "\n" +
                "\"ivrData\" : { " + "\n" +
                "\"welcomeText\" : \"Trauma Red\", " + "\n" +
                "\"byeText\" : \"謝謝\", " + "\n" +
                "\"text\" : \"急救室，不需備血\", " + "\n" +
                "\"repeat\" : 3, " + "\n" +
                "\"betweenTextRepeatDelay\" : 1, " + "\n" +
                "\"promptMode\" : \"M\" " + "\n" +
                "  }" + "\n" +
                "}";

        System.out.println(TAS);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type" , "application/json")
                .header("x-api-key" , "Thj8xPITx3Cd4DP1nUao9sUwahJKrb8D")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(TAS)))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void IsTest3() throws IOException, InterruptedException {

        String postEndpoint = "https://iot.cht.com.tw/apis/CHTIoT/phone-conn/v1/callout";

        String TAS = "{" + "\n" +
                "\"serviceNumber\" : \"0281920772\", " + "\n" +
                "\"phones\" : [\"0988795963\"], " + "\n" +
                "\"ivrData\" : { " + "\n" +
                "\"welcomeText\" : \"Trauma Red\", " + "\n" +
                "\"byeText\" : \"謝謝\", " + "\n" +
                "\"text\" : \"急診外科，不需備血\", " + "\n" +
                "\"repeat\" : 3, " + "\n" +
                "\"betweenTextRepeatDelay\" : 1, " + "\n" +
                "\"promptMode\" : \"F\" " + "\n" +
                "  }" + "\n" +
                "}";

        System.out.println(TAS);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type" , "application/json")
                .header("x-api-key" , "Thj8xPITx3Cd4DP1nUao9sUwahJKrb8D")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(TAS)))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
