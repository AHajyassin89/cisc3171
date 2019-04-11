public class Weather {
    private String cloudDescription;
    private double temp;
    private double humidity;
    private double maxTemp;
    private double minTemp;
    private String date;

    Weather(){}
//weather object class to hold the information from json

    public void setCloudDescription(String cloudDescription){this.cloudDescription = cloudDescription;}
    public String getCloudDescription() { return this.cloudDescription; }

    public void setTemp(double temp){this.temp= temp;}
    public double getTemp() { return this.temp; }

    public void setMaxTemp(double maxTemp){this.maxTemp=maxTemp;}
    public double getMaxTemp() { return this.minTemp;  }

    public void setMinTemp(double minTemp){this.minTemp = minTemp;}
    public double getMinTemp() { return this.minTemp; }

    public void setHumidity(double humidity){this.humidity= humidity;}
    public double getHumidity() {  return this.humidity; }

    public void setDate(String date){this.date = date;}
    public String getDate() {  return this.date; }

    @Override
    public String toString() {
        return ("Date: " + date + "\nTemperature: " + temp + "\nMaximum Temperature: " + maxTemp + "\nMinimum"
                + " Temperature: " + minTemp + "\nHumidity: " + humidity + "\n" + cloudDescription);
    }
}
