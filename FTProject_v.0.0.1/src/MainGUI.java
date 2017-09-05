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
		    "                      ��� ��������                       ", "                       ������� �������                      ", "                      ������������ ����                      ", "                   ������� ���������                ");
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
		
		if(args.replaceAll(" ","").equals("�����������") ){
			showRestaurantInfo(st);
			
		}
		
		
	}
	
	public void showRestaurantInfo(Stage st2){
		
		Image demoPhoto = new Image("noPhoto.png");
		
		Image demoLogo = new Image("logo.png");
		ImageView photoIV = new ImageView(demoPhoto);
		ImageView logoIV = new ImageView(demoLogo);
		
		photoIV.setLayoutX(20);
		photoIV.setLayoutY(70);
		photoIV.setFitHeight(150);
		photoIV.setFitWidth(150);
		
		Restaurant newRSample = new Restaurant("���_���������","��������_�������_���","��� �������� ������� � ������� ������� ���","��.������� 1","+79780000000","vk.com/club11111111","@instagramacc","facebook","@twitteracc",demoPhoto,demoLogo);
		
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
		
		
		Label rAdress = new Label(newRSample.getRestaurantAdress());
		rAdress.setLayoutX(180);
		rAdress.setLayoutY(195);
		rAdress.setFont(Font.font ("Verdana", 15));
		Image cell = new Image("191.png");
		
		ImageView cellIcon = new ImageView(cell);
		cellIcon.setLayoutX(180);
		cellIcon.setLayoutY(220);
		cellIcon.setFitHeight(20);
		cellIcon.setFitWidth(20);
		Label rNumber = new Label(" "+newRSample.getRestaurantNumber());
		rNumber.setLayoutX(200);
		rNumber.setLayoutY(220);
		rNumber.setFont(Font.font ("Verdana", 15));
		
		Image vk= new Image("25684.png");
		
		ImageView vkIcon = new ImageView(vk);
		vkIcon.setLayoutX(180);
		vkIcon.setLayoutY(245);
		vkIcon.setFitHeight(20);
		vkIcon.setFitWidth(20);
		Label rVk = new Label(" "+newRSample.getRestaurantVk());
		rVk.setLayoutX(200);
		rVk.setLayoutY(245);
		rVk.setFont(Font.font ("Verdana", 15));
		
		Image inst= new Image("174855.png");
		
		ImageView instIcon = new ImageView(inst);
		instIcon.setLayoutX(180);
		instIcon.setLayoutY(265);
		instIcon.setFitHeight(20);
		instIcon.setFitWidth(20);
		Label rInst = new Label(" "+newRSample.getRestaurantInst());
		rInst.setLayoutX(200);
		rInst.setLayoutY(265);
		rInst.setFont(Font.font ("Verdana", 15));
		
		Image fb= new Image("1600.png");
		
		ImageView fbIcon = new ImageView(fb);
		fbIcon.setLayoutX(180);
		fbIcon.setLayoutY(287);
		fbIcon.setFitHeight(18);
		fbIcon.setFitWidth(18);
		Label rFb = new Label(" "+newRSample.getRestaurantFb());
		rFb.setLayoutX(200);
		rFb.setLayoutY(287);
		rFb.setFont(Font.font ("Verdana", 15));
		
		
		Image tw= new Image("vector-twitter-icon-195.jpg");
		
		ImageView twIcon = new ImageView(tw);
		twIcon.setLayoutX(180);
		twIcon.setLayoutY(305);
		twIcon.setFitHeight(18);
		twIcon.setFitWidth(18);
		Label rTw = new Label(" "+newRSample.getRestaurantTwitter());
		rTw.setLayoutX(200);
		rTw.setLayoutY(305);
		rTw.setFont(Font.font ("Verdana", 15));
		
		
		
		restaurantInfoWindow = new AnchorPane();
		restaurantInfoWindow.getChildren().addAll(list,photoIV,rName,rSlogan,rDescription,rAdress,rNumber,cellIcon,vkIcon,rVk,instIcon,rInst,fbIcon,rFb,twIcon,rTw);
		mainScene.setRoot(restaurantInfoWindow);
		st2.setScene(mainScene);
		st2.show();
	}
	
	
	
	

}
