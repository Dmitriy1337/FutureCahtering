import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderTab extends AbstractTab implements Tab,Initializable{
	JFXButton test;
	JFXListView <AnchorPane>orderDisplay ;
	ArrayList <Order>orderList ;
	JFXDrawer moreInfo;
	AnchorPane tab;
	AnchorPane orderInfo;
	ArrayList<Integer>id;
	ArrayList<Integer>id2;
	TableView<MenuTab.Dish> menutable;
	boolean menuIsOpen = false;
	Stage stage;
	ImageView background1;
	
	public OrderTab(String s,Stage stage){
		
		this.stage = stage;
		if(s.equals("4")){
		init();
		
		}
	}
	
	public void setStageListener(){
		stage.widthProperty().addListener( new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    	moreInfo.setLayoutX((double)newValue-300);
                    	
                    }}

        );
		
	}
	
	
	public void fillOrderInfo(){

		if(orderList!=null){
			orderDisplay.getItems().clear();
			System.out.println("1 "+menutable.getItems().toString());
		
        int k = orderList.size();
		
       Image im = new Image("wbg.png");
        for(int i = 0;i<k;i++){
        	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(HelloTab.class.getResource("OrderAnchorPane.fxml")); 
	        loader.setController(new HelloTab(""));
	        AnchorPane ap = null;
			try {
				ap = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
       
			Label idLabel = (Label) ap.getChildren().get(1);
			
			
			
			Label dishesLabel =(Label) ap.getChildren().get(3);
			
			Label costLabel = (Label) ap.getChildren().get(9);
			
			
			idLabel.setText(""+orderList.get(i).getId());
			dishesLabel.setText(""+orderList.get(i).getDishes());
			costLabel.setText(""+orderList.get(i).getPrice());
			
			
			orderDisplay.getItems().add(ap);
			
		}
		System.out.println("s "+orderDisplay.getItems().toString());
		
		//orderList.clear();
	}
	}
	
	@Override
	public void init() {
		id = new ArrayList<>();
		id.add(0);
		//id.add(2);
		id2 = new ArrayList<>();
		//id2.add(1);
		id2.add(0);
		
		MenuTab mt = new MenuTab("");
		 menutable = mt.menutable;
		tab = (AnchorPane) loadPane("OrderTab.fxml","AnchorPane");
		orderList = new ArrayList<Order>();
		getObjects();
		
		background1.fitWidthProperty().bind(tab.widthProperty()); 
		 background1.fitHeightProperty().bind(tab.heightProperty()); 
		
		test.setOnMouseClicked(m->{
			Order o1= new Order(1,formList(id,menutable),id);
			orderList.add(o1);
			Order o2= new Order(2,formList(id2,menutable),id2);
			orderList.add(o2);
			fillOrderInfo();
		});
		
				
				
				orderInfo=(AnchorPane) loadPane("OrderInfoPane.fxml","AnchorPane");
				
				TableView<DishInDescr> orderListTable = (TableView) orderInfo.getChildren().get(2);
				
				TableColumn<DishInDescr, String> dishNameColumn = (TableColumn<DishInDescr, String>) orderListTable.getColumns().get(0);
				dishNameColumn.setText("Блюдo");
				dishNameColumn.setResizable(false);
				dishNameColumn.setCellValueFactory(
			            new PropertyValueFactory<>("name")
			        );
				
				TableColumn<DishInDescr, String> dishNumberColumn =  (TableColumn<DishInDescr, String>) orderListTable.getColumns().get(1);
				dishNumberColumn.setText("Кол-во");
				dishNumberColumn.setResizable(false);
				dishNumberColumn.setCellValueFactory(
			            new PropertyValueFactory<>("number")
			        );
				TableColumn<DishInDescr, String> dishPriceColumn = (TableColumn<DishInDescr, String>) orderListTable.getColumns().get(2);
				dishPriceColumn.setText("Цена");
				dishPriceColumn.setResizable(false);
				dishPriceColumn.setCellValueFactory(
			            new PropertyValueFactory<>("price")
			        );
				
				
				
					moreInfo.setSidePane(orderInfo);
					//AnchorPane.setRightAnchor(moreInfo, 1.0);
					moreInfo.setLayoutX(1050);
					moreInfo.setDefaultDrawerSize(300);
					
					setStageListener();
				orderDisplay.setOnMouseClicked(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent event) {
			        	 if(orderDisplay.getSelectionModel().getSelectedItem()!=null){
				        	
			        		 System.out.println("clicked on " + orderDisplay.getSelectionModel().getSelectedItem());
				            moreInfo.open();
				            Label number = (Label) orderDisplay.getSelectionModel().getSelectedItem().getChildren().get(1);
				            System.out.println( "orderInfo "+orderInfo.getChildren().toString());
				            fillInfoAboutOrder(Integer.parseInt(number.getText()),orderListTable);
				            Label infoNumber= (Label) orderInfo.getChildren().get(0);
				            infoNumber.setText("Заказ № "+number.getText());
				            Label sumPrice= (Label) orderInfo.getChildren().get(3);
				            sumPrice.setText("Цена: "+orderList.get(Integer.parseInt(number.getText())-1).getPrice()+" руб.");
			        	
			        	 }
			        }
			    });
				
					
				
				
				
				
	}

	
	
	public void fillInfoAboutOrder(int i,TableView orderListTable){
		
		System.out.println("1"+orderListTable.getItems().toString());
		orderListTable.getItems().clear();
		for(int j = 0;j<orderList.get(i-1).getDishesList().size();j++ ){
			orderListTable.getItems().add(new DishInDescr(orderList.get(i-1).getDishesList().get(j).getDishName(),"x1",orderList.get(i-1).getDishesList().get(j).getDishPrice()));
			
		}
	
	}
	
	
	
	@Override
	public void getObjects() {
		background1 = (ImageView)tab.getChildren().get(0);
		orderDisplay = (JFXListView<AnchorPane>) tab.getChildren().get(1);
		moreInfo = (JFXDrawer) tab.getChildren().get(2);
		test = (JFXButton) tab.getChildren().get(3);
	}

	@Override
	public Node getPane() {
		// TODO Auto-generated method stub
		return tab;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("initialize");
		
	}

	public ArrayList<MenuTab.Dish> formList(ArrayList<Integer>id,TableView<MenuTab.Dish> menutable){
		System.out.println(menutable.getItems().size());
		ArrayList<MenuTab.Dish> list = new ArrayList<MenuTab.Dish>();
		for(int i = 0;i<id.size();i++){
			list.add(menutable.getItems().get(id.get(i)));
			
		}
		return list;
	}
	
	
	public class Order{
		private int id;
		private ArrayList<MenuTab.Dish> dishesList;
		private int price;
		private ArrayList<Integer>intId;
		public Order(int id,ArrayList<MenuTab.Dish> observableList,ArrayList<Integer>intId){
			this.id = id;
			this.dishesList = observableList;
			this.price = calcPrice();
			this.intId = intId;
		}
	
		public String getDishes(){
			String s = "";
			for(int i = 0;i<this.dishesList.size();i++){
				s=s+","+this.dishesList.get(i).getDishName();
			}
			return s.replaceFirst(",", "");
		}
		public ArrayList<Integer> getDishesId(){
			
			
			return this.intId;
		}
		public ArrayList<MenuTab.Dish> getDishesList(){
			
			
			return this.dishesList;
		}
		
		
		public int getPrice(){
			return price;
		}
		public int getId(){
			return id;
		}
		
		public int calcPrice(){
			int price = 0;
			for(int i = 0;i<this.dishesList.size();i++){
				price+=Integer.parseInt(this.dishesList.get(i).getDishPrice());
				
				
			}
			return price;
			
		}
		
		
	}
	
	
	
}
