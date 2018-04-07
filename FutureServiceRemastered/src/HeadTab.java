import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HeadTab extends AbstractTab implements Tab, Initializable{
	double width = Values.width;
    double height = Values.height;
	double w = width/1.5;
    double h1 = height/3.8;
	double w1 = width/5.1;
	double h2 = height/3.5;
	double w2 = width/4.7;
    double TextDescrPos_X = Values.width/2.3;
    double TextDescrPos_Y = Values.height/2.3;	
    double TitleDescrPos_X = Values.width/5.7;
    double TitleDescrPos_Y = Values.height/2.84;	
	public ScrollPane tabPreview;
	public ImageView logo;
	public ImageView previewBackground;
	public AnchorPane previewPane;
	DropShadow ds;
	ImageView bg;
	
	public HeadTab(String s , int amount){
		if(s.equals("2")){
		    init();
		    setDescription(amount);
		    }
	}
	public void setDescription(int number){
		
		
		Image startImage = new Image("bg.png"); 
		BackgroundImage sttartBg =  new BackgroundImage(startImage, 
		    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.DEFAULT, 
		    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
		ds = new DropShadow();
        ds.setSpread(0);
        ds.setOffsetY(1.0);
        ds.setOffsetX(1.0);
        ds.setColor(Color.BLACK);
		for(int i=0;i<number;i++){
			createDescription();
			if(i!=number-1){
				height+=400;
			}
			w1 +=400;
			w2 +=400;
			TextDescrPos_Y +=400;
			TitleDescrPos_Y +=400;
		}
		previewPane.setBackground(new Background(sttartBg));
	}
	public void getObjects(){
		previewPane = (AnchorPane)tabPreview.getContent();
		previewPane.setPrefWidth(width-2);
		previewPane.setPrefHeight(height-2);
		
		
		logo =(ImageView)previewPane.getChildren().get(0);
	}
	@Override
	public void init() {
		 tabPreview = (ScrollPane) loadPane("UserPreview.fxml","AnchorPane");
		 tabPreview.setPrefWidth(width);
		 tabPreview.setPrefHeight(height);
		 getObjects();
		 tabPreview.setFitToWidth(true);
	}

	@Override
	public Node loadPane(String name, String type) {
		 if(type.equals("AnchorPane")){
			    try {
			    	  FXMLLoader loader = new FXMLLoader();
			          loader.setLocation(HeadTab.class.getResource(name)); 
			          loader.setController(new HeadTab("",0));
			          ScrollPane ap = (ScrollPane) loader.load();
			          return ap;
			    } catch (IOException e1) {
			      // TODO Auto-generated catch block
			      e1.printStackTrace();
			    }
			    
		 }
		return null;
	}
	
	public void createDescription(){
		Label title = new Label("Ёлектронное меню");
		title.setFont(new Font(20));
		Label descr = new Label(Values.MenuDecription);
		descr.setWrapText(true);
		descr.setFont(new Font(18));
		ImageView iv = new ImageView("wbg.png");
		iv.setFitWidth(w);
		iv.setFitHeight(47);
		iv.setLayoutX(h1);
		iv.setLayoutY(w1);
		ImageView iv1 = new ImageView("wbg.png");
		iv1.setFitWidth(w);
		iv1.setFitHeight(300);
		iv1.setLayoutX(h2);
		iv1.setLayoutY(w2);
		iv.setEffect(ds);
		iv1.setEffect(ds);
		descr.setLayoutX(TextDescrPos_X);
		descr.setLayoutY(TextDescrPos_Y);
		title.setLayoutX(TitleDescrPos_X);
		title.setLayoutY(TitleDescrPos_Y+10);
		previewPane.getChildren().addAll(iv1,iv,descr,title);
		previewPane.setPrefHeight(height-2);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Node getPane() {
		// TODO Auto-generated method stub
		return tabPreview;
	}
}
