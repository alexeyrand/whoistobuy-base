package ru.alexeyrand.whoistobuybase.rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WitbHttpClient {
    HttpClient client;
    public WitbHttpClient() {
        client = HttpClient.newHttpClient();
    }

    public void sendMessage(String destination) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(destination))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessagePost(String destination, String message) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(destination))
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJRV05sMENiTXY1SHZSV29CVUpkWjVNQURXSFVDS0NWODRlNGMzbEQtVHA0In0.eyJleHAiOjIwNzM5NDE1OTIsImlhdCI6MTc1ODU4MTU5MiwianRpIjoiOWYxMTQ4MzktMzFiNy00OTVlLThmYmMtMjQ4OGJkMTlmNjg2IiwiaXNzIjoiaHR0cHM6Ly9zc28uZXhvbHZlLnJ1L3JlYWxtcy9FeG9sdmUiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMWYwNWJlMWMtNGJjZS00YjQ4LThiNDctMjdhNGVjZDczYzhlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiNGEwODAxMzQtZTdiMy00NTJlLWJmZmYtMTFlOWZlMTM4N2M1Iiwic2Vzc2lvbl9zdGF0ZSI6Ijg4NTBiZTBiLTA0ZDItNGU5NS04NDc2LTYzNmQ2YjFlM2U5NiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1leG9sdmUiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJleG9sdmVfYXBwIHByb2ZpbGUgZW1haWwiLCJzaWQiOiI4ODUwYmUwYi0wNGQyLTRlOTUtODQ3Ni02MzZkNmIxZTNlOTYiLCJ1c2VyX3V1aWQiOiI1ODU1NWNkNy0yMTQ2LTQzZDktYjRmYS00NTRiM2RjNWRmZTQiLCJjbGllbnRJZCI6IjRhMDgwMTM0LWU3YjMtNDUyZS1iZmZmLTExZTlmZTEzODdjNSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjE3Mi4xNi4xNjEuMTkiLCJhcGlfa2V5Ijp0cnVlLCJhcGlmb25pY2Ffc2lkIjoiNGEwODAxMzQtZTdiMy00NTJlLWJmZmYtMTFlOWZlMTM4N2M1IiwiYmlsbGluZ19udW1iZXIiOiIxMzQ3MTgxIiwiYXBpZm9uaWNhX3Rva2VuIjoiYXV0ODA3YmI3ZTktNzg2ZC00NTc0LWE3ZmUtNTlkZTI3MWM4Mjc1IiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LTRhMDgwMTM0LWU3YjMtNDUyZS1iZmZmLTExZTlmZTEzODdjNSIsImN1c3RvbWVyX2lkIjoiMTQ4MzY3IiwiY2xpZW50QWRkcmVzcyI6IjE3Mi4xNi4xNjEuMTkifQ.k5JVafQOUCYQAYdD6XJGuXMc0fL3WBADoaj9lDI7P8OS8bvFGOVyca0uEhv0UVYLxeEQmKzAlZEQHYgs7LHe4tArHl-tKgj-8z4uBpmy4w0Q2ySAwBROY3m7f6A-kEjAU7zH7gc7fkqrO0VxNNzEBKb98hf_gIxO7MhQBo4llfT0xrXAA0zkZySAnvaHJ4IPROqs7Jq5WOjouaRSU_oR6f1seITS_EBEl0ilsjoHnrqkR6ljWH7HWBeDKhJT0wt1nwXLnvYZVzB7TfIHqWg2yyhTitum9PKtMRofKljwcJchcbNhPwmlLfv4BOLMAgGHYSkGADWn7Nbpz3UUj24NPw")
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}