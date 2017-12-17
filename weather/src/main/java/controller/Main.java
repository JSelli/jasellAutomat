package controller;

import org.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        UserInput userInput = new UserInput();
        userInput.getUserInput();

        /*CityChecker cityChecker = new CityChecker();
        OutputWriter outputWriter = new OutputWriter(cityChecker);
        outputWriter.writeToFile();
        outputWriter.writeToMultipleFiles();*/
    }
}
