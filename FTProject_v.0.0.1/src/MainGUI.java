import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainGUI extends Application implements Initializable{
	
	@FXML
	Group MainMenuGroup = new Group();
	
	@FXML 
	private AnchorPane root;
	
	AnchorPane dialogPane;
	
	int  cc = 0;	
	static ResServer rs;
	static int middleVar = 0 ;
    static  boolean openFromMenu = false;
    GraphicsEnvironment environment =  GraphicsEnvironment.getLocalGraphicsEnvironment();
    String fontNames[] = environment.getAvailableFontFamilyNames();
    public Button usAll;
    
    public AnchorPane redactor;
    public ListView<Label>redactorList;	   
    public Button addorsafe;	    
    static Image imageforPattern;
	public Label txt1,txt2,txt3,Buttontxt1,Buttontxt2,Buttontxt3;
    public Label animColor;
	public TextField PatternTextSize, TextBorderSize, ButtonTextSize,ButtonBorderSize;
	public ColorPicker PatternTextColor,PatternBackground,TextBorderColor,ButtonTextColor,ButtonBackgroundColor,ButtonBorderColor,animationColor;
	public ChoiceBox<String> PatternFont,ButtonTextFont;
	public Slider PatternOpacity,ButtonTextOpacity;
	public CheckBox animation;
	static String textinfo="default";
	static String buttoninfo="default";
	static HashMap<Integer, ArrayList<String>>ListOfPatterns = new HashMap<>();
	static public ArrayList<BackgroundImage>patt1=new ArrayList<>();
	static public ArrayList<BackgroundImage>patt2=new ArrayList<>();
	static public ArrayList<BackgroundImage>patt3=new ArrayList<>();
	static public ArrayList<BackgroundImage>patt4=new ArrayList<>();
	static public ArrayList<BackgroundImage>patt5=new ArrayList<>();
	static ArrayList<String>Textlist  = new ArrayList<>();
	static ArrayList<String>Textlist1  = new ArrayList<>();
	static boolean ViewIsClicked=false;
	static BackgroundImage bgm;
	static BackgroundImage bgm1;
	static BackgroundImage bgm2;
	static String menu;
	static int mainFieldTextSize;
	static int addFieldTextSize;
	static int CellSize;
	static int Number=0;
	static int Number1=0;
	public Button ButtonMenu,ButtonMakeOrder,ButtonOrderCondition,ButtonAboutUs;
	public Label nameLabel;
	public Label sloganLabel;
	static Stage kk;
	public Label changeRedac;
	 public GridPane redac1,redac2;
	public int  positionNumber=0; 
	public GridPane patMainV;
	public  Label lbb1;
	public ListView<String> listCategPattern;
	Image startImage = new Image("img/bckg.jpg");
	 public BackgroundImage startBg =  new BackgroundImage(startImage, 
	    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
	    BackgroundPosition.DEFAULT, 
	    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
	static boolean isOpen =false;
	 public   Label lDish;
	 public TextField test;
	 public   ListView<Object> PatternList;
	 static String textt;
	public int main_color=30;
	 public AnchorPane redactorPane;
	static public  BackgroundImage bgImage ;
	static int slideNumber=0;
	public Label PatternName;
static public HashMap<String,ArrayList<BackgroundImage>>bgpatterns = new HashMap<>();

@FXML   Label ResName;
	 @FXML
	
	 static ArrayList<Label>listofcategoriesnames = new ArrayList<>();
	 static ArrayList<Label>listofdishesnames = new ArrayList<>();
	@FXML 
	
	public GridPane MenuPane;
	public Button UsePattern;
	

	
	
	
	
	
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
 
	Dish selectedDish = null;
	public Button delete;
	
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
	
	@FXML Label addTest;
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
public Button changeButton;
	public ListView<Object> ld;
	
	@FXML TitledPane descrField;
	
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
	static FXMLLoader loader;
	 
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
		 rs  = new ResServer();
	    rs.start(ResServer.classStage);
		mainWindowStage.setResizable(false);
		showPreview(mainWindowStage);
		
		
				bgpatterns.put("MainView",patt1);  
				    bgpatterns.put("Categories",patt2);  
				    bgpatterns.put("Dish",patt3);
				    bgpatterns.put("DishInfo",patt4);

				
				    	loader = new FXMLLoader();
				        loader.setLocation(MainGUI.class.getResource("MainMenu.fxml"));
				        
		
				        
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


	
	

	public void showCategoriesAndDishes(ActionEvent event) throws IOException{
		  
	    
	    
	    MenuPane.setDisable(true);
	      MenuPane.setVisible(false);
	      ll.setVisible(true);
	    ll.setDisable(false);
	      positionNumber=0;
	  }



	public void addDishDialog(ActionEvent event)throws IOException{
		HashSet noDuplicateCateg= new HashSet(dhRef);
		ObservableList<String> categories =    FXCollections.observableArrayList();
		categories.addAll(noDuplicateCateg);
		//categories.
	    try {
	    	FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(MainGUI.class.getResource("AddDishWindow.fxml"));
	   		dialogPane = (AnchorPane) loader.load();
	   		System.out.println(dialogPane.getChildren().toString());
	   		
	   		Stage adDishStage = new Stage();
	   		adDishStage.initStyle(StageStyle.UNDECORATED);
	   		Scene addDishScene = new Scene(dialogPane);
	   		
	   		TextField name=(TextField)dialogPane.getChildren().get(13);
	   		descrField = (TitledPane)dialogPane.getChildren().get(14);
	   		TextField category=(TextField)dialogPane.getChildren().get(15);
	   		TextField ingridients=(TextField)dialogPane.getChildren().get(16);
	   		TextField b=(TextField)dialogPane.getChildren().get(17);
	   		TextField j=(TextField)dialogPane.getChildren().get(18);
	   		TextField u=(TextField)dialogPane.getChildren().get(19);
	   		TextField calories=(TextField)dialogPane.getChildren().get(20);
	   		TextField price=(TextField)dialogPane.getChildren().get(21);
	   		ImageView dishImage = (ImageView)dialogPane.getChildren().get(22);
	   		ImageView categoryImage = (ImageView)dialogPane.getChildren().get(23);
	   		Button ok = (Button)dialogPane.getChildren().get(24);
	   		ComboBox comboBox = (ComboBox)dialogPane.getChildren().get(25);
	   		ImageView exit = (ImageView)dialogPane.getChildren().get(26);
	   		Image enteredI = new Image("img/animationcb.png");
	   		Image exitedI = new Image("img/cb.png");
	   		exit.setOnMouseEntered(a->{
	   			exit.setImage(enteredI);	
	   			
	   		});
	   		exit.setOnMouseExited(a->{
	   			
	   			exit.setImage(exitedI);	
	   		});
	   		exit.setOnMouseClicked(t->{
	   			adDishStage.close();
	   			
	   		});
	   		comboBox.setItems(categories);
	   		
	   		comboBox.valueProperty().addListener(new ChangeListener<String>() {
	            @Override 
	            public void changed(ObservableValue ov, String t, String choose) {                
	               
	            	int n = dhRef.indexOf(choose);
	            	category.setText(choose);
	            	
	            	//BufferedImage i =ImageIO.read(categIm.get(n));
	            	
	            	try {
						categoryImage.setImage(createImage(dishIm.get(n)));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            	System.out.println(ov+"/"+t+"/"+choose);          
	            	System.out.println(categIm.toString());
	            
	            }    
	        });
	   		
	   		
	   		dishImage.setOnMouseClicked(ms->{
	   	    	chooseImageForImageDish(st1,dishImage);
	   	    });
	   		
	   		categoryImage.setOnMouseClicked(ms->{
	   			chooseImageForImageCateg(st1,categoryImage);
	   	    });
	   		
	   		tx4 =new TextArea();
	   		tx4.setPrefSize(200,200);
	   		tx4.setWrapText(true);
	        descrField.setText("Подробнее");
	        descrField.setExpanded(false);
	        descrField.setAnimated(true);
	        descrField.setContent(tx4);
	       
	        descrField.setOnMousePressed(ll->{
	       	
	       	 if(!descrField.isExpanded()){ 
	       		
	       		category.setVisible(false);
	       		ingridients.setVisible(false);
	       		comboBox.setVisible(false);
		       	
	       	}
	       	if(descrField.isExpanded()){ 
	       		
	       		category.setVisible(true);
	       		ingridients.setVisible(true);
	       		comboBox.setVisible(true);
	       	}
	        });
	    
	   		
	        ok.setOnAction(ee->{
	        	String bju = b.getText()+"/"+j.getText()+"/"+u.getText();
	        
	    		data.add(dsh=new Dish(name.getText(),tx4.getText(),ingridients.getText(),category.getText(),
	    				bju,calories.getText(),price.getText(),fl1,fl2));
	    		System.out.println("dsh.getDishName() "+dsh.getDishName());
	    		dhName.add(dsh.getDishName());//название
	    	dhDesc.add(dsh.getDishDescription()); //описание
	    	dhIngr.add(dsh.getDishIngredients());//ингридиенты
	    	dhRef.add(dsh.getDishRefer()); //категория
	    	dhVal.add(dsh.getDishHValue()); //бжу
	    	dhKkl.add(dsh.getDishKkl()); //калории
	    	dhPrice.add(dsh.getDishPrice());//цена
	    	categIm.add(dsh.getCategImage()); 
	    	dishIm.add(dsh.getDishImage());	
	    		counter1++;
	    		 SafeInfo();
	    		System.out.println("sizebefore"+dhName.size());
	    		adDishStage.close();
	        	
	        });
	        
	    	
	       
	   		
	   		
	   		
	   		adDishStage.setScene(addDishScene);
	   		adDishStage.show();
	   		
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

public void SafeInfo(){
	allMenuCombinedAndSorted.clear();
	almenu.clear();
	almenuPhoto.clear();
	System.out.println("size"+dhName.size());
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
	
		System.out.println(i+"almenu"+almenu.toString());
		System.out.println(i+"almenuPhoto"+almenuPhoto.toString());
	}
	//if(almenuPhoto.get(0).get(0)==null){
	//	System.out.println("9999999999999999999999");
	//}
	System.out.println("almenu"+almenu.toString());
	System.out.println("almenuPhoto"+almenuPhoto.toString());
	try {
		sortPictures();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sortTheTebleInformation();

	
	System.out.println(allMenuCombinedAndSorted.toString());
	System.out.print(ph1);
	
	
	//rs.sendMenuInfo(almenu,almenuPhoto);
	
}



public void sortTheTebleInformation(){
	System.out.println("almenu"+almenu.size());
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

    
     
      public void deleteDish(){
    	  data.remove(data.indexOf(selectedDish));
    	  mainTb.refresh();
    	  
      }
      
      
     
      public String getFromFile(){
    	  String s = "";
    	  try(FileReader reader = new FileReader("personalData.txt"))
          {
             
    		  // читаем посимвольно
              int c;
              while((c=reader.read())!=-1){
                   
                 s+=(char)c;
              } 
          }
          catch(IOException ex){
               
              System.out.println(ex.getMessage());
          }   
     return s;
      }

      public void changeDish(){
    	  

  		HashSet noDuplicateCateg= new HashSet(dhRef);
  		ObservableList<String> categories =    FXCollections.observableArrayList();
  		categories.addAll(noDuplicateCateg);
  		//categories.
  	    try {
  	    	FXMLLoader loader = new FXMLLoader();
  		    loader.setLocation(MainGUI.class.getResource("AddDishWindow.fxml"));
  	   		dialogPane = (AnchorPane) loader.load();
  	   		System.out.println(dialogPane.getChildren().toString());
  	   		
  	   		Stage adDishStage = new Stage();
  	   		adDishStage.initStyle(StageStyle.UNDECORATED);
  	   		Scene addDishScene = new Scene(dialogPane);
  	   		Label header= (Label)dialogPane.getChildren().get(3);
  	   		header.setText("Изменить");
  	   		TextField name=(TextField)dialogPane.getChildren().get(13);
  	   		descrField = (TitledPane)dialogPane.getChildren().get(14);
  	   		TextField category=(TextField)dialogPane.getChildren().get(15);
  	   		TextField ingridients=(TextField)dialogPane.getChildren().get(16);
  	   		TextField b=(TextField)dialogPane.getChildren().get(17);
  	   		TextField j=(TextField)dialogPane.getChildren().get(18);
  	   		TextField u=(TextField)dialogPane.getChildren().get(19);
  	   		TextField calories=(TextField)dialogPane.getChildren().get(20);
  	   		TextField price=(TextField)dialogPane.getChildren().get(21);
  	   		
  	   		String[] bjumass =selectedDish.getDishHValue().split("/") ;
  	   		
  	   	name.setText(selectedDish.getDishName());
  	   	category.setText(selectedDish.getDishRefer());	
  	   	ingridients.setText(selectedDish.getDishIngredients());	
  	   	b.setText(bjumass[0]);	
  	   	j.setText(bjumass[1]);	
  	   	u.setText(bjumass[2]);	
  	   	calories.setText(selectedDish.getDishKkl());	
  	   	price.setText(selectedDish.getDishPrice());	

  	   		
  	   		ImageView dishImage = (ImageView)dialogPane.getChildren().get(22);
  	   		ImageView categoryImage = (ImageView)dialogPane.getChildren().get(23);
  	   		
  	   		
  	   
  	  Image image = new Image(selectedDish.getCategImage().toURI().toString());
  	  categoryImage.setImage(image);
  	
  	   
  	Image image1 = new Image(selectedDish.getDishImage().toURI().toString());
	   	dishImage.setImage(image1);
  	   	
  	   		
  	   		Button ok = (Button)dialogPane.getChildren().get(24);
  	   		ComboBox comboBox = (ComboBox)dialogPane.getChildren().get(25);
  	   		ImageView exit = (ImageView)dialogPane.getChildren().get(26);
  	   		Image enteredI = new Image("img/animationcb.png");
  	   		Image exitedI = new Image("img/cb.png");
  	   		exit.setOnMouseEntered(a->{
  	   			exit.setImage(enteredI);	
  	   			
  	   		});
  	   		exit.setOnMouseExited(a->{
  	   			
  	   			exit.setImage(exitedI);	
  	   		});
  	   		exit.setOnMouseClicked(t->{
  	   			adDishStage.close();
  	   			
  	   		});
  	   		comboBox.setItems(categories);
  	   		
  	   		comboBox.valueProperty().addListener(new ChangeListener<String>() {
  	            @Override 
  	            public void changed(ObservableValue ov, String t, String choose) {                
  	               
  	            	int n = dhRef.indexOf(choose);
  	            	category.setText(choose);
  	            	
  	            	//BufferedImage i =ImageIO.read(categIm.get(n));
  	            	
  	            	try {
  						categoryImage.setImage(createImage(dishIm.get(n)));
  					} catch (IOException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  	            	
  	            	System.out.println(ov+"/"+t+"/"+choose);          
  	            	System.out.println(categIm.toString());
  	            
  	            }    
  	        });
  	   		
  	   		
  	   		dishImage.setOnMouseClicked(ms->{
  	   	    	chooseImageForImageDish(st1,dishImage);
  	   	    });
  	   		
  	   		categoryImage.setOnMouseClicked(ms->{
  	   			chooseImageForImageCateg(st1,categoryImage);
  	   	    });
  	   		
  	   		tx4 =new TextArea();
  	   		tx4.setPrefSize(200,200);
  	   		tx4.setWrapText(true);
  	        tx4.setText(selectedDish.getDishDescription());
  	   		descrField.setText("Подробнее");
  	        descrField.setExpanded(false);
  	        descrField.setAnimated(true);
  	        descrField.setContent(tx4);
  	       
  	        descrField.setOnMousePressed(ll->{
  	       	
  	       	 if(!descrField.isExpanded()){ 
  	       		
  	       		category.setVisible(false);
  	       		ingridients.setVisible(false);
  	       		comboBox.setVisible(false);
  		       	
  	       	}
  	       	if(descrField.isExpanded()){ 
  	       		
  	       		category.setVisible(true);
  	       		ingridients.setVisible(true);
  	       		comboBox.setVisible(true);
  	       	}
  	        });
  	    
  	   		
  	        ok.setOnAction(ee->{
  	        	String bju = b.getText()+"/"+j.getText()+"/"+u.getText();
  	        	selectedDish.setDishName(name.getText());
  	        	selectedDish.setDishDescription(tx4.getText());
  	        	selectedDish.setDishRefer(category.getText());
  	        	selectedDish.setDishIngredients(ingridients.getText());
  	        	selectedDish.setDishHValue(bju);
  	        	selectedDish.setDishKkl(calories.getText());
  	        	selectedDish.setDishPrice(price.getText());
  	        	selectedDish.setCategImage(fl1);
  	        	selectedDish.setDishImage(fl2);
  	        
  	        	adDishStage.close();
  	        mainTb.refresh();	
  	        });
  	        
  	    	
  	       
  	   		
  	   		
  	   		
  	   		adDishStage.setScene(addDishScene);
  	   		adDishStage.show();
  	   		
  	    } catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	    
  	    
  		
  	
      }
      
      
      
	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		
		
		
	
		
		
		if(ll!=null){  //ll.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
			
			
			String[]m = getFromFile().split("-");
System.out.println(getFromFile());
			nameLabel.setText(m[0]);
		       sloganLabel.setText(m[1]);
			
		       
		       try {
			   System.out.println(allMenuCombinedAndSorted.size());
			  for(int i= 0;i<allMenuCombinedAndSorted.size();i++){ 
			   
			    lbb1 =new Label(allMenuCombinedAndSorted.get(i).get(allMenuCombinedAndSorted.get(i).size()-1).get(3)+"(x"+allMenuCombinedAndSorted.get(i).size()+")");
			   
			   
			   listofcategoriesnames.add(lbb1);
			   ImageView img = new ImageView("img/chooseI.png");
			   img.setFitHeight(50);
			   img.setFitWidth(50);
			   if(ph2.get(allMenuCombinedAndSorted.get(i).get(allMenuCombinedAndSorted.get(i).size()-1).get(3))!=null){
			   
			    String URLInfo = ph2.get(allMenuCombinedAndSorted.get(i).get(allMenuCombinedAndSorted.get(i).size()-1).get(3)).toURI().toURL().toString();
			   
			   Image im = new Image(URLInfo);
			   img.setImage(im);
			   }
			   GridPane gp = new GridPane();
			   GridPane.setHalignment(img, HPos.LEFT);
			   GridPane.setHalignment(lbb1, HPos.CENTER);
			   GridPane.setMargin(img, new Insets(5,30,0,0));
			   GridPane.setMargin(lbb1, new Insets(0,0,0,60));
			   
			   gp.getChildren().addAll(lbb1,img);
			   
			   gp.setOnMouseClicked(lll->{
			    positionNumber=1;
			    try {
			    ld.setVisible(true);
			    ld.setDisable(false);
			    ld.getItems().clear();
			    
			     
			    
			    int position=ll.getSelectionModel().selectedIndexProperty().getValue();
			    for(int k = 0;k<allMenuCombinedAndSorted.get(position).size();k++){
			     if(!isOpen){
			     lDish = new Label();
			     
			     
			     if(k==0){
			      
			      lDish.setText(allMenuCombinedAndSorted.get(position).get((allMenuCombinedAndSorted.get(position).size()-1)).get(0)+"("+allMenuCombinedAndSorted.get(position).get((allMenuCombinedAndSorted.get(position).size()-1)).get(6)+"р.)");
			     //// if(menu!=null){
			      // lDish.setFont(new Font(menu,addFieldTextSize)); 
			     // }
			        
			     
			    
			    
			    
			    }
			    else if(k>0){
			     lDish.setText(allMenuCombinedAndSorted.get(position).get(k-1).get(0)+"("+allMenuCombinedAndSorted.get(position).get(k-1).get(6)+"р.)");
			     
			      //if(menu!=null){
			         //lDish.setFont(new Font(menu,addFieldTextSize)); 
			       // } 
			     
			     
			    }
			     listofdishesnames.add(lDish); 
			     isOpen= true;
			     }
			     
			     ImageView img1 = new ImageView("img/chooseI.png");
			    img1.setFitHeight(50);
			    img1.setFitWidth(50);
			    if((ph2.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3))!=null)&&(ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3))!=null)){
			    String URLInfo1 = ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3)).get(k).toURI().toURL().toString();
			    
			    Image im1 = new Image(URLInfo1);
			    img1.setImage(im1);
			    }
			    GridPane gp1 = new GridPane();
			    GridPane.setHalignment(img1, HPos.LEFT);
			    GridPane.setHalignment(lDish, HPos.CENTER);
			    GridPane.setMargin(img1, new Insets(5,30,0,0));
			    GridPane.setMargin(lDish, new Insets(0,0,0,70));
			   
			    
			    gp1.getChildren().addAll(lDish,img1);
			    gp1.setOnMouseClicked(pp->{;
			    positionNumber=2;
			    try {
			    
			     int Dishposition=ld.getSelectionModel().selectedIndexProperty().getValue();
			     Image immDish = new Image("img/chooseI.png");
			    
			     if((ph2.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3))!=null)&&(ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3))!=null)){
			    String URLDish = ph1.get(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(3)).get(Dishposition).toURI().toURL().toString();
			    
			     immDish = new Image(URLDish);
			     }
			    if(Dishposition==0){
			    DishImg.setImage(immDish);
			    DishName.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(0));
			    DishValue.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(4));
			    DishDescription.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(1));
			    DishIngredients.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(2));
			    DishKkal.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(5));
			                DishPrice.setText(allMenuCombinedAndSorted.get(position).get(allMenuCombinedAndSorted.get(position).size()-1).get(6));
			    InfoPane.setVisible(true);
			    InfoPane.setDisable(false);
			    
			    if(bgm!=null){
			    InfoPane.setBackground(new Background(bgm));
			    }
			    ld.setVisible(false); 
			    ld.setDisable(true);
			    ll.setVisible(false); 
			    ll.setDisable(true);
			    MenuPane.setVisible(false); 
			    MenuPane.setDisable(true);
			    }
			    if(Dishposition>0){
			     DishImg.setImage(immDish);
			     DishName.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(0));
			     DishValue.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(4));
			     DishDescription.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(1));
			     DishIngredients.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(2));
			     DishKkal.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(5));
			                 DishPrice.setText(allMenuCombinedAndSorted.get(position).get(Dishposition-1).get(6));
			     InfoPane.setVisible(true);
			     InfoPane.setDisable(false);
			     if(bgm!=null){
			      InfoPane.setBackground(new Background(bgm));
			      }
			     ld.setVisible(false); 
			     ld.setDisable(true);
			     ll.setVisible(false); 
			     ll.setDisable(true);
			     MenuPane.setVisible(false); 
			     MenuPane.setDisable(true);
			    }
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
			   }}
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
	
        mainTb.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedDish = newSelection;
            	System.out.println(obs+""+oldSelection+"/"+newSelection);
            }
        });
	
        changeButton.setOnAction(n->{
        	if(selectedDish!=null){
        	changeDish();
        	
        	}
        });
        
        delete.setOnAction(n->{
        	if(selectedDish!=null){
        	deleteDish();
        	
        	}
        });
	
	}		
		
	if(PatternList!=null){
	
    
	Image expattern1 = new Image("img/pattern4.jpg");		
		BackgroundImage exapmlePattern1 = new BackgroundImage(expattern1, 
					    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
					    BackgroundPosition.DEFAULT, 
					    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
		
		Image expattern2 = new Image("img/pattern5.jpg");		
	    BackgroundImage exapmlePattern2 = new BackgroundImage(expattern2, 
				    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				    BackgroundPosition.DEFAULT, 
				    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
	
		bgpatterns.get("MainView").add(Number, exapmlePattern1);
	    bgpatterns.get("Categories").add(Number, exapmlePattern2);
	    bgpatterns.get("Dish").add(Number, exapmlePattern2);
	    bgpatterns.get("DishInfo").add(Number, exapmlePattern2);
	    ArrayList<String> al = new ArrayList<>();
	    al.add("15");
		al.add("Impact");
		al.add("000000");
		al.add("default");
		al.add("ffffff");
	    al.add("1");
		al.add("0");
	    al.add("000000");
		al.add("15");
		al.add("Arial");
		al.add("000000");
		al.add("default");
		al.add("ffffff");
		al.add("1");
		al.add("0");
		al.add("000000");
		al.add(null);
		ListOfPatterns.put(Number, al);	
		Number++;
		
		  for(int k = 0;k<ListOfPatterns.size();k++){
			    DropShadow ds = new DropShadow();
		        ds.setOffsetY(2.3);
		        ds.setOffsetX(2.3);
		        ds.setColor(Color.GRAY);  
			  Image img =   bgpatterns.get("MainView").get(k).getImage();
	    		ImageView img1 = new ImageView();
	    		img1.setFitHeight(100);
	    		img1.setFitWidth(100);
	    		img1.setImage(img);
	    		img1.setEffect(ds);
	    		Label patternName1 = new Label("Pattern№1");
	    		patternName1.setFont(new Font(30));
	    		Label patternFont1 = new Label("Style:"+ListOfPatterns.get(k).get(1));
	    		patternFont1.setFont(new Font(15));
	    		Label patternSize1 = new Label("TextSize:"+ListOfPatterns.get(k).get(0)+"px");
	    		patternSize1.setFont(new Font(15));
	    		patternName1.setStyle("-fx-text-fill:black");
    			patternFont1.setStyle("-fx-text-fill:black");
    			patternSize1.setStyle("-fx-text-fill:black");
	    		Image redacPattern = new Image("img/PattRedac.jpg");
	    		Image redacPatternExchange = new Image("img/ImageForAnim.jpg");
	    		ImageView imgg = new ImageView();
	    		imgg.setImage(redacPattern);
	    		imgg.setOnMouseEntered(oo->{
	    			imgg.setImage(redacPatternExchange);
	    		});
	    		imgg.setOnMouseExited(o->{
	    			imgg.setImage(redacPattern);
	    		});
	    		imgg.setOnMouseClicked(ppnn->{
	    			Number1=PatternList.getSelectionModel().selectedIndexProperty().getValue();
	    			
	    			openFromMenu=true;
	    			openRedator();
	    		
	    		});
                Image closePattern = new Image("img/close.jpg");
                Image closePatternExchange = new Image("img/ImageCloseForAnim.jpg");
                ImageView closeim = new ImageView();
	    		closeim.setImage(closePattern);
	    		closeim.setOnMouseEntered(oo->{
	    			closeim.setImage(closePatternExchange);
	    		});
	    		closeim.setOnMouseExited(o->{
	    			closeim.setImage(closePattern);
	    		});
	    		closeim.setOnMouseClicked(oo1->{
	    			
	    		
	    			int deletePos =PatternList.getSelectionModel().selectedIndexProperty().getValue();
	    			if(deletePos==0&&PatternList.getItems().size()==1){
	    				PatternList.getItems().remove(deletePos);
	    				ListOfPatterns.remove(deletePos);
		    			bgpatterns.get("MainView").remove(deletePos);
	    		    	bgpatterns.get("Categories").remove(deletePos);
	    		    	bgpatterns.get("Dish").remove(deletePos);
	    		    	bgpatterns.get("DishInfo").remove(deletePos);
	    			Number=deletePos;
	    			}
	    			else{
	    			for(int i = deletePos ;i<PatternList.getItems().size()-1;i++){
	    		    	PatternList.getItems().set(i, PatternList.getItems().get(i+1));
	    		    	ListOfPatterns.replace(i, ListOfPatterns.get(i+1));
	    		    	
	    		    	bgpatterns.get("MainView").set(i,bgpatterns.get("MainView").get(i+1));
	    		    	bgpatterns.get("Categories").set(i,bgpatterns.get("Categories").get(i+1));
	    		    	bgpatterns.get("Dish").set(i,bgpatterns.get("Dish").get(i+1));
	    		    	bgpatterns.get("DishInfo").set(i,bgpatterns.get("DishInfo").get(i+1));
                      
	    		    	
	    			}
	    			PatternList.getItems().remove(PatternList.getItems().size()-1);
	    			ListOfPatterns.remove(ListOfPatterns.size()-1);
	    			bgpatterns.get("MainView").remove(bgpatterns.get("MainView").size()-1);
    		    	bgpatterns.get("Categories").remove(bgpatterns.get("Categories").size()-1);
    		    	bgpatterns.get("Dish").remove(bgpatterns.get("Dish").size()-1);
    		    	bgpatterns.get("DishInfo").remove(bgpatterns.get("DishInfo").size()-1);
    		    	Number = PatternList.getItems().size();
	    			}
	    			});
	    		GridPane patternPane1 = new GridPane();
	    		GridPane.setHalignment(img1, HPos.LEFT);
	    		GridPane.setHalignment(imgg, HPos.RIGHT);
	    		GridPane.setHalignment(closeim, HPos.RIGHT);
	    		GridPane.setHalignment(patternName1, HPos.CENTER);
	    		GridPane.setMargin(imgg, new Insets(50,0,0,130));
	    		GridPane.setMargin(img1, new Insets(0,30,5,0));
	    		GridPane.setMargin(closeim, new Insets(0,0,50,130));
	    		GridPane.setMargin(patternName1, new Insets(0,25,60,0));
	    		GridPane.setMargin(patternFont1, new Insets(10,0,0,0));
	    		GridPane.setMargin(patternSize1, new Insets(60,0,0,0));
	    		patternPane1.add(patternName1, 1, 0);
	    		patternPane1.add(patternFont1, 1, 0);
	    		patternPane1.add(patternSize1, 1, 0);
	    		patternPane1.add(imgg, 2,0 );
	    		patternPane1.add(closeim, 2,0 );
	    		patternPane1.getChildren().addAll(img1);
	    		patternPane1.setOnMouseClicked(ll1l->{
	    			patternName1.setStyle("-fx-text-fill:black");
	    			patternFont1.setStyle("-fx-text-fill:black");
	    			patternSize1.setStyle("-fx-text-fill:black");
	    			Number1=PatternList.getSelectionModel().selectedIndexProperty().getValue();
	    			 System.out.println(Number1);
	    		});
	    		
	    		PatternList.getItems().add(patternPane1);
	    			
	    	}
			UsePattern.setOnAction(ll1->{;
	    System.out.println(Number1);
	     menu = ListOfPatterns.get(Number1).get(1);
         addFieldTextSize = Integer.parseInt(ListOfPatterns.get(Number1).get(0));
	    	MenuPane.getStylesheets().add(this.getClass().getResource("style2.css").toExternalForm());
			
			BackgroundImage bgm1 = bgpatterns.get("MainView").get(Number1);
			BackgroundImage bgm2 = bgpatterns.get("Categories").get(Number1);
			BackgroundImage bgm3 = bgpatterns.get("Dish").get(Number1);
			BackgroundImage bgm4 =   bgpatterns.get("DishInfo").get(Number1); 
			MenuPane.setBackground(new Background(bgm1));
			 ll.setBackground(new Background(bgm2));
			 ld.setBackground(new Background(bgm3));
             InfoPane.setBackground(new Background(bgm4));
			 
             if(lbb1!=null){ 
            	
            	 for(int p= 0;p<listofcategoriesnames.size();p++){
					if(ListOfPatterns.get(Number1).get(0)!=null&&ListOfPatterns.get(Number1).get(1)!=null){
					listofcategoriesnames.get(p).setFont(new Font(menu,addFieldTextSize));
					listofcategoriesnames.get(p).setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+"-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(2).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(4).replaceAll("0x", "")
							+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(5)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(6)
							+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(7).replaceAll("0x", ""));
					if(textinfo.equals("bold")){
						listofcategoriesnames.get(p).setFont(Font.font(menu,FontWeight.BOLD,addFieldTextSize));
					}
					if(textinfo.equals("italic")){
						listofcategoriesnames.get(p).setFont(Font.font(menu,FontPosture.ITALIC,addFieldTextSize));
					}
					if(textinfo.equals("underlined")){
						listofcategoriesnames.get(p).setUnderline(true);
					    
					}
					}
            	 }
					
					if(ListOfPatterns.get(Number1).get(8)!=null&&ListOfPatterns.get(Number1).get(9)!=null){
						 //ButtonMenu.setFont(new Font(ListOfPatterns.get(Number1).get(9),Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
					    // ButtonMakeOrder.setFont(new Font(ListOfPatterns.get(Number1).get(9),Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonOrderCondition.setFont(new Font(ListOfPatterns.get(Number1).get(9),Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonAboutUs.setFont(new Font(ListOfPatterns.get(Number1).get(9),Integer.parseInt(ListOfPatterns.get(Number1).get(8))));                  
						 ButtonMenu.setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+"-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(10).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(12).replaceAll("0x", "")
									+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(13)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(14)
									+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(15).replaceAll("0x", ""));
						 ButtonMakeOrder.setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+"-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(10).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(12).replaceAll("0x", "")
									+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(13)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(14)
									+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(15).replaceAll("0x", ""));
						 ButtonOrderCondition.setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+"-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(10).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(12).replaceAll("0x", "")
									+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(13)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(14)
									+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(15).replaceAll("0x", ""));
						 ButtonAboutUs.setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+"-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(10).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(12).replaceAll("0x", "")
									+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(13)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(14)
									+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(15).replaceAll("0x", ""));
					if(buttoninfo.equals("bold")){
						 ButtonMenu.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontWeight.BOLD,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
					     ButtonMakeOrder.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontWeight.BOLD,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonOrderCondition.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontWeight.BOLD,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonAboutUs.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontWeight.BOLD,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
					}
					if(buttoninfo.equals("italic")){
						 ButtonMenu.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontPosture.ITALIC,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
					     ButtonMakeOrder.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontPosture.ITALIC,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonOrderCondition.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontPosture.ITALIC,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
						 ButtonAboutUs.setFont(Font.font(ListOfPatterns.get(Number1).get(9),FontPosture.ITALIC,Integer.parseInt(ListOfPatterns.get(Number1).get(8))));
					}
					if(buttoninfo.equals("underlined")){
						 ButtonMenu.setUnderline(true);
					     ButtonMakeOrder.setUnderline(true);
						 ButtonOrderCondition.setUnderline(true);
						 ButtonAboutUs.setUnderline(true);
					}
					}
					
				
			}
             System.out.println("lDish"+lDish);
             if(lDish!=null){
            	 System.out.println(listofdishesnames.size());
            	for(int p1 = 0;p1<listofdishesnames.size();p1++){
        	   if(ListOfPatterns.get(Number1).get(0)!=null&&ListOfPatterns.get(Number1).get(1)!=null){
        		  
        		   
        		   
        		   listofdishesnames.get(p1).setStyle("-fx-font-family:'"+menu+"'"+";"+"-fx-font-size:"+addFieldTextSize+";"+
        				   "-fx-text-fill:"+"#"+ListOfPatterns.get(Number1).get(2).replaceAll("0x", "")+";-fx-background-color:"+"#"+ListOfPatterns.get(Number1).get(4).replaceAll("0x", "")
							+ ";-fx-opacity:"+ListOfPatterns.get(Number1).get(5)+";-fx-border-width:"+ListOfPatterns.get(Number1).get(6)
							+";-fx-border-color:"+"#"+ListOfPatterns.get(Number1).get(7).replaceAll("0x", ""));
					}
        	   System.out.println("font"+listofdishesnames.get(p1).getFont().getFamily());
        	   if(textinfo.equals("bold")){
        		   listofdishesnames.get(p1).setFont(Font.font(menu,FontWeight.BOLD,addFieldTextSize));
				}
				if(textinfo.equals("italic")){
					listofdishesnames.get(p1).setFont(Font.font(menu,FontPosture.ITALIC,addFieldTextSize));
				}
				if(textinfo.equals("underlined")){
					listofdishesnames.get(p1).setUnderline(true);
				    
				}
           }
           }  
          
           ll.setFixedCellSize(55);
           ld.setFixedCellSize(55);
	    
	    });
	    }








if(redactorList!=null){
    
	PatternOpacity.setValue(1);
	ButtonTextOpacity.setValue(1);
	System.out.println(Number);
	redactorPane.setBackground(new Background(startBg));
	slideNumber=0;
	addorsafe.setText("Добавить");
	if(openFromMenu){
	
		addorsafe.setText("Сохранить");
	middleVar=Number;
	Number=Number1;
	
	redactorPane.setBackground(new Background(bgpatterns.get("MainView").get(Number1)));
	
	if(ListOfPatterns.get(Number1).get(0)!=null){
	PatternTextSize.setText(ListOfPatterns.get(Number1).get(0));
	}
	if(ListOfPatterns.get(Number1).get(1)!=null){
	PatternFont.setValue(ListOfPatterns.get(Number1).get(1));
	}
	if(ListOfPatterns.get(Number1).get(2)!=null){
	PatternTextColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(2)));
	}
	if(ListOfPatterns.get(Number1).get(3)!=null){
	           if(ListOfPatterns.get(Number1).get(3).equals("bold")){	
	        		txt1.setStyle("-fx-border-color: black; -fx-border-width: 1;");
	           }
	           if(ListOfPatterns.get(Number1).get(3).equals("italic")){
	        	    txt2.setStyle("-fx-border-color: black; -fx-border-width: 1;");
	           }
	           if(ListOfPatterns.get(Number1).get(3).equals("underlined")){ 
	        		txt3.setStyle("-fx-border-color: black; -fx-border-width: 1;"); 
	           }
	}
	if(ListOfPatterns.get(Number1).get(4)!=null){
	PatternBackground.setValue(Color.web(ListOfPatterns.get(Number1).get(4)));
	}
	if(ListOfPatterns.get(Number1).get(5)!=null){
	PatternOpacity.setValue(Double.valueOf(ListOfPatterns.get(Number1).get(5)));
	}
	if(ListOfPatterns.get(Number1).get(6)!=null){
	TextBorderSize.setText(ListOfPatterns.get(Number1).get(6));
	}
	if(ListOfPatterns.get(Number1).get(7)!=null){
	TextBorderColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(7)));
	}
	if(ListOfPatterns.get(Number1).get(8)!=null){
	ButtonTextSize.setText(ListOfPatterns.get(Number1).get(8));
	}
	if(ListOfPatterns.get(Number1).get(9)!=null){
	ButtonTextFont.setValue(ListOfPatterns.get(Number1).get(9));;
	}
	if(ListOfPatterns.get(Number1).get(10)!=null){
	ButtonTextColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(10)));
	}
	if(ListOfPatterns.get(Number1).get(11)!=null){
        if(ListOfPatterns.get(Number1).get(11).equals("bold")){	
        	Buttontxt1.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        }
        if(ListOfPatterns.get(Number1).get(11).equals("italic")){
        	Buttontxt2.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        }
        if(ListOfPatterns.get(Number1).get(11).equals("underlined")){ 
        	Buttontxt3.setStyle("-fx-border-color: black; -fx-border-width: 1;"); 
        }
}
	if(ListOfPatterns.get(Number1).get(12)!=null){
	ButtonBackgroundColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(12)));
	}
	if(ListOfPatterns.get(Number1).get(13)!=null){
	ButtonTextOpacity.setValue(Double.valueOf(ListOfPatterns.get(Number1).get(13)));
	}
	if(ListOfPatterns.get(Number1).get(14)!=null){
	ButtonBorderSize.setText(ListOfPatterns.get(Number1).get(14));
	}
	if(ListOfPatterns.get(Number1).get(15)!=null){
	ButtonBorderColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(15)));
	}
	if(ListOfPatterns.get(Number1).get(16)!=null){
	animationColor.setValue(Color.valueOf(ListOfPatterns.get(Number1).get(16)));
	}
	
	}
Label l1 = new Label ("     Вид текста     ");
l1.setFont(new Font(30));
Label l2 = new Label ("     Вид кнопки     ");
l2.setFont(new Font(30));

redactorList.getItems().addAll(l1,l2);
redactorList.setOnMouseClicked(pp->{
	int val = redactorList.getSelectionModel().selectedIndexProperty().getValue();
	if(val==0){
		redac2.setVisible(false);
		redac2.setDisable(true);
		redac1.setVisible(true);
		redac1.setDisable(false);
	}
	else if(val==1){
		redac1.setVisible(false);
		redac1.setDisable(true);
		redac2.setVisible(true);
		redac2.setDisable(false);
	}
	});
}
if(txt1!=null){
	  
    txt1.setOnMouseClicked(pp->{;
    if(txt1.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      textinfo="default";
      txt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
    txt1.setStyle("-fx-border-color: black; -fx-border-width: 1;");
    txt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    txt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    textinfo="bold";
    
    }
  
    });
    txt2.setOnMouseClicked(pp->{;
    if(txt2.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      textinfo="default";
      txt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
    txt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    txt2.setStyle("-fx-border-color: black; -fx-border-width: 1;");
    txt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    textinfo="italic";
    

    }
    
    });
    txt3.setOnMouseClicked(pp->{;
    if(txt3.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      textinfo="default";
      txt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
    txt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    txt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    txt3.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        textinfo="underlined";
    

    }
    
    });
    
    
    Buttontxt1.setOnMouseClicked(pp->{;
    if(Buttontxt1.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      buttoninfo="default";
      Buttontxt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
      Buttontxt1.setStyle("-fx-border-color: black; -fx-border-width: 1;");
      Buttontxt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      Buttontxt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      buttoninfo="bold";
    }
    });
    Buttontxt2.setOnMouseClicked(pp->{;
    if(Buttontxt2.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      buttoninfo="default";
      Buttontxt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
      Buttontxt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      Buttontxt2.setStyle("-fx-border-color: black; -fx-border-width: 1;");
      Buttontxt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      buttoninfo="italic";
    }
    
    });
    Buttontxt3.setOnMouseClicked(pp->{;
    if(Buttontxt3.getStyle().equals("-fx-border-color: black; -fx-border-width: 1;")){
      buttoninfo="default";
      Buttontxt3.setStyle("-fx-border-color: white; -fx-border-width: 0;");
    }
    else{
      Buttontxt1.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      Buttontxt2.setStyle("-fx-border-color: white; -fx-border-width: 0;");
      Buttontxt3.setStyle("-fx-border-color: black; -fx-border-width: 1;");
      buttoninfo="underlined";
    }
    });
    PatternOpacity.setMin(0);
    PatternOpacity.setMax(1);
    ButtonTextOpacity.setMin(0);
    ButtonTextOpacity.setMax(1);
    for(int i =0;i<fontNames.length;i++){
      PatternFont.getItems().add(fontNames[i]);
      ButtonTextFont.getItems().add(fontNames[i]);
    }
    
    animation.setOnAction(oo->{
      
      if(animation.isSelected()){
      animColor.setDisable(false);
      animationColor.setDisable(false);
    }
    else if(!animation.isSelected()){
      animColor.setDisable(true);
      animationColor.setDisable(true);
    }
    });
  }



		
	}
	
	public static javafx.scene.image.Image createImage(File file) throws IOException {
	    java.awt.Image image = ImageIO.read(file);
	    if (!(image instanceof RenderedImage)) {
	        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
	                image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	        Graphics g = bufferedImage.createGraphics();
	        g.drawImage(image, 0, 0, null);
	        g.dispose();

	        image = bufferedImage;
	    }
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ImageIO.write((RenderedImage) image, "png", out);
	    out.flush();
	    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
	    return new javafx.scene.image.Image(in);
	}





public void LabelsAddTest(){
	InfoPane.setVisible(false);
	InfoPane.setDisable(true);
	ld.setVisible(true);	
	ld.setDisable(false);
	
   
	 
}
public void useForAll(){
	
	if(bgpatterns.get("MainView").size()>=Number+1){
	bgpatterns.get("MainView").set(Number, bgImage);	
	}
	else{
		
		bgpatterns.get("MainView").add(Number, bgImage);
		
	}
	
	if(bgpatterns.get("Categories").size()>=Number+1){
	bgpatterns.get("Categories").set(Number, bgImage);	
	}
	else{
		
		bgpatterns.get("Categories").add(Number, bgImage);
		
	}
	if(bgpatterns.get("Dish").size()>=Number+1){
	bgpatterns.get("Dish").set(Number, bgImage);	
	}
	else{
		
			bgpatterns.get("Dish").add(Number, bgImage);
			
			
	}
	if(bgpatterns.get("DishInfo").size()>=Number+1){
	bgpatterns.get("DishInfo").set(Number, bgImage);
	}
	else{
		
			bgpatterns.get("DishInfo").add(Number, bgImage);
			
			
					
			
	}
	System.out.println(bgpatterns);
}


public void slideLeft(){
	if(slideNumber==1){
		PatternName.setText("Главный вид");
	slideNumber = 0;
	if(bgpatterns.get("MainView").size()>=Number+1){
		redactorPane.setBackground(new Background(bgpatterns.get("MainView").get(Number)));
		bgImage=bgpatterns.get("MainView").get(Number);
	}
		else{
			redactorPane.setBackground(new Background(startBg));
		
		}
	
	}
	
	else if(slideNumber==2){
		PatternName.setText("Категории");
	slideNumber = 1;
	if(bgpatterns.get("Categories").size()>=Number+1){
		redactorPane.setBackground(new Background(bgpatterns.get("Categories").get(Number)));
		bgImage=bgpatterns.get("Categories").get(Number);
        
	}
		else{
			redactorPane.setBackground(new Background(startBg));
			
		}
		
	}
	else if(slideNumber==3){
		PatternName.setText("Блюда");
	slideNumber = 2;
	if(bgpatterns.get("Dish").size()>=Number+1){
		redactorPane.setBackground(new Background(bgpatterns.get("Dish").get(Number)));
		bgImage=bgpatterns.get("Dish").get(Number);

	}
		else{
			redactorPane.setBackground(new Background(startBg));
			
		}
	
	}
	}
public void slideRight(){
	if(slideNumber==0){
	PatternName.setText("Категории");
	slideNumber = 1;
	if(bgpatterns.get("Categories").size()>=Number+1){
	redactorPane.setBackground(new Background(bgpatterns.get("Categories").get(Number)));
	bgImage=bgpatterns.get("Categories").get(Number);

	}
	else{
		redactorPane.setBackground(new Background(startBg));
		
	}
	
	}
	else if(slideNumber==1){
		PatternName.setText("Блюда");
	slideNumber = 2;
	if(bgpatterns.get("Dish").size()>=Number+1){
		redactorPane.setBackground(new Background(bgpatterns.get("Dish").get(Number)));
		bgImage=bgpatterns.get("Dish").get(Number);

	}
		else{
			redactorPane.setBackground(new Background(startBg));
			
		}
	
	}
	else if(slideNumber==2){
		PatternName.setText("Инф. Блюдо");
	slideNumber = 3;
	if(bgpatterns.get("DishInfo").size()>=Number+1){
		redactorPane.setBackground(new Background(bgpatterns.get("DishInfo").get(Number)));
		bgImage=bgpatterns.get("DishInfo").get(Number);

	}
		else{
			redactorPane.setBackground(new Background(startBg));
			
		}
	}
}
public void openRedator(){
	


try {
	FXMLLoader loader = new FXMLLoader();

	loader.setLocation(MainGUI.class.getResource("redactor.fxml"));
	
    rootLayout = (AnchorPane) loader.load();
	
    Scene Scene = new Scene(rootLayout);
	  
     kk = new Stage();
	   kk.setScene(Scene);
	   kk.show();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	
    
 
}
public void returnBack(){
	if(positionNumber==0){
		ll.setVisible(false);
	    ll.setDisable(true);
	    MenuPane.setVisible(true);
	    MenuPane.setDisable(false);
	}
	if(positionNumber==1){
		ld.setVisible(false);
	    ld.setDisable(true);
	    ll.setVisible(true);
	    ll.setDisable(false);
	    positionNumber=0;
	}
	if(positionNumber==2){
		InfoPane.setVisible(false);
		InfoPane.setDisable(true);
	    ld.setVisible(true);
	    ld.setDisable(false);
	    positionNumber=1;
	}

}
public void setBGforPattern(){
	chooseImageForPattern(st1);

	
	
}

public void chooseImageForPattern(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        configureFileChooser(fileChooser);
         Platform.runLater(new Runnable() {
                  @Override public void run() {
                    File file = fileChooser.showOpenDialog(stage);
                    
              try {
                
                
                String imagepath = file.toURI().toURL().toString();
                    Image imageforbackground = new Image(imagepath);
                     bgImage = new BackgroundImage(imageforbackground, 
                      BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                      BackgroundPosition.DEFAULT, 
                      new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
                
                
                
                
                
                if(slideNumber==0){  
                  if(patt1.size()<=Number){
                  patt1.add(Number,bgImage);
                  }
                  else{
                    patt1.set(Number,bgImage);
                  }
                   
  
                     redactorPane.setBackground(new Background(bgpatterns.get("MainView").get(Number)));
                   usAll.setDisable(false);
                }
                if(slideNumber==1){  
                  if(patt2.size()<=Number){
                    patt2.add(Number,bgImage);
                    }
                    else{
                      patt2.set(Number,bgImage);
                    }
                  
                  redactorPane.setBackground(new Background(bgpatterns.get("Categories").get(Number)));
                  usAll.setDisable(false);  
                }
                if(slideNumber==2){  
                  if(patt3.size()<=Number){
                    patt3.add(Number,bgImage);
                    }
                    else{
                      patt3.set(Number,bgImage);
                    }
                  
                  redactorPane.setBackground(new Background(bgpatterns.get("Dish").get(Number)));
                  usAll.setDisable(false);  
                }
                if(slideNumber==3){  
                  if(patt4.size()<=Number){
                    patt4.add(Number,bgImage);
                    }
                    else{
                      patt4.set(Number,bgImage);
                    }
                  
                  redactorPane.setBackground(new Background(bgpatterns.get("DishInfo").get(Number)));
                  usAll.setDisable(false);  
                }
                
                System.out.println(bgpatterns);
              
            
              } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
              
              
              
                  }});
      }



public void changeRedactor(){
	
	if(changeRedac.getText().equals("Вид кнопки")){
	
		redac1.setVisible(false);
	redac1.setDisable(true);
	redac2.setVisible(true);
	redac2.setDisable(false);
	changeRedac.setText("Вид текста");
	}
	else if(changeRedac.getText().equals("Вид текста")){
		redac2.setVisible(false);
		redac2.setDisable(true);
		redac1.setVisible(true);
		redac1.setDisable(false);
		changeRedac.setText("Вид кнопки");	
	}
}

public void addPattern(){
	DropShadow ds = new DropShadow();
    ds.setOffsetY(2.3);
    ds.setOffsetX(2.3);
    ds.setColor(Color.GRAY); 
    ImageView img = new ImageView();
	img.setFitHeight(100);
	img.setFitWidth(100);
	img.setImage(bgpatterns.get("MainView").get(Number).getImage());
	img.setEffect(ds);
	Label patternName = new Label("Pattern№1");
	patternName.setFont(new Font(30));
	Label patternFont = new Label("Style:"+ListOfPatterns.get(Number).get(1));
	patternFont.setFont(new Font(15));
	Label patternSize = new Label("TextSize:"+ListOfPatterns.get(Number).get(0)+"px");
	patternSize.setFont(new Font(15));
	patternName.setStyle("-fx-text-fill:black");
	patternFont.setStyle("-fx-text-fill:black");
	patternSize.setStyle("-fx-text-fill:black");
	Image redacPattern = new Image("img/PattRedac.jpg");
	Image redacPatternExchange = new Image("img/ImageForAnim.jpg");
	ImageView imgg = new ImageView();
	imgg.setImage(redacPattern);
	imgg.setOnMouseEntered(oo->{
		imgg.setImage(redacPatternExchange);
	});
	imgg.setOnMouseExited(o->{
		imgg.setImage(redacPattern);
	});
	imgg.setOnMouseClicked(ppnn->{
		Number1=PatternList.getSelectionModel().selectedIndexProperty().getValue();
		openFromMenu=true;
		openRedator();
	
	});
	Image closePattern = new Image("img/close.jpg");
	Image closePatternExchange = new Image("img/ImageCloseForAnim.jpg");
    ImageView closeim = new ImageView();
	closeim.setImage(closePattern);
	closeim.setOnMouseEntered(oo->{
		closeim.setImage(closePatternExchange);
	});
	closeim.setOnMouseExited(o->{
		closeim.setImage(closePattern);
	});
	closeim.setOnMouseClicked(oo1->{
		
		
		int deletePos =PatternList.getSelectionModel().selectedIndexProperty().getValue();
		if(deletePos==0&&PatternList.getItems().size()==1){
			PatternList.getItems().remove(deletePos);
			ListOfPatterns.remove(deletePos);
			bgpatterns.get("MainView").remove(deletePos);
	    	bgpatterns.get("Categories").remove(deletePos);
	    	bgpatterns.get("Dish").remove(deletePos);
	    	bgpatterns.get("DishInfo").remove(deletePos);
		Number=deletePos;
		}
		else{
		for(int i = deletePos ;i<PatternList.getItems().size()-1;i++){
	    	PatternList.getItems().set(i, PatternList.getItems().get(i+1));
	    	ListOfPatterns.replace(i, ListOfPatterns.get(i+1));
	    	
	    	bgpatterns.get("MainView").set(i,bgpatterns.get("MainView").get(i+1));
	    	bgpatterns.get("Categories").set(i,bgpatterns.get("Categories").get(i+1));
	    	bgpatterns.get("Dish").set(i,bgpatterns.get("Dish").get(i+1));
	    	bgpatterns.get("DishInfo").set(i,bgpatterns.get("DishInfo").get(i+1));
	    	
	    	
		}
		PatternList.getItems().remove(PatternList.getItems().size()-1);
		bgpatterns.get("MainView").remove(bgpatterns.get("MainView").size()-1);
    	bgpatterns.get("Categories").remove(bgpatterns.get("Categories").size()-1);
    	bgpatterns.get("Dish").remove(bgpatterns.get("Dish").size()-1);
    	bgpatterns.get("DishInfo").remove(bgpatterns.get("DishInfo").size()-1);
    	Number = PatternList.getItems().size();
		}
		});
	GridPane patternPane = new GridPane();
	GridPane.setHalignment(img, HPos.LEFT);
	GridPane.setHalignment(imgg, HPos.RIGHT);
	GridPane.setHalignment(closeim, HPos.RIGHT);
	GridPane.setHalignment(patternName, HPos.CENTER);
	GridPane.setMargin(img, new Insets(0,30,5,0));
	GridPane.setMargin(imgg, new Insets(50,0,0,130));
	GridPane.setMargin(closeim, new Insets(0,0,50,130));
	GridPane.setMargin(patternName, new Insets(0,25,60,0));
	GridPane.setMargin(patternFont, new Insets(10,0,0,0));
	GridPane.setMargin(patternSize, new Insets(60,0,0,0));
	patternPane.add(patternName, 1, 0);
	patternPane.add(patternFont, 1, 0);
	patternPane.add(patternSize, 1, 0);
	patternPane.add(imgg, 2,0 );
	patternPane.add(closeim, 2,0 );
	patternPane.getChildren().addAll(img);
	patternPane.setOnMouseClicked(lll->{
		patternName.setStyle("-fx-text-fill:black");
		patternFont.setStyle("-fx-text-fill:black");
		patternSize.setStyle("-fx-text-fill:black");
		Number1=PatternList.getSelectionModel().selectedIndexProperty().getValue();
		 System.out.println(Number1);
	});
	
	if(openFromMenu){
		
		
		PatternList.getItems().set(Number1, patternPane);
			
	Number = middleVar;
	}
	else{
		System.out.println("pp"+patternPane.getChildren().toString());
		PatternList.getItems().add(patternPane);
	System.out.println("pl"+PatternList.getItems().toString());
	System.out.println(Number);
	Number++;	
	}
}
public void addPatterntoList(){
	if(openFromMenu){
		
		ListOfPatterns.get(Number1).set(0,PatternTextSize.getText());
		ListOfPatterns.get(Number1).set(1,PatternFont.getValue());
		ListOfPatterns.get(Number1).set(2,PatternTextColor.getValue().toString());
		ListOfPatterns.get(Number1).set(3,textinfo);
		ListOfPatterns.get(Number1).set(4,PatternBackground.getValue().toString());
		ListOfPatterns.get(Number1).set(5,String.format("%.2f", PatternOpacity.getValue()).replace(',','.'));
		if(TextBorderSize.getText().equals("")){
			ListOfPatterns.get(Number1).set(6,"0");
		}
		else{
			ListOfPatterns.get(Number1).set(6,TextBorderSize.getText());
		}
		ListOfPatterns.get(Number1).set(7,TextBorderColor.getValue().toString());
		if(ButtonTextSize.getText().equals("")){
			ListOfPatterns.get(Number1).set(8,"15");
		}
		else{
			ListOfPatterns.get(Number1).set(8,ButtonTextSize.getText());
		}
		ListOfPatterns.get(Number1).set(9,ButtonTextFont.getValue());
		ListOfPatterns.get(Number1).set(10,ButtonTextColor.getValue().toString());
		ListOfPatterns.get(Number1).set(11,buttoninfo);
		ListOfPatterns.get(Number1).set(12,ButtonBackgroundColor.getValue().toString());
		ListOfPatterns.get(Number1).set(13,String.format("%.2f", ButtonTextOpacity.getValue()).replace(',','.'));
		if(ButtonBorderSize.getText().equals("")){
			ListOfPatterns.get(Number1).set(14,"0");
		}
		else{
			ListOfPatterns.get(Number1).set(14,ButtonBorderSize.getText());
		}
		ListOfPatterns.get(Number1).set(15,ButtonBorderColor.getValue().toString());
		ListOfPatterns.get(Number1).set(16,animationColor.getValue().toString());
		System.out.println("00");
	
	}
 	
	else{
		if(bgpatterns.get("MainView").size()==Number){
			bgpatterns.get("MainView").add(startBg);
		}
		if(bgpatterns.get("Categories").size()==Number){
			bgpatterns.get("Categories").add(startBg);
		}
		if(bgpatterns.get("Dish").size()==Number){
			bgpatterns.get("Dish").add(startBg);
		}
		if(bgpatterns.get("DishInfo").size()==Number){
			bgpatterns.get("DishInfo").add(startBg);
		}
		
		ArrayList<String>al = new ArrayList<>();
	al.add(PatternTextSize.getText());
	al.add(PatternFont.getValue());
	al.add(PatternTextColor.getValue().toString());
	al.add(textinfo);
	al.add(PatternBackground.getValue().toString());
    al.add(String.format("%.2f", PatternOpacity.getValue()).replace(',','.'));
	if(TextBorderSize.getText().equals("")){
		al.add("0");
	}
	else{
		 al.add(TextBorderSize.getText());
	}
    al.add(TextBorderColor.getValue().toString());
	if(ButtonTextSize.getText().equals("")){
		al.add("15");
	}
	else{
		al.add(ButtonTextSize.getText());
	}
	al.add(ButtonTextFont.getValue());
	al.add(ButtonTextColor.getValue().toString());
	al.add(buttoninfo);
	al.add(ButtonBackgroundColor.getValue().toString());
	al.add(String.format("%.2f", ButtonTextOpacity.getValue()).replace(',','.'));
	if(ButtonBorderSize.getText().equals("")){
		al.add("0");
	}
	else{
		al.add(ButtonBorderSize.getText());
	}
	al.add(ButtonBorderColor.getValue().toString());
	al.add(animationColor.getValue().toString());
	ListOfPatterns.put(Number, al);
	
	}
	kk.close();
	System.out.println(slideNumber);
	
	MainGUI mng= loader.getController();
	System.out.println("3"+loader.toString());
 	if(loader!=null){
 	mng.addPattern();
 	
 	}
	openFromMenu=false;
	}









 
	
}
