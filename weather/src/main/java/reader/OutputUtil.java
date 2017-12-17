package reader;

import org.json.JSONException;
import org.json.JSONObject;
import weather.CurrentWeather;
import weather.WeeklyWeather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputUtil {

    public HashMap<String, String> outputFormatter(String city) throws IOException, JSONException {

        HashMap<String, String> data = new HashMap<>();
        List<String> cityData = new ArrayList<>();
        CurrentWeather cw = new CurrentWeather(city);
        WeeklyWeather ww = new WeeklyWeather(city);

        cityData.add(city + "\n");
        cityData.add("Coordinates are " + cw.getCoordinates().toString().replace(",", " ").
                replace("{", "").replace("}", "").replace("\"", "") + "\n");
        String forecast = weeklyDataFormatter(ww.getWeather().toString());
        cityData.add("Forecast for the following days is: " + forecast + "\n");
        cityData.add("Current weather is " + cw.getTemp().toString() + "°C" + "\n");
        String output = cityData.toString().replaceAll("\\[", "")
                .replaceAll("]", "").replaceAll(",", "");
        data.put(city, output);

        return data;
    }

    private String weeklyDataFormatter(String data) throws JSONException {
        StringBuilder sb = new StringBuilder();
        try {
            JSONObject jsonObject = new JSONObject(data);
            sb.append("day 1 temperatures are ").append(jsonObject.get("day1")).append(";").append(" ");
            sb.append("day 2 temperatures are ").append(jsonObject.get("day2")).append(";").append(" ");
            sb.append("day 3 temperatures are ").append(jsonObject.get("day3")).append(".");
            return sb.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
