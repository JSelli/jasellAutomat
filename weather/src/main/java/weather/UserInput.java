package weather;

import org.json.JSONException;
import reader.CityChecker;

import java.io.IOException;
import java.util.Scanner;


public class UserInput {

    private CityChecker cityChecker;

    public UserInput() throws IOException, JSONException {
        this.cityChecker = new CityChecker();
    }

    public void getUserInput() throws IOException, JSONException {
        String town;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter city name: ");
            if (scanner.hasNext()) {
                town = scanner.nextLine();
                if (cityChecker.isCity(town)) {
                    CurrentWeather currentWeather = new CurrentWeather(town);
                    System.out.println(currentWeather.getName());
                    System.out.println(currentWeather.getWeather());
                } else {
                    System.out.println("Not a city!");
                }
            }
        }
    }
}
