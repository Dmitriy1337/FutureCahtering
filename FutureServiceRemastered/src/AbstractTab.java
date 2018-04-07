import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class AbstractTab {

	
	public Node loadPane(String name,String type){
		if(type.equals("AnchorPane")){
			AnchorPane ap;
			try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(HelloTab.class.getResource(name)); 
	        loader.setController(new HelloTab(""));
	       
	       
	         ap = (AnchorPane) loader.load();
	         System.gc();
	        return ap;
	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			ap=null;
		System.gc();
		}
		}
		
		
		return null;
	}

	
}
