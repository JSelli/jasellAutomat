package reader;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.MalformedURLException;

class JsonDecoder {

    String readFile(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (NullPointerException e) {
            throw new MalformedURLException("Wrong url!");
        }
        StringBuilder text = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            text.append(line);
            line = bufferedReader.readLine();
        }
        return text.toString();
    }
}
