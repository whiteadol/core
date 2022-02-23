package hello.core;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestAPITest {

    @Test
    public void post() {
        try {

            URL url = new URL("https://api.adotenglish.com/studySenior/returnPrice");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("x-dshare-signature", "Fg4tCMKx8Rvr4u9JjTQC/pbYAlZjGLASGmB0SiEsjRA=");
            conn.setRequestProperty("x-dshare-timestamp", "1641452610196");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            String jsonInputString = "{\"id\":\"seniorTe01\",\"hp\":\"01099999999\",\"class\":\"체크업클래스\"}";
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
                os.flush();
            }

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Sdddddderver .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println("output = "+output + "bug fix");
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
