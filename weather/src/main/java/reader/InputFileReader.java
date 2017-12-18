package reader;

import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    private ArrayList<String> citiesList;
    private CityChecker cityChecker;

    public InputFileReader(CityChecker cityChecker, Path path) throws IOException, JSONException {
        this.cityChecker = cityChecker;
        this.citiesList = readInput(path);
    }

    public ArrayList<String> readInput(Path path) throws IOException, JSONException {
        ArrayList<String> citiesList = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);
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
