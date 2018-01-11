
public class Device {
private int number;
private String state;
private int order;
private String orderstate;	


	public Device(int number,String state,int order,String orderstate){
		this.number = number;
		this.state = state;
		this.order = order;
		this.orderstate = orderstate;
		
	}
	
	public int getNumber(){
		
		return this.number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	
	public String getOrderState(){
		
		return this.orderstate;
	}
	public void setOrderState(String orderstate){
		this.orderstate = orderstate;
	}
	
public String getState(){
		
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
	
	public int getOrder(){
		
		return this.order;
	}
	public void setOrder(int order){
		this.order = order;
	}
	
}
