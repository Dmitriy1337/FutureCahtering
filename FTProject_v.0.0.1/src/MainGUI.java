import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainGUI extends Application implements Initializable{
	
	@FXML
	Group MainMenuGroup = new Group();
	
	@FXML 
	private AnchorPane root;
	
	
	int  cc = 0;	
	
	
	
	boolean gg = false;
	File fl1,fl2;
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
	int count=0;
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
	//SystemLog sL = new SystemLog();
	Image getImage;
	ChoiceBox<String> chooseLbFont1;
	ListView<String> list;
	ImageView[] imageList = new ImageView[4];
	
	final ObservableList<Dish> data =
	          FXCollections.observableArrayList();
	
	public Label lb1;
	
	
	public Label lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	public Label td1,td2,td3,td4,td5,td6,td7,td8;
	@FXML   TableColumn<Dish, String> t1;
	
	@FXML  TableColumn<Dish, String> t2;
	@FXML TableColumn<Dish, String> t3;
	@FXML TableColumn<Dish, String> t4;
	@FXML  TableColumn<Dish, String> t5;
	@FXML  TableColumn<Dish, String> t6;
	@FXML  TableColumn<Dish, String> t7;
	public AnchorPane InfoPane;
	public ListView<Object> ll;

	public ListView<Object> ld;
	
	@FXML TableColumn<Dish, File> t8;
	@FXML   TableColumn<Dish, File> t9;
	@FXML   private ListView<String> ListApps; 
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
	
	TextField tx;

	TextArea tx1,tx4;

	TextField tx2;

	TextField tx6;

	TextArea tx5;

	TextField tx3;
	@FXML
	ImageView img1,img2;
	@FXML
	Button OK;
	@FXML
	TableView<Dish>mainTb ; 
public ImageView DishImg;
public Label DishName,DishValue,DishDescription,DishIngredients,DishKkal,DishPrice;
	boolean isPr6 =false;
	GridPane planshetPane_1;
	SubScene planshetScene_2;
	ArrayList<String>al1=new ArrayList<>();
	 ArrayList<Object> topLabelNameData=new ArrayList<Object>();
	 ArrayList<Object> topLabelSloganData=new ArrayList<Object>();
	 ArrayList<Object> menuButtonData=new ArrayList<Object>();
	 ArrayList<Object> orderButtonData=new ArrayList<Object>();
	 ArrayList<Object> stateButtonData=new ArrayList<Object>();
	 ArrayList<Object> aboutUsButtonData=new ArrayList<Object>();
	 ArrayList<Object> picturesData=new ArrayList<Object>();
	static HashMap<String, ArrayList<File>>ph1 = new HashMap();
	static HashMap<String, File>ph2 = new HashMap();
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
	
	Scene sc;
	private Stage primaryStage;
  @FXML
	public  AnchorPane rootLayout ;
  @FXML
  public   AnchorPane Dialog1;
	int counter1=-1;
	ArrayList<String>dhName =new ArrayList<String>();
	ArrayList<String>dhDesc =new ArrayList<String>();
	ArrayList<String>dhIngr =new ArrayList<String>();
	ArrayList<String>dhRef =new ArrayList<String>();
	ArrayList<String>dhVal =new ArrayList<String>();
	ArrayList<String>dhKkl =new ArrayList<String>();
	ArrayList<String>dhPrice =new ArrayList<String>();
	ArrayList<File>categIm =new ArrayList<File>();
	ArrayList<File>dishIm =new ArrayList<File>();
	Group gr1;
	ListView<String>list1;
	ImageView imDish;
	ImageView imCateg;
	int index;
	Button safe,add,del;
	ImageView i22;
	Image i23;
	Dish dsh;
	Stage st1 = new Stage();

	
	//ResServer rs;
	ArrayList<ArrayList<String>>almenu = new ArrayList<>();
	ArrayList<ArrayList<File>>almenuPhoto = new ArrayList<>();
	static ArrayList<ArrayList<ArrayList<String>>>allMenuCombinedAndSorted = new ArrayList<>();
	static ArrayList<Label>listoflbs = new ArrayList<>();
	static ArrayList<Label>listoflbsDishes = new ArrayList<>();
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void start(Stage mainWindowStage) throws Exception {
		mainWindowStage.setResizable(false);
		showPreview(mainWindowStage);
		
		
		
		
		
	}

	
	public void showPreview(Stage mainStage){//метод визуализации превью
		 try {
	            // Загружаем корневой макет из fxml файла.
			 // Загружаем корневой макет из fxml файла.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainGUI.class.getResource("UserPreview.fxml"));
	            rootLayout = (AnchorPane) loader.load();

	            // Отображаем сцену, содержащую корневой макет.
	             Scene scene = new Scene(rootLayout,1190,650);
	            mainStage.setScene(scene);
	            mainStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		//
		
	}
	
	
	public void setColumns(){
	mainTb.getColumns().addAll(t1,t2,t3,t4,t5,t6,t7);
}
	
	
	public void listenMenu(String args,Stage st){
		
		if(args.replaceAll(" ","").equals("МойРесторан") ){
			//showRestaurantInfo(st);
			
		}
		if(args.replaceAll(" ","").equals("Каталогтоваров")){ 
			//showTable(st); 
			}
		if(args.replaceAll(" ","").equals("Визуализацияменю")){ 
			//showVisualMenu(st);
			}
	}
	
	public void LabelsAddTest(){
		  InfoPane.setVisible(false);
		  InfoPane.setDisable(true);
		  ld.setVisible(true);  
		  ld.setDisable(false);
		  
		   
		   
		}
	public void showVisualMenu(Stage st1){
		try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainGUI.class.getResource("MainMenu.fxml"));
            
            rootLayout = (AnchorPane) loader.load();
            rootLayout.getChildren().add(list);
            
            // Отображаем сцену, содержащую корневой макет.
           mainScene.setRoot(rootLayout);
            st1.setScene(mainScene);
            st1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


	
	

public void showCategoriesAndDishes(ActionEvent event) throws IOException{//открываеться при нажатии кнопки меню
	
		try {
           AnchorPane pane  = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
           
           MainMenuGroup.setVisible(false);
           
           root.getChildren().addAll(pane);
      
		} catch (IOException e) {
           e.printStackTrace();
       }
	} 



public void Dialog(ActionEvent event)throws IOException{

	
	dialog = new Dialog();
    dialog.initStyle(StageStyle.UTILITY);
    AnchorPane ap = new AnchorPane();
    ap.setPrefWidth(400);
    
    ap.setPrefHeight(620);
    Label lb  =new Label("Название");
    lb.setLayoutX(34);
    lb.setLayoutY(65);
    lb.setFont(new Font(16));
    ap.getChildren().add(lb);
    Label lb1  =new Label("Ингредиенты");
    lb1.setLayoutX(37);
    lb1.setLayoutY(200);
    lb1.setFont(new Font(16));
    ap.getChildren().add(lb1);
    Label lb2  =new Label("Ккл");
    lb2.setLayoutX(36);
    lb2.setLayoutY(527);
    lb2.setFont(new Font(16));
    ap.getChildren().add(lb2);
    Label lb3  =new Label("Категория");
    lb3.setLayoutX(36);
    lb3.setLayoutY(157);
    lb3.setFont(new Font(16));
    ap.getChildren().add(lb3);
    Label lb4 =new Label("Описание");
    lb4.setLayoutX(36);
    lb4.setLayoutY(109);
    lb4.setFont(new Font(16));
    ap.getChildren().add(lb4);
    Label lb5  =new Label("Белки/Жиры"
    +System.lineSeparator()		+ "/Углеводы");
    lb5.setLayoutX(36);
    lb5.setLayoutY(338);
    lb5.setFont(new Font(16));
    ap.getChildren().add(lb5);
    Label lb6  =new Label("Цена");
    lb6.setLayoutX(228);
    lb6.setLayoutY(527);
    lb6.setFont(new Font(16));
    ap.getChildren().add(lb6);
    Label lb7  =new Label("Категория(Картинка)");
    lb7.setLayoutX(36);
    lb7.setLayoutY(423);
    lb7.setFont(new Font(16));
    ap.getChildren().add(lb7);
    Label lb8  =new Label("Блюдо(Картинка)");
    lb8.setLayoutX(229);
    lb8.setLayoutY(423);
    lb8.setFont(new Font(16));
    ap.getChildren().add(lb8);
     tx =new TextField();
    tx.setLayoutX(154);
    tx.setLayoutY(65);
    tx.setPrefSize(202,25);
    tx1 =new TextArea();
    tx1.setLayoutX(156);
    tx1.setLayoutY(200);
    tx1.setPrefSize(200,120);
    tx4 =new TextArea();
   
    tx4.setPrefSize(200,200);
    TitledPane tl = new TitledPane();
     tl.setText("Подробнее");
     tl.setExpanded(false);
     tl.setAnimated(true);
     tl.setContent(tx4);
     tl.setLayoutX(154);
     tl.setLayoutY(109);
     tl.setOnMousePressed(ll->{
    	
    	 if(!tl.isExpanded()){ 
    		
    		tx1.setVisible(false);
    		tx3.setVisible(false);
    	
    	}
    	if(tl.isExpanded()){ 
    		
    		tx1.setVisible(true);
    		tx3.setVisible(true);
    		
    	}
     });
     ap.getChildren().add(tl);
     tx2 =new TextField();
    tx2.setLayoutX(83);
    tx2.setLayoutY(527);
    tx2.setPrefSize(85, 25);
     tx3 =new TextField();
    tx3.setLayoutX(154);
    tx3.setLayoutY(157);
    tx3.setPrefSize(202, 25);
     
     tx5 =new TextArea();
    tx5.setLayoutX(156);
    tx5.setLayoutY(338);
    tx5.setPrefSize(200,57);
     tx6 =new TextField();
    tx6.setLayoutX(277);
    tx6.setLayoutY(525);
    tx6.setPrefSize(75, 25);
     imCateg  =new ImageView("img/planshet.jpg");
    imCateg.setFitHeight(66);
    imCateg.setFitWidth(75);
    imCateg.setLayoutX(70);
    imCateg.setLayoutY(450);
    imCateg.setOnMouseClicked(ms->{
    	chooseImageForImageDish(st1,imCateg);
    });
     imDish  =new ImageView("img/planshet.jpg");
    imDish.setFitHeight(66);
    imDish.setFitWidth(75);
   imDish.setLayoutX(239);
    imDish.setLayoutY(450);
    imDish.setOnMouseClicked(ms1->{
    	chooseImageForImageCateg(st1,imDish);
   });
    ap.getChildren().addAll(tx,tx1,tx2,tx3,tx5,tx6,imDish,imCateg);
    dialog.getDialogPane().setContent(ap);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
	dialog.showAndWait();
	if(dialog.getResult().equals(ButtonType.OK)){
		data.add(dsh=new Dish(tx.getText(),tx4.getText(),tx1.getText(),tx3.getText(),tx5.getText(),
				tx2.getText(),tx6.getText(),fl1,fl2));
	
		dhName.add(dsh.getDishName());
	dhDesc.add(dsh.getDishDescription()); 
	dhIngr.add(dsh.getDishIngredients());
	dhRef.add(dsh.getDishRefer()); 
	dhVal.add(dsh.getDishHValue()); 
	dhKkl.add(dsh.getDishKkl()); 
	dhPrice.add(dsh.getDishPrice());
	categIm.add(dsh.getCategImage()); 
	dishIm.add(dsh.getDishImage());	
		counter1++;
	
		}
}

public void sortPictures() throws IOException{
	ph1.clear();
	ph2.clear();
	for(int i=0;i<almenu.size();i++){
		  ArrayList<File>all = new ArrayList<>();
		  ArrayList<File>all1 = new ArrayList<>();
		 // FileInputStream file = new FileInputStream(almenuPhoto.get(i).get(1));
		 
		 
		  all.add(almenuPhoto.get(i).get(1));
		  
		  all1.add(almenuPhoto.get(i).get(0));
		  if(ph1.containsKey(almenu.get(i).get(3))){
			ph1.get(almenu.get(i).get(3)).add(almenuPhoto.get(i).get(1));	 
			 }
		  else{
			  ph1.put(almenu.get(i).get(3),all);	 
		  }
		 ph2.put(almenu.get(i).get(3), almenuPhoto.get(i).get(0));
		 }
}

public void SafeInfo(ActionEvent event)throws IOException{
	allMenuCombinedAndSorted.clear();
	almenu.clear();
	almenuPhoto.clear();
	for(int i=0;i<dhName.size();i++){
		
		ArrayList<String>al = new ArrayList<>();
		ArrayList<File>all = new ArrayList<>();
		
		al.add(dhName.get(i));
		al.add(dhDesc.get(i));
		al.add(dhIngr.get(i));
		al.add(dhRef.get(i));
		al.add(dhVal.get(i));
		al.add(dhKkl.get(i));
		al.add(dhPrice.get(i));
		all.add(categIm.get(i));
		all.add(dishIm.get(i));
		almenu.add(al);
		almenuPhoto.add(all);
	}
	if(almenuPhoto.get(0).get(0)==null){
		System.out.println("9999999999999999999999");
	}
	System.out.println(almenu.toString());
	System.out.println(almenuPhoto.toString());
	sortPictures();
	sortTheTebleInformation();

	
	System.out.println(allMenuCombinedAndSorted.toString());
	System.out.print(ph1);
}



public void sortTheTebleInformation(){
	for (int i = 0; i < almenu.size(); i++) {
        ArrayList<ArrayList<String>> tesar = new ArrayList<>();
       count=0;
        if((almenu.size() - i == 1) &&(count==0)&&!(almenu.get(i).get(3).equals(""))){
            tesar.add(almenu.get(i));
            allMenuCombinedAndSorted.add(tesar);
        }

        for (int j = i + 1; j < almenu.size(); j++) {
            if ((almenu.get(i).get(3).equals(almenu.get(j).get(3)) && !(almenu.get(i).get(3).equals("")))) {
                tesar.add(almenu.get(j));

                almenu.get(j).set(3, "");
               count++;
            }

            if ((almenu.size() - j == 1) && (!tesar.isEmpty())) {


                tesar.add(almenu.get(i));
                allMenuCombinedAndSorted.add(tesar);

            }
       if((almenu.size() - j == 1) &&(count==0)&&!(almenu.get(i).get(3).equals(""))){
          tesar.add(almenu.get(i));
          allMenuCombinedAndSorted.add(tesar);
       }
        }
    }
		
}


	


	  public void chooseImageForImageDish(Stage stage,ImageView im){
  		FileChooser fileChooser = new FileChooser();
  		fileChooser.setTitle("Choose Image");
  		configureFileChooser(fileChooser);
  		 Platform.runLater(new Runnable() {
  	            @Override public void run() {
  	            	File file = fileChooser.showOpenDialog(stage);
  	            	fl1=file;
  					try {
  						    imagepath = file.toURI().toURL().toString();
  							getImage = new Image( imagepath);
  						im.setImage(getImage);
  						
  					
  						
  					} catch (MalformedURLException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  					
  					
  					
  	            }});
  	}
      public void chooseImageForImageCateg(Stage stage,ImageView im){
  		FileChooser fileChooser = new FileChooser();
  		fileChooser.setTitle("Choose Image");
  		configureFileChooser(fileChooser);
  		 Platform.runLater(new Runnable() {
  	            @Override public void run() {
  	            	File file = fileChooser.showOpenDialog(stage);
  	            	fl2 = file;
  					try {
  						    imagepath = file.toURI().toURL().toString();
  							getImage = new Image( imagepath);
  						im.setImage(getImage);
  						
  					
  						
  					} catch (MalformedURLException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  					
  					
  					
  	            }});
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


	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {

		if(ll!=null){
			try {
			System.out.println(allMenuCombinedAndSorted.size());
		for(int i= 0;i<allMenuCombinedAndSorted.size();i++){	
			
			Label lbb1 =new Label(allMenuCombinedAndSorted.get(i).get(allMenuCombinedAndSorted.get(i).size()-1).get(3));
			lbb1.setFont(new Font(34));
			
			Label DishCount =new Label(Integer.toString(allMenuCombinedAndSorted.get(i).size()));
			DishCount.setFont(new Font(34));
			
			ImageView img = new ImageView("img/planshet.jpg");
			img.setFitHeight(50);
			img.setFitWidth(50);
			
			String URLInfo = ph2.get(allMenuCombinedAndSorted.get(i).get(allMenuCombinedAndSorted.get(i).size()-1).get(3)).toURI().toURL().toString();
			Image im = new Image(URLInfo);
			img.setImage(im);
			GridPane gp = new GridPane();
			GridPane.setHalignment(img, HPos.LEFT);
			GridPane.setHalignment(lbb1, HPos.CENTER);
			GridPane.setHalignment(DishCount, HPos.RIGHT); 
			GridPane.setMargin(lbb1, new Insets(0,0,0,60));
			GridPane.setMargin(DishCount, new Insets(0,0,0,100));
			gp.add(DishCount,1,0);
			gp.getChildren().addAll(lbb1,img);
			
			gp.setOnMouseClicked(lll->{
				try {
				ld.getItems().clear();
				int position=ll.getSelectionModel().selectedIndexProperty().getValue();
				for(int k = 0;k<allMenuCombinedAndSorted.get(position).size();k++){
				Label lDish  =new Label(allMenuCombinedAndSorted.get(position).get(k).get(0));
				lDish.setFont(new Font(34));
				
				ImageView img1 = new ImageView("img/planshet.jpg");
				img1.setFitHeight(50);
				img1.setFitWidth(50);
				
				String URLInfo1 = ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3)).get(k).toURI().toURL().toString();
				
				Image im1 = new Image(URLInfo1);
				img1.setImage(im1);
				GridPane gp1 = new GridPane();
				GridPane.setHalignment(img1, HPos.LEFT);
				GridPane.setHalignment(lDish, HPos.CENTER);
				GridPane.setMargin(lDish, new Insets(0,0,0,70));
				gp1.getChildren().addAll(lDish,img1);
				gp1.setOnMouseClicked(pp->{;
				try {
				int Dishposition=ld.getSelectionModel().selectedIndexProperty().getValue();
				
				
				String URLDish = ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3)).get(Dishposition).toURI().toURL().toString();
				
				Image imDish = new Image(URLDish);
				DishImg.setImage(imDish);
				DishName.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(0));
				DishValue.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(4));
				DishDescription.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(1));
				DishIngredients.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(2));
				DishKkal.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(5));
                DishPrice.setText(allMenuCombinedAndSorted.get(position).get(Dishposition).get(6));
				InfoPane.setVisible(true);
				InfoPane.setDisable(false);
				ld.setVisible(false);	
				ld.setDisable(true);
				
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				});
				ld.getItems().add(gp1);
				}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	 		
			ll.getItems().add(gp);
	 		
	 		}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		//            Каталог блюд                        ","                     Визуализация меню                      ","                         Бухгалтерия                        ");
	if(t1!=null){
		 t1.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishName")
	        );
	
		t2.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishDescription")
	        );
		
		t3.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishIngredients")
	        );
		
		t4.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishRefer")
	        );
		
		t5.setCellValueFactory(
	           new PropertyValueFactory<Dish,String>("dishHValue")
	        );
		 
		t6.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishKkl")
	        );
		 
		t7.setCellValueFactory(
	            new PropertyValueFactory<Dish,String>("dishPrice")
	        );
	
		t8.setCellValueFactory(
	            new PropertyValueFactory<Dish,File>("categImage")
	        );
		
		t9.setCellValueFactory(
	            new PropertyValueFactory<Dish,File>("dishImage")
	        );
        mainTb.setItems(data);
	}		
		
	
		
	}
	
	
	  
	
}
