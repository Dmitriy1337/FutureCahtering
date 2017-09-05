import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGUI extends Application {

	AnchorPane restaurantInfo;
	AnchorPane restaurantInfoWindow;
	Scene mainScene;
	SystemLog sL = new SystemLog();
	ListView<String> list;
	public static void main(String[] args) {
		launch(args);

	}

	
	public void start(Stage mainWindowStage) throws Exception {
		
		mainWindowStage.setTitle("FutureCathering");
		restaurantInfo = new AnchorPane();
		mainScene = new Scene(restaurantInfo,1000,600);
		
		 list = new ListView<String>();
		list.setOrientation(Orientation.HORIZONTAL);
		ObservableList<String> items =FXCollections.observableArrayList (
		    "                      Мой Ресторан                       ", "                       Каталог товаров                      ", "                      Визуализация меню                      ", "                   Текущее состояние                ");
		list.setItems(items);
		
		list.setPrefWidth(1000);
		list.setPrefHeight(50);
		
		
		list.getSelectionModel().selectedItemProperty().addListener(
		        (ObservableValue<? extends String> ov, String old_val, 
		            String new_val) -> {
		                
		                listenMenu(new_val,mainWindowStage);
		    });
		
		
		
		
		restaurantInfo.getChildren().add(list);
		
		
		mainWindowStage.setScene(mainScene);
		mainWindowStage.show();
		
	}

	public void listenMenu(String args,Stage st){
		
		if(args.replaceAll(" ","").equals("МойРесторан") ){
			showRestaurantInfo(st);
			
		}
		
		
	}
	
	public void showRestaurantInfo(Stage st2){
		
		Image demoPhoto = new Image("photo.png");
		
		Image demoLogo = new Image("logo.png");
		ImageView photoIV = new ImageView(demoPhoto);
		ImageView logoIV = new ImageView(demoLogo);
		
		photoIV.setLayoutX(20);
		photoIV.setLayoutY(70);
		photoIV.setFitHeight(150);
		photoIV.setFitWidth(150);
		
		Restaurant newRSample = new Restaurant("Имя_Ресторана","Ресторан_вкусной_еды","Наш ресторан готовит и продает вкусную еду","Ул.Уличная 1","+79780000000","vk.com/club11111111","@instagramacc","facebook","@twitteracc",demoPhoto,demoLogo);
		
		Label rName = new Label(newRSample.getRestaurantName());
		rName.setLayoutX(180);
		rName.setLayoutY(70);
		rName.setFont(Font.font ("Verdana", 23));
		
		Label rSlogan = new Label(newRSample.getRestaurantSlogan());
		rSlogan.setLayoutX(180);
		rSlogan.setLayoutY(100);
		rSlogan.setFont(Font.font ("Verdana", 18));
		
		
		Label rDescription = new Label(newRSample.getRestaurantDescription());
		rDescription.setLayoutX(180);
		rDescription.setLayoutY(125);
		rDescription.setFont(Font.font ("Verdana", 17));
		
		
		restaurantInfoWindow = new AnchorPane();
		restaurantInfoWindow.getChildren().addAll(list,photoIV,rName,rSlogan,rDescription);
		mainScene.setRoot(restaurantInfoWindow);
		st2.setScene(mainScene);
		st2.show();
	}
	
	
	
	

}
