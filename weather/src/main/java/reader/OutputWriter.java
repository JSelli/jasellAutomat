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

    private CityChecker cityChecker;

    private OutputWriter(CityChecker cityChecker) {
        this.cityChecker = cityChecker;
    }

    private void writeOutput(ArrayList<String> text) throws IOException {
        Path file = Paths.get("C:\\Users\\Jaagup\\IdeaProjects\\jasellAutomat\\weather\\src\\main\\java\\reader\\output.txt");
        Files.write(file, text, Charset.forName("UTF-8"));

    }


    private void writeToFile() throws IOException, JSONException {
        InputFileReader inputFileReader = new InputFileReader(cityChecker);
        ArrayList<String> cities = inputFileReader.getCitiesList();

        ArrayList<String> output = new ArrayList<>();

        for (String city : cities) {
            System.out.println(city);
            output.add(city);
            CurrentWeather cw = new CurrentWeather(city);
            output.add("Current weather is " + cw.getTemp().toString() + "°C");
            WeeklyWeather ww = new WeeklyWeather(city);
            output.add("Forecast is " + ww.getWeather().toString());
            output.add("Coordinates are " + cw.getCoordinates().toString().
                    replace("{", "").replace("}", "").replace("\"", ""));
        }

        writeOutput(output);
    }

    public static void main(String[] args) throws IOException, JSONException {
        CityChecker cityChecker = new CityChecker();
        OutputWriter outputWriter = new OutputWriter(cityChecker);
        outputWriter.writeToFile();
    }
}
