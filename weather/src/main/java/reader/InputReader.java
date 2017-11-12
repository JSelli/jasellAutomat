package reader;

import weather.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {

    private ArrayList<String> readInput() throws IOException {
        ArrayList<String> citiesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\reader\\input.txt"))) {
            String line = br.readLine();
            while (line != null) {
                if (Main.isCity(line)) {
                    citiesList.add(line);
                }
                line = br.readLine();
            }
        }
        return citiesList;
    }
}
