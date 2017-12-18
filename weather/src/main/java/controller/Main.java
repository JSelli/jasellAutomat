package controller;

import api.ReadAPI;
import org.json.JSONException;
import reader.CityChecker;
import reader.InputFileReader;
import reader.OutputWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        ReadAPI readAPI = new ReadAPI();

        //UserInput userInput = new UserInput(readAPI);
        //userInput.getUserInput();

        CityChecker cityChecker = new CityChecker();
        Path inputFilePath = Paths.get("weather/src/main/java/writing/input.txt");
        InputFileReader inputFileReader = new InputFileReader(cityChecker, inputFilePath);
        OutputWriter outputWriter = new OutputWriter(readAPI, inputFileReader);
        outputWriter.writeToFile(inputFilePath);
        outputWriter.writeToMultipleFiles(inputFilePath);
    }
}
