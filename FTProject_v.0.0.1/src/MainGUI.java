import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class MainGUI extends Application {
	
	ImageView plMPhoto,plMPhoto1,plMPhoto2,plMPhoto3,plMPhoto4;
	TextArea description;
	TextArea workDescription;
	Label rDescription;
	ImageView imVk,imInst,imFB,imTwit,imTel;
	Label vkInfo,instInfo,fbInfo,twitInfo,telInfo,adressInfo;
	int MAX_CHARS=0;
	Label descc;
	Group SocInfo;
	ImageView  selfInfo,cellIcon,vkIcon,instIcon,fbIcon,twIcon, photoIV ;
 ImageView photo1,photo2,photo3,photo4;
	 HBox   hBox_outter_0,hBox_outter,hBox_outter_2,hBox_outter_3,hBox_outter_4;
	
	 Label nam;
	 Label slog;

	
	
	
	Button menuB;
	Button orderB;
	Button conditionB;
	Button aboutUsB;
	Label buttonBgImage;
	Insets buttonMargin ;
	Label buttonNameInfo;
	ImageView planshetIV;
	String name ;
	SubScene nodeChangeScene;
	 ImageView categoryP;
	GridPane planshetPane;
	Label buttonDescription;
	Label menuChooseTopLabel;
	Label menuChooseTopDescription;
	Background background;
	GridPane planshetPane_2;
	SubScene planshetScene_1;
	int numbr;
	 Label categoryName;
	AnchorPane showVisualPane;
	SubScene planshetScene;
	double size;
	ImageView categoryIV;
	Group bGroup;
	TextField tSize;
	int counter = 0;;
	boolean isPr5 = false;
	ArrayList<Double>bTextSize;
	ArrayList<String>bTextFont;
	ChoiceBox<String> chooseFont;
	ChangeListener<String> changeListener;
	 ListCell<String> cell;
	boolean buttonImageChosen1 = false;
	boolean buttonImageChosen2 = false;
	boolean buttonImageChosen3 = false;
	boolean buttonImageChosen4 = false;
	boolean imageP = false;
	boolean imageChosen1 = false;
	boolean imageChosen2 = false;
	boolean labelP = false;
	Label setTextFont;
	Button chooseBg;
	boolean isPr = false;
	ArrayList <Label> labelsL;
	ArrayList <Label> labelsB;
	ArrayList <Color> colors;
	Label companyName;
	Label companySlogan;
	Label Tdes;
	Label TSubdes;
	boolean isPr2 = false;
	boolean isPr3 = false;
	Image demoPhoto;
	String imagepath;
	 GridPane changePane;
	 Group labelHeadGroup;
	 Image demoLogo;
	Restaurant newRSample;
	AnchorPane restaurantInfo;
	AnchorPane restaurantInfoWindow;
	Scene mainScene;
	SystemLog sL = new SystemLog();
	Image getImage;
	ChoiceBox<String> chooseLbFont1;
	ListView<String> list;
	ImageView[] imageList = new ImageView[4];
	TableColumn<Dish, String> t1,t2,t3,t4,t5,t6,t7;
	boolean isReady = false;
	 Label categoryDescr ;
	ColorPicker chooseColor;
	ArrayList<String>numbers;
	AnchorPane table; 
	 ArrayList<String>buttonD;
	AnchorPane dial; 
	 String[] fontList;
	 Insets margin;
	 ImageView planshetIV_1;
	 Label bMargin;
	 Label categoryString;
	 Label bMarginTop;
	Label bMarginBottom;
	Label bMarginLeft;
	Label bMarginRight;
	int a = 0;
	int bb = 0;
	int c= 30;
	int d = 0;
	TextField tLeft;
	TextField tRight;
	TextField tTop;
	TextField tBottom;
	String[]margines;
	Scene dishes; 
	Label colorLabel;
	Dialog dialog; 
	TextArea tx,tx1,tx2,tx3,tx4,tx5,tx6,tx7; 
	private final TableView<Dish>mainTb = new TableView<Dish>(); 
	boolean isPr6 =false;
	GridPane planshetPane_1;
	SubScene planshetScene_2;
	
	 ArrayList<Object> topLabelNameData=new ArrayList<Object>();
	 ArrayList<Object> topLabelSloganData=new ArrayList<Object>();
	 ArrayList<Object> menuButtonData=new ArrayList<Object>();
	 ArrayList<Object> orderButtonData=new ArrayList<Object>();
	 ArrayList<Object> stateButtonData=new ArrayList<Object>();
	 ArrayList<Object> aboutUsButtonData=new ArrayList<Object>();
	 ArrayList<Object> picturesData=new ArrayList<Object>();
	 
	 AnchorPane showVisualPane_1 ;
	 
	 Insets labelInsets;
	 AnchorPane showVisualPane_2;
	ColorPicker colorTextPicker;
	Label Tsize  ;
	Label Tcolor ;
	Button LabelBg;
    Label Tindent  ;
    TextField direction;
    TextField sizeT;
    
    Label Tbg ;
    
	ListView<String> listChooser;
	
	ImageView planshetIV_2;
	
	
	
	private final ObservableList<Dish> data = 
	FXCollections.observableArrayList();
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void start(Stage mainWindowStage) throws Exception {
		mainWindowStage.setResizable(false);
		demoPhoto = new Image("noPhoto.png");
		 MainSettings mainSettings = new MainSettings(topLabelNameData,topLabelSloganData,menuButtonData,orderButtonData,stateButtonData,aboutUsButtonData);
		 bTextSize = new ArrayList<Double>();
		 bTextFont = new ArrayList<String>();
		 
		 demoLogo = new Image("logo.png");
		
		 fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			
			
		 
		 buttonD = new ArrayList<String>();
			buttonD.add("При нажатии пользователь переходит в раздел меню, где отображается полный каталог товаров.");
			buttonD.add("При нажатии пользователю предоставляется информация о выбранных блюдах. Здесь пользователь может сделать заказ.");
			buttonD.add("При нажатии пользователю предоставляется информация о состоянии его заказа.");
			buttonD.add("При нажатии пользователю предоставляется информация о заведении.");
			
		 
		newRSample = new Restaurant("Имя_Ресторана","Ресторан_вкусной_еды","Наш ресторан готовит и продает вкусную еду","Ул.Уличная 1","+79780000000","vk.com/name","@instagramacc","facebook","@twitteracc",demoPhoto,demoLogo,imageList);
		mainWindowStage.setTitle("FutureCathering");
		restaurantInfo = new AnchorPane();
		restaurantInfo.setStyle("-fx-border-color:red");
		mainScene = new Scene(restaurantInfo,992,597);
		
		 list = new ListView<String>();
		 list.setStyle(" -fx-font: 11pt 'HelveticaNeueCyr';-fx-background-color:#f25327;-fx-selection-bar-text: #f25327;");
		 list.setOrientation(Orientation.HORIZONTAL);
		
		 
		 ObservableList<String> items =FXCollections.observableArrayList (
		    "         Мой Ресторан              ", "          Каталог товаров              ", "           Визуализация меню              ", "            Текущее состояние              ");
		list.setItems(items);
		
		
		
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

	        @Override
	        public ListCell<String> call(ListView<String> param) {
	            cell = new ListCell<String>() {

	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (item != null) {
	                    	cell.setPrefWidth(248);
	                    	cell.setAlignment(Pos.CENTER);
	                    	if(counter==1){
	                    		cell.setText("Мой Ресторан");
	                    	
	                    	}
	                    	if(counter==2){
	                    		cell.setText("Каталог товаров");
	                    	}
	                    	if(counter==3){
	                    		cell.setText("Визуализация меню");
	                    	}
	                    	if(counter==4){
	                    		cell.setText("Текущее состояние");
	                    	}
	                    	
	                    	
	                    	counter++;
	                    	
	                    
	                    }
	                }
	            };
	            return cell;
	        }

			
	    });
		
		
		
		list.setPrefWidth(1010);
		list.setMinWidth(1000);
		list.setPrefHeight(50);
		list.setLayoutY(-5);
		list.setLayoutX(-5);
		 
		
		
		
		list.getSelectionModel().selectedItemProperty().addListener(
		        (ObservableValue<? extends String> ov, String old_val, 
		            String new_val) -> {
		            	
		                listenMenu(new_val,mainWindowStage);
		    });
		
		
		
		
		listChooser = new ListView<String>();
		listChooser.setOrientation(Orientation.VERTICAL);
		ObservableList<String> chooseItems =FXCollections.observableArrayList (" Главное меню "," Выбор категории "," Выбор блюда "," Описание блюда ");
		listChooser.setItems(chooseItems);
		
		listChooser.setPrefWidth(150);
		listChooser.setPrefHeight(100);
		listChooser.setLayoutX(390);
		listChooser.setLayoutY(80);
		
		listChooser.getSelectionModel().selectedItemProperty().addListener(
		        (ObservableValue<? extends String> ov, String old_val, 
		            String new_val) -> {
		                
		                listenChooserMenu(new_val,mainWindowStage);
		    });
		
		
		
		list.getStyleClass().add("lists");
		listChooser.getStyleClass().add("lists");
		
		
		restaurantInfo.getChildren().add(list);
		dialogTableDescription();
		mainScene.getStylesheets().add(this.getClass().getResource("list.css").toExternalForm());
		
		mainWindowStage.setScene(mainScene);
		mainWindowStage.show();
		
	}
public void setColumns(){
	mainTb.getColumns().addAll(t1,t2,t3,t4,t5,t6,t7);
}
	
	public void listenChooserMenu(String args,Stage st){
		if(args.replaceAll(" ","").equals("Выборкатегории") ){
			showChooseCategoryMenu(st);
			
		}
		if(args.replaceAll(" ","").equals("Главноеменю") ){
			showVisualMenu(st);
			
		}
		if(args.replaceAll(" ","").equals("Выборблюда") ){
			showDishMenu(st);
			sL.logN("h");
		}
		
	}
		
	
	
	public void showDishMenu(Stage st){
		 
		
		
		showVisualPane_2 = new AnchorPane();
		if(!isPr6){	
		Image planshetImage = new Image("planshet.png");
		Image dishBGImage = new Image("dishBG.png");
		Image dishPhotoImage = new Image("dishImage.png");
			  planshetIV_2 = new ImageView(planshetImage);
			 planshetIV_2.setFitWidth(350);
			 planshetIV_2.setFitHeight(525);
			 planshetIV_2.setLayoutX(30);
			 planshetIV_2.setLayoutY(70);
			
			 planshetPane_2 = new GridPane();
			 planshetPane_2.setAlignment(Pos.TOP_CENTER);
			
			 
			categoryString  = new Label("Категория");
			 labelsL.add(categoryString);
			 colors.add((Color) categoryString.getTextFill());
			 categoryString.setFont(Font.font ("HelveticaNeueCyr", 25));//
			 numbers.add("5");
			
			
			
			categoryDescr  = new Label("Выберите блюдо:");
			 labelsL.add(categoryDescr);
			 colors.add((Color) categoryDescr.getTextFill());
			 categoryDescr.setFont(Font.font ("HelveticaNeueCyr", 15));//
			 numbers.add("6");
			
			 ImageView dishBG = new ImageView(dishBGImage);
			 dishBG.setFitWidth(350/1.3);
			 dishBG.setFitHeight(120);
			 
			 ImageView dishImageIV = new ImageView(dishPhotoImage);
			 dishImageIV.setFitWidth(150/1.5);
			 dishImageIV.setFitHeight(150/1.5);
			 
			 planshetPane_2.setVgap(10);
			 planshetPane_2.add(categoryString, 0, 0,2,1);
			 planshetPane_2.add(categoryDescr, 0, 1,2,1);
			 planshetPane_2.add(dishBG, 0,2,2,1);
			 planshetPane_2.add(dishImageIV, 0,2,2,1);
			GridPane.setHalignment(categoryString, HPos.CENTER);
			GridPane.setHalignment(dishImageIV, HPos.LEFT);
			GridPane.setValignment(dishImageIV, VPos.TOP);
			GridPane.setHalignment(categoryDescr, HPos.CENTER);
			GridPane.setMargin(dishImageIV,new Insets(5,0,0,10));
			
			
			setLabelListener(st);
			 planshetScene_2 = new SubScene(planshetPane_2,285,420);
			planshetScene_2.setLayoutX(60);
			planshetScene_2.setLayoutY(120);
			
		
			
			
			
		}
		showVisualPane_2.getChildren().addAll(list,listChooser,planshetIV_2,planshetScene_2,nodeChangeScene);	
		mainScene.setRoot(showVisualPane_2);
			st.setScene(mainScene);
			st.show();
			
		isPr6 = true;
		
	}
	
	
	
	
	public void showChooseCategoryMenu(Stage st){
		
		 showVisualPane = new AnchorPane();
		Image planshetImage = new Image("planshet.png");
		Image categoryImage = new Image("category.png");
		 planshetIV=new ImageView(planshetImage);
		planshetIV.setFitWidth(350);
		planshetIV.setFitHeight(525);
		planshetIV.setLayoutX(30);
		planshetIV.setLayoutY(70);
		
		
		 categoryIV=new ImageView(categoryImage);
		categoryIV.setFitWidth(350/1.3);
		categoryIV.setFitHeight(100/1.3+10);
		
		
		
		
		
		
		if(!isPr5){
		 planshetPane = new GridPane();
		planshetPane.setAlignment(Pos.TOP_CENTER);
		
		
		categoryIV.setOnMouseEntered(click->{
		
			sL.logN("true");
			//labelP = true;
			imageP = true;
			
		});	
		categoryIV.setOnMouseExited(click->{
			
			
			//labelP = false;
			imageP = false;
			
		});	
		categoryIV.setOnMouseClicked(action->{
			
			sL.logN("action commited");
			chooseImageIV(st,categoryIV,0);
		});
		
	}
		
		if(!isPr5){
		menuChooseTopLabel = new Label("Меню");
		 labelsL.add(menuChooseTopLabel);
		 colors.add((Color) menuChooseTopLabel.getTextFill());
		 menuChooseTopLabel.setFont(Font.font ("HelveticaNeueCyr", 25));//
		 numbers.add("2");
		 
		 
		 
		 menuChooseTopDescription= new Label("Выберите категорию блюда");
		 labelsL.add(menuChooseTopDescription);
		 colors.add((Color) menuChooseTopDescription.getTextFill());
		 menuChooseTopDescription.setFont(Font.font ("HelveticaNeueCyr", 16));//
		 numbers.add("3");
		
		 Image testI = new Image("test.png");
		  categoryP= new ImageView(testI);
		 categoryP.setFitWidth(106);
		 categoryP.setFitHeight(70);
		 
		
		 
		 
		 
		  categoryName = new Label("Категория");
		 labelsL.add(categoryName);
		 colors.add((Color) categoryName.getTextFill());
		 categoryName.setFont(Font.font ("HelveticaNeueCyr", 18));//
		 categoryName.setPrefWidth(150);
		 categoryName.setWrapText(true);
		 numbers.add("4");
		 
		 
		 setLabelListener(st);
		 planshetPane.add(menuChooseTopLabel, 1, 0,2,1);
		 planshetPane.add(menuChooseTopDescription, 0, 1,2,1);
		 
		 
		 
		
		 planshetPane.add(categoryIV, 0, 2,2,1);
		 planshetPane.add(categoryP, 0, 2,2,1);
		 planshetPane.add(categoryName, 0, 2,2,1);
		GridPane.setHalignment(categoryIV, HPos.CENTER);
		 GridPane.setMargin(categoryIV, new Insets(30,0,0,0));
		 GridPane.setMargin(categoryName, new Insets(25,0,0,140));
		 GridPane.setMargin(menuChooseTopLabel, new Insets(0,0,0,0));
		 GridPane.setMargin(categoryP, new Insets(31,0,0,15));
		 GridPane.setHalignment(menuChooseTopLabel, HPos.CENTER);
		GridPane.setHalignment(menuChooseTopDescription, HPos.CENTER);
		 planshetScene = new SubScene(planshetPane,285,420);
		planshetScene.setLayoutX(60);
		planshetScene.setLayoutY(120);
		planshetPane.setOnMouseClicked(action->{
			sL.logN("planshetPanepressed "+labelP);
			chooseImageBG(st,planshetPane,0);
			
		});
		
		
		}
		
		
		showVisualPane.getChildren().addAll(list,listChooser,planshetIV,planshetScene,nodeChangeScene);
		mainScene.setRoot(showVisualPane);
		st.setScene(mainScene);
		st.show();
		isPr5 = true;
	}


	
	
	
	
	
	

public void showVisualMenu(Stage st){
	 showVisualPane_1 = new AnchorPane();
	Image planshetImage = new Image("planshet.png");
		 planshetIV_1=new ImageView(planshetImage);
		
		planshetIV_1.setFitWidth(350);
		planshetIV_1.setFitHeight(525);
		planshetIV_1.setLayoutX(30);
		planshetIV_1.setLayoutY(70);
		
		
		
		if(!isPr){
		labelsL = new ArrayList<Label>(); 
		numbers = new ArrayList<String>();
		colors= new ArrayList<Color>();
		}
		if(!isPr){
		 companyName = new Label();
		 companyName.setAlignment(Pos.CENTER);
		companyName.setFont(Font.font ("HelveticaNeueCyr", 25));//
		
		
		}
		
		companyName.setText(newRSample.getRestaurantName());
		if(!isPr){
		labelsL.add(companyName);
		numbers.add("0");
		colors.add((Color) companyName.getTextFill());
		companySlogan = new Label();
		
		companySlogan.setFont(Font.font ("HelveticaNeueCyr", 20));
		colors.add((Color) companySlogan.getTextFill());
		labelsL.add(companySlogan);
		numbers.add("1");
		}
		companySlogan.setText(newRSample.getRestaurantSlogan());
		labelHeadGroup = new Group();
		labelHeadGroup.getChildren().add(companyName);
		labelHeadGroup.getChildren().add(companySlogan);
		companySlogan.setLayoutY(companyName.getLayoutY()+40);
		companyName.setLayoutX(labelHeadGroup.getLayoutX()+20);
		
		
		if(!isPr){
		 menuB = new Button("Меню");
		 menuB.setPrefHeight(40);
		menuB.setPrefWidth(170);
		menuB.setAlignment(Pos.CENTER);
		menuB.setOnAction(act->{
			changePane.getChildren().clear();
			setButtonInfo(menuB,st);
		});
		
		}
		
		
		if(!isPr){
		 orderB = new Button("Ваш Заказ");
		 orderB.setPrefHeight(40);
			orderB.setPrefWidth(170);
			orderB.setAlignment(Pos.CENTER);
			orderB.setOnAction(act->{
				changePane.getChildren().clear();
				setButtonInfo(orderB,st);
			});
		
		}
		
		
		if(!isPr){
		conditionB = new Button("Состояние заказа");
		conditionB.setPrefHeight(40);
		conditionB.setAlignment(Pos.CENTER);
		conditionB.setPrefWidth(170);
		conditionB.setOnAction(act->{
			changePane.getChildren().clear();
			setButtonInfo(conditionB,st);
		});
		}
		
		
		if(!isPr){
		aboutUsB = new Button("О нас");
		aboutUsB.setPrefHeight(40);
		aboutUsB.setAlignment(Pos.CENTER);
		aboutUsB.setPrefWidth(170);
		aboutUsB.setOnAction(act->{
			changePane.getChildren().clear();
			setButtonInfo(aboutUsB,st);
		});
		}
		
	
		
		if(!isPr){
		 bGroup = new Group();
		 bGroup.setStyle("-fx-background-color:#000000");
			bGroup.getChildren().add(menuB);
			bGroup.getChildren().add(orderB);
			bGroup.getChildren().add(conditionB);
			bGroup.getChildren().add(aboutUsB);
			
		}
		
		
		
		
		orderB.setLayoutY(menuB.getLayoutY()+50);
		conditionB.setLayoutY(orderB.getLayoutY()+50);
		aboutUsB.setLayoutY(conditionB.getLayoutY()+50);
		
		
		 margin = new Insets(a,bb,c,d);//0,0,30,0
		 
		 planshetPane_1 = new GridPane();
		 
		planshetPane_1.setVgap(20);
		planshetPane_1.setAlignment(Pos.TOP_CENTER);
		GridPane.setHalignment(companyName, HPos.CENTER);
		GridPane.setHalignment(companySlogan, HPos.CENTER);
		GridPane.setHalignment(bGroup, HPos.CENTER);
		GridPane.setMargin(bGroup, margin);
		planshetPane_1.add(companyName,1,0,1,1);
		planshetPane_1.add(companySlogan,0,1,2,1);
		planshetPane_1.add(bGroup,1,2,2,1);
		
		 planshetScene_1 = new SubScene(planshetPane_1,285,420);
		 planshetScene_1.setLayoutX(60);
		 planshetScene_1.setLayoutY(120);
		
		planshetPane_1.setStyle("-fx-background-color:#ffffff");
		planshetPane_1.setOnMouseClicked(action->{
			sL.logN("planshetPanepressed "+labelP);
			chooseImageBG(st,planshetPane_1,0);
			
		});
		
		
		if(!isPr){	
		
			setLabelListener(st);
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
		
		showVisualPane_1.getChildren().addAll(list,listChooser,planshetIV_1,planshetScene_1,nodeChangeScene);
		mainScene.setRoot(showVisualPane_1);
		st.setScene(mainScene);
		st.show();
		
		
		
		
	}
	
	public void setLabelListener(Stage st){
		for(int i= 0;i<labelsL.size();i++){
			int j = i;
			labelsL.get(i).setOnMouseEntered(click->{
				labelsL.get(j).setTextFill(Color.web("#11c3f5"));
				
				labelP = true;
				
				
			});	
			labelsL.get(i).setOnMouseExited(click->{
				labelsL.get(j).setTextFill(colors.get(j));
				
				labelP = false;
				
				
			});	
		
		
			labelsL.get(i).setOnMouseClicked(click->{
				
				changePane.getChildren().clear();
				showLabelInfo(labelsL.get(j),  st);
				
				
			});
		
		
		}
		
	}	



	
	
	public void refreshImages(){
		picturesData.clear();
		try{
		picturesData.add(planshetPane_1.getBackground());
		}
		catch(Exception e){
			picturesData.add( null);
		}
		try{
			picturesData.add(categoryIV);
			}
			catch(Exception e){
				picturesData.add(null);
			}
			
		try{
			picturesData.add(planshetPane.getBackground());
			}
			catch(Exception e){
				picturesData.add(null);
			}
		
		
		
		
		
		
		sL.logN(" picturesData "+picturesData.toString());
	}
	
	
	
public void refreshButtons(){
		menuButtonData.clear();
		orderButtonData.clear();
		stateButtonData.clear();
		aboutUsButtonData.clear();
		
		if(buttonImageChosen1){
		menuButtonData.add(menuB.getBackground().getImages());
		}
		menuButtonData.add(menuB.getFont().getSize());
		menuButtonData.add(menuB.getFont().getName());
		menuButtonData.add(menuB.getTextFill());
		menuButtonData.add(buttonMargin);
		
		if(buttonImageChosen2){
			orderButtonData.add(orderB.getBackground().getImages());
			}
		orderButtonData.add(orderB.getFont().getSize());
		orderButtonData.add(orderB.getFont().getName());
		orderButtonData.add(orderB.getTextFill());
		orderButtonData.add(buttonMargin);
			
			
			
		if(buttonImageChosen3){
			stateButtonData.add(conditionB.getBackground().getImages());
			}
		stateButtonData.add(conditionB.getFont().getSize());
		stateButtonData.add(conditionB.getFont().getName());
		stateButtonData.add(conditionB.getTextFill());
		stateButtonData.add(buttonMargin);
				
				
			if(buttonImageChosen4){
				aboutUsButtonData.add(aboutUsB.getBackground().getImages());
				}
			aboutUsButtonData.add(aboutUsB.getFont().getSize());
			aboutUsButtonData.add(aboutUsB.getFont().getName());
			aboutUsButtonData.add(aboutUsB.getTextFill());
			aboutUsButtonData.add(buttonMargin);
		
			sL.logN(" menuButtonData "+menuButtonData.toString());
			sL.logN(" orderButtonData "+orderButtonData.toString());
			sL.logN(" stateButtonData "+stateButtonData.toString());
			sL.logN(" aboutUsButtonData "+aboutUsButtonData.toString());
			
	}
	
	
	
	public void refreshLabels(){
		topLabelNameData.clear();
		topLabelSloganData.clear();
		topLabelNameData.add(companyName.getText());
		topLabelNameData.add(""+companyName.getFont().getSize());
		topLabelNameData.add(companyName.getFont().getName());
		topLabelNameData.add(companyName.getTextFill());
		if(imageChosen1){
		topLabelNameData.add(companyName.getBackground().getImages());
		}
		topLabelNameData.add(labelInsets	);
		
		
		topLabelSloganData.add(companySlogan.getText());
		topLabelSloganData.add(""+companySlogan.getFont().getSize());
		topLabelSloganData.add(companySlogan.getFont().getName());
		topLabelSloganData.add(companySlogan.getTextFill());
		if(imageChosen2){
		topLabelSloganData.add(companySlogan.getBackground().getImages());
		}
		topLabelSloganData.add(labelInsets);
		
		sL.logN(" topLabelNameData "+topLabelNameData.toString());
		sL.logN(" topLabelSloganData "+topLabelSloganData.toString());
		
		
		
		
		
	}
	
	
	
	
	public void setButtonInfo(Button b,Stage st){
	 name  = b.getText();
	
	 
	 
	 
	 
	 sL.logN("start "+name);
		
		//refreshFont();
		sL.logN("2");
		
		labelsB = new ArrayList<Label>();
		
		if(!isPr2){
		 buttonNameInfo = new Label();//"Кнопка "+"«"+name+"»"
		 buttonNameInfo.setFont(Font.font ("Verdana", 15));
		}
		buttonNameInfo.setText("Кнопка "+"«"+name+"»");
		labelsB.add(buttonNameInfo);
		
		
		
		
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
		labelsB.add(buttonDescription);
		if(!isPr2){
		buttonDescription.setFont(Font.font ("Verdana", 12));
		}
		if(!isPr2){
		buttonBgImage  = new Label("Фоновое изображение кнопки"+System.lineSeparator() +"(130x40): ");
		}
		buttonBgImage.setFont(Font.font ("Verdana", 12));
		
		if(!isPr2){
		chooseBg = new Button("Выбрать");
		chooseBg.getStyleClass().add("buttons");
		}
		chooseBg.setPrefHeight(25);
		chooseBg.setPrefWidth(130);
		chooseBg.setOnAction(action->{

			
			chooseImage(st,b);
			refreshButtons();
			
		});
		
		if(!isPr2){
		 setTextFont = new Label("Шрифт и размер"+System.lineSeparator()+" текста кнопки:");
		 setTextFont.setFont(Font.font ("Verdana", 12));
		}
		
		
		//ArrayList<String >list = new ArrayList<String>();
		if(!isPr2){
		chooseFont = new ChoiceBox<String>();
		}
		chooseFont.setItems(FXCollections.observableArrayList(fontList  )
			);
		chooseFont.setTooltip(new Tooltip("Выберите шрифт"));
		chooseFont.setPrefWidth(100);
		
		if(!isPr2){
		 changeListener = new ChangeListener<String>() {
			 
            @Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
               if(newValue!=null){
            	   sL.logN(name);
            	   if(name.equals("Меню")){
            		  menuB.setFont(Font.font (newValue, 12));
            	  sL.logN(menuB.getFont().getName());
            	   }
            	   if(name.equals("Ваш Заказ")){
            		   orderB.setFont(Font.font (newValue, 12));
            		   sL.logN("j "+orderB.getFont().getName());
            	   }
            	   if(name.equals("Состояние заказа")){
            		   conditionB.setFont(Font.font (newValue, 12));
            		   sL.logN(conditionB.getFont().getName());
            	   }
            	   if(name.equals("О нас")){
            		   aboutUsB.setFont(Font.font (newValue, 12));
            		   sL.logN(aboutUsB.getFont().getName());
            	   }
            	   
            	   }
              
               refreshButtons();
            }
        };
		}
        
        
        
        if(!isPr2){
        chooseFont.getSelectionModel().selectedItemProperty().addListener(changeListener);
        }
        if(!isPr2){
        tSize = new TextField();
        tSize.setTooltip(new Tooltip("Выберите размер текста"));
		tSize.setPrefWidth(20);
		tSize.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent key) {
				if(key.getCode().equals(KeyCode.ENTER)){
					size = Double.parseDouble(tSize.getText()) ;
					if(name.equals("Меню")){
	            		  menuB.setFont(Font.font (menuB.getFont().getName(),size ));
	            	  
	            	   }
	            	   if(name.equals("Ваш Заказ")){
	            		   orderB.setFont(Font.font (orderB.getFont().getName(), size));
	            		  
	            	   }
	            	   if(name.equals("Состояние заказа")){
	            		   conditionB.setFont(Font.font (conditionB.getFont().getName(), size));
	            		  
	            	   }
	            	   if(name.equals("О нас")){
	            		   aboutUsB.setFont(Font.font (aboutUsB.getFont().getName(), size));
	            		  
	            	   }
					
	            	   refreshButtons();
				}
				
			}});
		
        }
		
        if(!isPr2){ 
        colorLabel= new Label("Цвет текста:");
        colorLabel.setFont(Font.font ("Verdana", 12));
        }
        
        if(!isPr2){ 
        chooseColor =new ColorPicker();
        chooseColor.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	
            	
            	if(name.equals("Меню")){
            		
            		menuB.setTextFill(chooseColor.getValue());
               	   }
               	   if(name.equals("Ваш Заказ")){
               		orderB.setTextFill(chooseColor.getValue());
               	   }
               	   if(name.equals("Состояние заказа")){
               		conditionB.setTextFill(chooseColor.getValue());
               	   }
               	   if(name.equals("О нас")){
               		aboutUsB.setTextFill(chooseColor.getValue()); 
               	   }
               	refreshButtons();
            }
        });
        }
       
        
        if(!isPr2){ 
        bMargin = new Label("Отступы от краев:");
        bMarginTop = new Label("Сверху:");
        bMarginBottom = new Label("Снизу:");
        bMarginLeft = new Label("Слева:");
        bMarginRight = new Label("Справа:");
        
        ArrayList<TextField>marginTF = new ArrayList<TextField>();
        tTop = new TextField();
        tTop.setPrefWidth(15);
        marginTF.add(tTop) ;      
        tBottom = new TextField();
        tBottom.setPrefWidth(15);
        marginTF.add(tBottom) ;    
        tLeft = new TextField();
        tLeft.setPrefWidth(15);
        marginTF.add(tLeft) ;    
        tRight = new TextField();
        tRight.setPrefWidth(15);
        marginTF.add(tRight) ;    
       
        
        for(int i = 0;i<marginTF.size();i++){
        	int j = i;
        	marginTF.get(j).setOnKeyPressed(new EventHandler<KeyEvent>(){

				@Override
				public void handle(KeyEvent arg0) {
					if(arg0.getCode() ==KeyCode.ENTER){
						if(marginTF.get(j).equals(tTop)){
							a =Integer.parseInt( tTop.getText());
						}
						if(marginTF.get(j).equals(tBottom)){
							c =Integer.parseInt( tBottom.getText());
						}
						if(marginTF.get(j).equals(tLeft)){
							d =Integer.parseInt( tLeft.getText());
						}
						if(marginTF.get(j).equals(tRight)){
							bb =Integer.parseInt( tRight.getText());
						}
						
						
						
						
						 buttonMargin = new Insets(a,bb,c,d);
						BorderPane.setMargin(bGroup,buttonMargin);	
						refreshButtons();
					}
					
				}});
        	
        }
        
        }
       
        
        if(name.equals("Меню")){
   		 tSize.setText(""+menuB.getFont().getSize());
   		chooseFont.setValue(menuB.getFont().getName());
   		chooseColor.setValue((Color) menuB.getTextFill());
        }
   	   if(name.equals("Ваш Заказ")){
   		   tSize.setText(""+orderB.getFont().getSize());
   		chooseFont.setValue(orderB.getFont().getName());
   		chooseColor.setValue((Color) orderB.getTextFill());
   	   }
   	   if(name.equals("Состояние заказа")){
   		   tSize.setText(""+conditionB.getFont().getSize());
   		chooseFont.setValue(conditionB.getFont().getName());
   		chooseColor.setValue((Color) conditionB.getTextFill());
   	   }
   	   if(name.equals("О нас")){
   		   tSize.setText(""+aboutUsB.getFont().getSize());
   		chooseFont.setValue(aboutUsB.getFont().getName());
   		chooseColor.setValue((Color) aboutUsB.getTextFill());
   	   }
		
		
		
	
		GridPane.setHalignment(buttonNameInfo, HPos.LEFT);
		GridPane.setHalignment(buttonDescription, HPos.LEFT);
		GridPane.setHalignment(chooseBg, HPos.RIGHT);
		GridPane.setHalignment(chooseFont, HPos.RIGHT);
		GridPane.setHalignment(chooseColor, HPos.RIGHT);
		GridPane.setMargin(buttonBgImage, new Insets(20,0,0,10));
		GridPane.setMargin(chooseBg, new Insets(20,0,0,0));
		GridPane.setMargin(setTextFont, new Insets(20,0,0,10));
		GridPane.setMargin(colorLabel, new Insets(20,0,0,10));
		GridPane.setMargin(bMargin, new Insets(20,0,0,10));
		GridPane.setMargin(chooseFont, new Insets(20,0,0,0));
		GridPane.setMargin(tSize, new Insets(20,0,0,0));
		GridPane.setMargin(chooseColor, new Insets(20,0,0,0));
		GridPane.setMargin(bMarginTop, new Insets(10,0,0,0));
		GridPane.setMargin(bMarginBottom, new Insets(10,0,0,0));
		GridPane.setMargin(bMarginLeft, new Insets(10,0,0,0));
		GridPane.setMargin(bMarginRight, new Insets(10,0,0,0));
		GridPane.setMargin(tTop, new Insets(10,20,0,20));
		GridPane.setMargin(tBottom, new Insets(10,20,0,20));
		GridPane.setMargin(tLeft, new Insets(10,20,0,20));
		GridPane.setMargin(tRight, new Insets(10,20,0,20));
		
		
		changePane.add(buttonNameInfo, 0, 1,2,1);
		changePane.add(buttonDescription, 0, 2,2,1);
		changePane.add(buttonBgImage, 0, 3,1,1);
		changePane.add(chooseBg, 2, 3,1,1);
		changePane.add(setTextFont, 0, 4,1,1);
		changePane.add(chooseFont, 2, 4,1,1);
		changePane.add(tSize, 1, 4,1,1);
		changePane.add(colorLabel, 0, 5,1,1);
		changePane.add(chooseColor, 1, 5,2,1);
		changePane.add(bMargin, 0, 6,2,1);
		changePane.add(bMarginTop, 1, 7,2,1);
		changePane.add(bMarginBottom, 1, 8,2,1);
		changePane.add(bMarginLeft, 1, 9,2,1);
		changePane.add(bMarginRight, 1, 10,2,1);
		changePane.add(tTop, 2, 7,1,1);
		changePane.add(tBottom, 2, 8,1,1);
		changePane.add(tLeft, 2, 9,1,1);
		changePane.add(tRight, 2, 10,1,1);
		
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
						if(file!=null){
						imagepath = file.toURI().toURL().toString();
						getImage = new Image( imagepath);
					
						sL.logN("/"+getImage.toString());
					
						BackgroundImage backgroundImage = new BackgroundImage( getImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
						
						Background background = new Background(backgroundImage);
						
						b.setBackground(background);
						
						if(b.equals(menuB)){
							buttonImageChosen1=true;
						}
						if(b.equals(orderB)){
							buttonImageChosen2=true;
						}
						if(b.equals(conditionB)){
							buttonImageChosen3=true;
						}
						if(b.equals(aboutUsB)){
							buttonImageChosen4=true;
						}
						
						
						
						
						refreshButtons();
						}
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            
	            }});
	}
	
	
public void chooseImageIV(Stage stage,ImageView iv,int id){
		
		System.out.println("labelP "+labelP);
		
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Image");
		configureFileChooser(fileChooser);
		 Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	File file = fileChooser.showOpenDialog(stage);
	            	
					try {
						if(file!=null){
						imagepath = file.toURI().toURL().toString();
						getImage = new Image( imagepath);
					
						sL.logN("/"+getImage.toString());
					
						Image chosenImage = new Image(imagepath);
						//BackgroundImage backgroundImage = new BackgroundImage( getImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
						
						//Background background = new Background(backgroundImage);
						
						
						if(id == 0){
						iv.setImage(chosenImage);
						}
						
						refreshImages();
						}
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            
	            }});
		
		
	
	}
	
	public void chooseImageBG(Stage stage,GridPane planshetPane2,int i){
		
		System.out.println(labelP);
		if(!labelP){
		if(!imageP){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose Image");
		configureFileChooser(fileChooser);
		 Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	File file = fileChooser.showOpenDialog(stage);
	            	
					try {
						if(file!=null){
						imagepath = file.toURI().toURL().toString();
						getImage = new Image( imagepath);
					
						sL.logN("/"+getImage.toString());
					
						BackgroundImage backgroundImage = new BackgroundImage( getImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
						
						 background = new Background(backgroundImage);
						
						
							planshetPane2.setBackground(background);
						
						refreshImages();
						}
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            
	            }});
		
		}
		}
	
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
		
		double socialN_X=85;
		double socialN_Y=220;
		restaurantInfoWindow = new AnchorPane();
		if(!isPr3){
		 photoIV = new ImageView(demoPhoto);
		}
		ImageView logoIV = new ImageView(demoLogo);
		Image selfi=new Image("planshet.png");
		if(!isPr3){ 
		  selfInfo=new ImageView(selfi);
		}
		selfInfo.setFitWidth(310);
		selfInfo.setFitHeight(465);
		selfInfo.setLayoutX(660);
		selfInfo.setLayoutY(70);
		photoIV.setLayoutX(120);
		photoIV.setLayoutY(65);
		photoIV.setFitHeight(145);
		photoIV.setFitWidth(150);
		if(!isPr3){
		workDescription  = new TextArea();
		}
		workDescription.setLayoutX(230);
		workDescription.setLayoutY(130);
		workDescription.setPrefSize(400, 270);
         workDescription.setEditable(false);
         workDescription.setWrapText(true);
         workDescription.setVisible(false);
         workDescription.setOnMouseClicked(ll->{;
		if(ll.getClickCount()==2){
		   rDescription.setVisible(true);
		   workDescription.setVisible(false);
		   hBox_outter.setLayoutY(155);
		   hBox_outter_2.setLayoutY(155);
		   hBox_outter_3.setLayoutY(155);
		   hBox_outter_4.setLayoutY(155);
			}
			});
         if(!isPr3){ 
         hBox_outter_0 = new HBox();
         }
         String style_outter_0 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_0.setStyle(style_outter_0);
	      if(!isPr3){ 
	      hBox_outter_0.getChildren().add(photoIV);
	      }
	      hBox_outter_0.setLayoutX(60);
	      hBox_outter_0.setLayoutY(70);
		
	      photoIV.setOnMouseClicked(action->{
	    	  dialogContentTwoImage(st2,photoIV,plMPhoto);
			
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
		rName.setLayoutX(230);
		rName.setLayoutY(75);
		rName.setFont(Font.font ("Verdana", 23));
		labels.add(rName);
		
		
		Label rSlogan = new Label(newRSample.getRestaurantSlogan());
		rSlogan.setLayoutX(230);
		rSlogan.setLayoutY(105);
		rSlogan.setFont(Font.font ("Verdana", 18));
		labels.add(rSlogan);
		
		 rDescription = new Label("Описание ресторана");
		
		rDescription.setLayoutX(230);
		rDescription.setLayoutY(130);
		
		rDescription.setFont(Font.font ("Verdana", 17));
		
		labels.add(rDescription);
		
		Label rAdress = new Label(newRSample.getRestaurantAdress());
		rAdress.setLayoutX(socialN_X-20);
		rAdress.setLayoutY(335);
		rAdress.setFont(Font.font ("Verdana", 15));
		//rAdress
		labels.add(rAdress);
		
		
		Image cell = new Image("191.png");
		if(!isPr3){ 
		 cellIcon = new ImageView(cell);
		}
		cellIcon.setLayoutX(socialN_X-20);
		cellIcon.setLayoutY(225);
		cellIcon.setFitHeight(20);
		cellIcon.setFitWidth(20);
		Label rNumber = new Label(" "+newRSample.getRestaurantNumber());
		rNumber.setLayoutX(socialN_X);
		rNumber.setLayoutY(225);
		rNumber.setFont(Font.font ("Verdana", 15));
		labels.add(rNumber);
		
		
		
		Image vk= new Image("25684.png");
		if(!isPr3){ 
		 vkIcon = new ImageView(vk);
		}
		vkIcon.setLayoutX(socialN_X-20);
		vkIcon.setLayoutY(250);
		vkIcon.setFitHeight(20);
		vkIcon.setFitWidth(20);
		Label rVk = new Label(" "+newRSample.getRestaurantVk());
		rVk.setLayoutX(socialN_X);
		rVk.setLayoutY(250);
		rVk.setFont(Font.font ("Verdana", 15));
		labels.add(rVk);
		
		
		Image inst= new Image("174855.png");
		if(!isPr3){ 
		 instIcon = new ImageView(inst);
		}
		instIcon.setLayoutX(socialN_X-20);
		instIcon.setLayoutY(270);
		instIcon.setFitHeight(20);
		instIcon.setFitWidth(20);
		Label rInst = new Label(" "+newRSample.getRestaurantInst());
		rInst.setLayoutX(socialN_X);
		rInst.setLayoutY(270);
		rInst.setFont(Font.font ("Verdana", 15));
		labels.add(rInst);
		
		
		
		
		Image fb= new Image("1600.png");
		
		if(!isPr3){ 
		 fbIcon = new ImageView(fb);
		}
		fbIcon.setLayoutX(socialN_X-20);
		fbIcon.setLayoutY(292);
		fbIcon.setFitHeight(18);
		fbIcon.setFitWidth(18);
		Label rFb = new Label(" "+newRSample.getRestaurantFb());
		rFb.setLayoutX(socialN_X);
		rFb.setLayoutY(292);
		rFb.setFont(Font.font ("Verdana", 15));
		labels.add(rFb);
		
		Image tw= new Image("vector-twitter-icon-195.jpg");
		if(!isPr3){ 
		 twIcon = new ImageView(tw);
		}
		twIcon.setLayoutX(socialN_X-20);
		twIcon.setLayoutY(315);
		twIcon.setFitHeight(18);
		twIcon.setFitWidth(18);
		Label rTw = new Label(" "+newRSample.getRestaurantTwitter());
		rTw.setLayoutX(socialN_X);
		rTw.setLayoutY(315);
		rTw.setFont(Font.font ("Verdana", 15));
		labels.add(rTw);
		
		
		if(!isPr3){  
		 photo1 = new ImageView(demoPhoto);
		}
		imageList[0] = photo1;
		//photo1.setLayoutX(300);
		//photo1.setLayoutY(210);
		photo1.setFitHeight(100);
		photo1.setFitWidth(100);
		if(!isPr3){  
		hBox_outter = new HBox();
}
String style_outter = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter.setStyle(style_outter);
	      if(!isPr3){  
	      hBox_outter.getChildren().add(photo1);
	      }
	      hBox_outter.setLayoutX(225);
	      hBox_outter.setLayoutY(155);
		
		photo1.setOnMouseClicked(action->{
			
			dialogContentTwoImage(st2,photo1,plMPhoto1);
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
		 photo2 = new ImageView(demoPhoto);
		imageList[1] = photo2;
		//photo2.setLayoutX(720);
		//photo2.setLayoutY(200);
		photo2.setFitHeight(100);
		photo2.setFitWidth(100);
		if(!isPr3){ 
		  hBox_outter_2 = new HBox();
}
String style_outter_2 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_2.setStyle(style_outter_2);
	      if(!isPr3){  
	      hBox_outter_2.getChildren().add(photo2);
	      }
	      hBox_outter_2.setLayoutX(325);
	      hBox_outter_2.setLayoutY(155);
		
		photo2.setOnMouseClicked(action->{
			
			dialogContentTwoImage(st2,photo2,plMPhoto2);
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
		
		
		 photo3 = new ImageView(demoPhoto);
		imageList[2] = photo3;
		
		photo3.setFitHeight(100);
		photo3.setFitWidth(100);
		if(!isPr3){  
		hBox_outter_3 = new HBox();
}
String style_outter_3 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_3.setStyle(style_outter_3);
	      if(!isPr3){  
	      hBox_outter_3.getChildren().add(photo3);
	      }
	      hBox_outter_3.setLayoutX(425);
	      hBox_outter_3.setLayoutY(155);
		
		photo3.setOnMouseClicked(action->{
			
			dialogContentTwoImage(st2,photo3,plMPhoto3);
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
		
		
		 photo4 = new ImageView(demoPhoto);
		
		imageList[3] = photo4;
		
		photo4.setFitHeight(100);
		photo4.setFitWidth(100);
		if(!isPr3){ 
		 hBox_outter_4 = new HBox();
		}
		String style_outter_4 = "-fx-border-color: black;"
	              + "-fx-border-width: 2;";
	      hBox_outter_4.setStyle(style_outter_4);
	      if(!isPr3){  
	      hBox_outter_4.getChildren().add(photo4);
	      }
	      hBox_outter_4.setLayoutX(525);
	      hBox_outter_4.setLayoutY(155);
		
		photo4.setOnMouseClicked(action->{
			
			dialogContentTwoImage(st2,photo4,plMPhoto4);
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
				if(j==0||j==1){
					MAX_CHARS=18;
				}
				if(j==4){
					MAX_CHARS=11;
				}
				
				if(j==2&&click.getButton()==MouseButton.SECONDARY){
				
						
						rDescription.setVisible(false);
						
						workDescription.setVisible(true);
						// workDescription.setVisible(true);
				   hBox_outter.setLayoutY(420);
				   hBox_outter_2.setLayoutY(420);
				   hBox_outter_3.setLayoutY(420);
				   hBox_outter_4.setLayoutY(420);
				   
						
			}
			if(click.getButton()==MouseButton.PRIMARY){
				
				dialogContentLabel(labels.get(j),labels.get(j).getText(),j);
				
			}
			
		});	
		 
			labels.get(i).setOnMouseEntered(click->{
				labels.get(j).setTextFill(Color.web("#1583d1"));
				
				
				
				
			});	
			labels.get(i).setOnMouseExited(click->{
				labels.get(j).setTextFill(Color.web("#000000"));
				
				
				
				
			});	
			
		}
	/*	
		Button show =new Button();
		show.setLayoutX(610);
		show.setLayoutY(125);
		show.setOnAction(gg->{
			
		});
		*/
		
	    descc = new Label("Описание");
		
		descc.setVisible(true);
		descc.setFont(Font.font ("Verdana", 15));
		descc.setOnMouseClicked(ll->{
			if(ll.getClickCount()==2){
			descc.setVisible(false);
			description.setVisible(true);
			imVk.setVisible(false);
			imInst.setVisible(false);
			imFB.setVisible(false);
			imTwit.setVisible(false);
			imTel.setVisible(false);
			vkInfo.setVisible(false);
			instInfo.setVisible(false);
			fbInfo.setVisible(false);
			twitInfo.setVisible(false);
			telInfo.setVisible(false);
			
			}
			});
		if(!isPr3){
		plMPhoto  = new ImageView("noPhoto.png");
		}
		plMPhoto.setFitHeight(80);
		plMPhoto.setFitWidth(80);
		if(!isPr3){
		plMPhoto1  = new ImageView("noPhoto.png");
		}
		plMPhoto1.setFitHeight(60);
		plMPhoto1.setFitWidth(60);
		if(!isPr3){
		plMPhoto2  = new ImageView("noPhoto.png");
		}
		plMPhoto2.setFitHeight(60);
		plMPhoto2.setFitWidth(60);
		if(!isPr3){
		plMPhoto3  = new ImageView("noPhoto.png");
		}
		plMPhoto3.setFitHeight(60);
		plMPhoto3.setFitWidth(60);
		
		if(!isPr3){
		plMPhoto4  = new ImageView("noPhoto.png");
		}
		plMPhoto4.setFitHeight(60);
		plMPhoto4.setFitWidth(60);
		
		if(!isPr3){ 
		nam=new Label("bvz htcnjhfyf");
		}
		nam.setFont(Font.font ("Verdana", 15));
		nam.setWrapText(true);
		
		if(!isPr3){
		slog=new Label("bvz htcnjhfyf");
		}
		slog.setFont(Font.font ("Verdana", 15));
		slog.setWrapText(true);
		
		if(!isPr3){
		description=new TextArea("bvz htcnjhfyfghdfghdgh");
		}
		description.setWrapText(true);
		description.setEditable(false);
		description.setVisible(false);
		description.setOnMouseClicked(ll->{
			if(ll.getClickCount()==2){
			description.setVisible(false);
			descc.setVisible(true);
			imVk.setVisible(true);
			imInst.setVisible(true);
			imFB.setVisible(true);
			imTwit.setVisible(true);
			imTel.setVisible(true);
			vkInfo.setVisible(true);
			instInfo.setVisible(true);
			fbInfo.setVisible(true);
			twitInfo.setVisible(true);
			telInfo.setVisible(true);
			
			}
		});
		
		description.setFont(Font.font ("Verdana", 15));
		if(!isPr3){
		imVk  = new ImageView("25684.png");
		}
		imVk.setFitHeight(30);
		imVk.setFitWidth(30);
		if(!isPr3){
		imInst  = new ImageView("174855.png");
		}
		imInst.setFitHeight(30);
		imInst.setFitWidth(30);
		if(!isPr3){
		imFB  = new ImageView("1600.png");
		}
		imFB.setFitHeight(30);
		imFB.setFitWidth(30);
		if(!isPr3){
		imTwit  = new ImageView("vector-twitter-icon-195.jpg");
		}
		imTwit.setFitHeight(30);
		imTwit.setFitWidth(30);
		if(!isPr3){
		imTel  = new ImageView("191.png");
		}
		imTel.setFitHeight(30);
		imTel.setFitWidth(30);
		if(!isPr3){
		vkInfo = new Label("vkkkkkkkkkkkkkkkkkk");
		}
		vkInfo.setFont(Font.font ("Verdana", 13));
		if(!isPr3){
		instInfo= new Label("vkkkkkkkkkkkkkkkkkk");
		}
		instInfo.setFont(Font.font ("Verdana", 13));
		if(!isPr3){
		fbInfo= new Label("vkkkkkkkkkkkkkkkkkk");
		}
		fbInfo.setFont(Font.font ("Verdana", 13));
		if(!isPr3){
		twitInfo= new Label("vkkkkkkkkkkkkkkkkkk");
		}
		twitInfo.setFont(Font.font ("Verdana", 13));
		if(!isPr3){
		telInfo= new Label("vkkkkkkkkkkkkkkkkkk");
		}
		telInfo.setFont(Font.font ("Verdana", 13));
		if(!isPr3){
		adressInfo= new Label("vkkkkkkkkk");
		}
		adressInfo.setFont(Font.font ("Verdana", 15));
		
		
		GridPane infoPlan=new GridPane();
		SubScene inforOnPlanshet = new SubScene(infoPlan,257,380);
		inforOnPlanshet.setLayoutX(680);
		inforOnPlanshet.setLayoutY(110);
		infoPlan.setStyle("-fx-background-color:#ffffff");
		GridPane.setHalignment(plMPhoto,HPos.LEFT);
		GridPane.setHalignment(imVk,HPos.RIGHT);
		GridPane.setHalignment(imInst,HPos.RIGHT);
		GridPane.setHalignment(imFB,HPos.RIGHT);
		GridPane.setHalignment(imTwit,HPos.RIGHT);
		GridPane.setHalignment(imTel,HPos.LEFT);
		GridPane.setHalignment(vkInfo,HPos.CENTER);
		GridPane.setHalignment(instInfo,HPos.CENTER);
		GridPane.setHalignment(fbInfo,HPos.CENTER);
		GridPane.setHalignment(twitInfo,HPos.CENTER);
		GridPane.setMargin(plMPhoto, new Insets(10,0,0,10));
		GridPane.setMargin(nam, new Insets(0,0,50,100));
		GridPane.setMargin(slog, new Insets(0,0,10,100));
		GridPane.setMargin(adressInfo, new Insets(70,0,0,100));
		GridPane.setMargin(plMPhoto2, new Insets(10,0,0,70));
		GridPane.setMargin(plMPhoto4, new Insets(10,0,0,190));
		GridPane.setMargin(plMPhoto1, new Insets(10,0,0,10));
		GridPane.setMargin(plMPhoto3, new Insets(10,0,0,130));
		GridPane.setMargin(description, new Insets(10,0,0,10));
		GridPane.setMargin(descc, new Insets(10,0,180,10));
		GridPane.setMargin(imVk, new Insets(0,10,95,0));
		GridPane.setMargin(imInst, new Insets(0,10,25,0));
		GridPane.setMargin(imFB, new Insets(45,10,0,0));
		GridPane.setMargin(imTwit, new Insets(115,10,0,0));
		GridPane.setMargin(imTel, new Insets(175,0,0,55));
		GridPane.setMargin(vkInfo, new Insets(0,0,95,0));
		GridPane.setMargin(instInfo, new Insets(0,0,25,0));
		GridPane.setMargin(fbInfo, new Insets(45,0,0,0));
		GridPane.setMargin(twitInfo, new Insets(115,0,0,0));
		GridPane.setMargin(telInfo, new Insets(180,0,0,95));
		infoPlan.add(plMPhoto, 0, 0);
		infoPlan.add(nam, 0, 0);
		infoPlan.add(slog, 0, 0);
		infoPlan.add(adressInfo, 0, 0);
		infoPlan.add(plMPhoto1, 0, 1);
		infoPlan.add(plMPhoto2, 0, 1);
		infoPlan.add(plMPhoto3, 0, 1);
		infoPlan.add(plMPhoto4, 0, 1);
		infoPlan.add(description, 0, 2);
		infoPlan.add(descc, 0, 2);
		infoPlan.add(imVk, 0, 2);
		infoPlan.add(imInst, 0, 2);
		infoPlan.add(imFB, 0, 2);
		infoPlan.add(imTwit, 0, 2);
		infoPlan.add(imTel, 0, 2);
		infoPlan.add(vkInfo, 0, 2);
		infoPlan.add(instInfo, 0, 2);
		infoPlan.add(fbInfo, 0, 2);
		infoPlan.add(twitInfo, 0, 2);
		infoPlan.add(telInfo, 0, 2);
		
		//infoPlan.add(description1, 0, 3);
		
				//SocInf
				
		restaurantInfoWindow.getChildren().addAll(list,hBox_outter_0,rName,rSlogan,rDescription,rAdress,rNumber,cellIcon,vkIcon,rVk,instIcon,rInst,fbIcon,rFb,twIcon,rTw,hBox_outter,hBox_outter_2,hBox_outter_3,hBox_outter_4,selfInfo,inforOnPlanshet,workDescription);
		
		isPr3= true;
		mainScene.setRoot(restaurantInfoWindow);
		st2.setScene(mainScene);
		
		st2.show();
	}
	
public  void dialogContentTwoImage(Stage stage,ImageView iv,ImageView iv1){//ImageView iv,int id,Stage stage
	
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open Resource File");
	
	configureFileChooser(fileChooser);
	 Platform.runLater(new Runnable() {
            @Override public void run() {
            	File file = fileChooser.showOpenDialog(stage);
            	
				try {
					
					imagepath = file.toURI().toURL().toString();
					getImage = new Image(imagepath);
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	iv.setImage(getImage);
            	iv1.setImage(getImage);
            	iv.setStyle("-fx-border-color: black; -fx-border-style: solid;	  -fx-border-width: 5;");
            	
           
            
            }
        });
	
	
	
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
           
           // enterField.setWrapText(true);
           enterField.setTextFormatter(new TextFormatter<String>(change -> 
           change.getControlNewText().length() <= MAX_CHARS ? change : null));
           
           
           Button okButton = new Button("Ok");
           okButton.setLayoutX(50);
           okButton.setLayoutY(110);
           okButton.setPrefHeight(30);
           okButton.setPrefWidth(75);
           okButton.setOnAction(action->{
           	
           	label.setPrefWidth(300);
           	System.out.println(label.getLayoutY());
           	label.setWrapText(true);	
           	if(!(id==2)){
           	label.setText(" "+enterField.getText());
           	}
           	
           if(id==0){
          		 newRSample.setRestaurantName(enterField.getText());
          	      nam.setText(enterField.getText());
          	 }
          	 if(id==1){
          		 newRSample.setRestaurantSlogan(enterField.getText());
          		slog.setText(enterField.getText());
          	 }
          	 if(id==2){
          		 newRSample.setRestaurantDescription(enterField.getText());
          		 description.setText(enterField.getText());
          		 workDescription.setText(enterField.getText());
          		
          		
          	 }
          	 if(id==3){
          		 newRSample.setRestaurantAdress(enterField.getText());
          		adressInfo.setText(enterField.getText());
           }
          	 if(id==4){
          		 newRSample.setRestaurantNumber(enterField.getText());
          		telInfo.setText(enterField.getText());
          	 }
          	 if(id==5){
          		 newRSample.setRestaurantVk(enterField.getText());
          		vkInfo.setText(enterField.getText());
          	 }
          	 if(id==6){
          		 newRSample.setRestaurantInst(enterField.getText());
          		instInfo.setText(enterField.getText());
          	 }
          	 if(id==7){
          		 newRSample.setRestaurantFb(enterField.getText());
          		fbInfo.setText(enterField.getText());
          	 }
          	 if(id==8){
          		 newRSample.setRestaurantTwitter(enterField.getText());
          		twitInfo.setText(enterField.getText());
          	 }
          	 
          	 dialog.close(); 
          	MAX_CHARS=10000;
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
       add.getStyleClass().add("buttons");
       add.setText("Добавить");
		add.setLayoutX(50);
		add.setLayoutY(530);
		add.setPrefHeight(40);
		add.setPrefWidth(130);
		add.setOnAction(ad->{
			dialog.showAndWait();
		if(dialog.getResult().equals(ButtonType.OK)){
			data.add(new Dish(tx.getText(),tx4.getText(),tx1.getText(),
					tx3.getText(),tx5.getText(),tx2.getText(),tx6.getText()));
		}
		
	});
		Button safe  = new Button();
		safe.getStyleClass().add("buttons");
		safe.setText("Сохранить");
		safe.setLayoutX(170);
		safe.setLayoutY(530);
		safe.setPrefHeight(40);
		safe.setPrefWidth(130);
		
		Button del  = new Button();
		del.getStyleClass().add("buttons");
		del.setText("Удалить");
		del.setLayoutX(290);
		del.setLayoutY(530);
		del.setPrefHeight(40);
		del.setPrefWidth(130);
		
		
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

	
	 
	  public void showLabelInfo(Label lb, Stage st){
		//  changePane.
		  
		  if(lb.equals(companyName)){
			  numbr = 0;
		  }
		  if(lb.equals(companySlogan)){
			  numbr = 1;
		  }
		  if(lb.equals(menuChooseTopLabel)){
			  numbr = 2;
		  }
		  if(lb.equals(menuChooseTopDescription)){
			  numbr = 3;
		  }
		  if(lb.equals(categoryName)){
			  numbr = 4;
		  }
		  if(lb.equals(categoryString)){
			  numbr = 5;
		  }
		  if(lb.equals(categoryDescr)){
			  numbr = 6;
		  }
		  name = lb.getText();
		  
		  sL.logN("n"+numbr);
		  if(!isPr3){
		 Tdes  =new Label();
			Tdes.setFont(Font.font ("Verdana", 18));
		  }
		  Tdes.setText(name);
		  if(!isPr3){
		
			  bMargin = new Label("Отступы от краев:");
			  bMargin.setFont(Font.font ("Verdana", 13));
			  bMarginTop = new Label("Сверху:");
			  bMarginTop.setFont(Font.font ("Verdana", 13));
			  bMarginBottom = new Label("Снизу:");
			  bMarginBottom.setFont(Font.font ("Verdana", 13));
			  bMarginLeft = new Label("Слева:");
			  bMarginLeft.setFont(Font.font ("Verdana", 13));
			  bMarginRight = new Label("Справа:");
			  bMarginRight.setFont(Font.font ("Verdana", 13));
		        
		        
		        
		        ArrayList<TextField>marginTF = new ArrayList<TextField>();
		        tTop = new TextField();
		        tTop.setPrefWidth(15);
		        marginTF.add(tTop) ;      
		        tBottom = new TextField();
		        tBottom.setPrefWidth(15);
		        marginTF.add(tBottom) ;    
		        tLeft = new TextField();
		        tLeft.setPrefWidth(15);
		        marginTF.add(tLeft) ;    
		        tRight = new TextField();
		        tRight.setPrefWidth(15);
		        marginTF.add(tRight) ;    
		        
			  TSubdes  =new Label("Вы можете редактировать вид этой надписи");
			TSubdes.setMaxWidth(380);
			TSubdes.setWrapText(true);
			TSubdes.setFont(Font.font ("Verdana", 13));
			
			
			
			Tsize  =new Label("Шрифт/"+System.lineSeparator()+"Размер текста:");
			Tsize.setFont(Font.font ("Verdana", 13));
			 Tcolor  =new Label("Цвет/"+System.lineSeparator()+"Фон текста:");
			 Tcolor.setFont(Font.font ("Verdana", 13));
		    
		     Tindent  =new Label("Отступ:");
		    Tindent.setFont(Font.font ("Verdana", 13));
		    
		    
		    
		     Tbg  =new Label("Фон/Стиль:");
		    Tbg.setFont(Font.font ("Verdana", 13));
		    
			
			 sizeT  =new TextField();
			sizeT.setPrefWidth(20);
			
			sizeT.setOnMouseClicked(ac->{
			sizeT.setOnKeyPressed(f->{;
			if(f.getCode() == KeyCode.ENTER){
				Double  size = Double.parseDouble(sizeT.getText()) ;
				if(numbr==0){companyName.setFont(Font.font(companyName.getFont().getName(),size));}	
				
				if(numbr==1){companySlogan.setFont(Font.font(companySlogan.getFont().getName(),size));}	
				
				
				if(numbr==2){menuChooseTopLabel.setFont(Font.font(menuChooseTopLabel.getFont().getName(),size));}	
				
				if(numbr==3){menuChooseTopDescription.setFont(Font.font(menuChooseTopDescription.getFont().getName(),size));}	
				if(numbr==4){categoryName.setFont(Font.font(categoryName.getFont().getName(),size));}	
				if(numbr==5){categoryString.setFont(Font.font(categoryString.getFont().getName(),size));}	
				if(numbr==6){categoryDescr.setFont(Font.font(categoryDescr.getFont().getName(),size));}	
				
				
				
				refreshLabels();
			
			}
				
			});
			});
			
			 direction  =new TextField();
			direction.setPrefWidth(40);
			direction.setOnMouseClicked(ac2->{
			direction.setOnKeyPressed(f2->{;
			if(f2.getCode() == KeyCode.ENTER){
				
				
			   
			}
			});
			});
			LabelBg =new Button("Выберите фон");
			LabelBg.getStyleClass().add("buttons");
			LabelBg.setPrefWidth(100);
			LabelBg.setOnAction(actt->{
			chooseImageForLabel(st,lb);
			refreshLabels();
			});
			
			
			chooseLbFont1 = new ChoiceBox<String>();
				
				chooseLbFont1.setItems(FXCollections.observableArrayList(fontList  )
					);
				
				chooseLbFont1.setPrefWidth(100);
				ChangeListener<String> changeListener = new ChangeListener<String>() {
					 
		            @Override
		           public void changed(ObservableValue<? extends String> observable, //
		                    String oldValue, String newValue) {
		            	if(numbr==0){ companyName.setFont(Font.font (newValue, companyName.getFont().getSize()));}	
						
						if(numbr==1){ companySlogan.setFont(Font.font (newValue, companySlogan.getFont().getSize()));}	
		                 
						if(numbr==2){ menuChooseTopLabel.setFont(Font.font (newValue, menuChooseTopLabel.getFont().getSize()));}	
						
						if(numbr==3){ menuChooseTopDescription.setFont(Font.font (newValue, menuChooseTopDescription.getFont().getSize()));}	
						
						if(numbr==4){ categoryName.setFont(Font.font (newValue, categoryName.getFont().getSize()));}	
		              
						if(numbr==5){ categoryString.setFont(Font.font (newValue, categoryString.getFont().getSize()));}
						
						if(numbr==6){ categoryDescr.setFont(Font.font (newValue, categoryDescr.getFont().getSize()));}
						
						
						sL.logN(newValue+"//"+lb.getFont());
		                 refreshLabels();
		           }
		        };
				   chooseLbFont1.getSelectionModel().selectedItemProperty().addListener(changeListener);
			 colorTextPicker =new ColorPicker();		
			colorTextPicker.setPrefWidth(100);
			colorTextPicker.setOnAction(cll->{
				if(numbr==0){companyName.setTextFill(colorTextPicker.getValue());
				colors.set(0, colorTextPicker.getValue());
				}	
				
				if(numbr==1){companySlogan.setTextFill(colorTextPicker.getValue()); 
				colors.set(1, colorTextPicker.getValue());
				}	
				if(numbr==2){
					sL.logN("numbr=2");
					menuChooseTopLabel.setTextFill(colorTextPicker.getValue()); 
					colors.set(2, colorTextPicker.getValue());
					}	
				
				if(numbr==3){
					menuChooseTopDescription.setTextFill(colorTextPicker.getValue()); 
					colors.set(3, colorTextPicker.getValue());
					}	
				if(numbr==4){
					categoryName.setTextFill(colorTextPicker.getValue()); 
					colors.set(4, colorTextPicker.getValue());
					}	
				if(numbr==5){
					categoryString.setTextFill(colorTextPicker.getValue()); 
					colors.set(5, colorTextPicker.getValue());
					}	
				if(numbr==6){
					categoryDescr.setTextFill(colorTextPicker.getValue()); 
					colors.set(6, colorTextPicker.getValue());
					}	
				
				
				
				refreshLabels();	
			
			});
			
			for(int i = 0;i<marginTF.size();i++){
	        	int j = i;
	        	marginTF.get(j).setOnKeyPressed(new EventHandler<KeyEvent>(){

					@Override
					public void handle(KeyEvent arg0) {
						if(arg0.getCode() ==KeyCode.ENTER){
							if(marginTF.get(j).equals(tTop)){
								a =Integer.parseInt( tTop.getText());
							}
							if(marginTF.get(j).equals(tBottom)){
								c =Integer.parseInt( tBottom.getText());
							}
							if(marginTF.get(j).equals(tLeft)){
								d =Integer.parseInt( tLeft.getText());
							}
							if(marginTF.get(j).equals(tRight)){
								bb =Integer.parseInt( tRight.getText());
							}
							
							
							
							
							labelInsets = new Insets(a,bb,c,d);
							BorderPane.setMargin(labelHeadGroup,labelInsets);	
							
							
							
							refreshLabels();
						}
						
					}});
	        	
	        }
			
			
		  }
			GridPane.setHalignment(Tdes, HPos.LEFT);
		 	GridPane.setHalignment(TSubdes, HPos.LEFT);
		 	GridPane.setHalignment(sizeT, HPos.CENTER);
		 	GridPane.setHalignment(chooseLbFont1, HPos.LEFT);
			GridPane.setMargin(chooseLbFont1, new Insets(30,20,0,10));
			GridPane.setMargin(sizeT, new Insets(30,45,0,45));
			GridPane.setMargin(Tsize, new Insets(30,0,0,10));
			
			GridPane.setMargin(Tcolor, new Insets(30,0,0,10));
			GridPane.setMargin(colorTextPicker, new Insets(30,0,0,0));
			
			GridPane.setMargin(direction, new Insets(20,0,0,80));
			//GridPane.setMargin(chooseMargine, new Insets(30,0,0,0));
			GridPane.setMargin(Tbg, new Insets(30,0,0,10));
			GridPane.setMargin(LabelBg, new Insets(30,0,0,10));
			
			GridPane.setMargin(bMargin, new Insets(30,0,0,10));
			GridPane.setMargin(bMarginTop, new Insets(10,0,0,0));
			GridPane.setMargin(bMarginBottom, new Insets(10,0,0,0));
			GridPane.setMargin(bMarginLeft, new Insets(10,0,0,0));
			GridPane.setMargin(bMarginRight, new Insets(10,0,0,0));
			GridPane.setMargin(tTop, new Insets(10,20,0,20));
			GridPane.setMargin(tBottom, new Insets(10,20,0,20));
			GridPane.setMargin(tLeft, new Insets(10,20,0,20));
			GridPane.setMargin(tRight, new Insets(10,20,0,20));
		
			changePane.add(Tdes, 0, 1,2,1);
			
			changePane.add(TSubdes, 0,2,2,1);
			
			changePane.add(Tsize, 0,3,1,1);
			changePane.add(sizeT, 1,3,1,1);
			changePane.add(chooseLbFont1, 2,3,1,1);
			
			
			changePane.add(Tcolor, 0,4,1,1);
			changePane.add(colorTextPicker, 1,4,1,1);
			
			
			
			
			//changePane.add(direction, 1,5,1,1);
			//changePane.add(chooseMargine, 2,5,1,1);
			changePane.add(Tbg, 0,5,1,1);
			changePane.add(LabelBg, 1,5,1,1);
		
	 
			changePane.add(bMargin, 0, 7,2,1);
			changePane.add(bMarginTop, 1, 8,2,1);
			changePane.add(bMarginBottom, 1, 9,2,1);
			changePane.add(bMarginLeft, 1, 10,2,1);
			changePane.add(bMarginRight, 1, 11,2,1);
			changePane.add(tTop, 2, 8,1,1);
			changePane.add(tBottom, 2, 9,1,1);
			changePane.add(tLeft, 2, 10,1,1);
			changePane.add(tRight, 2, 11,1,1);
			
			
			
			if(!isPr){
			if(numbr==0){
		   		 tSize.setText(""+companyName.getFont().getSize());
		   		chooseFont.setValue(companyName.getFont().getName());
		   		chooseColor.setValue((Color) companyName.getTextFill());
		        }
		   	   if(numbr==1){
		   		   tSize.setText(""+companySlogan.getFont().getSize());
		   		chooseFont.setValue(companySlogan.getFont().getName());
		   		chooseColor.setValue((Color) companySlogan.getTextFill());
		   	   }
		   	   if(numbr==2){
		   		   tSize.setText(""+menuChooseTopLabel.getFont().getSize());
		   		chooseFont.setValue(menuChooseTopLabel.getFont().getName());
		   		chooseColor.setValue((Color) menuChooseTopLabel.getTextFill());
		   	   }
		   	   if(numbr==3){
		   		   tSize.setText(""+menuChooseTopDescription.getFont().getSize());
		   		chooseFont.setValue(menuChooseTopDescription.getFont().getName());
		   		chooseColor.setValue((Color) menuChooseTopDescription.getTextFill());
		   	   }
			
		   	 if(numbr==4){
		   		   tSize.setText(""+categoryName.getFont().getSize());
		   		chooseFont.setValue(categoryName.getFont().getName());
		   		chooseColor.setValue((Color) categoryName.getTextFill());
		   	   }
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			isPr3 = true;
			//labelP = false;
 }	
	  
	  
	  
	  public void chooseImageForLabel(Stage stage,Label lb){
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
  					
  					if(numbr==0){companyName.setBackground(background);
  					imageChosen1 = true;
  					refreshLabels();
  					}	
  					
  					if(numbr==1){companySlogan.setBackground(background);
  					imageChosen2 = true;
  					refreshLabels();
  					}	
  					
  	            
  	            }});
  	}
}
