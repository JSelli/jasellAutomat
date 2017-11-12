package weather;

import org.json.JSONException;

interface WeatherRequest {

    Object getWeather() throws JSONException;

    Object getCoordinates() throws JSONException;

    Object getTemp() throws JSONException;

    Object getPressure() throws JSONException;

    Object getName() throws JSONException;

    Object getCountry() throws JSONException;

    Object getID() throws JSONException;

    Object getHumidity() throws JSONException;

}
