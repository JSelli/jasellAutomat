package tests.readAPI;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import api.ReadAPI;
import weather.CurrentWeather;
import weather.WeeklyWeather;

import java.io.IOException;

public class apiCallTests {

    private ReadAPI readAPI = null;

    @Before
    public void createClasses() throws IOException, JSONException {
        this.readAPI = Mockito.mock(ReadAPI.class);
    }

    @Test
    public void testCurrentClassDefault() throws JSONException, IOException {
        CurrentWeather currentWeather = new CurrentWeather(readAPI);
        Mockito.verify(readAPI).getJSONNameDaily("Tallinn");
    }

    @Test
    public void testCurrentClassWithName() throws IOException, JSONException {
        String city = "London";
        CurrentWeather currentWeather = new CurrentWeather(readAPI, city);
        Mockito.verify(readAPI).getJSONNameDaily(city);
    }

    @Test
    public void testCurrentClassWithCode() throws IOException, JSONException {
        CurrentWeather currentWeather = new CurrentWeather(readAPI, 4578456);
        Mockito.verify(readAPI).getJSONCodeDaily(4578456);
    }

    @Test
    public void testForecastClassDefault() throws IOException, JSONException {
        WeeklyWeather weeklyWeather = new WeeklyWeather(readAPI);
        Mockito.verify(readAPI).getJSONNameForecast("Tallinn");
    }

    @Test
    public void testForecastClassWithName() throws IOException, JSONException {
        String city = "London";
        WeeklyWeather weeklyWeather = new WeeklyWeather(readAPI, city);
        Mockito.verify(readAPI).getJSONNameForecast(city);
    }

    @Test
    public void testForecastClassWithID() throws IOException, JSONException {
        int code = 84596230;
        WeeklyWeather weeklyWeather = new WeeklyWeather(readAPI, code);
        Mockito.verify(readAPI).getJSONCodeForecast(code);
    }
}
