package com.anuragroy.Controllers;

import com.anuragroy.Models.FiveDayForecast;
import com.anuragroy.Models.ImageHandler;
import com.anuragroy.Models.WeatherManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {
    WeatherManager weatherManager;
    public static FiveDayForecast fdf;
    public static String citySet;

    @FXML
    private ImageView img;
    @FXML
    private JFXButton change, set, cancel, fiveDayForecast;
    @FXML
    private JFXTextField cityName, invis;
    @FXML
    private Label city, temperature, day, desc, errors, windSpeed, cloudiness, pressure, humidity;

    @FXML
    private ImageView img1, img2, img3, img4, img5;
    @FXML
    private JFXButton back;
    @FXML
    private Label currentTemp, high1, high2, high3, high4, high5, low1, low2, low3, low4, low5;
    
    //Constructor to set the initial city to Pune
    public Controller() {
         String publicIpAddress;
         if (citySet == null)
         {
             
         
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

     //String citySet="";
        try {
            URL url_name2 = new URL("https://ipapi.co/"+publicIpAddress+"/city");  //if you want to return zipcode replace city with "postal"
            BufferedReader readcity = new BufferedReader(new InputStreamReader(url_name2.openStream()));
            URL url_name3 = new URL("https://ipapi.co/"+publicIpAddress+"/region");  //if you want to return zipcode replace city with "postal"
            BufferedReader readcity2 = new BufferedReader(new InputStreamReader(url_name3.openStream()));
            //return address
            citySet = readcity.readLine().trim() + ", " + readcity2.readLine().trim();
        }
        catch(Exception e)
        {
            citySet = "error";
        }
         }
         
    }
    
    public Controller(String citySet) {
        Controller.citySet = citySet;
    }

    //Event Handler for each button
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent ae) {
        String initialCity = city.getText(); //stores the last searched city-name

        if(ae.getSource() == change){
            //cityName.setText("");
            //bottomSet(true);
            //cityName.requestFocus();
            setPressed();
        }/*else if (ae.getSource() == set) {
            setPressed();
        } else if (ae.getSource() == cancel) {
            cityName.setText(initialCity);
            bottomSet(false);
            invis.requestFocus();
        }*/
    }

    //method to clear all the fields
    private void reset() {
        //bottomSet(false);
        day.setText("");
        temperature.setText("");
        desc.setText("");
        windSpeed.setText("");
        cloudiness.setText("");
        pressure.setText("");
        humidity.setText("");
        img.setImage(null);
    }

    //method to set the new entered city
    private void setPressed(){
        //if user enters nothing into cityName field
        if(cityName.getText().equals("")){
            showToast("City Name cannot be blank");
        }else {
            try {
                errors.setText("");
                Controller.citySet = cityName.getText().trim();
                cityName.setText((cityName.getText().trim()).toUpperCase());
                weatherManager = new WeatherManager(citySet);
                fdf = new FiveDayForecast(citySet,true);
                showWeather();
                //bottomSet(false);
                invis.requestFocus();
            }catch(Exception e){
                city.setText("Error!!");
                city.setTextFill(Color.TOMATO);
                showToast("City with the given name was not found.");
                reset();
                invis.requestFocus();
            }
        }
    }

    //method to handle nodes at botton part of the scene
    private void bottomSet(boolean statement){
        cityName.setDisable(!statement);
        set.setVisible(statement);
        change.setVisible(!statement);
        cancel.setVisible(statement);
    }

    //method to show error messages
    private void showToast(String message) {
        errors.setText(message);
        errors.setTextFill(Color.TOMATO);
        errors.setStyle("-fx-background-color: #fff; -fx-background-radius: 50px;");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), errors);
        fadeIn.setToValue(1);
        fadeIn.setFromValue(0);
        fadeIn.play();

        fadeIn.setOnFinished(event -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.play();
            pause.setOnFinished(event2 -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), errors);
                fadeOut.setToValue(0);
                fadeOut.setFromValue(1);
                fadeOut.play();
            });
        });
    }

    //actual method to call and get the weather and populate the scene
    private void showWeather(){
        weatherManager.getWeather();
        city.setText(weatherManager.getCity().toUpperCase());
        if(!city.getText().contains(","))
        {
            city.setText(city.getText() + "," + weatherManager.getCountry());
        }
        temperature.setText(weatherManager.getTemperature().toString()+"°F");
        day.setText(weatherManager.getDay().toUpperCase());
        desc.setText(weatherManager.getDescription().toUpperCase());
        img.setImage(new Image(ImageHandler.getImage(weatherManager.getIcon())));
        windSpeed.setText(weatherManager.getWindSpeed()+" m/s");
        cloudiness.setText(weatherManager.getCloudiness()+"%");
        pressure.setText(weatherManager.getPressure()+" hpa");
        humidity.setText(weatherManager.getHumidity()+"%");
    }

    
    @FXML
    private void loadFiveDay(ActionEvent event) throws IOException
    {
        
        
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/5DayForecast.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
        
    }

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cityName.setText(citySet);
        cityName.setDisable(false);
        set.setVisible(false);
        cancel.setVisible(false);
        fiveDayForecast.setVisible(true);
        errors.setText("");
        weatherManager = new WeatherManager(citySet);
        try {
            fdf = new FiveDayForecast(citySet,true);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        invis.requestFocus();

        //try catch block to see if there is internet and disabling ecery field
        try{
            showWeather();
        } catch (Exception e){
            city.setText("Error!! - No Internet");
            city.setTextFill(Color.TOMATO);
            showToast("Internet Down. Please Connect");
            reset();
            change.setDisable(true);
            cityName.setText("");
        }

        //Set the city entered into textField on pressing enter on Keyboard
        cityName.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                setPressed();
            }
        });
    }
    

    


}