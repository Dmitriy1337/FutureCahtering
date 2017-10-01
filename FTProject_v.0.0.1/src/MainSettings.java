import java.util.ArrayList;

public class MainSettings {

	private ArrayList<Object> topLabelNameData;
	private ArrayList<Object> topLabelSloganData;
	private ArrayList<Object> menuButtonData;
	private ArrayList<Object> orderButtonData;
	private ArrayList<Object> stateButtonData;
	private ArrayList<Object> aboutUsButtonData;
	
	
	public MainSettings(ArrayList<Object> nameData,ArrayList<Object> sloganData,ArrayList<Object> firstButtonData,ArrayList<Object> secondButtonData,ArrayList<Object> thirdButtonData,ArrayList<Object> forthButtonData){
		this.topLabelNameData = nameData;
		this.topLabelSloganData = sloganData;
		this.menuButtonData = firstButtonData;
		this.orderButtonData = secondButtonData;
		this.stateButtonData = thirdButtonData;
		this.aboutUsButtonData = forthButtonData;
		
	}
	
	public void setTopLabelNameData(ArrayList<Object> arg){
		
		this.topLabelNameData = arg;
	}
	public ArrayList<Object> getTopLabelNameData(){
		
		return this.topLabelNameData;
	}
	
	
	public void setTopLabelSloganData(ArrayList<Object> arg){
		
		this.topLabelSloganData = arg;
	}
	public ArrayList<Object> getTopLabelSloganData(){
		
		return this.topLabelSloganData;
	}
	
	
	
	
	public void setMenuButtonData(ArrayList<Object> arg){
		
		this.menuButtonData = arg;
	}
	public ArrayList<Object> getMenuButtonData(){
		
		return this.menuButtonData;
	}
	
	
	public void setOrderButtonData(ArrayList<Object> arg){
		
		this.orderButtonData = arg;
	}
	public ArrayList<Object> getOrderButtonData(){
		
		return this.orderButtonData;
	}
	
	public void setStateButtonData(ArrayList<Object> arg){
		
		this.stateButtonData = arg;
	}
	public ArrayList<Object> getStateButtonData(){
		
		return this.stateButtonData;
	}
	
	public void setAboutUsButtonData(ArrayList<Object> arg){
		
		this.aboutUsButtonData = arg;
	}
	public ArrayList<Object> getAboutUsButtonData(){
		
		return this.aboutUsButtonData;
	}
	
	
	
	
	
	
}
