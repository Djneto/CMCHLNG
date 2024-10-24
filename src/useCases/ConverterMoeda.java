package useCases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConverterMoeda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/d6a50f7638ab907c7693d17f/pair/";


    public void executar(String sourceCoin, String endCoin, double amount) {
        try {

            String requestUrl = API_URL + sourceCoin + "/" + endCoin + "/" + amount;

            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Erro na requisição: Código HTTP " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

            double convertedAmount = jsonResponse.get("conversion_result").getAsDouble();

            System.out.println(amount + " " + sourceCoin + " >> " + convertedAmount + " " + endCoin);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
