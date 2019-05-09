
package com.anuragroy.Models;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON 
{
    
    

    //method to build the JSON object
    private static String readAll(Reader rd) throws IOException 
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) 
        {
          sb.append((char) cp);
        }
        return sb.toString();
    }

    //method that returns a JSON object from a url with an API key
    //method accepts a url abd api key
    public static JSONObject readJsonFromUrl(String url, String key) throws IOException, JSONException 
    {
        try 
        (InputStream is = new URL(url+key).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }
    
    //method to get a JSON object from a url without an api key
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException 
    {
        try 
        (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

}
