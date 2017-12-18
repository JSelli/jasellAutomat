package reader;

import api.ReadAPI;
import org.json.JSONException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OutputWriter {

    private final InputFileReader inputFileReader;
    private OutputUtil outputUtil;

    public OutputWriter(ReadAPI readAPI, InputFileReader inputFileReader) throws IOException, JSONException {
        this.inputFileReader = inputFileReader;
        this.outputUtil = new OutputUtil(readAPI);
    }

    private void writeOutput(ArrayList<String> text, Path file) throws IOException {
        Files.write(file, text, Charset.forName("UTF-8"));
    }

    public void writeToMultipleFiles(Path path) throws IOException, JSONException {
        ArrayList<String> cities = inputFileReader.readInput(path);
        for (String city : cities) {
            ArrayList<String> output = new ArrayList<>();
            output.add(String.valueOf(outputUtil.outputFormatter(city).values()).replaceAll("\\[", "").replaceAll("]", ""));
            Path file = Paths.get("weather/src/main/java/writing/output/" + city + ".txt");
            writeOutput(output, file);
        }
    }

    public void writeToFile(Path path) throws IOException, JSONException {
        ArrayList<String> cities = inputFileReader.readInput(path);
        Path file = Paths.get("weather/src/main/java/writing/output.txt");

        ArrayList<String> output = new ArrayList<>();
        for (String city : cities) {
            output.add(String.valueOf(outputUtil.outputFormatter(city).values()).replaceAll("\\[", "").replaceAll("]", ""));
        }
        writeOutput(output, file);
    }


}
