import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainBody extends Application  implements Initializable{
	AnchorPane startPane;
	AnchorPane menuPane;
	AnchorPane currentPane;
	
	JFXDrawer menu;
	JFXHamburger ham;
	@FXML
	public Node node1;
	public boolean menuIsOpen = false;
	
	double width;
	double height;
	
	ArrayList<String> components = new ArrayList<String>();
	HashMap<String,AbstractTab> pagesMap = new HashMap<String,AbstractTab>();
	
	
	
	public MainBody(){}
	public static void main(String[] args) {
	launch(args);
	}
		public void fillList(){
			components.add("HelloTab");
			components.add("HeadTab");
			components.add("MenuTab");
			components.add("OrderTab");
			components.add("Fourth");
			components.add("Fifth");
			components.add("Sixth");
			components.add("Seventh");
			components.add("Seventh");
			
	
		}
		
		
		public void fillPageMap(Stage s){
			pagesMap.put("HelloTab",new HelloTab("1"));
			pagesMap.put( "HeadTab",new HeadTab("2",1));
			pagesMap.put( "MenuTab",new MenuTab("3"));
			pagesMap.put( "OrderTab",new OrderTab("4",s));
		}
	
		
		
		
	@Override
	public void start(Stage stage) throws Exception {
		DataBase userDataDB = new DataBase();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth()-600;
	    height = screenSize.getHeight()-380;
		
		fillList();
		fillPageMap(stage);
		stage.setTitle("FutureService");
		 startPane = (AnchorPane) loadPane("MainPane.fxml","AnchorPane");
		 menuPane = (AnchorPane) loadPane("MenuPane.fxml","AnchorPane");
		 ScrollPane buttons = (ScrollPane)menuPane.getChildren().get(1);
		 AnchorPane buttonPane = (AnchorPane)buttons.getContent();
		
		 
		 buttonPane.setPrefSize(menuPane.getPrefWidth(), components.size()*50);
		
			
			
		
		 
		 
		 menu =new JFXDrawer();
		 menu.setLayoutX(0);
		 menu.setLayoutY(0);
		menu.setDefaultDrawerSize(260);
	
		 menu.setSidePane(menuPane);
		menu.setOnDrawerClosed(f->{
			 if(menu.isShown()){
				
			 }
			 else{	
				
			 }
			
			
		});
		 menu.setPrefHeight(800);
		 
		 ham = new JFXHamburger();
		 ham.setVisible(false);
		 ham.setLayoutX(5);
		 ham.setLayoutY(7);
			ham.setOnMouseClicked(event->{
				if(!menuIsOpen){
				menuIsOpen = true;
				}	
				else{
					menuIsOpen = false;
				}
				
					System.out.println("clicked");
				 if(!menuIsOpen){
					 System.out.println("clicked1");
					 menu.close();
					 menu.setPrefWidth(1);	 
				 }
				 else{	
					 
					 menu.open();
					 menu.setPrefWidth(1600);
					 System.out.println("clicked2"+menu.isShowing());
				 }
				
				
			});
		
		menu.setOnDrawerClosed(e->{
			
			menu.setPrefWidth(1);	 	
		});
		 
		 Scene mScene = new Scene(startPane,width,height);
		
		 stage.setMinHeight(500);
		//stage.set
		stage.setMinWidth(700);
		HelloTab tab= (HelloTab) pagesMap.get(components.get(0));
		currentPane = (AnchorPane)tab.getPane();
		
		AnchorPane ap = (AnchorPane)tab.getPane();
		Group a = (Group) ap.getChildren().get(2);
		AnchorPane a1 = (AnchorPane) a.getChildren().get(0);
		JFXButton logIn= (JFXButton) a1.getChildren().get(5);
		JFXTextField login = (JFXTextField) a1.getChildren().get(2);
		JFXPasswordField password = (JFXPasswordField) a1.getChildren().get(4);
		logIn.setOnMouseClicked(s->{
			if(userDataDB.isMatch(login.getText(), password.getText())){
			
				ham.setVisible(true);
			 

			Platform.runLater(new Runnable(){
				public void run(){
			
					System.out.println(startPane.getChildren().toString());
					ScrollPane anPane;;// (AnchorPane) startPane.getChildren().get(0);
					HeadTab at= (HeadTab) pagesMap.get(components.get(1));
					
					System.out.println(startPane.getChildren().toString());
					anPane = (ScrollPane) at.getPane();
					
					
					
					
					
					FadeTransition fadeTransition = new FadeTransition();
					fadeTransition.setDuration(Duration.millis(500));
					
					fadeTransition.setFromValue(1);
					fadeTransition.setToValue(0);
					fadeTransition.setNode(currentPane);
					fadeTransition.setOnFinished(e->{
						System.out.println("finishee");
						stage.setMaximized(true);
						stage.setMinHeight(600);
						stage.setMinWidth(1000);
						startPane.getChildren().set(0, anPane);
						FadeTransition fadeTransition2 = new FadeTransition();
						fadeTransition2.setDuration(Duration.millis(500));
						
						fadeTransition2.setFromValue(0);
						fadeTransition2.setToValue(1);
						fadeTransition2.setNode(anPane);
						fadeTransition2.play();
					
					
					});
					fadeTransition.play();
					
					
					
					
					
					
				}
				});}
		
	
		});
		
		ap.getChildren().get(1).setLayoutX(((double)width/2)-110);
		ap.getChildren().get(2).setLayoutX(((double)width/2)-100);
		ap.getChildren().get(1).setLayoutY(((double)height/3)-110);
		ap.getChildren().get(2).setLayoutY(((double)height/3)-100);
		mScene.widthProperty().addListener(
				
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                  
                    	ap.getChildren().get(1).setLayoutX(((double)newValue/2)-110);
                    	ap.getChildren().get(2).setLayoutX(((double)newValue/2)-100);
                    	
                    	// AnchorPane.setRightAnchor( (ImageView)ap.getChildren().get(1), (Double) newValue/2.6);
                       //AnchorPane.setRightAnchor( (Group)ap.getChildren().get(2), (Double) newValue/2.55);
                    }}

        );
		
		mScene.heightProperty().addListener(
				
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                   
                    	
                    	ap.getChildren().get(1).setLayoutY(((double)newValue/3)-110);
                		ap.getChildren().get(2).setLayoutY(((double)newValue/3)-100);
                    	// AnchorPane.setRightAnchor( (ImageView)ap.getChildren().get(1), (Double) newValue/2.6);
                       //AnchorPane.setRightAnchor( (Group)ap.getChildren().get(2), (Double) newValue/2.55);
                    }}

        );
		
		
		
		System.out.println(currentPane.toString());
		AnchorPane.setRightAnchor(tab.getPane(), 0.0);
		AnchorPane.setLeftAnchor(tab.getPane(), 0.0);
		AnchorPane.setTopAnchor(tab.getPane(), 0.0);
		AnchorPane.setBottomAnchor(tab.getPane(), 0.0);
		startPane.getChildren().addAll(currentPane,menu,ham);//((AnchorPane)helloTab.getPane(),ham,menu);
		
		
		showMenu(components,buttonPane,stage);
		
		
		stage.setScene(mScene);
		stage.show();
		
	}

	public void animateChange(Node from,Node to){

		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(0));
		
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setNode(from);
		fadeTransition.setOnFinished(e->{
			
			startPane.getChildren().set(0, to);
			
			FadeTransition fadeTransition2 = new FadeTransition();
			fadeTransition2.setDuration(Duration.millis(300));
			
			fadeTransition2.setFromValue(0);
			fadeTransition2.setToValue(1);
			fadeTransition2.setNode(to);
			fadeTransition2.play();
		
		
		});
		fadeTransition.play();
		
	}
	
	public void showMenu(ArrayList<String> categories,AnchorPane ap,Stage stage){
		for(int i = 1;i<categories.size();i++){
			int j = i;
			JFXButton jb = new JFXButton();
			jb.setStyle("-fx-font-size:25;-fx-font-family:XXllCentarRegular");
			
			jb.setText(categories.get(i));
			jb.setPrefSize(260,50);
			jb.setLayoutY(50*(i-1));
			
			jb.setOnMouseClicked(e->{
				menuIsOpen = false;
				menu.close();
				if(j==1){
					Platform.runLater(new Runnable(){
						public void run(){
					
						
							
							ScrollPane anPane;
							HeadTab at= (HeadTab) pagesMap.get(components.get(1));
							System.out.println("//"+startPane.getChildren().toString());
							
							anPane = (ScrollPane) at.getPane();
							anPane.setPrefSize(width+540, height+360);
							
							
							animateChange(currentPane,anPane);
							
						
							
							
							System.out.println(startPane.getPrefWidth());
						}
						});
				}
					if(j==2){

						Platform.runLater(new Runnable(){
							public void run(){
						
								System.out.println(startPane.getChildren().toString());
								AnchorPane anPane ;//= (AnchorPane) startPane.getChildren().get(0);
								MenuTab at= (MenuTab) pagesMap.get(components.get(2));
								
								
								anPane = (AnchorPane) at.getPane();
								
								//startPane.getChildren().remove(0);
								animateChange(currentPane,anPane);
								System.out.println("!"+startPane.getChildren().toString());
							}
							});
					
					}
					if(j==3){
						Platform.runLater(new Runnable(){
							public void run(){
						
							
								
								AnchorPane anPane;
								OrderTab at= (OrderTab) pagesMap.get(components.get(3));
								at.fillOrderInfo();
								System.out.println("//"+startPane.getChildren().toString());
								
								anPane = (AnchorPane) at.getPane();
								anPane.setPrefSize(width+540, height+360);
								
								
								animateChange(currentPane,anPane);
								
							
								
								
								System.out.println(startPane.getPrefWidth());
							}
							});
					}
				
				
				
			});
			
			
		 ap.getChildren().add(jb);
		
		}
		
	}
	
	
	public Node loadPane(String name,String type){
		if(type.equals("AnchorPane")){
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainBody.class.getResource(name)); 
			AnchorPane ap = (AnchorPane) loader.load();
			return ap;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
		
		
		return null;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
