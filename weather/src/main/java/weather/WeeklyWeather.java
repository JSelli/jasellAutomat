package weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reader.ReadAPI;

import java.io.IOException;

public class WeeklyWeather implements WeatherRequest {

    private JSONObject jsonObject;

    public WeeklyWeather() throws IOException, JSONException {
        ReadAPI reader = new ReadAPI();
        jsonObject = reader.getJSONNameForecast("Tallinn");
    }

    public WeeklyWeather(String name) throws IOException, JSONException {
        ReadAPI reader = new ReadAPI();
        jsonObject = reader.getJSONNameForecast(name);
    }

    @Override
    public Object getWeather() throws JSONException {
        JSONArray object = (JSONArray) jsonObject.get("list");

        for (int i = 0; i < 40; i++) {
            JSONObject jO = new JSONObject(object.get(i).toString());
            System.out.println(jO.get("main"));
        }



        return object;
    }

    @Override
    public Object getCoordinates() {
        return null;
    }

    @Override
    public Object getTemp() {
        return null;
    }

    @Override
    public Object getPressure() {
        return null;
    }

    @Override
    public Object getName() {
        return null;
    }

    @Override
    public Object getCountry() {
        return null;
    }

    @Override
    public Object getID() {
        return null;
    }

    @Override
    public Object getHumidity() throws JSONException {
        return null;
    }
}
