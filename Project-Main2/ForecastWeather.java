import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class ForecastWeather {
public Weather[] forecastList;
//array to store weather objects

    public ForecastWeather() {

    }

    public ForecastWeather(String url) throws IOException {
        JSONObject forecastWeather = JSON.readJsonFromUrl(url);
        JSONArray weathers = forecastWeather.getJSONArray("list");

        this.forecastList = new Weather[weathers.length()];
        for (int i=0; i < weathers.length(); i++) {
            forecastList[i] = new Weather();
//stores the weather object in the array
            JSONObject list = weathers.getJSONObject(i);
            JSONObject cloudInfo = list.getJSONArray("weather").getJSONObject(0);

            this.forecastList[i].setDate(list.getString("dt_txt"))  ;
            this.forecastList[i].setCloudDescription(cloudInfo.getString("description"));
            this.forecastList[i].setTemp((list.getJSONObject("main").getDouble("temp") - 273.15) * 9 / 5 + 32);
            this.forecastList[i].setHumidity(list.getJSONObject("main").getDouble("humidity"));
            this.forecastList[i].setMaxTemp(((list.getJSONObject("main").getDouble("temp_max") - 273.15) * 9 / 5 + 32));
            this.forecastList[i].setMinTemp((list.getJSONObject("main").getDouble("temp_min") - 273.15) * 9 / 5 + 32);   ;
        }


    }

}