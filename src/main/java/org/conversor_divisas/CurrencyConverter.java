package org.conversor_divisas;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_KEY = "tu_api_key_aqui";

    public static double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency + "/" + amount;

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject obj = new JSONObject(response.toString());
        return obj.getDouble("converted_amount");
    }
}