
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class dummyFail {


    public static void main(String[] args) throws IOException {

        String key = "2428b4cbc243376503343db78f3acc66";
        String dayURL = "http://api.openweathermap.org/data/2.5/weather?id=588409&units=metric&appid=2428b4cbc243376503343db78f3acc66";
        String weeklyURL = "http://api.openweathermap.org/data/2.5/forecast/?id=588409&units=metric&APPID=2428b4cbc243376503343db78f3acc66";
        dummyFail dummyFail = new dummyFail();
        String text = dummyFail.readFile(dummyFail.readHTTP(dayURL));
        //dummyFail.getInfo(text);
        //JSObject jsObject = new JSObject();
        //JSONListAdapter listAdapter = new JSONListAdapter(jsObject, Global.instance());
        //JSONObject object = new JSONObject(text);
        //System.out.println(object);
        //JSONArray array = new JSONArray(object.get("subcatagories"));
        //System.out.println(array);


    }

    InputStream readHTTP(String url) throws IOException {
        return new URL(url).openStream();
    }

    String readFile(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder text = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            text.append(line);
            line = bufferedReader.readLine();
        }

        return text.toString();
    }

    Map<String, String> getInfo(String info) {
        HashMap<String, String> impInfo = new HashMap<>();

        info = info.substring(1, info.length());
        String[] strings;
        for (int i = 0; i < 7; i++) {
            strings = info.substring(0, info.indexOf("}") + 1).split(":", 2);
            if (!impInfo.containsKey(strings[0])) {
                System.out.println(Arrays.toString(strings));
                impInfo.put(strings[0], strings[1]);
                System.out.println(impInfo);
            }
            info = info.substring(info.indexOf("}") + 2);
        }

        return null;
    }

}
