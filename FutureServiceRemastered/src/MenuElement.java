


import java.io.Serializable;

public class MenuElement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dishPrice;
	private String dishDescription;	
	private String dishName;	
	private String dishKkl;
	private String dishCategory;
	private String dishIngredients;
	private String dishHValue;
	private byte[] categImage;
	private byte[] dishImage;
	private int posInTable;
   
	public MenuElement(String a1,String a2,String a3,String a4,String a5,String a6,String a7,byte[]a8,byte[] a9,  int a10){
		  this.dishName =a1;
		  this.dishDescription =a2;
		  this.dishCategory =a3;
		  this.dishIngredients=a4;
		  this.dishHValue =a5;
		  this.dishKkl =a6;
		  this.dishPrice =a7;
		  this.categImage =a8;
		  this.dishImage =a9;
		  this.posInTable = a10;
	}

	public int getPosInTable() {
		return posInTable;
	}

	public void setPosInTable(int posInTable) {
		this.posInTable = posInTable;
	}

	public String getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(String dishPrice) {
		this.dishPrice = dishPrice;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishKkl() {
		return dishKkl;
	}

	public void setDishKkl(String dishKkl) {
		this.dishKkl = dishKkl;
	}

	public String getDishCategory() {
		return dishCategory;
	}

	public void setDishCategory(String dishCategory) {
		this.dishCategory = dishCategory;
	}

	public String getDishIngredients() {
		return dishIngredients;
	}

	public void setDishIngredients(String dishIngredients) {
		this.dishIngredients = dishIngredients;
	}

	public String getDishHValue() {
		return dishHValue;
	}

	public void setDishHValue(String dishHValue) {
		this.dishHValue = dishHValue;
	}

	public byte[] getCategImage() {
		return categImage;
	}

	public void setCategImage(byte[] categImage) {
		this.categImage = categImage;
	}
	
	public byte[] getDishImage() {
		return dishImage;
	}

	public void setDishImage(byte[] dishImage) {
		this.dishImage = dishImage;
	}

	
}
