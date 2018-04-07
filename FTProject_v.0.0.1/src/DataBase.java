import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import javafx.collections.ObservableList;

public class DataBase {
	boolean a = false;
	 Wini ini = null;
	public DataBase(){
		try {
			ini = new Wini(new File("userInfo.ini"));
			
			
				
			
			
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void savePersonalData(String name, String slogan,String adress,String phone,String vk,String fb,String inst,String twitter) throws IOException{
		
		
		
	

        ini.add("personalData", "name", name);
        ini.add("personalData", "slogan", slogan);
        ini.add("personalData", "adress", adress);
        ini.add("personalData", "phone", phone);
        ini.add("personalData", "vk", vk);
        ini.add("personalData", "fb", fb);
        ini.add("personalData", "inst", inst);
        ini.add("personalData", "twitter", twitter);
        ini.store();
	}
	
	public String getDishElement(String name,int n){
		
		return ini.get("#"+n, name);
		
	}
	
	public void saveDishData(Dish dish,int number) throws MalformedURLException{
		
		 ini.add("#"+number, "name", dish.getDishName());
		 ini.add("#"+number, "description", dish.getDishDescription());
		 ini.add("#"+number, "ingridients", dish.getDishIngredients());
		 ini.add("#"+number, "category", dish.getDishRefer());
		 ini.add("#"+number, "bju", dish.getDishHValue());
		 ini.add("#"+number, "calory", dish.getDishKkl());
		 ini.add("#"+number, "price", dish.getDishPrice());
		 ini.add("#"+number, "image", dish.getDishImage().toURI().toURL().toString());
		 ini.add("#"+number, "cimage", dish.getCategImage().toURI().toURL().toString());
		 try {
			ini.store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void saveDishTableData( ObservableList<Dish> data){
		
		ini.add("dsize", "numberOfDishes", data.size());
		try {
			ini.store();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<data.size();i++){
			try {
				
				saveDishData(data.get(i),i);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(ini.toString());
		
	}
	public int getDishNumber(){
		if(ini.get("dsize", "numberOfDishes")!=null){
			System.out.println(Integer.parseInt(ini.get("dsize", "numberOfDishes")));
			return Integer.parseInt(ini.get("dsize", "numberOfDishes"));}
		else{
			return 0;
		}
	}
	
	
	public String getName() throws InvalidFileFormatException, IOException{
		
		return ini.get("personalData", "name");
	}
	
	public String getSlogan(){
		return ini.get("personalData", "slogan");
	}
	public String getAdress(){
		return ini.get("personalData", "adress");
	}
	
	public String getPhone(){
		return ini.get("personalData", "phone");
	}
	
	public String getVk(){
		return ini.get("personalData", "vk");
	}
	
	public String getFb(){
		return ini.get("personalData", "fb");
	}
	public String getInst(){
		return ini.get("personalData", "inst");
	}
	public String getTwitter(){
		return ini.get("personalData", "twitter");
	
	}
	
	
	
	
	
	
	
	
}



