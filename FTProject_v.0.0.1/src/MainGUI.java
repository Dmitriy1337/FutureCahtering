import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class MainGUI extends Application {
	Button menuB;
	Button orderB;
	Button conditionB;
	Button aboutUsB;
	Label buttonBgImage;
	Label buttonNameInfo;
	SubScene nodeChangeScene;
	Label buttonDescription;
	Button chooseBg;
	boolean isPr = false;
	boolean isPr2 = false;
	Image demoPhoto;
	String imagepath;
	 GridPane changePane;
	Image demoLogo;
	Restaurant newRSample;
	AnchorPane restaurantInfo;
	AnchorPane restaurantInfoWindow;
	Scene mainScene;
	SystemLog sL = new SystemLog();
	Image getImage;
	ListView<String> list;
	ImageView[] imageList = new ImageView[4];
	TableColumn<Dish, String> t1,t2,t3,t4,t5,t6,t7;
	boolean isReady = false;
	AnchorPane table; 
	 ArrayList<String>buttonD;
	AnchorPane dial; 
	
	Scene dishes; 
	
	Dialog dialog; 
	TextArea tx,tx1,tx2,tx3,tx4,tx5,tx6,tx7; 
	private final TableView<Dish>mainTb = new TableView<Dish>(); 

	private final ObservableList<Dish> data = 
	FXCollections.observableArrayList();
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void start(Stage mainWindowStage) throws Exception {
		 demoPhoto = new Image("noPhoto.png");
		
		 demoLogo = new Image("logo.png");
		
		 buttonD = new ArrayList<String>();
			buttonD.add("При нажатии пользователь переходит в раздел меню, где отображается полный каталог товаров.");
			buttonD.add("При нажатии пользователю предоставляется информация о выбранных блюдах. Здесь пользователь может сделать заказ.");
			buttonD.add("При нажатии пользователю предоставляется информация о состоянии его заказа.");
			buttonD.add("При нажатии пользователю предоставляется информация о заведении.");
			
		 
		newRSample = new Restaurant("Имя_Ресторана","Ресторан_вкусной_еды","Наш ресторан готовит и продает вкусную еду","Ул.Уличная 1","+79780000000","vk.com/name","@instagramacc","facebook","@twitteracc",demoPhoto,demoLogo,imageList);
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
		dialogTableDescription();
		
		mainWindowStage.setScene(mainScene);
		mainWindowStage.show();
		
	}
public void setColumns(){
	mainTb.getColumns().addAll(t1,t2,t3,t4,t5,t6,t7);
}
	
	public void showVisualMenu(Stage st){
		Image planshetImage = new Image("planshet.png");
		ImageView planshetIV=new ImageView(planshetImage);
		AnchorPane showVisualPane = new AnchorPane();
		planshetIV.setFitWidth(350);
		planshetIV.setFitHeight(525);
		planshetIV.setLayoutX(30);
		planshetIV.setLayoutY(70);
		
		ArrayList <Label> labels = new ArrayList<Label>(); 
		
		
		Label companyName = new Label();
		companyName.setText(newRSample.getRestaurantName());
		companyName.setFont(Font.font ("Verdana", 25));
		labels.add(companyName);
		
		Label companySlogan = new Label();
		companySlogan.setText(newRSample.getRestaurantSlogan());
		companySlogan.setFont(Font.font ("Verdana", 20));
		labels.add(companySlogan);
		
		Group labelHeadGroup = new Group();
		labelHeadGroup.getChildren().add(companyName);
		labelHeadGroup.getChildren().add(companySlogan);
		companySlogan.setLayoutY(companyName.getLayoutY()+40);
		companyName.setLayoutX(labelHeadGroup.getLayoutX()+20);
		
		
		if(!isPr){
		 menuB = new Button("Меню");
		}
		menuB.setPrefHeight(40);
		menuB.setPrefWidth(130);
		
		if(!isPr){
		 orderB = new Button("Ваш Заказ");
		}
		orderB.setPrefHeight(40);
		orderB.setPrefWidth(130);
		
		
		if(!isPr){
		conditionB = new Button("Состояние заказа");
		}
		conditionB.setPrefHeight(40);
		conditionB.setPrefWidth(130);
		
		if(!isPr){
		aboutUsB = new Button("О нас");
		}
		aboutUsB.setPrefHeight(40);
		aboutUsB.setPrefWidth(130);
	
		
		
		
		Group bGroup = new Group();
		bGroup.setStyle("-fx-background-color:#000000");
		bGroup.getChildren().add(menuB);
		bGroup.getChildren().add(orderB);
		bGroup.getChildren().add(conditionB);
		bGroup.getChildren().add(aboutUsB);
		
		for(int i = 0;i<bGroup.getChildren().size();i++){
			int j = i;
			bGroup.getChildren().get(i).setOnMouseClicked(action->{
			
			Button b= (Button) bGroup.getChildren().get(j);
			changePane.getChildren().clear();
			setButtonInfo(b,st);
			
			
			
		});
		}
		orderB.setLayoutY(menuB.getLayoutY()+50);
		conditionB.setLayoutY(orderB.getLayoutY()+50);
		aboutUsB.setLayoutY(conditionB.getLayoutY()+50);
		
		
		
		BorderPane planshetPane = new BorderPane();
		BorderPane.setAlignment(labelHeadGroup, Pos.TOP_CENTER);
		//BorderPane.setAlignment(companyName, Pos.TOP_CENTER);
		BorderPane.setAlignment(bGroup, Pos.CENTER);
		
		
		planshetPane.setCenter(bGroup);
		planshetPane.setTop(labelHeadGroup);
		
		SubScene planshetScene = new SubScene(planshetPane,285,420);
		planshetScene.setLayoutX(60);
		planshetScene.setLayoutY(120);
		
		planshetPane.setStyle("-fx-background-color:#ffffff");
		
		
		for(int i= 0;i<labels.size();i++){
			int j = i;
			labels.get(i).setOnMouseEntered(click->{
				labels.get(j).setTextFill(Color.web("#1583d1"));
				
				
				
				
			});	
			labels.get(i).setOnMouseExited(click->{
				labels.get(j).setTextFill(Color.web("#000000"));
				
				
				
				
			});	
		}
		if(!isPr){
		 changePane = new GridPane();
		}
		 changePane.setPadding(new Insets(10));
		changePane.setHgap(0);
		changePane.setVgap(0);
	 
		
		if(!isPr){
		nodeChangeScene= new SubScene(changePane,400,510);//(Button b)
		}
		nodeChangeScene.setLayoutX(550);
		nodeChangeScene.setLayoutY(70);
		changePane.setStyle("-fx-background-color:#ffffff; -fx-border-color: #000000;-fx-border-width: 3px;");
		
		isPr=true;
		
		showVisualPane.getChildren().addAll(list,planshetIV,planshetScene,nodeChangeScene);
		mainScene.setRoot(showVisualPane);
		st.setScene(mainScene);
		st.show();
		
	}
	
	public void setButtonInfo(Button b,Stage st){
		ArrayList<Label>labels = new ArrayList<Label>();
		
		if(!isPr2){
		 buttonNameInfo = new Label("Кнопка "+"«"+b.getText()+"»");
		}
		labels.add(buttonNameInfo);
		buttonNameInfo.setFont(Font.font ("Verdana", 15));
		
		if(!isPr2){
		 buttonDescription= new Label();
		}
		buttonDescription.setMaxWidth(380);
		buttonDescription.setWrapText(true);
		
		if(b.getText().equals("Меню")){
			buttonDescription.setText(buttonD.get(0));
			
		}
		if(b.getText().equals("Ваш Заказ")){
			buttonDescription.setText(buttonD.get(1));
			
		}
		if(b.getText().equals("Состояние заказа")){
			buttonDescription.setText(buttonD.get(2));
	
		}
		if(b.getText().equals("О нас")){
	
			buttonDescription.setText(buttonD.get(3));
		}
		labels.add(buttonDescription);
		buttonDescription.setFont(Font.font ("Verdana", 12));
		
		if(!isPr2){
		buttonBgImage  = new Label("Фоновое изображение кнопки"+System.lineSeparator() +"(130x40): ");
		}
		buttonBgImage.setFont(Font.font ("Verdana", 12));
		
		if(!isPr2){
		chooseBg = new Button("Выбрать");
		}
		chooseBg.setPrefHeight(25);
		chooseBg.setPrefWidth(130);
		chooseBg.setOnAction(action->{

			
			chooseImage(st,b);
			
			
		});
		
		
		GridPane.setHalignment(buttonNameInfo, HPos.LEFT);
		GridPane.setHalignment(buttonDescription, HPos.LEFT);
		GridPane.setHalignment(chooseBg, HPos.RIGHT);
		GridPane.setMargin(buttonBgImage, new Insets(20,0,0,10));
		GridPane.setMargin(chooseBg, new Insets(20,0,0,0));
		changePane.add(buttonNameInfo, 0, 1,2,1);
		changePane.add(buttonDescription, 0, 2,2,1);
		changePane.add(buttonBgImage, 0, 3,1,1);
		changePane.add(chooseBg, 1, 3,1,1);
		isPr2=true;
	
	}
	
	
	
	public void listenMenu(String args,Stage st){
		
		if(args.replaceAll(" ","").equals("МойРесторан") ){
			showRestaurantInfo(st);
			
		}
		if(args.replaceAll(" ","").equals("Каталогтоваров")){ 
			showTable(st); 
			}
		if(args.replaceAll(" ","").equals("Визуализацияменю")){ 
			showVisualMenu(st);
			}
	}
	
	public void chooseImage(Stage stage,Button b){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Image");
		configureFileChooser(fileChooser);
		 Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	File file = fileChooser.showOpenDialog(stage);
	            	
					try {
						imagepath = file.toURI().toURL().toString();
						getImage = new Image( imagepath);
					
						sL.logN("/"+getImage.toString());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BackgroundImage backgroundImage = new BackgroundImage( getImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					
					Background background = new Background(backgroundImage);
					
					b.setBackground(background);
	            
	            }});
	}
	
	
	public void dialogTableDescription(){
		dialog = new Dialog();
		dialog.initStyle(StageStyle.UTILITY);
		AnchorPane ap = new AnchorPane();
		ap.setPrefWidth(400);
		ap.setPrefHeight(250);
		Label lb  =new Label("Название");
		lb.setLayoutX(5);
		lb.setLayoutY(4);
		ap.getChildren().add(lb);
		Label lb1  =new Label("Ингредиенты");
		lb1.setLayoutX(5);
		lb1.setLayoutY(60);
		ap.getChildren().add(lb1);
		Label lb2  =new Label("Ккл");
		lb2.setLayoutX(5);
		lb2.setLayoutY(155);
		ap.getChildren().add(lb2);
		Label lb3  =new Label("Категория");
		lb3.setLayoutX(5);
		lb3.setLayoutY(215);
		ap.getChildren().add(lb3);
		Label lb4 =new Label("Описание");
		lb4.setLayoutX(220);
		lb4.setLayoutY(4);
		ap.getChildren().add(lb4);
		Label lb5  =new Label("Белки/Жиры/Углеводы");
		lb5.setLayoutX(130);
		lb5.setLayoutY(174);
		ap.getChildren().add(lb5);
		Label lb6  =new Label("Цена");
		lb6.setLayoutX(350);
		lb6.setLayoutY(174);
		ap.getChildren().add(lb6);
		 tx =new TextArea();
		tx.setLayoutX(5);
		tx.setLayoutY(22);
		tx.setPrefSize(100, 25);
		 tx1 =new TextArea();
		tx1.setLayoutX(5);
		tx1.setLayoutY(80);
		tx1.setPrefSize(100, 75);
		 tx2 =new TextArea();
		tx2.setLayoutX(5);
		tx2.setLayoutY(175);
		tx2.setPrefSize(100, 15);
		 tx3 =new TextArea();
		tx3.setLayoutX(5);
		tx3.setLayoutY(235);
		tx3.setPrefSize(100, 25);
		 tx4 =new TextArea();
		tx4.setLayoutX(130);
		tx4.setLayoutY(22);
		tx4.setPrefSize(250, 145);
		 tx5 =new TextArea();
		tx5.setLayoutX(130);
		tx5.setLayoutY(195);
		tx5.setPrefSize(128, 75);
		 tx6 =new TextArea();
		tx6.setLayoutX(275);
		tx6.setLayoutY(195);
		tx6.setPrefSize(105, 25);
		ap.getChildren().addAll(tx,tx1,tx2,tx3,tx4,tx5,tx6);
		dialog.getDialogPane().setContent(ap);
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
		
		
		
	}
	
	
	public void showRestaurantInfo(Stage st2){
		
		double socialN_X=125;
		double socialN_Y=220;
		
		ImageView photoIV = new ImageView(demoPhoto);
		ImageView logoIV = new ImageView(demoLogo);
		
		//photoIV.setLayoutX(120);
		//photoIV.setLayoutY(65);
		photoIV.setFitHeight(145);
		photoIV.setFitWidth(150);
		HBox hBox_outter_0 = new HBox();
	      String style_outter_0 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_0.setStyle(style_outter_0);
	 
	      hBox_outter_0.getChildren().add(photoIV);
	      hBox_outter_0.setLayoutX(120);
	      hBox_outter_0.setLayoutY(65);
		
	      photoIV.setOnMouseClicked(action->{
			
			dialogContentImage(st2,photoIV);
			
		});
	      photoIV.setOnMouseEntered(action->{
				 String style_outter_4e = "-fx-border-color:#1583d1;"
			              + "-fx-border-width: 2;";
			      hBox_outter_0.setStyle(style_outter_4e);
				
			});
	      photoIV.setOnMouseExited(action->{
		
				String style_outter_4e = "-fx-border-color:black;"
			              + "-fx-border-width: 2;";
			      hBox_outter_0.setStyle(style_outter_4e);
			});
		ArrayList<Label> labels= new ArrayList<Label>();
		
		
		Label rName = new Label(" "+newRSample.getRestaurantName());
		rName.setLayoutX(280);
		rName.setLayoutY(70);
		rName.setFont(Font.font ("Verdana", 23));
		labels.add(rName);
		
		
		Label rSlogan = new Label(newRSample.getRestaurantSlogan());
		rSlogan.setLayoutX(280);
		rSlogan.setLayoutY(100);
		rSlogan.setFont(Font.font ("Verdana", 18));
		labels.add(rSlogan);
		
		Label rDescription = new Label(newRSample.getRestaurantDescription());
		rDescription.setLayoutX(280);
		rDescription.setLayoutY(125);
		rDescription.setFont(Font.font ("Verdana", 17));
		labels.add(rDescription);
		
		Label rAdress = new Label(newRSample.getRestaurantAdress());
		rAdress.setLayoutX(socialN_X);
		rAdress.setLayoutY(330);
		rAdress.setFont(Font.font ("Verdana", 15));
		labels.add(rAdress);
		
		
		Image cell = new Image("191.png");
		
		ImageView cellIcon = new ImageView(cell);
		cellIcon.setLayoutX(socialN_X);
		cellIcon.setLayoutY(220);
		cellIcon.setFitHeight(20);
		cellIcon.setFitWidth(20);
		Label rNumber = new Label(" "+newRSample.getRestaurantNumber());
		rNumber.setLayoutX(socialN_X+20);
		rNumber.setLayoutY(220);
		rNumber.setFont(Font.font ("Verdana", 15));
		labels.add(rNumber);
		
		
		
		Image vk= new Image("25684.png");
		
		ImageView vkIcon = new ImageView(vk);
		vkIcon.setLayoutX(socialN_X);
		vkIcon.setLayoutY(245);
		vkIcon.setFitHeight(20);
		vkIcon.setFitWidth(20);
		Label rVk = new Label(" "+newRSample.getRestaurantVk());
		rVk.setLayoutX(socialN_X+20);
		rVk.setLayoutY(245);
		rVk.setFont(Font.font ("Verdana", 15));
		labels.add(rVk);
		
		
		Image inst= new Image("174855.png");
		
		ImageView instIcon = new ImageView(inst);
		instIcon.setLayoutX(socialN_X);
		instIcon.setLayoutY(265);
		instIcon.setFitHeight(20);
		instIcon.setFitWidth(20);
		Label rInst = new Label(" "+newRSample.getRestaurantInst());
		rInst.setLayoutX(socialN_X+20);
		rInst.setLayoutY(265);
		rInst.setFont(Font.font ("Verdana", 15));
		labels.add(rInst);
		
		
		
		
		Image fb= new Image("1600.png");
		
		ImageView fbIcon = new ImageView(fb);
		fbIcon.setLayoutX(socialN_X);
		fbIcon.setLayoutY(287);
		fbIcon.setFitHeight(18);
		fbIcon.setFitWidth(18);
		Label rFb = new Label(" "+newRSample.getRestaurantFb());
		rFb.setLayoutX(socialN_X+20);
		rFb.setLayoutY(287);
		rFb.setFont(Font.font ("Verdana", 15));
		labels.add(rFb);
		
		Image tw= new Image("vector-twitter-icon-195.jpg");
		
		ImageView twIcon = new ImageView(tw);
		twIcon.setLayoutX(socialN_X);
		twIcon.setLayoutY(310);
		twIcon.setFitHeight(18);
		twIcon.setFitWidth(18);
		Label rTw = new Label(" "+newRSample.getRestaurantTwitter());
		rTw.setLayoutX(socialN_X+20);
		rTw.setLayoutY(310);
		rTw.setFont(Font.font ("Verdana", 15));
		labels.add(rTw);
		
		
		
		ImageView photo1 = new ImageView(demoPhoto);
		imageList[0] = photo1;
		//photo1.setLayoutX(300);
		//photo1.setLayoutY(210);
		photo1.setFitHeight(100);
		photo1.setFitWidth(100);
		 HBox hBox_outter = new HBox();
	      String style_outter = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter.setStyle(style_outter);
	 
	      hBox_outter.getChildren().add(photo1);
	      hBox_outter.setLayoutX(720);
	      hBox_outter.setLayoutY(70);
		
		photo1.setOnMouseClicked(action->{
			
			dialogContentImage(st2,photo1);
			imageList[0] = photo1;
			newRSample.setImageList(imageList);
		});
		photo1.setOnMouseEntered(action->{
			 String style_outter_4e = "-fx-border-color:#1583d1;"
		              + "-fx-border-width: 2;";
		      hBox_outter.setStyle(style_outter_4e);
			
		});
		photo1.setOnMouseExited(action->{
	
			String style_outter_4e = "-fx-border-color:black;"
		              + "-fx-border-width: 2;";
		      hBox_outter.setStyle(style_outter_4e);
		});
		ImageView photo2 = new ImageView(demoPhoto);
		imageList[1] = photo2;
		//photo2.setLayoutX(720);
		//photo2.setLayoutY(200);
		photo2.setFitHeight(100);
		photo2.setFitWidth(100);
		
		 HBox hBox_outter_2 = new HBox();
	      String style_outter_2 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_2.setStyle(style_outter_2);
	 
	      hBox_outter_2.getChildren().add(photo2);
	      hBox_outter_2.setLayoutX(720);
	      hBox_outter_2.setLayoutY(175);
		
		photo2.setOnMouseClicked(action->{
			
			dialogContentImage(st2,photo2);
			imageList[1] = photo2;
			newRSample.setImageList(imageList);
		});
		photo2.setOnMouseEntered(action->{
			 String style_outter_4e = "-fx-border-color:#1583d1;"
		              + "-fx-border-width: 2;";
		      hBox_outter_2.setStyle(style_outter_4e);
			
		});
		photo2.setOnMouseExited(action->{
	
			String style_outter_4e = "-fx-border-color:black;"
		              + "-fx-border-width: 2;";
		      hBox_outter_2.setStyle(style_outter_4e);
		});
		
		
		ImageView photo3 = new ImageView(demoPhoto);
		imageList[2] = photo3;
		
		photo3.setFitHeight(100);
		photo3.setFitWidth(100);
		HBox hBox_outter_3 = new HBox();
	      String style_outter_3 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_3.setStyle(style_outter_3);
	 
	      hBox_outter_3.getChildren().add(photo3);
	      hBox_outter_3.setLayoutX(720);
	      hBox_outter_3.setLayoutY(280);
		
		photo3.setOnMouseClicked(action->{
			
			dialogContentImage(st2,photo3);
			imageList[2] = photo3;
			newRSample.setImageList(imageList);
		});
		photo3.setOnMouseEntered(action->{
			 String style_outter_4e = "-fx-border-color:#1583d1;"
		              + "-fx-border-width: 2;";
		      hBox_outter_3.setStyle(style_outter_4e);
			
		});
		photo3.setOnMouseExited(action->{
	
			String style_outter_4e = "-fx-border-color:black;"
		              + "-fx-border-width: 2;";
		      hBox_outter_3.setStyle(style_outter_4e);
		});
		
		
		ImageView photo4 = new ImageView(demoPhoto);
		imageList[3] = photo4;
		photo4.setLayoutX(615);
		photo4.setLayoutY(210);
		photo4.setFitHeight(100);
		photo4.setFitWidth(100);
		
		HBox hBox_outter_4 = new HBox();
	      String style_outter_4 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_4.setStyle(style_outter_4);
	 
	      hBox_outter_4.getChildren().add(photo4);
	      hBox_outter_4.setLayoutX(720);
	      hBox_outter_4.setLayoutY(385);
		
		photo4.setOnMouseClicked(action->{
			
			dialogContentImage(st2,photo4);
			imageList[3] = photo4;
			newRSample.setImageList(imageList);
		});
		photo4.setOnMouseEntered(action->{
			 String style_outter_4e = "-fx-border-color:#1583d1;"
		              + "-fx-border-width: 2;";
		      hBox_outter_4.setStyle(style_outter_4e);
			
		});
		photo4.setOnMouseExited(action->{
	
			String style_outter_4e = "-fx-border-color:black;"
		              + "-fx-border-width: 2;";
		      hBox_outter_4.setStyle(style_outter_4e);
		});
		
		
		for(int i = 0;i<8;i++){
		int j = i;
			labels.get(i).setOnMouseClicked(click->{
			dialogContentLabel(labels.get(j),labels.get(j).getText(),j);
			
			
			
		});	
		 
			labels.get(i).setOnMouseEntered(click->{
				labels.get(j).setTextFill(Color.web("#1583d1"));
				
				
				
				
			});	
			labels.get(i).setOnMouseExited(click->{
				labels.get(j).setTextFill(Color.web("#000000"));
				
				
				
				
			});	
			
		}
		
		
		
		restaurantInfoWindow = new AnchorPane();
		restaurantInfoWindow.getChildren().addAll(list,hBox_outter_0,rName,rSlogan,rDescription,rAdress,rNumber,cellIcon,vkIcon,rVk,instIcon,rInst,fbIcon,rFb,twIcon,rTw,hBox_outter,hBox_outter_2,hBox_outter_3,hBox_outter_4);
		mainScene.setRoot(restaurantInfoWindow);
		st2.setScene(mainScene);
		
		st2.show();
	}
	
	
	
	 private static void configureFileChooser(
		        final FileChooser fileChooser) {      
		            fileChooser.setTitle("View Pictures");
		            fileChooser.setInitialDirectory(
		                new File(System.getProperty("user.home"))
		            );                 
		            fileChooser.getExtensionFilters().addAll(
		               // new FileChooser.ExtensionFilter("All Images", "*.*"),
		                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png")
		            );
		    }
	
	public void dialogContentImage(Stage stage,ImageView iv){//ImageView iv,int id,Stage stage
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		 Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	File file = fileChooser.showOpenDialog(stage);
	            	String imagepath;
					try {
						imagepath = file.toURI().toURL().toString();
						getImage = new Image( imagepath);
					
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            	iv.setImage(getImage);
	            	iv.setStyle("-fx-border-color: black; -fx-border-style: solid;	  -fx-border-width: 5;");
	            	
	           
	            
	            }
	        });
		
		
		
	}
	
	
	public void dialogContentLabel(Label label,String content,int id){
		 Stage dialog = new Stage();
         dialog.setTitle(content);
		 dialog.initStyle(StageStyle.UNDECORATED);
         AnchorPane dWindow = new AnchorPane();
        dWindow.setStyle(" -fx-background-color: #ffffff ;-fx-border-color: #4a90c2;  -fx-border-width: 2px; ");
       
        
        
        TextArea enterField = new TextArea();
         enterField.setLayoutX(5);
         enterField.setLayoutY(5);
         enterField.setPrefWidth(250);
         enterField.setPrefHeight(100);
         
         Button okButton = new Button("Ok");
         okButton.setLayoutX(50);
         okButton.setLayoutY(110);
         okButton.setPrefHeight(30);
         okButton.setPrefWidth(75);
         okButton.setOnAction(action->{
        	 label.setText(" "+enterField.getText());
        	 
        	 if(id==0){
        		 newRSample.setRestaurantName(enterField.getText());
        	 }
        	 if(id==1){
        		 newRSample.setRestaurantSlogan(enterField.getText());
        	 }
        	 if(id==2){
        		 newRSample.setRestaurantDescription(enterField.getText());
        	 }
        	 if(id==3){
        		 newRSample.setRestaurantAdress(enterField.getText());
        	 }
        	 if(id==4){
        		 newRSample.setRestaurantNumber(enterField.getText());
        	 }
        	 if(id==5){
        		 newRSample.setRestaurantVk(enterField.getText());
        	 }
        	 if(id==6){
        		 newRSample.setRestaurantInst(enterField.getText());
        	 }
        	 if(id==7){
        		 newRSample.setRestaurantFb(enterField.getText());
        	 }
        	 if(id==8){
        		 newRSample.setRestaurantTwitter(enterField.getText());
        	 }
        	 
        	 dialog.close(); 
        	 
         });
         
         
         Button cancelButton = new Button("Cancel");
         cancelButton.setLayoutX(150);
         cancelButton.setLayoutY(110);
         cancelButton.setPrefHeight(30);
         cancelButton.setPrefWidth(75);
         cancelButton.setOnAction(action->{
        	 dialog.close(); 
        	 
        	 
         });
         
         dWindow.getChildren().addAll(enterField,okButton,cancelButton);
         Scene scene = new Scene(dWindow,260,150);
         
         dialog.setScene(scene);
         dialog.show();
		
		
	}
	
	public void showTable(Stage st3){
		 Callback<TableColumn<Dish, String>, 
        TableCell<Dish, String>> cellFactory
            = (TableColumn<Dish, String> p) -> new EditingCell();

		
		mainTb.setEditable(true);
		 mainTb.setLayoutX(50);
		mainTb.setLayoutY(60);
		mainTb.setPrefHeight(460);
		mainTb.setPrefWidth(910);
		mainTb.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	  
		 t1 = 
	            new TableColumn<>();
		t1.setText("   Название   ");
		t1.setResizable(false);
		
		t1.setPrefWidth(100);
		t1.setCellFactory(cellFactory); 
		t1.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishName")
	        );
		 t1.setOnEditCommit(
		            (CellEditEvent<Dish, String> t) -> {
		                ((Dish) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setDishName(t.getNewValue());
		        });      
		  t2 = 
		            new TableColumn<>();
		 t2.setResizable(false);
		 t2.setText("                                   Описание                               ");
		t2.setPrefWidth(300);
		t2.setCellFactory(cellFactory); 
		t2.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishDescription")
	        );
		t2.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishDescription(t.getNewValue());
	        });     
		t3 = 
		            new TableColumn<>();
		t3.setText("  Ингредиенты  ");
		t3.setResizable(false);
		t3.setPrefWidth(110);
		t3.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishIngredients")
	        );
		t3.setCellFactory(cellFactory); 
		t3.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishIngredients(t.getNewValue());
	        });   
		 t4 = 
	            new TableColumn<>();
		t4.setText("  Категория  ");
		t4.setResizable(false);
		t4.setPrefWidth(100);
		t4.setCellFactory(cellFactory); 
		t4.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishRefer")
	        );
		t4.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishRefer(t.getNewValue());
	        });   
		 t5 = 
	            new TableColumn<>();
		t5.setText(" Белки/Жиры/Углеводы ");
		t5.setPrefWidth(170);
		t5.setResizable(false);
		t5.setCellFactory(cellFactory); 
		t5.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishHValue")
	        );
		t5.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishHValue(t.getNewValue());
	        });
		 t6 = 
	            new TableColumn<>();
		t6.setText(" Ккал ");
		t6.setResizable(false);
		t6.setPrefWidth(60);
		t6.setCellFactory(cellFactory); 
		t6.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishKkl")
	        );
		t6.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishKkl(t.getNewValue());
	        });
		 t7 = 
	            new TableColumn<>();
		t7.setText("Цена(р.)");
		t7.setResizable(false);
		t7.setPrefWidth(70);
		t7.setCellFactory(cellFactory); 
		t7.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishPrice")
	        );
		t7.setOnEditCommit(
	            (CellEditEvent<Dish, String> t) -> {
	                ((Dish) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDishPrice(t.getNewValue());
	        });
		mainTb.setItems(data);
		if(!isReady){
		mainTb.getColumns().addAll(t1,t2,t3,t4,t5,t6,t7);
		}
		final TextField addFirstName = new TextField();
       addFirstName.setPromptText("First Name");
       addFirstName.setMaxWidth(t1.getPrefWidth());
		
       Button add  = new Button();
		add.setText("Добавить");
		add.setLayoutX(50);
		add.setLayoutY(530);
		add.setPrefHeight(40);
		add.setPrefWidth(100);
		add.setOnAction(ad->{
			dialog.showAndWait();
		if(dialog.getResult().equals(ButtonType.OK)){
			data.add(new Dish(tx.getText(),tx4.getText(),tx1.getText(),
					tx3.getText(),tx5.getText(),tx2.getText(),tx6.getText()));
		}
		
	});
		Button safe  = new Button();
		safe.setText("Сохранить");
		safe.setLayoutX(170);
		safe.setLayoutY(530);
		safe.setPrefHeight(40);
		safe.setPrefWidth(100);
		
		Button del  = new Button();
		del.setText("Удалить");
		del.setLayoutX(290);
		del.setLayoutY(530);
		del.setPrefHeight(40);
		del.setPrefWidth(100);
		
		
		table = new AnchorPane();
		table.getChildren().addAll(list,mainTb,add,safe,del);
		mainScene.setRoot(table);
		st3.setScene(mainScene);
		st3.show();
	
		isReady = true;
	}
	
	
	class EditingCell extends TableCell<Dish, String> {
		 
	        private TextArea textField;
	 
	        public EditingCell() {
	        }
	 
	        @Override
	        public void startEdit() {
	            if (!isEmpty()) {
	                super.startEdit();
	                createTextField();
	                setText(null);
	                setGraphic(textField);
	                textField.selectAll();
	            }
	        }
	 
	        @Override
	        public void cancelEdit() {
	            super.cancelEdit();
	 
	            setText((String) getItem());
	            setGraphic(null);
	        }
	 
	        @Override
	        public void updateItem(String item, boolean empty) {
	            super.updateItem(item, empty);
	 
	            if (empty) {
	                setText(null);
	                setGraphic(null);
	            } else {
	                if (isEditing()) {
	                    if (textField != null) {
	                        textField.setText(getString());
	                    }
	                    setText(null);
	                    setGraphic(textField);
	                } else {
	                    setText(getString());
	                    setGraphic(null);
	                }
	            }
	        }
	 
	        private void createTextField() {
	            textField = new TextArea(getString());
	            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
	            textField.focusedProperty().addListener(
	                (ObservableValue<? extends Boolean> arg0, 
	                Boolean arg1, Boolean arg2) -> {
	                    if (!arg2) {
	                        commitEdit(textField.getText());
	                    }
	            });
	        }
	 
	        private String getString() {
	            return getItem() == null ? "" : getItem().toString();
	        }
	    }

}
