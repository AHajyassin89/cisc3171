import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


// example of using classes to handle the data for current weather
// goal would be to apply this to the 5 day 3 hour forecast




public class WeatherApp {


    public static void main(String[] args) throws IOException {
        
        String apiKey = "";
        
        CurrentWeather cw = new CurrentWeather("http://api.openweathermap.org/data/2.5/weather?q=new york&APPID="+apiKey);
        CurrentWeather cw2 = new CurrentWeather("http://api.openweathermap.org/data/2.5/weather?q=chicago&APPID="+apiKey);
        //System.out.println(cw.toString());
       ForecastWeather fwList= new ForecastWeather("http://api.openweathermap.org/data/2.5/forecast?q=new%20york,us&APPID="+apiKey);

        for(int i = 0; i< 38 ;i++){
            System.out.println(fwList.forecastList[i].toString());
        }



        //get public ip
    String publicIpAddress = "";
    try {
        URL url_name = new URL("http://bot.whatismyipaddress.com");
        BufferedReader readip = new BufferedReader(new InputStreamReader(url_name.openStream()));
        //return address
        publicIpAddress = readip.readLine().trim();
        }
    catch(Exception e)
        {
        publicIpAddress = "error";
         }

        //get city from ipaddress

     String cityname="";
        try {
            URL url_name2 = new URL("https://ipapi.co/"+publicIpAddress+"/city");  //if you want to return zipcode replace city with "postal"
            BufferedReader readcity = new BufferedReader(new InputStreamReader(url_name2.openStream()));
            //return address
            cityname = readcity.readLine().trim();
        }
        catch(Exception e)
        {
            cityname = "error";
        }
        System.out.println(cityname);
    }

}

