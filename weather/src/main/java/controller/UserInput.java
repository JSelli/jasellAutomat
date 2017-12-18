package controller;

import api.ReadAPI;
import org.json.JSONException;
import reader.CityChecker;
import reader.OutputUtil;
import reader.OutputWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


class UserInput {

    private CityChecker cityChecker;
    private OutputUtil outputUtil;
    private OutputWriter outputWriter;

    UserInput(ReadAPI readAPI, OutputWriter outputWriter) throws IOException, JSONException {
        this.outputWriter = outputWriter;
        this.cityChecker = new CityChecker();
        this.outputUtil = new OutputUtil(readAPI);
    }

    void getUserInput() throws IOException, JSONException {
        String town;
        System.out.println("Type \"q\" to exit.");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter city name: ");
                if (scanner.hasNext()) {
                    town = scanner.nextLine();
                    if (cityChecker.isCity(town)) {
                        Path path = Paths.get("weather/src/main/java/writing/userOutput/" + town + ".txt");
                        outputWriter.writeToFile(path, town);
                        System.out.println(outputUtil.outputFormatter(town).values());
                    } else if (town.equals("q")) {
                        break;
                    } else {
                        System.out.println("Not a city!");
                    }
                }
            }
        }
    }
}
