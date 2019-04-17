
package weathergit;

import java.io.IOException;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ForecastWeatherTest {
    
    private ForecastWeather fw;
    
    public ForecastWeatherTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException, ParseException {
        fw = new ForecastWeather("http://api.openweathermap.org/data/2.5/forecast?q=new york&appid=2f872b5246cef2d7a2bfcf6e10a62160&lang=eng&units=imperial");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDailyHigh method, of class ForecastWeather.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyHigh() {
        System.out.println("getDailyHigh");
        int day = 0;
        fw.getDailyHigh(day);
    }

    /**
     * Test of getDailyLow method, of class ForecastWeather.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyLow() {
        System.out.println("getDailyLow");
        int day = 0;
        fw.getDailyLow(day);
    }

    /**
     * Test of getDailyHumidity method, of class ForecastWeather.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyHumidity() {
        System.out.println("getDailyHumidity");
        int day = 0;
        fw.getDailyHumidity(day);
    }

    /**
     * Test of getDailyWind method, of class ForecastWeather.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyWind() {
        System.out.println("getDailyWind");
        int day = 0;
        fw.getDailyWind(day);
    }


    
}
