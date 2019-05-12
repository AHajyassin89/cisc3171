
package com.anuragroy.Controllers;

import com.anuragroy.Models.FiveDayForecast;
import com.anuragroy.Models.ImageHandler;
import com.anuragroy.Models.WeatherManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ForecastController implements Initializable{
 
    
        @FXML
    private JFXButton back;

    @FXML
    private Pane pane1;

    @FXML
    private Label city;

    @FXML
    private Label errors;

    @FXML
    private Label currentTemp;

    @FXML
    private  ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private Label high1;

    @FXML
    private Label low1;

    @FXML
    private Label high2;

    @FXML
    private Label low2;

    @FXML
    private Label high3;

    @FXML
    private Label low3;

    @FXML
    private Label high4;

    @FXML
    private Label low4;

    @FXML
    private Label high5;

    @FXML
    private Label low5;
    @FXML
    private Label humidityHolder,humidityHolder1, humidityHolder2, humidityHolder3, humidityHolder4;
    @FXML
    private Label windHolder,windHolder1, windHolder2, windHolder3, windHolder4, cloudDesc, cloudDesc1, cloudDesc2, cloudDesc3, cloudDesc4;
    
    @FXML
    private AnchorPane parent;
    
    private String citySet;
    
    
    public ForecastController() throws IOException, ParseException
    {
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            String str = "" + Controller.fdf.getDailyHigh(1);
            high1.setText(str);
            str = "" + Controller.fdf.getDailyHigh(2);
            high2.setText(str);
            str = "" + Controller.fdf.getDailyHigh(3);
            high3.setText(str);
            str = "" + Controller.fdf.getDailyHigh(4);
            high4.setText(str);
            str = "" + Controller.fdf.getDailyHigh(5);
            high5.setText(str);
            
            str = "" + Controller.fdf.getDailyLow(1);
            low1.setText(str);
            str = "" + Controller.fdf.getDailyLow(2);
            low2.setText(str);
            str = "" + Controller.fdf.getDailyLow(3);
            low3.setText(str);
            str = "" + Controller.fdf.getDailyLow(4);
            low4.setText(str);
            str = "" + Controller.fdf.getDailyLow(5);
            low5.setText(str);
            
            str = String.format("%.2f", Controller.fdf.getDailyHumidity(1))+"%";
            humidityHolder.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyHumidity(2))+"%";
            humidityHolder1.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyHumidity(3))+"%";
            humidityHolder2.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyHumidity(4))+"%";
            humidityHolder3.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyHumidity(5)) +"%";
            humidityHolder4.setText(str);
            
            str = String.format("%.2f", Controller.fdf.getDailyWind(1))+ "mph";
            windHolder.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyWind(2))+ "mph";
            windHolder1.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyWind(3))+ "mph";
            windHolder2.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyWind(4))+ "mph";
            windHolder3.setText(str);
            str = String.format("%.2f", Controller.fdf.getDailyWind(5)) + "mph";
            windHolder4.setText(str);
            
            cloudDesc.setText(Controller.fdf.getDailyCloudDescription(1));
            cloudDesc1.setText(Controller.fdf.getDailyCloudDescription(2));
            cloudDesc2.setText(Controller.fdf.getDailyCloudDescription(3));
            cloudDesc3.setText(Controller.fdf.getDailyCloudDescription(4));
            cloudDesc4.setText(Controller.fdf.getDailyCloudDescription(5));
            city.setText(Controller.citySet);
            errors.setText("");
        
    }
    @FXML
    private void back(ActionEvent event) throws IOException
    {
        Parent newParent = FXMLLoader.load(getClass().getResource("/fxml/weather.fxml"));
        Scene scene = new Scene(newParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    
}
