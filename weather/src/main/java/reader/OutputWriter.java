package reader;

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

    public void writeOutputWithPath(ArrayList<String> text, Path path) {

    }

    private void writeOutput(ArrayList<String> text) throws IOException {
        Path file = Paths.get("weather/src/main/java/writing/output.txt");
        Files.write(file, text, Charset.forName("UTF-8"));

    }

    private void writeOutput(ArrayList<String> text, String name) throws IOException {
        Path file = Paths.get("weather/src/main/java/writing/output/" + name + ".txt");
        Files.write(file, text, Charset.forName("UTF-8"));
    }

    public void writeToMultipleFiles() throws IOException, JSONException {
        ArrayList<String> cities = inputFileReader.getCitiesList();
        for (String city : cities) {
            ArrayList<String> output = new ArrayList<>();
            output.add(String.valueOf(outputUtil.outputFormatter(city).values()).replaceAll("\\[", "").replaceAll("]", ""));
            writeOutput(output, city);
        }
    }

    public void writeToFile() throws IOException, JSONException {
        ArrayList<String> cities = inputFileReader.getCitiesList();

        ArrayList<String> output = new ArrayList<>();
        for (String city : cities) {
            output.add(String.valueOf(outputUtil.outputFormatter(city).values()).replaceAll("\\[", "").replaceAll("]", ""));
        }
        writeOutput(output);
    }


}
