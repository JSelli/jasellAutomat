package weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import api.ReadAPI;

import java.io.IOException;
import java.util.HashMap;

public class WeeklyWeather implements WeatherRequest {

    private JSONObject jsonObject;

    public WeeklyWeather(String data) throws JSONException {
        jsonObject = new JSONObject(data);
    }

    public WeeklyWeather(ReadAPI reader) throws IOException, JSONException {
        jsonObject = reader.getJSONNameForecast("Tallinn");
    }

    public WeeklyWeather(ReadAPI reader, String name) throws IOException, JSONException {
        jsonObject = reader.getJSONNameForecast(name);
    }

    public WeeklyWeather(ReadAPI reader, int code) throws IOException, JSONException {
        jsonObject = reader.getJSONCodeForecast(code);
    }

    @Override
    public Object getTemp() throws JSONException {
        if (jsonObject != null) {
            JSONArray object = (JSONArray) jsonObject.get("list");
            return new JSONObject(getAverages(object));
        }
        return "";
    }

    @Override
    public Object getCoordinates() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("city");
            return temp.get("coord");
        }
        return "";
    }

    @Override
    public Object getWeather() throws JSONException {
        return null;
    }

    @Override
    public Object getPressure() {
        return null;
    }

    @Override
    public Object getName() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("city");
            return temp.get("name");
        }
        return "";
    }

    @Override
    public Object getCountry() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("city");
            return temp.get("country");
        }
        return "";
    }

    @Override
    public Object getID() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("city");
            return temp.get("id");
        }
        return "";
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
            days.put("day" + String.valueOf(i / 8 + 1), nums);
        }

        return days;
    }
}
