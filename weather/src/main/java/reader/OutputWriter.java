package reader;

import org.json.JSONException;
import weather.CurrentWeather;
import weather.WeeklyWeather;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OutputWriter {

    OutputWriter() {

    }

    private void writeOutput(ArrayList<String> text) throws IOException {
        Path file = Paths.get("C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\reader\\output.txt");
        Files.write(file, text, Charset.forName("UTF-8"));

    }


    private void writeToFile() throws IOException, JSONException {
        InputReader inputReader = new InputReader();
        ArrayList<String> cities = inputReader.getCitiesList();

        ArrayList<String> output = new ArrayList<>();

        for (String city : cities) {
            output.add(city);
            CurrentWeather cw = new CurrentWeather(city);
            output.add("Current weather is " + cw.getTemp().toString());
            WeeklyWeather ww = new WeeklyWeather(city);
            output.add("Forecast is " + ww.getWeather().toString());
            output.add("Coordinates are " + cw.getCoordinates().toString());
            output.add("\n");
        }

        writeOutput(output);
    }

    public static void main(String[] args) throws IOException, JSONException {
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.writeToFile();
    }
}
