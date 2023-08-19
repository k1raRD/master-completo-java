package com.k1rard.hackerrank.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaAPIJson {
    public static void main(String[] args) {
        try {
            getRegistersAPI("un", 100090);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getRegistersAPI(String s, int p) throws IOException {
        // Create a URL object with the endpoint you want to call
        URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?name=" + s );
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set the HTTP request method (GET, POST, PUT, DELETE, etc.)
        connection.setRequestMethod("GET");
        // Get the response code
        int responseCode = connection.getResponseCode();
        // Stringbuilder to store the response
        StringBuilder sb = new StringBuilder();
        // Conditional to know if the request was good
        if(responseCode == 200){
            System.out.println("Response code: " + responseCode);
            // Scanner to read the response
            Scanner scanner = new Scanner(connection.getInputStream());
            String line;
            // While there is a line is going to keep reading
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                sb.append(line);
            }
            scanner.close();
        }

        // Creating the raw data received from the API
        JSONObject rawData = new JSONObject(sb.toString());
        // Storing the data
        JSONArray data = new JSONArray(rawData.getJSONArray("data"));

        // Filtering the data which is greater than p
        int registers = IntStream.range(0, data.length())
                .mapToObj(data::getJSONObject)
                .filter(jsonObject -> jsonObject.getInt("population") > p)
                .reduce(0, (acc, jsonObject) -> acc + 1, Integer::sum);

        return registers;
    }
}
