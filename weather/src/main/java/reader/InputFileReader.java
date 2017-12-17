package reader;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class InputFileReader {

    private ArrayList<String> citiesList;
    private CityChecker cityChecker;

    InputFileReader(CityChecker cityChecker) throws IOException, JSONException {
        this.cityChecker = cityChecker;
        this.citiesList = readInput();
    }

    private ArrayList<String> readInput() throws IOException, JSONException {
        ArrayList<String> citiesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\writing\\input.txt"))) {
            String line = br.readLine();
            while (line != null) {
                if (cityChecker.isCity(line)) {
                    citiesList.add(line);
                }
                line = br.readLine();
            }
        }
        return citiesList;
    }

    ArrayList<String> getCitiesList() {
        return citiesList;
    }
}
