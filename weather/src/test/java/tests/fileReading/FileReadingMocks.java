package tests.fileReading;

import controller.UserInput;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import reader.CityChecker;
import reader.InputFileReader;
import reader.OutputWriter;
import reader.ReadAPI;

import java.io.IOException;

public class FileReadingMocks {

    private CityChecker cityChecker = null;
    private ReadAPI readAPI = null;
    private OutputWriter outputWriter = null;
    private InputFileReader inputFileReader = null;
    private UserInput userInput = null;

    @Before
    public void createClasses() throws IOException, JSONException {
        this.cityChecker = Mockito.mock(CityChecker.class);
        this.readAPI = Mockito.mock(ReadAPI.class);
        this.inputFileReader = Mockito.mock(InputFileReader.class);
        this.outputWriter = new OutputWriter(readAPI, inputFileReader);
        this.userInput = Mockito.mock(UserInput.class);
    }

    @Test
    public void testOutput() throws IOException, JSONException {
        OutputWriter outputWriter = new OutputWriter(readAPI, inputFileReader);
        outputWriter.writeToFile();
        Mockito.verify(readAPI).getJSONNameDaily("Tallinn");
    }
}
