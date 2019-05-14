/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuragroy.Models;

import java.io.IOException;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author mendel
 */
public class FiveDayForecastTest {
    

    
    private static FiveDayForecast fdf;
    
    static int day = 0;
    
    public FiveDayForecastTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, ParseException 
    {
        fdf = new FiveDayForecast("fivedayforecast.json", false);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDailyHigh method, of class FiveDayForecast.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyHighException() {
        System.out.println("getDailyHighException");
        fdf.getDailyHigh(day);
    }

    /**
     * Test of getDailyLow method, of class FiveDayForecast.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyLowException() {
        System.out.println("getDailyLowException");
        fdf.getDailyLow(day);
    }

    /**
     * Test of getDailyHumidity method, of class FiveDayForecast.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyHumidityException() {
        System.out.println("getDailyHumidityException");
        fdf.getDailyHumidity(day);
    }

    /**
     * Test of getDailyWind method, of class FiveDayForecast.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyWindException() {
        System.out.println("getDailyWindException");
        fdf.getDailyWind(day);
    }
    /**
     * Test of getDailyCloudDescription method, of class FiveDayForecast.
     */
    @Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetDailyCloudDescriptionException(){
        System.out.println("getDailyCloudDescriptionException");
        fdf.getDailyCloudDescription(day);
    }
    
    
        /**
     * Test of getDailyHigh method, of class FiveDayForecast.
     */
    @Test
    public void testGetDailyHigh() {
        System.out.println("getDailyHigh");
        fdf.getDailyHigh(day);
    }

    /**
     * Test of getDailyLow method, of class FiveDayForecast.
     */
    @Test
    public void testGetDailyLow() {
        System.out.println("getDailyLow");
        fdf.getDailyLow(day);
    }

    /**
     * Test of getDailyHumidity method, of class FiveDayForecast.
     */
    @Test
    public void testGetDailyHumidity() {
        System.out.println("getDailyHumidity");
        fdf.getDailyHumidity(day);
    }

    /**
     * Test of getDailyWind method, of class FiveDayForecast.
     */
    @Test
    public void testGetDailyWind() {
        System.out.println("getDailyWind");
        fdf.getDailyWind(day);
    }
    /**
     * Test of getDailyCloudDescription method, of class FiveDayForecast.
     */
    @Test
    public void testGetDailyCloudDescription(){
        System.out.println("getDailyCloudDescription");
        fdf.getDailyCloudDescription(day);
    }
    
}
