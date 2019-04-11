package com.codebeasty.json.json;

public class List {
    private String dt;

    private String rain;

    private String dt_txt;

    private String snow;

    private Weather[] weather;

    private Maint main;

    private Clouds clouds;

    private Sys sys;

    private Wind wind;

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public String getRain ()
    {
        return rain;
    }

    public void setRain (String rain)
    {
        this.rain = rain;
    }

    public String getDt_txt ()
    {
        return dt_txt;
    }

    public void setDt_txt (String dt_txt)
    {
        this.dt_txt = dt_txt;
    }

    public String getSnow ()
    {
        return snow;
    }

    public void setSnow (String snow)
    {
        this.snow = snow;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public Maint getMain ()
    {
        return main;
    }

    public void setMain (Maint main)
    {
        this.main = main;
    }

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dt = "+dt+", rain = "+rain+", dt_txt = "+dt_txt+", snow = "+snow+", weather = "+weather+", main = "+main+", clouds = "+clouds+", sys = "+sys+", wind = "+wind+"]";
    }
}
