package reader;

import org.json.JSONException;
import weather.UserInput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        UserInput userInput = new UserInput();
        userInput.getUserInput();
    }
}
