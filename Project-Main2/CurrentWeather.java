//class for handling current weather

import java.io.IOException;
import org.json.JSONObject;


public class CurrentWeather 
{
    private final String cloudDescription;
    private final double temp;
    private final double humidity;
    private final double maxTemp;
    private final double minTemp;
    
    //default constructor
    public CurrentWeather()
    {
        this.cloudDescription="null";
        this.temp=0;
        this.humidity=0;
        this.maxTemp=0;
        this.minTemp=0;
    }
    
    
    //constructor that sets all variable through provided link
    public CurrentWeather(String url) throws IOException
    {
        JSONObject currentWeather = JSON.readJsonFromUrl(url);
        JSONObject cloudInfo = currentWeather.getJSONArray("weather").getJSONObject(0);
        this.cloudDescription=cloudInfo.getString("description");
        this.temp= ((currentWeather.getJSONObject("main").getDouble("temp")-273.15)*9/5 +32);
        this.humidity=currentWeather.getJSONObject("main").getDouble("humidity");
        this.maxTemp=((currentWeather.getJSONObject("main").getDouble("temp_max")-273.15)*9/5 +32);
        this.minTemp=((currentWeather.getJSONObject("main").getDouble("temp_min")-273.15)*9/5 +32);
    }
    
    public String getCloudDescription()
    {
        return this.cloudDescription;
    }
    public double getTemp()
    {
        return this.temp;
    }
    public double getMaxTemp()
    {
        return this.maxTemp;
    }
    public double getMinTemp()
    {
        return this.minTemp;
    }
    public double getHumidity()
    {
        return this.humidity;
    }

    @Override
    public String toString() {
        return ("Temperature: "+temp+"\nMaximum Temperature: "+maxTemp+"\nMinimum"
                + " Temperature: "+minTemp+"\nHumidity: "+humidity+"\n"+cloudDescription);
    }

}
