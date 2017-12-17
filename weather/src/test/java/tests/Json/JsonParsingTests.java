package tests.Json;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import weather.CurrentWeather;
import weather.WeeklyWeather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonParsingTests {

    private CurrentWeather cw;
    private WeeklyWeather ww;

    @Before
    public void setup() throws IOException, JSONException {
        List<String> lines = Files.readAllLines(Paths.get("weather/src/test/java/tests/Json/currentWeather.json"));
        this.cw = new CurrentWeather(lines.get(0));
        List<String> lines2 = Files.readAllLines(Paths.get("weather/src/test/java/tests/Json/weeklyWeather.json"));
        this.ww = new WeeklyWeather(lines2.get(0));
    }

    @Test
    public void testCurrentName() throws JSONException {
        assertEquals(cw.getName(), "Tallinn");
    }

    @Test
    public void testCurrentCountry() throws JSONException {
        assertEquals(cw.getCountry(), "EE");
    }

    @Test
    public void testCurrentID() throws JSONException {
        assertEquals(cw.getID(), 590447);
    }

    @Test
    public void testCurrentCoordinates() throws JSONException {
        assertEquals(cw.getCoordinates().toString(), "{\"lon\":24.75,\"lat\":59.44}");
    }

    @Test
    public void testCurrentTemp() throws JSONException {
        assertEquals(cw.getTemp(), 0);
    }

    @Test
    public void testCurrentWeather() throws JSONException {
        assertEquals(cw.getWeather().toString(), "[{\"icon\":\"04d\",\"description\":\"broken clouds\",\"main\":\"Clouds\",\"id\":803}]");
    }

    @Test
    public void testCurrentPressure() throws JSONException {
        assertEquals(cw.getPressure().toString(), "1009");
    }

    @Test
    public void testCurrentHumidity() throws JSONException {
        assertEquals(cw.getHumidity(), 100);
    }

    @Test
    public void testForecastName() throws JSONException {
        assertEquals(ww.getName(), "Tallinn");
    }

    @Test
    public void testForecastCountry() throws JSONException {
        assertEquals(ww.getCountry(), "EE");
    }

    @Test
    public void testForecastID() throws JSONException {
        assertEquals(ww.getID(), 590447);
    }

    @Test
    public void testForecastCoordinates() throws JSONException {
        assertEquals(ww.getCoordinates().toString(), "{\"lon\":24.7454,\"lat\":59.4372}");
    }

    @Test
    public void testForecastWeather() throws JSONException {
        assertEquals(ww.getWeather(), null);
    }

    @Test
    public void testForecastHumidity() throws JSONException {
        assertEquals(ww.getHumidity(), null);
    }

    @Test
    public void testForecastPressure() throws JSONException {
        assertEquals(ww.getPressure(), null);
    }

    @Test
    public void testForecastTemperature() throws JSONException {
        assertEquals(ww.getTemp().toString(), "{\"day2\":\"temp_min:-0.69, temp_max:1.77\",\"day3\":\"temp_min:-1.13, temp_max:1.39\",\"day1\":\"temp_min:-1.53, temp_max:0.53\"}");
    }

}
