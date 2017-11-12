package weather;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        String town;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter city name: ");
                if (scanner.hasNext()) {
                    town = scanner.next();
                    if (Main.isCity(town)) {
                        break;
                    } else {
                        System.out.println("Not a city!");
                    }
                }
            }
        }

        CurrentWeather currentWeather = new CurrentWeather(town);
        System.out.println(currentWeather.getName());
    }

    public static boolean isCity(String town) throws IOException {
        ArrayList<String> cities = Main.allCities();
        return cities.contains(town);
    }

    public static ArrayList<String> allCities() throws IOException {
        String fileName = "C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\reader\\city_list.txt";
        ArrayList<String> cities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                cities.add(line.split("\\s+")[1]);
                line = br.readLine();
            }
        }
        return cities;
    }
}
