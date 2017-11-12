package weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reader.ReadAPI;

import java.io.IOException;
import java.util.HashMap;

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
        return new JSONObject(getAverages(object));
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

    private HashMap<String, String> getAverages(JSONArray object) throws JSONException {
        Double min;
        Double max;

        HashMap<String, String> days = new HashMap<>();

        for (int i = 0; i < 24; i += 8) {
            JSONObject jO = new JSONObject(object.get(i).toString());
            JSONObject jsonObject = new JSONObject(jO.get("main").toString());
            min = Double.parseDouble(jsonObject.get("temp_min").toString());
            max = Double.parseDouble(jsonObject.get("temp_max").toString());
            for (int j = i + 1; j < i + 8; j++) {
                JSONObject jsonObject1 = new JSONObject(object.get(j).toString());
                JSONObject jsonObject2 = new JSONObject(jsonObject1.get("main").toString());
                if (Double.parseDouble(jsonObject2.get("temp_min").toString()) < min) {
                    min = Double.parseDouble(jsonObject2.get("temp_min").toString());
                }
                if (Double.parseDouble(jsonObject2.get("temp_max").toString()) > max) {
                    max = Double.parseDouble(jsonObject2.get("temp_max").toString());
                }
            }
            String nums = "temp_min:" + String.valueOf(min) + ", " + "temp_max:" + String.valueOf(max);
            days.put("day" + String.valueOf(i / 8 + 1) + ":", nums);
        }

        return days;
    }
}
