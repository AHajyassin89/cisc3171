import java.io.IOException;
import org.json.JSONObject;


// example of using classes to handle the data for current weather
// goal would be to apply this to the 5 day 3 hour forecast




public class WeatherApp {


    public static void main(String[] args) throws IOException {
        
        String apiKey = ""
        
        CurrentWeather cw = new CurrentWeather("http://api.openweathermap.org/data/2.5/weather?q=new york&APPID="+apiKey);
        CurrentWeather cw2 = new CurrentWeather("http://api.openweathermap.org/data/2.5/weather?q=chicago&APPID="+apiKey);        
        System.out.println(cw.toString());
        

    }
    
}