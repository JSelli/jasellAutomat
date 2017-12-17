package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityChecker {

    private List<String> listOfCities = allCities();

    public CityChecker() throws IOException {
    }

    public boolean isCity(String town) throws IOException {
        return listOfCities.contains(town);
    }

    private ArrayList<String> allCities() throws IOException {
        String fileName = "C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\writing\\city_list.txt";
        ArrayList<String> cities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                cities.add(line.split("\\t+")[1]);
                line = br.readLine();
            }
        }
        return cities;
    }
}
