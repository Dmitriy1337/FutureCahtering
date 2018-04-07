import java.awt.Dimension;
import java.awt.Toolkit;

public class Values {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static double width = screenSize.getWidth();
	public static double height = screenSize.getHeight()-80;
	
	public static String MenuDecription
		= "Наше приложение предоставляет возможность" +"\n"
   		+ "добавлять и редактировать электронное меню," +"\n"
   		+ "которое открывает огромное количество " +"\n"
   		+ "возможностей для вышего заведения, а именно:" +"\n"
   		+ "экономия на печати и дизайне меню, взможность " +"\n"
   		+ "сменить ассортимент и цены в любое время," +"\n"
   		+ "разнообразие языков, удобство в использовании" + "\n"
   		+ "и много другое.";
   
	
}
