
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HelloTab extends AbstractTab implements Tab ,Initializable {
	
	@FXML
	private ImageView background1;
	private ImageView background2;
	@FXML
	private AnchorPane tab;
	Group regGroup;
	
	public HelloTab(String s){
		if(s.equals("1")){
		init();
		
		}
	}
	
	public void getObjects(){
		background1 = (ImageView)tab.getChildren().get(0);
		background2 = (ImageView)tab.getChildren().get(1);
	}
	
	@Override
	public void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth()-80;
		double height = screenSize.getHeight()-80;
		
		
		tab = (AnchorPane) loadPane("HelloTab.fxml","AnchorPane");
		System.out.println("t"+tab.getScene());
		 getObjects();
		 background1.fitWidthProperty().bind(tab.widthProperty()); 
		 background1.fitHeightProperty().bind(tab.heightProperty()); 
			System.out.println( tab.getWidth());
		// AnchorPane.setRightAnchor(background2, width/2.5);
		 //AnchorPane.setTopAnchor(background2, height/3);
	   
	}
	public void test(){
		
		
		
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
			
	}
	@Override
	public Node getPane() {
		System.out.println("tr"+tab.toString());
		return tab;
	}
	

	
	
	
}
