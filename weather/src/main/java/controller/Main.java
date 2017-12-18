package controller;

import api.ReadAPI;
import org.json.JSONException;
import reader.OutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        ReadAPI readAPI = new ReadAPI();

        OutputWriter output = new OutputWriter(readAPI);
        UserInput userInput = new UserInput(readAPI, output);
        userInput.getUserInput();

        /*CityChecker cityChecker = new CityChecker();
        Path inputFilePath = Paths.get("weather/src/main/java/writing/input.txt");
        InputFileReader inputFileReader = new InputFileReader(cityChecker, inputFilePath);
        OutputWriter outputWriter = new OutputWriter(readAPI, inputFileReader);
        outputWriter.writeToFile(inputFilePath);
        outputWriter.writeToMultipleFiles(inputFilePath);*/
    }
}
