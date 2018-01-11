import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Controller implements Initializable {
	
	static String STATE_WAITING = "Waiting";
	static String STATE_ORDER = "Order";
	static String STATE_OFF = "Off";
	
	static String ORDER_WAITING = "W";
	static String ORDER_PREPAIRING = "P";
	static String ORDER_READY = "R";
	
	String imagepath="";;
	
	Label obname,obslogan,obadress,obphone,obvk,obfb,obinst,obtwi;
	int counter2 = 0;;
	int counter = 0;
	Cell cell;
	Cell cell2;
	boolean isPr = true;
	boolean isPr2 = true;
	boolean isPr3 = true;
	boolean isPr4 = true;
	boolean isPr5 = true;
	static AnchorPane visualView=null;
	static AnchorPane tablePane=null;
	static AnchorPane stateView=null;
	@FXML
	Label descrName;
	
	@FXML
	Label descrText;
	
	@FXML 
	Button startUse;
	@FXML 
	Button sendPost;
	
	@FXML 
	ScrollPane planshetPane;
	
	
	@FXML 
	Button confirmButton;
	
	@FXML 
	Label dName;
	@FXML 
	Label dState;
	@FXML 
	Label dNumber;
	@FXML 
	Circle stateCircle;
	
	
	
	@FXML 
	Button changeInfo;
	
	@FXML
	public  ListView<Object> planshetList;
	int count = 1;
	
	 ObservableList<Node> postsL =FXCollections.observableArrayList ();
	@FXML 
	 TextField name;
	@FXML
	TextField slogan;
	@FXML
	TextField phone;
	@FXML
	TextField adress;
	@FXML
	TextField vk;
	@FXML
	TextField fb;
	@FXML
	TextField inst;
	@FXML
	TextField twi;
	
	
	@FXML
	ScrollPane scrollPane;
	
	@FXML 
	 static   Label lname;
	@FXML
	static Label lslogan;
	@FXML
	Label lphone;
	@FXML
	Label ladress;
	@FXML
	Label lvk;
	@FXML
	Label lfb;
	@FXML
	Label linst;
	@FXML
	Label ltwi;
	
	
	ArrayList<String>posts = new ArrayList<String>();
	ArrayList<String>info = new ArrayList<String>();
	
	ListView<Label> listView;
	ObservableList<Label> listViewItems;
	ArrayList<PreviewPattern> patternList= new ArrayList<PreviewPattern>();
	static AnchorPane mainMenu=null;
	@FXML 
	ListView topMenu;
	
	@FXML 
	ImageView avatar;
	
	static AnchorPane dialogPane;
	
	@FXML 
	BorderPane borderPane;
	
	static AnchorPane personOverview;
	
	private MainGUI mainApp;
	
	public Controller() {
    }

	
	@FXML
	public void startUseButtonListener(){
		
		initTopMenu();
		
		
		
	}

	
	public void saveInfo(){
		

		System.out.println(mainMenu.getChildren().toString()+"/"+slogan.getText()+"/"+phone.getText()+"/"+adress.getText()+"/"+vk.getText()+"/"+fb.getText()+"/"+inst.getText()+"/"+twi.getText()+"/");
		
		Label obname = (Label)mainMenu.getChildren().get(5);
		Label obslogan = (Label)mainMenu.getChildren().get(6);
		Label obadress = (Label)mainMenu.getChildren().get(9);
		Label obphone = (Label)mainMenu.getChildren().get(10);
		Label obvk = (Label)mainMenu.getChildren().get(11);
		Label obfb = (Label)mainMenu.getChildren().get(12);
		Label obinst = (Label)mainMenu.getChildren().get(13);
		Label obtwi = (Label)mainMenu.getChildren().get(14);
		
		
		Platform.runLater(new Runnable() {
            @Override public void run() {
            	
            	obname.setText(name.getText());
            	obslogan.setText(slogan.getText());
        		obadress.setText("Адрес:"+adress.getText());
        		obphone.setText("Телефон:"+phone.getText());
        		obvk.setText("ВКонтакте:"+vk.getText());
        		obfb.setText("Facebook:"+fb.getText());
        		obinst.setText("Instagram:"+inst.getText());
        		obtwi.setText("Twitter:"+twi.getText());
            }
        });
		
		
		
		
		
		dialogPane.setDisable(true);
    	dialogPane.setOpacity(0);	
	}
	
	public void openImage(){
		ImageView ava = (ImageView)mainMenu.getChildren().get(2);
		Stage st = new Stage();
		chooseImageIV(st,ava);
	}
	
public void chooseImageIV(Stage stage,ImageView iv){
		
		
		
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Выберите избражение");
		//configureFileChooser(fileChooser);
		 
		
		Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	File file = fileChooser.showOpenDialog(stage);
	            	
					try {
						if(file!=null){
						imagepath = file.toURI().toURL().toString();
						
					
						
					
						Image chosenImage = new Image(imagepath);
						//BackgroundImage backgroundImage = new BackgroundImage( getImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
						
						//Background background = new Background(backgroundImage);
						
						
						
						iv.setImage(chosenImage);
						
						
						
						}
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            
	            }});
		
		
	
	}
	
	
	
	
	
		

		
	public void changeInfo(){
		Platform.runLater(new Runnable() {
            @Override public void run() {
            	System.out.println("//"+mainMenu.getChildren().toString());
            	 obname = (Label)mainMenu.getChildren().get(5);
        		 obslogan = (Label)mainMenu.getChildren().get(6);
        		 obadress = (Label)mainMenu.getChildren().get(9);
        		 obphone = (Label)mainMenu.getChildren().get(10);
        		 obvk = (Label)mainMenu.getChildren().get(11);
        		 obfb = (Label)mainMenu.getChildren().get(12);
        		 obinst = (Label)mainMenu.getChildren().get(13);
        		 obtwi = (Label)mainMenu.getChildren().get(14);
            	
        		 //System.out.println(dialogPane.getChildren().toString());
        		 TextField obname2 =(TextField)dialogPane.getChildren().get(10);
        		 TextField obslogan2 =(TextField)dialogPane.getChildren().get(11);
        		 TextField obadress2 =(TextField)dialogPane.getChildren().get(12);
        		 TextField obphone2 =(TextField)dialogPane.getChildren().get(13);
        		 TextField obvk2 =(TextField)dialogPane.getChildren().get(14);
        		 TextField obfb2 =(TextField)dialogPane.getChildren().get(15);
        		 TextField obinst2 =(TextField)dialogPane.getChildren().get(16);
        		 TextField obtwi2 =(TextField)dialogPane.getChildren().get(17);
        		// 
            	//System.out.println(obname.toString());
        		
        		 
        		 obname2.setText(obname.getText());
        		 obslogan2.setText(obslogan.getText());
        		 obadress2.setText(splitString(obadress.getText()));
        		 obphone2.setText(splitString(obphone.getText()));
        		 obvk2.setText(splitString(obvk.getText()));
        		 obfb2.setText(splitString(obfb.getText()));
        		 obinst2.setText(splitString(obinst.getText()));
        		 obtwi2.setText(splitString(obtwi.getText()));
            	
        		 System.out.println(info);
        		
        		 
            	if(dialogPane.isDisable()){
            		dialogPane.setDisable(false);
                	dialogPane.setOpacity(1);	
            		
            	}
            	
            	
            	
            }
        });
		
        
       
		
		
	}
	
	
	public String splitString(String line){
		
		String []mass = line.split(":");
		return mass[1];
	}
	

	public void removePreview(){
	AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
	
	System.out.println("//"+borderPane.getChildren().get(0).toString());
	borderPane.getChildren().remove(0);
	
	System.out.println("//"+borderPane.getChildren().get(0).toString());
		
		System.out.println(ap.getChildren().size());
		
		
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
			ap.getChildren().remove(ap.getChildren().get(1));
		ap.getChildren().remove(ap.getChildren().get(1));
		
		
		ListView<String> lv = (ListView<String>)ap.getChildren().get(0);
		lv.setPrefHeight(75);
		
			ap.setPrefHeight(75);
	}
	
	public void initTopMenu(){
		
	removePreview();
			
		//ap.getChildren().remove(ap.getChildren().get(1));
		//ap.getChildren().remove(2);
		
		ObservableList<String> items =FXCollections.observableArrayList (
			    "Главная страница", "  Меню  ", "Визуализация меню", "Состояние системы");
		
		topMenu.setItems(items);
		
		
		topMenu.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

	        @Override
	        public ListCell<String> call(ListView<String> param) {
	             cell = new ListCell<String>() {

	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (item != null) {
	                    	cell.setPrefWidth(299);
	                    	cell.setAlignment(Pos.CENTER);
	                    	
	                    	if(counter==1){
	                    		cell.setText("Главная страница");
	                    	
	                    	}
	                    	if(counter==2){
	                    		cell.setText("Меню");
	                    	}
	                    	if(counter==3){
	                    		cell.setText("Визуализация меню");
	                    	}
	                    	if(counter==4){
	                    		cell.setText("Состояние системы");
	                    	}
	                    	
	                    	
	                    	counter++;
	                    	
	                    
	                    }
	                    
	                    
	                    
	                }
	            };
	            return  (ListCell<String>) cell;
	        }

			
	    });
		
		
		topMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        System.out.println("ListView selection changed from oldValue = " 
		                + oldValue + " to newValue = " + newValue);
		    
		    if(newValue.replace(" ", "").equals("Главнаястраница")){
		    	System.out.println(newValue.replace(" ", ""));
		    	listenTopMenu(1);
		    	
		    }
			 if(newValue.replace(" ", "").equals("Меню")){
				 listenTopMenu(2);    	
					    }
			 if(newValue.replace(" ", "").equals("Визуализацияменю")){
				 listenTopMenu(3);
			 }
			 if(newValue.replace(" ", "").equals("Состояниесистемы")){
				 listenTopMenu(4);
			 }
					    
		    }
		});
		
		showMainPage();
	}
	
	public void showTablePage(){
		

        // loader.setLocation(MainGUI.class.getResource("fxml/MainPage.fxml"));
		 InputStream stream = getClass().getResourceAsStream("MainTable.fxml");
		
		 
		 
            try {
				
            	if(isPr2){
				tablePane = new FXMLLoader().load(stream)  ;
            	isPr2 = false;
            	}
            	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//(AnchorPane) FXMLLoader.load(MainGUI.class.getResource("MainPage.fxml"));
          
           // Помещаем сведения об адресатах в центр корневого макета.
         System.out.println(borderPane.toString());
            borderPane.setCenter(tablePane);
            
         
			counter = 0;	
            System.out.println(tablePane.getChildren().toString());

}
public void showVisualPage(){
		

        // loader.setLocation(MainGUI.class.getResource("fxml/MainPage.fxml"));
		 InputStream stream = getClass().getResourceAsStream("MainMenu.fxml");
		
		 
		 
            try {
				
            	
            	if(isPr4){
            	personOverview = new FXMLLoader().load(stream)  ;
            	isPr4 = false;
            	}
            
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//(AnchorPane) FXMLLoader.load(MainGUI.class.getResource("MainPage.fxml"));
          
           // Помещаем сведения об адресатах в центр корневого макета.
         System.out.println(borderPane.toString());
            borderPane.setCenter(personOverview);
            
         
			counter = 0;	
            System.out.println(personOverview.getChildren().toString());

}
	
	
	
	
	
	public void listenTopMenu(int index) {
		
		if(index == 1){
			
			showMainPage();
			
		}
		if(index == 2){
			showTablePage();
		}
		if(index == 3){
			showVisualPage();
		}
		
		if(index == 4){
			try {
				showStatePage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public void createPrevewPatterns(){
		
		patternList.add(new PreviewPattern("Описание продукта.","","В этом видео можно узнать основные возможности программы и с чего начать работу."));
		patternList.add(new PreviewPattern("Добавление меню.","","В этом видео можно узнать об особенностях работы с меню в продукте."));
		patternList.add(new PreviewPattern("Вкладка 'Виpуализация'.","","В этом видео можно ознакомиться с разделом 'Визуализация'."));
		patternList.add(new PreviewPattern("Вкладка 'Состояние системы'","","В этом видео можно узнать о том как система устроена изнутри и о том как мониторить состояние системы.."));

	}
	
	public void firstDescription(){
		System.out.println("/");
		AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
		//5
		RadioButton r2 =(RadioButton)ap.getChildren().get(7) ;
		RadioButton r3 =(RadioButton)ap.getChildren().get(9) ;
		RadioButton r4 =(RadioButton)ap.getChildren().get(8) ;
		r2.setSelected(false);
		r3.setSelected(false);
		r4.setSelected(false);
		
		descrName.setText("Описание продукта. Начало работы");
		descrText.setText("Многие клиенты  сталкиваются с проблемой ожидания официанта. Иногда время,уходящее на обслуживание, больше чем на приготовление. Многие клиенты предпочли бы совершать заказ напрямую без участия официанта. Это приложение позволяет администрировать систему, которая автоматизирует многие процессы в заведении. Настройка программы занимает не более получаса, а администрирование не требует больших затрат времени и усилий.  Для начала стоит заполнить данные о заведени, указать ваши контакты и соц.сети. Вы всегда сможете добавить новую информацию и изменить старую.  ");
		
	}
	public void secondDescription(){
		AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
		//6
		RadioButton r2 =(RadioButton)ap.getChildren().get(6) ;
		RadioButton r3 =(RadioButton)ap.getChildren().get(8) ;
		RadioButton r4 =(RadioButton)ap.getChildren().get(9) ;	
		
		r2.setSelected(false);
		r3.setSelected(false);
		r4.setSelected(false);
		descrName.setText("Работа с меню");
		descrText.setText("Добавьте информацию о блюдах(*обязательные пункты:категория,название,фото). Сохраните введенную информацию.  ");
	
	}
	public void thirdDescription(){
		AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
		//7
		RadioButton r2 =(RadioButton)ap.getChildren().get(6) ;
		RadioButton r3 =(RadioButton)ap.getChildren().get(7) ;
		RadioButton r4 =(RadioButton)ap.getChildren().get(9) ;
		r2.setSelected(false);
		r3.setSelected(false);
		r4.setSelected(false);
		descrName.setText("Визуализация на мобильном устройстве");
		descrText.setText("На мобильном устройстве отображаются все пункты меню.");
	}
	public void fourthDescription(){
		AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
		//8
		RadioButton r2 =(RadioButton)ap.getChildren().get(7) ;
		RadioButton r3 =(RadioButton)ap.getChildren().get(8) ;
		RadioButton r4 =(RadioButton)ap.getChildren().get(6) ;
		r2.setSelected(false);
		r3.setSelected(false);
		r4.setSelected(false);
		
		descrName.setText("Состояние системы(в разработке)");
		descrText.setText("");
	}
	
	
	public void addPostbyEnter(KeyEvent e){
		System.out.println("kk");
		if(e.getCode().equals(KeyCode.ENTER)){
		System.out.println("posted");
		
		
		
		ScrollPane scrollPost =(ScrollPane) mainMenu.getChildren().get(15);
		System.out.println("scrollPost"+scrollPost.getContent().toString());
		AnchorPane container =(AnchorPane) scrollPost.getContent();//  (ScrollPane) mainMenu.getChildren().get(15);
		
		
		System.out.println("g"+container.getChildren().toString());
		TextField enterField = (TextField)container.getChildren().get(2);
		VBox postList = (VBox) container.getChildren().get(3);
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainGUI.class.getResource("Post.fxml"));
        AnchorPane post;
		try {
			post = (AnchorPane) loader.load();
			 
	        Label postText =(Label) post.getChildren().get(1);
	        postText.setText(enterField.getText());
	        enterField.setText("");
	        Label postDate =(Label) post.getChildren().get(2);
	        Date date = new Date();
	        postDate.setText(date.toString());
	        
	        
	       
	        postsL.add(post);
	        Collections.reverse(postsL);
	        postList.getChildren().setAll(postsL);
	        Collections.reverse(postsL);
	       
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
		
		
	}
	}
	public void addPost(){
		System.out.println("posted");
		
		
		
		ScrollPane scrollPost =(ScrollPane) mainMenu.getChildren().get(15);
		System.out.println("scrollPost"+scrollPost.getContent().toString());
		AnchorPane container =(AnchorPane) scrollPost.getContent();//  (ScrollPane) mainMenu.getChildren().get(15);
		
		
		System.out.println("g"+container.getChildren().toString());
		TextArea enterField = (TextArea)container.getChildren().get(2);
		VBox postList = (VBox) container.getChildren().get(3);
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainGUI.class.getResource("Post.fxml"));
        AnchorPane post;
		try {
			post = (AnchorPane) loader.load();
			 Date date = new Date();
	        Label postText =(Label) post.getChildren().get(1);
	        ImageView bg = (ImageView) post.getChildren().get(0);
	        postText.setText(enterField.getText());
	       // postText.setBorder(new Border(new BorderStroke(Color.BLACK, 
		       //     BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	       int aa = 0;
	        
	        for(int i = 0;i<enterField.getText().length();i++){
	        	char a = enterField.getText().charAt(i);
	        	if(a=='\n'){
	        		aa++;
	        	}
	        	
	        }
	     System.out.println(aa);
	        aa++;
	        postText.setPrefHeight(((enterField.getText().length()/80+1)+aa)*21+20);
	        post.setPrefHeight(postText.getPrefHeight()+40);
	        bg.setFitHeight(postText.getPrefHeight()+40);
	        enterField.setText("");
	        Label postDate =(Label) post.getChildren().get(2);
	        AnchorPane.setTopAnchor(postDate,postText.getPrefHeight()-30 );
	        postDate.setText(date.toString());
	        
	        
	       
	        postsL.add(post);
	        Collections.reverse(postsL);
	        postList.getChildren().setAll(postsL);
	        Collections.reverse(postsL);
	       
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
		
		
	}
	
	
	public void showStatePage() throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainGUI.class.getResource("StateView.fxml"));
         
         
		 
		if(isPr5){
		 stateView = (AnchorPane) loader.load();//(AnchorPane) FXMLLoader.load(MainGUI.class.getResource("MainPage.fxml"));
		isPr5 = false;
		}   
         // Помещаем сведения об адресатах в центр корневого макета.
       System.out.println(borderPane.toString());
          borderPane.setCenter(stateView);
          
       
			counter = 0;	
        //  System.out.println(personOverview.getChildren().toString());
				 
	 
	 
			
		
		
	}
	
	
	public void showMainPage(){
		
		 try {
			
			
	           // loader.setLocation(MainGUI.class.getResource("fxml/MainPage.fxml"));
			// InputStream stream = getClass().getResourceAsStream("MainTable.fxml");
			
			 FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainGUI.class.getResource("MainPage.fxml"));
	            
	            
			 
			if(isPr){
			 mainMenu = (AnchorPane) loader.load();//(AnchorPane) FXMLLoader.load(MainGUI.class.getResource("MainPage.fxml"));
			isPr = false;
			}   
	            // Помещаем сведения об адресатах в центр корневого макета.
	          System.out.println(borderPane.toString());
	             borderPane.setCenter(mainMenu);
	             
	          
				counter = 0;	
	           //  System.out.println(personOverview.getChildren().toString());
					 
		 
		 
		 } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		 
		 try {
			
			 FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainGUI.class.getResource("ChangeDialog.fxml"));
			// InputStream stream = getClass().getResourceAsStream("ChangeDialog.fxml");
				
			 dialogPane = (AnchorPane) loader.load(); ;
			 dialogPane.setLayoutX(889);
			 dialogPane.setLayoutY(30);
			 dialogPane.setDisable(true);
			 dialogPane.setOpacity(0);
			 mainMenu.getChildren().add(dialogPane);
			//BorderPane.setMargin(dialogPane, new Insets(0,0,0,0));
			
	           // dialogPane.setC(personOverview);
		
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setPlanshetState(){
			
		int connNumber = MainGUI.rs.getConnNumber();
		System.out.println("connNumber "+connNumber);
		int fPaneNumber=0;
		if(connNumber%4==0){
		 fPaneNumber = connNumber/4;
		}
		else{
			fPaneNumber=(connNumber/4)+1;
			
		}
		
		Image im1 = new Image("img/logomin.png");
		ImageView iv1 = new ImageView(im1);
		iv1.setFitHeight(150);
		iv1.setFitWidth(300);
		ImageView iv2 = new ImageView(im1);
		iv2.setFitHeight(150);
		iv2.setFitWidth(800);
		
		Device[][] dList = new Device[4][fPaneNumber];
		for(int i = 0;i<fPaneNumber;i++){
			for(int j = 0;j<4;j++){
				if(i*4+j<connNumber){
					System.out.println("i"+i+"/"+"j"+j);
					dList[j][i] = new Device((i*4+j),STATE_WAITING,0,ORDER_WAITING);
				}
			}
			
		}
		System.out.println("size"+dList.length);
		
		for(int i = 0;i<fPaneNumber;i++){
			for(int j = 0;j<4;j++){
				System.out.println("i"+i+"/"+"j"+j);
				if(i*4+j<connNumber){
				System.out.print(dList[j][i]+" ");
				}
				}
			System.out.println("");
		}
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainGUI.class.getResource("DevicePane.fxml"));
        
		
		
		GridPane devicePane = new GridPane();
		devicePane.setHgap(20);
		devicePane.setVgap(20);
		
		for(int i = 0;i<fPaneNumber;i++){
			for(int j = 0;j<4;j++){
				if(i*4+j<connNumber){
					AnchorPane device;
					try {
						device = (AnchorPane) loader.load();
						
						device.setBorder(new Border(new BorderStroke(Color.BLACK, 
					            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
						Label dName = (Label)device.getChildren().get(0);
						Label dState = (Label)device.getChildren().get(1);
						Label dNumber = (Label)device.getChildren().get(2);
						Circle dCircle = (Circle)device.getChildren().get(3);
						Button dButton = (Button)device.getChildren().get(4);
						
						dName.setText("Устройство № "+dList[j][i].getNumber());
						dState.setText("Состояние: "+dList[j][i].getState());
						dNumber.setText("Номер заказа:"+dList[j][i].getOrder()+"/"+dList[j][i].getOrderState());
						dCircle.setFill(Color.LIME);
						
						
						//device.getChildren().add(new Label(dList[j][i].getState()));
						devicePane.add(device, j, i, 1, 1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} ;
					
					
				}
				
			}
			
		}
		
		//devicePane.add(iv1, 0, 0, 1, 1);
		//devicePane.add(iv2, 1, 0, 1, 1);
		planshetPane.setContent(devicePane);
		planshetPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT
	           , CornerRadii.EMPTY, Insets.EMPTY)));		
	}
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		if(descrName!=null&&descrText!=null){
		descrName.setText("Описание продукта. Начало работы.");
		descrText.setText("Многие клиенты  сталкиваются с проблемой ожидания официанта. Иногда, время,уходящее на обслуживание больше, чем на приготовление. Многие клиенты предпочли бы совершать заказ напрямую без участия официанта. Это приложение позволяет администрировать систему, которая автоматизирует многие процессы в заведении. Настройка программы занимает не более получаса, а администрирование не требует больших затрат времени и усилий.  Для начала стоит заполнить данные о заведени, указать ваши контакты и соц.сети. Вы всегда сможете добавить новую информацию и изменить старую.  ");
		AnchorPane ap = (AnchorPane)borderPane.getChildren().get(1);
		RadioButton r1 =(RadioButton)ap.getChildren().get(6) ;
		r1.setSelected(true);
		}
		if(planshetPane!=null){
		System.out.println("l"+planshetPane);
		setPlanshetState();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}
