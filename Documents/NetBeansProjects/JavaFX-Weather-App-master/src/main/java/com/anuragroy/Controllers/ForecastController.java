
package com.anuragroy.Controllers;

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
import java.util.ResourceBundle;
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
    private ImageView img1;

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
    private AnchorPane parent;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML
    private void back(ActionEvent event) throws IOException
    {
        Parent blah = FXMLLoader.load(getClass().getResource("/fxml/weather.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    
}
