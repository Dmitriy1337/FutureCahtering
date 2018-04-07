import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.traversal.Direction;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuTab extends AbstractTab implements Tab, Initializable{
	double width = Values.width;
    double height = Values.height;
	double tableWidth = width/1.09;
	double tableHeight = height/1.2;
    double dishpaneWidth = width/3.8;
    Image[] imageStore = new Image[]{
    new Image("images/ph10.jpg"),
    new Image("images/ph2.jpg"),new Image("images/ph3.jpg"),
    new Image("images/ph4.jpg"), new Image("images/ph5.jpg"), new Image("images/ph6.jpg"), new Image("images/ph7.jpg"),
    new Image("images/ph8.jpg"), new Image("images/ph9.jpg"), new Image("images/ph11.jpg"), new Image("images/ph12.jpg")
    };
    
    static int DishPosition;
    File file1,file2;
    boolean categoryClicked ;
    boolean openedForChanging = false;
    public JFXDrawer imagesPane;
    public AnchorPane menutab;
	public static TableView<Dish> menutable;
	public TableColumn<Dish,String> t1,t2,t3,t4,t5,t6,t7,t8,t9;
	public JFXDrawer addDishPane;
	public JFXTextField dishName,dishCategory; 
    public TitledPane dishDescription;
    public AnchorPane dishpanecontent;
	public JFXTextArea dishDescriptionArea;
	public TitledPane dishIngredients;
	public JFXTextArea dishIngredientsArea;
    public JFXTextField dishProtein, dishFats, dishCarboHydrate, dishPrice, dishValue,addIngridient; 
    public Label dishCategoryImageLabel, dishImageLabel;
    public ImageView dishCategoryImage,dishImage; 
    public JFXButton addDish;
    public ImageView binImage;
    public JFXListView<String>ingList;
    // Server server;
    
    ArrayList<Dish>tableList = new ArrayList<>();
    ArrayList<String>ingridientsList  = new ArrayList<>();
    
    public MenuTab(String s){
		if(s.equals("3")){
			System.out.println("lul");
			/*
			try {
				server  = new Server();
				server.start(Server.classStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    */
			init();
		    createTable();
		    }
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void getObjects(){
		
		menutable =(TableView<Dish>) menutab.getChildren().get(1);
		menutable.setId("orderT");
		//menutable.setStyle("-fx-background-color: #0093ff;");
		menutable.getStylesheets().add("tablestyle.css");
		ImageView background1= (ImageView) menutab.getChildren().get(0);
		background1.fitWidthProperty().bind(menutab.widthProperty()); 
		 background1.fitHeightProperty().bind(menutab.heightProperty()); 
		addDishPane = (JFXDrawer) menutab.getChildren().get(2);
		imagesPane  = (JFXDrawer) menutab.getChildren().get(3);
		
		
		imagesPane.setSidePane(getImagesPane());
		imagesPane.setLayoutX(width/1.35);
		imagesPane.setLayoutY(height/2);
		imagesPane.setDefaultDrawerSize(width/2);
		
		addDishPane.setSidePane(getAddDishPane());
		addDishPane.setDefaultDrawerSize(130);
		//AnchorPane.setRightAnchor(addDishPane, (double) 1);
		addDishPane.setLayoutX(width-220);
		addDishPane.setLayoutY(0);
		
		
		setDishPaneElements();
		
		menutable.setLayoutX(tableWidth/20);
		menutable.setLayoutY(tableHeight/20);
		menutable.setPrefWidth(tableWidth);
		menutable.setPrefHeight(tableHeight);
		
		menutable.setOnMouseClicked(event->{
			System.out.println("3");
			if(addDishPane.isShown()){
				System.out.println("2");
				addDishPane.close();
				addDishPane.setPrefWidth(500);
				imagesPane.close();
			}
		    else{
		    	System.out.println("1");
		    	addDishPane.open();
		    	addDishPane.setPrefWidth(130);
		    }
		});
	}
	@Override
	public void init() {
		menutab = (AnchorPane) loadPane("MenuTab.fxml","AnchorPane");
		menutab.getStylesheets().add("tablestyle.css");
		
		menutab.setPrefWidth(width);
		menutab.setPrefHeight(height);
		getObjects();
		
	}
	public void createTable(){
		menutable.setRowFactory(tv -> {
			TableRow<Dish> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		    	DishPosition = row.getIndex();
		    	if(DishPosition>=tableList.size()){
		    		clearAddDishPane();
		    		addDish.setText("Добавить блюдо");
		    		openedForChanging = false;
		    		addDishPane.open();
		    		
		    	}
		    	else{
			    	String []  PFH = tableList.get(DishPosition).getDishHValue().split("/");
			    	dishName.setText(tableList.get(DishPosition).getDishName());
					dishDescriptionArea.setText(tableList.get(DishPosition).getDishDescription());
					dishCategory.setText(tableList.get(DishPosition).getDishCategory());
					dishIngredientsArea.setText(tableList.get(DishPosition).getDishIngredients());
					dishProtein.setText(PFH[0]);
					dishFats.setText(PFH[1]);
					dishCarboHydrate.setText(PFH[2]);
					dishValue.setText(tableList.get(DishPosition).getDishKkl());
					dishPrice.setText(tableList.get(DishPosition).getDishPrice());
					dishCategoryImage.setImage(tableList.get(DishPosition).getCategImage().getImage());
					dishImage.setImage(tableList.get(DishPosition).getDishImage().getImage());
					addDish.setText("Изменить");
					openedForChanging = true;
					addDishPane.open();
		    	}
		    	});
		    return row ;
		});
		TableColumn<Dish, String> t1 = new TableColumn<>();
		t1.setText("Название");
		t1.setPrefWidth(tableWidth/9);
		t1.setResizable(false);
		//t1.setSortable(true);
		//t1.setCellFactory(cellFactory); 
		t1.setCellValueFactory(
	            new PropertyValueFactory<>("dishName")
	        );
		     
		TableColumn<Dish, String> t2 = 
		            new TableColumn<>();
		t2.setText("Описание");
		t2.setResizable(false);
		t2.setPrefWidth(tableWidth/6.4);
		//t2.setCellFactory(cellFactory); 
		t2.setCellValueFactory(
	            new PropertyValueFactory<>("dishDescription")
	        );
		    
		TableColumn<Dish, String> t3 = 
		            new TableColumn<>();
		t3.setText("Категория");
		t3.setResizable(false);
		t3.setPrefWidth(tableWidth/10);
		t3.setCellValueFactory(
	            new PropertyValueFactory<>("dishCategory")
	        );
		//t3.setCellFactory(cellFactory); 
		  
		TableColumn<Dish, String> t4 = 
	            new TableColumn<>();
		t4.setText("Ингредиенты");
		t4.setPrefWidth(tableWidth/8);
		t4.setResizable(false);
		//t4.setCellFactory(cellFactory); 
		t4.setCellValueFactory(
	            new PropertyValueFactory<>("dishIngredients")
	        );
		  
		TableColumn<Dish, String> t5 = 
	            new TableColumn<>();
		t5.setText("Белки/Жиры/Углеводы");
		t5.setPrefWidth(tableWidth/7.5);
		t5.setResizable(false);
		//t5.setCellFactory(cellFactory); 
		t5.setCellValueFactory(
	            new PropertyValueFactory<>("dishHValue")
	        );
		
		TableColumn<Dish, String> t6 = 
	            new TableColumn<>();
		t6.setText("Ккал");
		t6.setPrefWidth(tableWidth/12);
		t6.setResizable(false);
		//t6.setCellFactory(cellFactory); 
		t6.setCellValueFactory(
	            new PropertyValueFactory<>("dishKkl")
	        );
		
		TableColumn<Dish, String> t7 = 
	            new TableColumn<>();
		t7.setText("Цена(р.)");
		t7.setPrefWidth(tableWidth/12);
		t7.setResizable(false);
		//t7.setCellFactory(cellFactory); 
		t7.setCellValueFactory(
	            new PropertyValueFactory<>("dishPrice")
	        );
		
		TableColumn<Dish, String> t8 = 
	            new TableColumn<>();
		t8.setText("К.(Категория)");
		t8.setPrefWidth(tableWidth/10);
		t8.setResizable(false);
		//t8.setCellFactory(cellFactory1); 
		t8.setCellValueFactory(
	            new PropertyValueFactory<>("categImage")
	        );
		
		TableColumn<Dish,  String> t9 = 
	            new TableColumn<>();
		t9.setText("К.(Блюдо)");
		t9.setPrefWidth(tableWidth/10);
		t9.setResizable(false);
		//t9.setCellFactory(cellFactory1); 
		t9.setCellValueFactory(
	            new PropertyValueFactory<>("dishImage")
	        );
		
		menutable.getColumns().addAll(t1,t2,t3,t4,t5,t6,t7,t8,t9);
		
	}
	@Override
	public Node loadPane(String name, String type) {
		if(type.equals("AnchorPane")){
		    try {
		    	  FXMLLoader loader = new FXMLLoader();
		          loader.setLocation(MenuTab.class.getResource(name)); 
		          loader.setController(new MenuTab(""));
		          AnchorPane ap = (AnchorPane) loader.load();
		          return ap;
		    } catch (IOException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		    
	 }
		return null;
	}
	 
	public void setSearchListeners(JFXListView<String>list,JFXTextField enter){
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        // Your action here
		        System.out.println("Selected item: " + newValue);
		    enter.setText(newValue);
		    list.setVisible(false);
		    
		    }
		});
		
		enter.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                
               
                 String ent = enter.getText();
                if(!ent.equals("")){
                	list.setVisible(true);
                	ArrayList<String>temp =new ArrayList<>();
                 temp.addAll(ingridientsList);
                 int s = temp.size();
                 System.out.println("temp.toString() "+ingridientsList.toString());
                 for(int i = 0;i<s;i++){
                	 if(ent.length()<=temp.get(i).length()){
                		 System.out.println(i+"//"+ent+"//"+temp.get(i).substring(0, ent.length()));
                		 if(!ent.equals(temp.get(i).substring(0, ent.length()))){
                			 temp.set(i, " ");
                		 }
                		 
                	 }
                	 else{
                		 temp.set(i, " ");
                	 }
                	 
                 }
                
               
                 
               temp.removeAll(Collections.singleton(" "));
                
                	System.out.println(temp.toString());
                 fillView(list,temp);
          if(temp.size()<=3)
                 list.setPrefHeight(temp.size()*25);
            }
            }
        });
		
		enter.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER:    
                    	//System.out.println(""+enter.getText());
                    	if(dishIngredientsArea.getText().equals("")){
                    		dishIngredientsArea.setText(enter.getText());
                    	}
                    	else{
                    		dishIngredientsArea.setText(dishIngredientsArea.getText()+System.lineSeparator()+""+enter.getText());
                    	}
                    	
                    	ingridientsList.add(enter.getText());
                    	list.getItems().add(enter.getText());
                    	enter.setText("");
                    	
                    	break;
                   
                }
            }
        });
	}
	public void fillView(ListView<String>l,ArrayList<String>list){
		l.getItems().clear();
		for(int i = 0;i<list.size();i++){
			l.getItems().add(list.get(i));
		}
		
	}
	public Node getAddDishPane(){
		dishpanecontent = (AnchorPane)loadPane("AddDishPane.fxml" , "AnchorPane");
		dishpanecontent.setPrefSize(dishpaneWidth, height);
		return dishpanecontent;
	}
	public void AddDish(){
		
		/*
		try {
			FileInputStream file11 = new FileInputStream(file1);
			byte[] bytes1 = new byte[file11.available()];
			file11.read(bytes1);
			 
			FileInputStream file22 = new FileInputStream(file2);
			byte[] bytes2= new byte[file22.available()];
			file22.read(bytes2);
			
		
			server.sendMenuInfo(new MenuElement(dishName.getText(),dishDescriptionArea.getText(),dishCategory.getText(),
					dishIngredientsArea.getText(),dishProtein.getText()+"/"+dishFats.getText()+"/"+dishCarboHydrate.getText(),
					dishValue.getText(),dishPrice.getText(),bytes1,bytes2, -1));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		ImageView im1 = new ImageView(dishCategoryImage.getImage());
		im1.setFitHeight(tableHeight/15);
		im1.setFitWidth(tableHeight/15);
		ImageView im2 = new ImageView(dishImage.getImage());
		im2.setFitHeight(tableHeight/15);
		im2.setFitWidth(tableHeight/15);
		tableList.add(new Dish(dishName.getText(),dishDescriptionArea.getText(),dishCategory.getText(),
				dishIngredientsArea.getText(),dishProtein.getText()+"/"+dishFats.getText()+"/"+dishCarboHydrate.getText(),
				dishValue.getText(),dishPrice.getText(),im1,im2));
		menutable.getItems().add(
				new Dish(dishName.getText(),dishDescriptionArea.getText(),dishCategory.getText(),
				dishIngredientsArea.getText(),dishProtein.getText()+"/"+dishFats.getText()+"/"+dishCarboHydrate.getText(),
				dishValue.getText(),dishPrice.getText(),im1,im2)
				);
		
	}
	
	public void changeDishInfo(){
		ImageView im1 = new ImageView(dishCategoryImage.getImage());
		im1.setFitHeight(tableHeight/15);
		im1.setFitWidth(tableHeight/15);
		ImageView im2 = new ImageView(dishImage.getImage());
		im2.setFitHeight(tableHeight/15);
		im2.setFitWidth(tableHeight/15);
		tableList.set(DishPosition,
				new Dish(dishName.getText(),dishDescriptionArea.getText(),dishCategory.getText(),
				dishIngredientsArea.getText(),dishProtein.getText()+"/"+dishFats.getText()+"/"+dishCarboHydrate.getText(),
				dishValue.getText(),dishPrice.getText(),im1,im2));
		menutable.getItems().set(DishPosition,
				new Dish(dishName.getText(),dishDescriptionArea.getText(),dishCategory.getText(),
				dishIngredientsArea.getText(),dishProtein.getText()+"/"+dishFats.getText()+"/"+dishCarboHydrate.getText(),
				dishValue.getText(),dishPrice.getText(),im1,im2)
				);
	}
	
	public void clearAddDishPane(){
		dishName.clear();
		dishDescriptionArea.clear();
		dishCategory.clear();
		dishIngredientsArea.clear();
		dishProtein.clear();
		dishFats.clear();
		dishCarboHydrate.clear();
		dishValue.clear();
		dishPrice.clear();
		dishCategoryImage.setImage(new Image("images/ph13.jpg"));
		dishImage.setImage(new Image("images/ph13.jpg"));
	}
	public void setDishPaneElements(){
		
		
		
		dishName = (JFXTextField)dishpanecontent.getChildren().get(0);
		dishName.setFont(new Font(18));
		dishName.setPromptText("Название блюда");
		dishName.setLabelFloat(true);
		dishName.setLayoutX(dishpaneWidth/7.7);
		dishName.setLayoutY(height/16);
		
		dishDescription = (TitledPane)dishpanecontent.getChildren().get(1);
		dishDescription.setLayoutX(dishpaneWidth/6.4);
		dishDescription.setLayoutY(height/6.8);
		dishDescription.setPrefSize(dishpaneWidth/1.54, height/3);
		dishDescription.setText("Описание блюда");
		dishDescription.setOnMouseClicked(event->{
			if(!dishDescription.isExpanded()){
				TranslateTransition transition = new TranslateTransition(Duration.millis(400), dishCategory);
				TranslateTransition transition1 = new TranslateTransition(Duration.millis(400), dishIngredients);
				TranslateTransition transition2 = new TranslateTransition(Duration.millis(400), dishProtein);
				TranslateTransition transition3 = new TranslateTransition(Duration.millis(400), dishFats);
				TranslateTransition transition4 = new TranslateTransition(Duration.millis(400), dishCarboHydrate);
				TranslateTransition transition5 = new TranslateTransition(Duration.millis(400), dishValue);
				TranslateTransition transition6 = new TranslateTransition(Duration.millis(400), dishPrice);
				TranslateTransition transition7 = new TranslateTransition(Duration.millis(400), dishCategoryImageLabel);
				TranslateTransition transition8 = new TranslateTransition(Duration.millis(400), dishImageLabel);
				TranslateTransition transition9 = new TranslateTransition(Duration.millis(400), dishCategoryImage);
				TranslateTransition transition10 = new TranslateTransition(Duration.millis(400), dishImage);
				TranslateTransition transition11 = new TranslateTransition(Duration.millis(400), addDish);
				TranslateTransition transition12 = new TranslateTransition(Duration.millis(400), binImage);
				transition.setToY(height/10000);
				transition1.setToY(height/10000);
				transition2.setToY(height/10000);
				transition3.setToY(height/10000);
				transition4.setToY(height/10000);
				transition5.setToY(height/10000);
				transition6.setToY(height/10000);
				transition7.setToY(height/10000);
				transition8.setToY(height/10000);
				transition9.setToY(height/10000);
				transition10.setToY(height/10000);
				transition11.setToY(height/10000);
				transition12.setToY(height/10000);
		   		transition.play();
				transition1.play();
				transition2.play();
				transition3.play();
				transition4.play();
				transition5.play();
				transition6.play();
				transition7.play();
				transition8.play();
				transition9.play();
				transition10.play();
				transition11.play();
				transition12.play();
			}
			else if(dishDescription.isExpanded()){
				TranslateTransition transition = new TranslateTransition(Duration.millis(400), dishCategory);
				TranslateTransition transition1 = new TranslateTransition(Duration.millis(400), dishIngredients);
				TranslateTransition transition2 = new TranslateTransition(Duration.millis(400), dishProtein);
				TranslateTransition transition3 = new TranslateTransition(Duration.millis(400), dishFats);
				TranslateTransition transition4 = new TranslateTransition(Duration.millis(400), dishCarboHydrate);
				TranslateTransition transition5 = new TranslateTransition(Duration.millis(400), dishValue);
				TranslateTransition transition6 = new TranslateTransition(Duration.millis(400), dishPrice);
				TranslateTransition transition7 = new TranslateTransition(Duration.millis(400), dishCategoryImageLabel);
				TranslateTransition transition8 = new TranslateTransition(Duration.millis(400), dishImageLabel);
				TranslateTransition transition9 = new TranslateTransition(Duration.millis(400), dishCategoryImage);
				TranslateTransition transition10 = new TranslateTransition(Duration.millis(400), dishImage);
				TranslateTransition transition11 = new TranslateTransition(Duration.millis(400), addDish);
				TranslateTransition transition12 = new TranslateTransition(Duration.millis(400), binImage);
				transition.setToY(height/3.5);
				transition1.setToY(height/3.5);
				transition2.setToY(height/3.5);
				transition3.setToY(height/3.5);
				transition4.setToY(height/3.5);
				transition5.setToY(height/3.5);
				transition6.setToY(height/3.5);
				transition7.setToY(height/3.5);
				transition8.setToY(height/3.5);
				transition9.setToY(height/3.5);
				transition10.setToY(height/3.5);
				transition11.setToY(height/3.5);
				transition12.setToY(height/3.5);
		   		transition.play();
				transition1.play();
				transition2.play();
				transition3.play();
				transition4.play();
				transition5.play();
				transition6.play();
				transition7.play();
				transition8.play();
				transition9.play();
				transition10.play();
				transition11.play();
				transition12.play();
			}
		});
		dishDescriptionArea = (JFXTextArea) dishDescription.getContent();
		dishDescriptionArea.setPrefSize(dishpaneWidth/1.54,height/4);
		dishDescriptionArea.setFont(new Font(16));
		
		
   		dishCategory = (JFXTextField)dishpanecontent.getChildren().get(2);
		dishCategory.setLayoutX(dishpaneWidth/7.7);
		dishCategory.setLayoutY(height/4.3);
		dishCategory.setFont(new Font(18));
		dishCategory.setPromptText("Категория");
		dishCategory.setLabelFloat(true);
		
		addIngridient =  (JFXTextField)dishpanecontent.getChildren().get(15);
		addIngridient.setFont(new Font(15));
		addIngridient.setLabelFloat(true);
		addIngridient.setDisable(true);
		addIngridient.setVisible(false);
		addIngridient.setPromptText("Добавить ингридиент");
		
		ingList =  (JFXListView)dishpanecontent.getChildren().get(16);
		ingList.setLayoutX(dishpaneWidth/6.4);
		ingList.setVisible(false);
		setSearchListeners(ingList,addIngridient);
		
		dishIngredients = (TitledPane)dishpanecontent.getChildren().get(3);
		dishIngredients.setWrapText(true);
		
		dishIngredients.setLayoutX(dishpaneWidth/6.4);
		dishIngredients.setLayoutY(height/3.15);
		dishIngredients.setPrefSize(dishpaneWidth/1.54, height/3);
		dishIngredients.setText("Ингредиенты");
		dishIngredients.setOnMouseClicked(event->{
			if(!dishIngredients.isExpanded()){
				
				dishProtein.setLayoutY(height/2.5);
				dishFats.setLayoutY(height/2.5);
				dishCarboHydrate.setLayoutY(height/2.5);
				
				addIngridient.setDisable(true);
				addIngridient.setVisible(false);
				ingList.setVisible(false);
				TranslateTransition transition2 = new TranslateTransition(Duration.millis(400), dishProtein);
				TranslateTransition transition3 = new TranslateTransition(Duration.millis(400), dishFats);
				TranslateTransition transition4 = new TranslateTransition(Duration.millis(400), dishCarboHydrate);
				TranslateTransition transition5 = new TranslateTransition(Duration.millis(400), dishValue);
				TranslateTransition transition6 = new TranslateTransition(Duration.millis(400), dishPrice);
				TranslateTransition transition7 = new TranslateTransition(Duration.millis(400), dishCategoryImageLabel);
				TranslateTransition transition8 = new TranslateTransition(Duration.millis(400), dishImageLabel);
				TranslateTransition transition9 = new TranslateTransition(Duration.millis(400), dishCategoryImage);
				TranslateTransition transition10 = new TranslateTransition(Duration.millis(400), dishImage);
				TranslateTransition transition11 = new TranslateTransition(Duration.millis(400), addDish);
				TranslateTransition transition12 = new TranslateTransition(Duration.millis(400), binImage);
				TranslateTransition transition13 = new TranslateTransition(Duration.millis(400), addIngridient);
				TranslateTransition transition14 = new TranslateTransition(Duration.millis(400), ingList);
				transition2.setToY(height/10000);
				transition3.setToY(height/10000);
				transition4.setToY(height/10000);
				transition5.setToY(height/10000);
				transition6.setToY(height/10000);
				transition7.setToY(height/10000);
				transition8.setToY(height/10000);
				transition9.setToY(height/10000);
				transition10.setToY(height/10000);
				transition11.setToY(height/10000);
				transition12.setToY(height/10000);
				transition13.setToY(height/10000);
				transition14.setToY(height/10000);
				transition2.play();
				transition3.play();
				transition4.play();
				transition5.play();
				transition6.play();
				transition7.play();
				transition8.play();
				transition9.play();
				transition10.play();
				transition13.play();
				transition14.play();
				//transition11.play();
				//transition12.play();
			}
			else if(dishIngredients.isExpanded()){
				addIngridient.setDisable(false);
				addIngridient.setVisible(true);
				
				dishProtein.setLayoutY(height/2.5+25);
				dishFats.setLayoutY(height/2.5+25);
				dishCarboHydrate.setLayoutY(height/2.5+25);
				TranslateTransition transition2 = new TranslateTransition(Duration.millis(400), dishProtein);
				TranslateTransition transition3 = new TranslateTransition(Duration.millis(400), dishFats);
				TranslateTransition transition4 = new TranslateTransition(Duration.millis(400), dishCarboHydrate);
				TranslateTransition transition5 = new TranslateTransition(Duration.millis(400), dishValue);
				TranslateTransition transition6 = new TranslateTransition(Duration.millis(400), dishPrice);
				TranslateTransition transition7 = new TranslateTransition(Duration.millis(400), dishCategoryImageLabel);
				TranslateTransition transition8 = new TranslateTransition(Duration.millis(400), dishImageLabel);
				TranslateTransition transition9 = new TranslateTransition(Duration.millis(400), dishCategoryImage);
				TranslateTransition transition10 = new TranslateTransition(Duration.millis(400), dishImage);
				TranslateTransition transition11 = new TranslateTransition(Duration.millis(400), addDish);
				TranslateTransition transition12 = new TranslateTransition(Duration.millis(400), binImage);
				TranslateTransition transition13 = new TranslateTransition(Duration.millis(400), addIngridient);
				TranslateTransition transition14 = new TranslateTransition(Duration.millis(400), ingList);
				transition2.setToY(height/3.5);
				transition3.setToY(height/3.5);
				transition4.setToY(height/3.5);
				transition5.setToY(height/3.5);
				transition6.setToY(height/3.5);
				transition7.setToY(height/3.5);
				transition8.setToY(height/3.5);
				transition9.setToY(height/3.5);
				transition10.setToY(height/3.5);
				transition11.setToY(height/3.5);
				transition12.setToY(height/3.5);
				transition13.setToY(height/3.5);
				transition14.setToY(height/3.5);
		   		transition2.play();
				transition3.play();
				transition4.play();
				transition5.play();
				transition6.play();
				transition7.play();
				transition8.play();
				transition9.play();
				transition10.play();
				//transition11.play();
				//transition12.play();
				transition13.play();
				transition14.play();
			}
		});
		dishIngredientsArea = (JFXTextArea) dishIngredients.getContent();
		dishIngredientsArea.setEditable(false);
		dishIngredientsArea.setWrapText(true);
		dishIngredientsArea.setPrefSize(dishpaneWidth/1.54,height/4);
		dishIngredientsArea.setFont(new Font(16));
	
		dishProtein = (JFXTextField)dishpanecontent.getChildren().get(4);
		dishProtein.setFont(new Font(16));
		dishProtein.setPrefWidth(dishpaneWidth/4);
		dishProtein.setLayoutX(dishpaneWidth/7.6);
		dishProtein.setLayoutY(height/2.5);
		dishProtein.setPromptText("Белки");
		dishProtein.setLabelFloat(true);
		
		dishFats = (JFXTextField)dishpanecontent.getChildren().get(5);
		dishFats.setFont(new Font(16));
		dishFats.setPrefWidth(dishpaneWidth/4);
		dishFats.setLayoutX(dishpaneWidth/3);
		dishFats.setLayoutY(height/2.5);
		dishFats.setPromptText("Жиры");
		dishFats.setLabelFloat(true);
		
		dishCarboHydrate = (JFXTextField)dishpanecontent.getChildren().get(6);
		dishCarboHydrate.setFont(new Font(16));
		dishCarboHydrate.setPrefWidth(dishpaneWidth/3.3);
		dishCarboHydrate.setLayoutX(dishpaneWidth/1.86);
		dishCarboHydrate.setLayoutY(height/2.5);
		dishCarboHydrate.setPromptText("Углеводы");
		dishCarboHydrate.setLabelFloat(true);
		
		dishValue = (JFXTextField)dishpanecontent.getChildren().get(7);
		dishValue.setFont(new Font(18));
		dishValue.setLayoutX(dishpaneWidth/7.7);
		dishValue.setLayoutY(height/2);
		dishValue.setPromptText("Килокалории");
		dishValue.setLabelFloat(true);
		
		dishPrice = (JFXTextField)dishpanecontent.getChildren().get(8);
		dishPrice.setFont(new Font(18));
		dishPrice.setLayoutX(dishpaneWidth/7.7);
		dishPrice.setLayoutY(height/1.65);
		dishPrice.setPromptText("Цена");
		dishPrice.setLabelFloat(true);
	
		dishCategoryImageLabel = (Label) dishpanecontent.getChildren().get(9);
		dishCategoryImageLabel.setFont(new Font(14));
		dishCategoryImageLabel.setLayoutX(dishpaneWidth/6.5);
		dishCategoryImageLabel.setLayoutY(height/1.42);
		
		dishImageLabel = (Label) dishpanecontent.getChildren().get(10);
		dishImageLabel.setFont(new Font(14));
		dishImageLabel.setLayoutX(dishpaneWidth/2);
		dishImageLabel.setLayoutY(height/1.42);
		
		dishCategoryImage = (ImageView)dishpanecontent.getChildren().get(11);
		dishCategoryImage.setFitWidth(dishpaneWidth/3.2);
		dishCategoryImage.setFitHeight(dishpaneWidth/3.5);
		dishCategoryImage.setImage(new Image("images/ph13.jpg"));
		dishCategoryImage.setLayoutX(dishpaneWidth/6.4);
		dishCategoryImage.setLayoutY(height/1.28);
		dishCategoryImage.setOnMouseClicked(event->{
			categoryClicked = true;
			imagesPane.open();
		});
		
		dishImage = (ImageView)dishpanecontent.getChildren().get(12);
		dishImage.setFitWidth(dishpaneWidth/3.2);
		dishImage.setFitHeight(dishpaneWidth/3.5);
		dishImage.setImage(new Image("images/ph13.jpg"));
		dishImage.setLayoutX(dishpaneWidth/2);
		dishImage.setLayoutY(height/1.28);
		dishImage.setOnMouseClicked(event ->{
			categoryClicked = false;
			chooseImageForImageCateg(dishImage);
		});
		
		
		addDish = (JFXButton) dishpanecontent.getChildren().get(13);
		addDish.setFont(new Font(15));
		addDish.setStyle("-fx-background-color:#300ce1;-fx-text-fill:white");
		addDish.setLayoutX(dishpaneWidth/6.5);
		addDish.setLayoutY(height/1.06);
		addDish.setOnMouseClicked(event->{
			addDishPane.close();
			addDishPane.setPrefWidth(500);
			if(!openedForChanging){
				AddDish();
			
			}
			else{
				changeDishInfo();
			}
		});
		
		binImage = (ImageView)dishpanecontent.getChildren().get(14);
		binImage.setFitWidth(dishpaneWidth/7);
		binImage.setFitHeight(dishpaneWidth/7);
		binImage.setImage(new Image("images/ph12.jpg"));
		binImage.setLayoutX(dishpaneWidth/1.5);
		binImage.setLayoutY(height/1.08);
		binImage.setOnMouseClicked(event->{
			clearAddDishPane();
		});
	}
	public Node getImagesPane(){
		double pos_X = width/100;
		double pos_Y = width/100;
		ScrollPane scrl  = new ScrollPane();
		scrl.setMinSize(dishpaneWidth, height/2);
		
		AnchorPane imgPane = new AnchorPane();
		imgPane.setPrefSize(dishpaneWidth, dishpaneWidth);
		imgPane.setStyle("-fx-background-color:#daf7ff");
		for(int i =0;i<imageStore.length;i++){
			ImageView elem = new ImageView(imageStore[i]);
			elem.setLayoutX(pos_X);
			elem.setLayoutY(pos_Y);
			if(i!=0){
				elem.setOnMouseClicked(event->{
					dishCategoryImage.setImage(elem.getImage());
					//file1 = new File(elem.getImage());
					imagesPane.close();
				});
			}
			else{
				elem.setOnMouseClicked(event->{
					
					chooseImageForImageCateg(dishCategoryImage);
					
				});
			}
			
			imgPane.getChildren().add(elem);
			if((i+1)%3==0&&i!=0){
				pos_Y+=100;
				pos_X = width/100;
			}
			else{
				pos_X+=100;
			}
		}
		scrl.setContent(imgPane);
		return scrl;
	}
	public void chooseImageForImageCateg(ImageView im){
  		 FileChooser fileChooser = new FileChooser();
  		 fileChooser.setTitle("Choose Image");
  		 configureFileChooser(fileChooser);
  		 Stage stage  = new Stage();
  		 Platform.runLater(new Runnable() {
  	            @Override public void run() {
  	            	File file = fileChooser.showOpenDialog(stage);
  	            	if(categoryClicked){
  	            		file1 = file;
  	            		
  	            	}
  	            	else{//fl2 = file;
  	            		file2 = file;
  	            		
  	            	}
  					try {
						String  imagepath = file.toURI().toURL().toString();
						Image getImage = new Image( imagepath);
						im.setImage(getImage);
						imagesPane.close();
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
	public Node getPane() {
		// TODO Auto-generated method stub
		return menutab;
	}

public class Dish{
	public String dishPrice;
	public String dishDescription;	
	public String dishName;	
	public String dishKkl;
	public String dishCategory;
	public String dishIngredients;
	public String dishHValue;
	public ImageView categImage;
    public ImageView dishImage;
	
    public Dish(String a1,String a2,String a3,String a4,String a5,String a6,String a7,ImageView a8,ImageView a9){
		  this.dishName =a1;
		  this.dishDescription =a2;
		  this.dishCategory=a3;
		  this.dishIngredients =a4;
		  this.dishHValue =a5;
		  this.dishKkl =a6;
		  this.dishPrice =a7;
		  this.categImage =a8;
		  this.dishImage =a9;
	}
    public void setCategImage(ImageView categImage) {
  	  this.categImage = categImage;
  	  
    }


  	public void setDishImage(ImageView dishImage) {
  		this.dishImage = dishImage;
  		
  	}
  	

  	

    public void setDishPrice(String dishPrice) {
  	this.dishPrice = dishPrice;
  	
    }


  public void setDishDescription(String dishDescription) {
  	this.dishDescription = dishDescription;
  	
  }


  public void setDishName(String dishName1) {
  	this.dishName = dishName1;

  }


  public void setDishKkl(String dishKkl) {
  	this.dishKkl = dishKkl;
  	
  }



  public void setDishCategory(String dishCategory) {
  	this.dishCategory = dishCategory;
  	
  }

  public void setDishIngredients(String dishIngredients) {
  	this.dishIngredients = dishIngredients;
  	
  }
  public void setDishHValue(String dishHValue) {
  	this.dishHValue = dishHValue;
  	
  }




  public String getDishPrice() {
  	return this.dishPrice;
  }


  public String getDishDescription() {
  	return this.dishDescription;
  }

  public String getDishName() {
  	return this.dishName;
  }


  public String getDishKkl() {
  	return this.dishKkl;
  }


  public String getDishCategory() {
  	return this.dishCategory;
  }
  public String getDishIngredients() {
  	return this.dishIngredients;
  }
  public String getDishHValue() {
  	return this.dishHValue;
  }
  public ImageView getCategImage() {
  	return this.categImage;
  }
  public ImageView getDishImage() {
  	return this.dishImage;
  }

}
}
