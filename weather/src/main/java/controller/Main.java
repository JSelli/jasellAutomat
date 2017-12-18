package controller;

import api.ReadAPI;
import org.json.JSONException;
import reader.CityChecker;
import reader.InputFileReader;
import reader.OutputWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {

        ReadAPI readAPI = new ReadAPI();
        System.out.println("Type \"r\" to read from file, type \"i\" to enter an input.");
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equals("r")) {
                    CityChecker cityChecker = new CityChecker();
                    Path inputFilePath = Paths.get("weather/src/main/java/writing/input.txt");
                    InputFileReader inputFileReader = new InputFileReader(cityChecker, inputFilePath);
                    OutputWriter outputWriter = new OutputWriter(readAPI, inputFileReader);
                    outputWriter.writeToFile(inputFilePath);
                    outputWriter.writeToMultipleFiles(inputFilePath);
                    System.out.println("Your files are located in the writing/output folder.");
                } else if (command.equals("i")) {
                    OutputWriter output = new OutputWriter(readAPI);
                    UserInput userInput = new UserInput(readAPI, output);
                    userInput.getUserInput();
                    System.out.println("Your files are located in the writing/userOutput folder.");
                }

            }
        }
    }
}
