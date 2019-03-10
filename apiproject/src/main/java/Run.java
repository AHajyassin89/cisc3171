package com.apiproject;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Run {

    public static void main(String[] args) throws IOException, JsonIOException, Exception {

        String apikey = "a9fcfa98383a945eba9a89ee2cbdbdc7";
//api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=
        String json = readUrl("https://api.openweathermap.org/data/2.5/weather?q=Brooklyn,us&APPID="
                + apikey);

        Gson gson = new Gson();
       com.apiproject.Jsonpar jsonpar= gson.fromJson(json, com.apiproject.Jsonpar.class);
     System.out.println(jsonpar.getName());
     System.out.println(jsonpar.getMain().getHumidity());
     System.out.println(jsonpar.getMain().getTemp());

    }
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    }


