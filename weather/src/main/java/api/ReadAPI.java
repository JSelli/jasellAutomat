package api;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;


public class ReadAPI {

    private String key = "2428b4cbc243376503343db78f3acc66";
    private JsonDecoder decoder;

    public ReadAPI() {
        this.decoder = new JsonDecoder();
    }

    public JSONObject getJSONNameDaily(String town) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?q=" + town + "&units=metric&appid=" + key;
        try {
            String text = decoder.readFile(readHTTP(dayURL));
            return new JSONObject(text);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public JSONObject getJSONNameForecast(String town) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/forecast/?q=" + town + "&units=metric&appid=" + key;
        try {
            String text = decoder.readFile(readHTTP(dayURL));
            return new JSONObject(text);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public JSONObject getJSONCodeDaily(int code) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?id=" + String.valueOf(code) + "&units=metric&appid=" + key;
        try {
            String text = decoder.readFile(readHTTP(dayURL));
            return new JSONObject(text);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public JSONObject getJSONCodeForecast(int code) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/forecast/?id=" + String.valueOf(code) + "&units=metric&appid=" + key;
        try {
            String text = decoder.readFile(readHTTP(dayURL));
            return new JSONObject(text);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private InputStream readHTTP(String url) throws IOException {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
                return new URL(url).openStream();
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (UnknownHostException e) {
            System.out.println("No connection!");
            return null;
        }
    }
}
