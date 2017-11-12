package tests;

import org.json.JSONException;
import org.junit.Test;
import weather.CurrentWeather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;


public class WeatherTester {


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
    public void testCurrentWeather() throws IOException, JSONException {
        CurrentWeather currentWeather = new CurrentWeather("Tallinn");
        System.out.println(currentWeather.getWeather());
    }

    @Test
    public void testCorrectCity() throws IOException, JSONException {
        CurrentWeather currentWeather = new CurrentWeather("Tallinn");
        assertEquals(currentWeather.getName().toString(), "Tallinn");
    }


    @Test
    public void testHumidity() throws IOException, JSONException {
        CurrentWeather currentWeather = new CurrentWeather("Tallinn");
        assertEquals(Integer.parseInt(currentWeather.getHumidity().toString()), 50, 50.0);
    }

    @Test
    public void testLowestTemp() {
    }

    @Test
    public void testHighestTemp() {
    }

    @Test
    public void testCoordinates() throws IOException, JSONException {
        CurrentWeather currentWeather = new CurrentWeather("Tallinn");
        assertEquals(currentWeather.getCoordinates().toString(), "{\"lon\":24.75,\"lat\":59.44}");
    }

    @Test
    public void testCoordinateInput() {
    }
    // Checks if the coordinates are valid

    @Test
    public void testCoordinatesMatchWeather() {
    }

    @Test
    public void JSONformat() {
    }

    @Test
    public void cityExists() {
    }

    @Test
    public void newRecord() {
    }

    @Test
    public void temperatureFormat() {
    }

    @Test
    public void cityNameFormat() {
    }


}
