import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Restaurant {
	public String restaurantName;
	public String restaurantSlogan;
	public String restaurantDescription;
	public String restaurantAdress;
	public String restaurantNumber;
	public String restaurantVk;
	public String restaurantInst;
	public String restaurantFb;
	public String restaurantTwitter;
	public Image restaurantLogo;
	public Image restaurantPhoto;
	public ImageView[]imageList;
	
		public Restaurant(String a,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,Image a9,Image a10,ImageView[]iv){
			this.restaurantName=a;
			this.restaurantSlogan=a1;
			this.restaurantDescription=a2;
			this.restaurantAdress=a3;
			this.restaurantNumber=a4;
			this.restaurantVk=a5;
			this.restaurantInst=a6;
			this.restaurantFb=a7;
			this.restaurantTwitter=a8;
			this.restaurantLogo=a9;
			this.restaurantPhoto=a10;
			this.imageList = iv;
		
		}
	
	
		public ImageView[] getImageList(){
			
			return this.imageList;
		}
		
		public void setImageList(ImageView[] iv){
			
			this.imageList = iv;
		}
		
		public String getRestaurantName(){
		
		return this.restaurantName;
	}
	
	public String getRestaurantSlogan(){
		
		return this.restaurantSlogan;
	}
	public String getRestaurantDescription(){
		
		return this.restaurantDescription;
	}
	public String getRestaurantAdress(){
		
		return this.restaurantAdress;
	}
	public String getRestaurantNumber(){
		
		return this.restaurantNumber;
	}
	public String getRestaurantVk(){
		
		return this.restaurantVk;
	}
	public String getRestaurantInst(){
		
		return this.restaurantInst;
	}
	public String getRestaurantFb(){
		
		return this.restaurantFb;
	}
	public String getRestaurantTwitter(){
		
		return this.restaurantTwitter;
	}
	public Image getRestaurantLogo(){
		
		return this.restaurantLogo;
	}
	public Image getRestarauntPhoto(){
	
	return this.restaurantPhoto;
	}
	
	
	public void setRestaurantName(String s){
		this.restaurantName = s;
		
		
	}
	
	public void setRestaurantSlogan(String s){
		this.restaurantSlogan = s;
		
		
	}
	public void setRestaurantDescription(String s){
		this.restaurantDescription = s;
		
		
	}
	public void setRestaurantAdress(String s){
		this.restaurantAdress = s;
		
		
	}
	public void setRestaurantNumber(String s){
		this.restaurantNumber = s;
		
		
	}
	public void setRestaurantVk(String s){
		this.restaurantVk = s;
		
		
	}
	public void setRestaurantInst(String s){
		this.restaurantInst = s;
		
		
	}
	public void setRestaurantFb(String s){
		this.restaurantFb = s;
		
		
	}
	public void setRestaurantTwitter(String s){
		this.restaurantTwitter = s;
		
		
	}
	
	public void setRestaurantLogo(Image i){
		this.restaurantLogo = i;
		
		
	}
	public void setRestaurantPhoto(Image i){
		this.restaurantPhoto = i;
		
		
	}
	
	
	
	
}
