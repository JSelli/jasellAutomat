package weather;

import org.json.JSONException;
import org.json.JSONObject;
import api.ReadAPI;

import java.io.IOException;
import java.util.Objects;

public class CurrentWeather implements WeatherRequest {

    private JSONObject jsonObject;

    public CurrentWeather(String data) throws JSONException {
        if (!Objects.equals(data, "")) {
            jsonObject = new JSONObject(data);
        } else {
            jsonObject = null;
        }
    }

    public CurrentWeather(ReadAPI reader) throws IOException, JSONException {
        jsonObject = reader.getJSONNameDaily("Tallinn");
    }

    public CurrentWeather(ReadAPI reader, String name) throws IOException, JSONException {
        jsonObject = reader.getJSONNameDaily(name);
    }

    public CurrentWeather(ReadAPI reader, int code) throws IOException, JSONException {
        jsonObject = reader.getJSONCodeDaily(code);
    }

    @Override
    public Object getTemp() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("main");
            return temp.get("temp");
        }
        return "";
    }

    @Override
    public Object getCoordinates() throws JSONException {
        if (jsonObject != null) {
            return jsonObject.get("coord");
        }
        return "";
    }

    @Override
    public Object getWeather() throws JSONException {
        if (jsonObject != null) {
            return jsonObject.get("weather");
        }
        return "";
    }

    @Override
    public Object getPressure() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("main");
            return temp.get("pressure");
        }
        return "";
    }

    @Override
    public Object getName() throws JSONException {
        if (jsonObject != null) {
            return jsonObject.get("name");
        }
        return "";
    }

    @Override
    public Object getCountry() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("sys");
            return temp.get("country");
        }
        return "";
    }

    @Override
    public Object getID() throws JSONException {
        if (jsonObject != null) {
            return jsonObject.get("id");
        }
        return "";
    }

    @Override
    public Object getHumidity() throws JSONException {
        if (jsonObject != null) {
            JSONObject temp = (JSONObject) jsonObject.get("main");
            return temp.get("humidity");
        }
        return "";
    }
}
