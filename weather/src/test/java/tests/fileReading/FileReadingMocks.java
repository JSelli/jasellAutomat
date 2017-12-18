package tests.fileReading;

import api.ReadAPI;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import reader.InputFileReader;
import reader.OutputWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadingMocks {

    private ReadAPI readAPI = null;
    private OutputWriter outputWriter = null;
    private InputFileReader inputFileReader = null;

    @Before
    public void createClasses() throws IOException, JSONException {
        this.readAPI = Mockito.mock(ReadAPI.class);
        this.inputFileReader = Mockito.mock(InputFileReader.class);
        this.outputWriter = new OutputWriter(readAPI, inputFileReader);
    }

    @Test
    public void testFileReading() throws IOException, JSONException {
        Path file = Paths.get("weather/java/tests/fileReading/exampleCity.json");
        outputWriter.writeToFile(file);
        Mockito.verify(inputFileReader).readInput(file);
    }

    @Test
    public void testOutput() throws IOException, JSONException {
        Path file = Paths.get("weather/java/tests/fileReading/exampleCity.json");
        outputWriter.writeToFile(file);
        Mockito.verify(inputFileReader).readInput(file);
        Mockito.verify(readAPI);
        Mockito.verifyZeroInteractions(readAPI);

    }
}
