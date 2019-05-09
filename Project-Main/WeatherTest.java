
package weathergit;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import org.json.JSONObject;
import org.junit.*;
import static org.junit.Assert.assertEquals;


public class WeatherTest {
    
    
    private static String json;
    private static JSONObject weather;
    private Weather currentWeather;
    
    public WeatherTest() {
           
    }


    
    @BeforeClass
    public static void setUpClass() throws FileNotFoundException 
    {
        File file = new File("weather.json");
        Scanner inputFile = new Scanner(file);
        
        json = inputFile.nextLine();
        weather = new JSONObject(json);
        
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException 
    {
        currentWeather = new Weather();
        
        
        JSONObject cloudInfo = weather.getJSONArray("weather").getJSONObject(0);
        currentWeather.setCloudDescription(cloudInfo.getString("description"));
        currentWeather.setTemp(weather.getJSONObject("main").getDouble("temp"));
        currentWeather.setHumidity(weather.getJSONObject("main").getDouble("humidity"));
        currentWeather.setMaxTemp(weather.getJSONObject("main").getDouble("temp_max"));
        currentWeather.setMinTemp(weather.getJSONObject("main").getDouble("temp_min"));
    }
    
    @After
    public void tearDown() {
    }






    /**
     * Test of getCloudDescription method, of class Weather.
     */
    @Test
    public void testGetCloudDescription() {
        System.out.println("getCloudDescription");
        String expResult = "light intensity drizzle";
        assertEquals(expResult, currentWeather.getCloudDescription());
    }



    /**
     * Test of getTemp method, of class Weather.
     */
    @Test
    public void testGetTemp() {
        System.out.println("getTemp");
        double expResult = 280.32;
        assertEquals(expResult, currentWeather.getTemp(), 0.0);
    }



    /**
     * Test of getMaxTemp method, of class Weather.
     */
    @Test
    public void testGetMaxTemp() {
        System.out.println("getMaxTemp");
        double expResult = 281.15;
        assertEquals(expResult, currentWeather.getMaxTemp(), 0.0);
    }



    /**
     * Test of getMinTemp method, of class Weather.
     */
    @Test
    public void testGetMinTemp() {
        System.out.println("getMinTemp");
        double expResult = 279.15;
        assertEquals(expResult, currentWeather.getMinTemp(), 0.0);
    }



    /**
     * Test of getHumidity method, of class Weather.
     */
    @Test
    public void testGetHumidity() {
        System.out.println("getHumidity");
        double expResult = 81;
        assertEquals(expResult, currentWeather.getHumidity(), 0.0);
    }



    
}
