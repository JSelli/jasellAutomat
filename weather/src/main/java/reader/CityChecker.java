package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CityChecker {

    private List<String> listOfCities;

    public CityChecker() throws IOException {
        this.listOfCities = allCities();
    }

    public boolean isCity(String town) throws IOException {
        return listOfCities.contains(town);
    }

    private ArrayList<String> allCities() throws IOException {
        ArrayList<String> cities = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("weather/src/main/java/writing/city_list.txt"));
        for (String line : lines) {
            cities.add(line.split("\\t+")[1]);
        }
        return cities;
    }
}
