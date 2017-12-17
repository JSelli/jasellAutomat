package controller;

import org.json.JSONException;
import reader.CityChecker;
import reader.OutputUtil;

import java.io.IOException;
import java.util.Scanner;


class UserInput {

    private CityChecker cityChecker;
    private OutputUtil outputUtil;

    UserInput() throws IOException, JSONException {
        this.cityChecker = new CityChecker();
        this.outputUtil = new OutputUtil();
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
                        System.out.println(outputUtil.outputFormatter(town).values());
                    } else if(town.equals("q")) {
                        break;
                    } else {
                        System.out.println("Not a city!");
                    }
                }
            }
        }
    }
}