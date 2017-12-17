package tests.online;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import reader.CityChecker;
import reader.ReadAPI;
import weather.CurrentWeather;
import weather.WeeklyWeather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WeatherTester {

    private CurrentWeather currentWeather;
    private WeeklyWeather weeklyWeather;

    @Before
    public void initiate() throws IOException, JSONException {
        ReadAPI readAPI = new ReadAPI();
        this.currentWeather = new CurrentWeather(readAPI);
        this.weeklyWeather = new WeeklyWeather(readAPI);
    }

    @Test
    public void testHttpConnectionToExampleApi() {
        try {
            InputStream
                    in = new URL("http://api.openweathermap.org/data/2.5/weather?id=588409&appid=2428b4cbc243376503343db78f3acc66").openStream();
        } catch (MalformedURLException e) {
            System.out.println("Wrong URL!");
        } catch (IOException e) {
            System.out.println("IO exception.");
        }
    }

    @Test(expected = IOException.class)
    public void testHttpFail() throws IOException {
        InputStream
                in = new URL("http://api.openweathermap.org/data/2.5/weather?id=588409&appid=2428b4cbc23343db78f3acc66").openStream();

    }

    @Test
    public void testHumidity() throws IOException, JSONException {
        assertEquals(Integer.parseInt(currentWeather.getHumidity().toString()), 50, 50.0);
    }

    @Test
    public void testCurrentCoordinates() throws IOException, JSONException {
        assertEquals(currentWeather.getCoordinates().toString(), "{\"lon\":24.75,\"lat\":59.44}");
    }

    @Test
    public void testCurrentName() throws JSONException {
        assertEquals(currentWeather.getName().toString(), "Tallinn");
    }

    @Test
    public void testCurrentID() throws JSONException {
        assertEquals(currentWeather.getID().toString(), "590447");
    }

    @Test
    public void testCurrentCountry() throws JSONException {
        assertEquals(currentWeather.getCountry().toString(), "EE");
    }

    @Test
    public void cityExists() throws IOException, JSONException {
        String city = "Tallinn";
        CityChecker cityChecker = new CityChecker();
        assertEquals(cityChecker.isCity(city), true);
    }

    @Test
    public void cityDoesNotExist() throws IOException, JSONException {
        String city = "Obviously not a city";
        CityChecker cityChecker = new CityChecker();
        assertEquals(cityChecker.isCity(city), false);
    }

    @Test
    public void testWeeklyName() throws JSONException, IOException {
        assertEquals(weeklyWeather.getName(), "Tallinn");
    }

    @Test
    public void testWeeklyCoordinates() throws JSONException, IOException {
        assertEquals(weeklyWeather.getCoordinates().toString(), "{\"lon\":24.7454,\"lat\":59.4372}");
    }

    @Test
    public void testWeeklyID() throws JSONException {
        assertEquals(weeklyWeather.getID().toString(), "590447");
    }

    @Test
    public void testWeeklyCountry() throws JSONException {
        assertEquals(weeklyWeather.getCountry().toString(), "EE");
    }

    @Test
    public void testTempPositive() throws JSONException {
        assertTrue(Integer.parseInt(currentWeather.getTemp().toString()) < 100);
    }

    @Test
    public void testTempNegative() throws JSONException {
        assertTrue(-40 < Integer.parseInt(currentWeather.getTemp().toString()));
    }
}
