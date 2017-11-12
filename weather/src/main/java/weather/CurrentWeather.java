package weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class CurrentWeather implements WeatherRequest {

    private JSONObject jsonObject;

    public CurrentWeather(String name) throws IOException, JSONException {
        ReadAPI reader = new ReadAPI();
        jsonObject = reader.getJSONName(name);
    }

    @Override
    public Object getWeather() throws JSONException {
        return jsonObject.get("weather");
    }

    @Override
    public Object getCoordinates() throws JSONException {
        return jsonObject.get("coord");
    }

    @Override
    public Object getTemp() throws JSONException {
        JSONObject temp = (JSONObject) jsonObject.get("main");
        return temp.get("temp");
    }

    @Override
    public Object getPressure() throws JSONException {
        JSONObject temp = (JSONObject) jsonObject.get("main");
        return temp.get("pressure");
    }

    @Override
    public Object getName() throws JSONException {
        return jsonObject.get("name");
    }

    @Override
    public Object getCountry() throws JSONException {
        JSONObject temp = (JSONObject) jsonObject.get("sys");
        return temp.get("country");
    }

    @Override
    public Object getID() throws JSONException {
        return jsonObject.get("id");
    }

    @Override
    public Object getHumidity() throws JSONException {
        JSONObject temp = (JSONObject) jsonObject.get("main");
        return temp.get("humidity");
    }
}
