package reader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;


public class ReadAPI {

    private String key = "2428b4cbc243376503343db78f3acc66";


    public static void main(String[] args) throws IOException, JSONException {

        String key = "2428b4cbc243376503343db78f3acc66";
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?id=588409&units=metric&appid=2428b4cbc243376503343db78f3acc66";
        String weeklyURL = "http://api.openweathermap.org/data/2.5/forecast/?id=588409&units=metric&APPID=2428b4cbc243376503343db78f3acc66";
        ReadAPI ReadAPI = new ReadAPI();
        String text = ReadAPI.readFile(ReadAPI.readHTTP(dayURL));
        //reader.ReadAPI.getInfo(text);
        //JSObject jsObject = new JSObject();
        //JSONListAdapter listAdapter = new JSONListAdapter(jsObject, Global.instance());
        JSONObject object = new JSONObject(text);
        System.out.println(object);
    }

    public JSONObject getJSONNameDaily(String town) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?q=" + town + "&units=metric&appid=" + key;
        String text = readFile(readHTTP(dayURL));
        return new JSONObject(text);
    }

    public JSONObject getJSONNameForecast(String town) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/forecast/?q=" + town + "&units=metric&appid=" + key;
        String text = readFile(readHTTP(dayURL));
        return new JSONObject(text);
    }

    JSONObject getJSONCode(String code) throws IOException, JSONException {
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?id=" + code + "&units=metric&appid=" + key;
        String text = readFile(readHTTP(dayURL));
        return new JSONObject(text);
    }

    private InputStream readHTTP(String url) throws IOException {
        try {
            return new URL(url).openStream();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private String readFile(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder text = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            text.append(line);
            line = bufferedReader.readLine();
        }

        return text.toString();
    }
}
