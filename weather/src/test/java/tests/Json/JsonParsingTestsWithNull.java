package tests.Json;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import weather.CurrentWeather;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonParsingTestsWithNull {

    private CurrentWeather dummy;

    @Before
    public void setup() throws IOException, JSONException {
        this.dummy = new CurrentWeather("");
    }

    @Test
    public void testCurrentName() throws JSONException {
        assertEquals(dummy.getName(), "");
    }

    @Test
    public void testCurrentCountry() throws JSONException {
        assertEquals(dummy.getCountry(), "");
    }

    @Test
    public void testCurrentID() throws JSONException {
        assertEquals(dummy.getID(), "");
    }

    @Test
    public void testCurrentCoordinates() throws JSONException {
        assertEquals(dummy.getCoordinates(), "");
    }

    @Test
    public void testCurrentWeather() throws JSONException {
        assertEquals(dummy.getWeather(), "");
    }

    @Test
    public void testCurrentTemp() throws JSONException {
        assertEquals(dummy.getTemp(), "");
    }

    @Test
    public void testCurrentPressure() throws JSONException {
        assertEquals(dummy.getPressure(), "");
    }

    @Test
    public void testCurrentHumidity() throws JSONException {
        assertEquals(dummy.getHumidity(), "");
    }
}
