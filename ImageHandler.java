package com.anuragroy.Models;

public class ImageHandler {

    public static String getImage(String icon) {
        switch (icon){
            case "01d":                     //day icon
                return "/images/01dd.png";
            
            case "01n":                     //night icon
                return "/images/01nn.png";
            
            case "02d":                     //sunny with cloud icon
                return "/images/02dd.png";
            
            case "02n":                     //night with cloud icon
                return "/images/02n.png";
            
            case "03d":                     //cloudy icon
                return "/images/03d.png";
             
            case "03n":                     //cloudy night
                return "/images/03n.png";
            
            case "04d": case "04n":         //dark cloud? 
                return "/images/03n.png";
            
            case "09d": case "09n":         //rain icon
                return "/images/09.png";
            
            case "10d":                     //rain with sun
                return "/images/10dd.png";
            
            case "10n":                     //rain at night
                return "/images/10nn.png";
            
            case "11n": case "11d":         //thunder
                return "/images/11.png";
            
            case "13d":                     //snowy icon
                return "/images/133.png";
            
            case "13n":                     //snow at night icon
                return "/images/13nn.png";
            
            case "50d": case "50n":         //foggy icon
                return "/images/50.png";
            
        }
        return "images/01d.jpg";
    }

}
