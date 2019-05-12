
package com.anuragroy.Models;


import java.io.IOException;
import java.text.ParseException;
import org.json.*;

public class FiveDayForecast {
public Weather[] forecastList;
private double[] highs;
private double[] lows;
private double[] humidity;
private double[] wind;
private String[] cloudDescription;
//array to store weather objects

    public FiveDayForecast() {

    }

    public FiveDayForecast(String city) throws IOException, ParseException {
        JSONObject forecastWeather = JSON.readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=2f872b5246cef2d7a2bfcf6e10a62160&lang=eng&units=imperial");
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
            this.forecastList[i].setWind(list.getJSONObject("wind").getDouble("speed"));
            this.forecastList[i].setIcon(cloudInfo.getString("icon"));
            

        }
        highs = new double[5];
        lows = new double[5];
        humidity = new double[5];
        wind = new double[5];
        cloudDescription = new String[5];
        double windAvg = 0, humidityAvg=0;
        
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
                    
                   humidityAvg += forecastList[i].getHumidity();
                    windAvg += forecastList[i].getWind();
                    i++;
                    

                }
                cloudDescription[j-1]= forecastList[i].getCloudDescription();
                humidity[j-1] = humidityAvg/i;
                humidityAvg = 0;
                wind[j-1] = windAvg/i;
                windAvg = 0;
                j++;
                }
            }
    }
    
    public double getDailyHigh(int day)
    {
        if (day>5 || day <1)
        {
            throw new ArrayIndexOutOfBoundsException("5 days only: range 1-5");
        }
        return highs[day-1];
    }
    public double getDailyLow(int day)
    {
        if (day>5 || day <1)
        {
            throw new ArrayIndexOutOfBoundsException("5 days only: range 1-5");
        }
        return lows[day-1];
    }
    public double getDailyHumidity(int day)
    {
        if (day>5 || day <1)
        {
            throw new ArrayIndexOutOfBoundsException("5 days only: range 1-5");
        }
        return humidity[day-1];
    }
    public double getDailyWind(int day)
    {
        if (day>5 || day <1)
        {
            throw new ArrayIndexOutOfBoundsException("5 days only: range 1-5");
        }
        return wind[day-1];
    }
    public String getDailyCloudDescription(int day)
    {
        if (day>5 || day <1)
        {
            throw new ArrayIndexOutOfBoundsException("5 days only: range 1-5");
        }
        return cloudDescription[day-1];
    }

    


}
