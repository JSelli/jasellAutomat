package controller;

import org.json.JSONException;
import reader.CityChecker;
import reader.OutputWriter;
import reader.ReadAPI;
import reader.InputFileReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        ReadAPI readAPI = new ReadAPI();

        //UserInput userInput = new UserInput(readAPI);
        //userInput.getUserInput();

        CityChecker cityChecker = new CityChecker();
        InputFileReader inputFileReader = new InputFileReader(cityChecker);
        OutputWriter outputWriter = new OutputWriter(readAPI, inputFileReader);
        outputWriter.writeToFile();
        outputWriter.writeToMultipleFiles();
    }
}
