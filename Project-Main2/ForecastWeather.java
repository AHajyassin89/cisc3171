import java.io.IOException;
import java.text.ParseException;
import org.json.*;

public class ForecastWeather {
public Weather[] forecastList;
private double[] highs;
private double[] lows;
//array to store weather objects

    public ForecastWeather() {

    }

    public ForecastWeather(String url) throws IOException, ParseException {
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
            this.forecastList[i].setTemp(list.getJSONObject("main").getDouble("temp"));
            this.forecastList[i].setHumidity(list.getJSONObject("main").getDouble("humidity"));
            this.forecastList[i].setMaxTemp(list.getJSONObject("main").getDouble("temp_max"));
            this.forecastList[i].setMinTemp(list.getJSONObject("main").getDouble("temp_min"));



	    // removed the math because you can add "&units=imperia" at the end of the url
            //"http://api.openweathermap.org/data/2.5/forecast?q=new york&appid=2f872b5246cef2d7a2bfcf6e10a62160&lang=eng&units=imperial"
            
            

        }
        highs = new double[5];
            lows = new double [5];
     
            for (int i=0, j=1;i<(forecastList.length-1);i++)
            {
                if (j<6)
                {
                lows[j-1] = forecastList[i].getMinTemp();
                highs[j-1] = forecastList[i].getMaxTemp();
                while ( i<(forecastList.length-2) &&
                        forecastList[i].getDateWithoutTime().compareTo(forecastList[i+1].getDateWithoutTime()) == 0)
                        
                {
                    if(lows[j-1] > forecastList[i+1].getMinTemp())
                    {
                        lows[j-1] = forecastList[i+1].getMinTemp();
                    }
                    if(highs[j-1] < forecastList[i+1].getMaxTemp())
                    {
                        highs[j-1] = forecastList[i+1].getMaxTemp();
                    }
                    i++;
                }
                j++;
                }
            }
    }
    

    
}