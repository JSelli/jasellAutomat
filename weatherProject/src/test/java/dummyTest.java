import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class dummyTest {


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
    public void testCurrentWeather() {
    }


    @Test
    public void testWeatherForecastNext() {
    }

    @Test
    public void testLowestTemp() {
    }

    @Test
    public void testHighestTemp() {
    }

    @Test
    public void testCoordinates() {
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
