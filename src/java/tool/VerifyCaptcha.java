/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author amry4
 */
public class VerifyCaptcha {
     public static final String SITE_VERIFY_URL = //
            "https://www.google.com/recaptcha/api/siteverify";
 
    public static boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            System.out.println("GAGAL");
            return false;
        }
 
        try {
            URL verifyUrl = new URL(SITE_VERIFY_URL);
 
            // Open a Connection to URL above.
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
 
            // Add the Header informations to the Request to prepare send to the server.
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Chrome/80.0.3987.149");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
            // Data will be sent to the server.
            String postParams = "secret=" + IdKey.SECRET_KEY //
                    + "&response=" + gRecaptchaResponse;
 
            // Send Request
            conn.setDoOutput(true);
 
            // Get the output stream of Connection.
            // Write data in this stream, which means to send data to Server.
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
 
            outStream.flush();
            outStream.close();
 
            // Response code return from Server.
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode=" + responseCode);
 
            // Get the Input Stream of Connection to read data sent from the Server.
            InputStream is = conn.getInputStream();
 
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
 
            // ==> {"success": true}
            System.out.println("Response: " + jsonObject);
 
            boolean success = jsonObject.getBoolean("success");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//
//    versi 2
//    public static final String urllink = "https://www.google.com/recaptcha/api/siteverify";
//    public static final String secret = IdKey.SECRET_KEY;
//
//    private final static String USER_AGENT = "Mozilla/5.0";
//
//    public static boolean verify(String gRecaptchaResponse) throws IOException {
//        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
//            return false;
//        }
//        try {
//            URL obj = new URL(urllink);
//            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//            // add reuqest header
//            con.setRequestMethod("POST");
//            con.setRequestProperty("User-Agent", USER_AGENT);
//            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//            String postParams = "secret=" + secret + "&response="
//                    + gRecaptchaResponse;
//            // Send post request
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(postParams);
//            wr.flush();
//            wr.close();
//            int responseCode = con.getResponseCode();
//            System.out.println("\nSending 'POST' request to URL : " + urllink);
//            System.out.println("Post parameters : " + postParams);
//            System.out.println("Response Code : " + responseCode);
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            // print result
//            System.out.println(response.toString());
//            //parse JSON response and return 'success' value
//            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
//            JsonObject jsonObject = jsonReader.readObject();
//            jsonReader.close();
//            return jsonObject.getBoolean("success");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
