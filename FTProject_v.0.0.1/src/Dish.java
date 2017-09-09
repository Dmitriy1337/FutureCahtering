public  class Dish {
  public String dishPrice;
  public String dishDescription;	
  public String dishName;	
  public String dishKkl;
  public String dishRefer;
  public String dishIngredients;
  public String dishHValue;
  public Dish(String a1,String a2,String a3,String a4,String a5,String a6,String a7){
	  this.dishName =a1;
	  this.dishDescription =a2;
	  this.dishIngredients=a3;
	  this.dishRefer =a4;
	  this.dishHValue =a5;
	  this.dishKkl =a6;
	  this.dishPrice =a7;
  

  }


public void setDishPrice(String dishPrice) {
	this.dishPrice = dishPrice;
}


public void setDishDescription(String dishDescription) {
	this.dishDescription = dishDescription;
}


public void setDishName(String dishName) {
	this.dishName = dishName;
}


public void setDishKkl(String dishKkl) {
	this.dishKkl = dishKkl;
}


public void setDishRefer(String dishRefer) {
	this.dishRefer = dishRefer;
}
public void setDishIngredients(String dishIngredients) {
	this.dishRefer = dishIngredients;
}
public void setDishHValue(String dishHValue) {
	this.dishRefer = dishHValue;
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


public String getDishRefer() {
	return this.dishRefer;
}
public String getDishIngredients() {
	return this.dishIngredients;
}
public String getDishHValue() {
	return this.dishHValue;
}
}
