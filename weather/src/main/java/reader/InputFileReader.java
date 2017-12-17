package reader;

import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    private ArrayList<String> citiesList;
    private CityChecker cityChecker;

    public InputFileReader(CityChecker cityChecker) throws IOException, JSONException {
        this.cityChecker = cityChecker;
        this.citiesList = readInput();
    }

    private ArrayList<String> readInput() throws IOException, JSONException {
        ArrayList<String> citiesList = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("weather/src/main/java/writing/input.txt"));
        for (String city : lines) {
            if (cityChecker.isCity(city)) {
                citiesList.add(city);
            }
        }
        return citiesList;
    }

    ArrayList<String> getCitiesList() {
        return citiesList;
    }
}
