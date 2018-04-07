import java.net.InetAddress;

import java.net.ServerSocket; 
import java.net.ServerSocket; 
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue; 
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; 

/** 
* Класс сервера. Сидит тихо на порту, принимает сообщение, создает SocketProcessor на каждое сообщение 
*/ 
public class ResServer extends Application{ 
	static Stage classStage = new Stage();
	static BufferedReader br;  
	static BufferedWriter bw;
	BufferedReader UL;
	 public  ServerSocket ss; // сам сервер-сокет 
public  Thread serverThread; // главная нить обработки сервер-сокета 
public int port = 54002; // порт сервер сокета. 
//очередь, где храняться все SocketProcessorы для рассылки 
//static Socket s = null;
BlockingQueue<SocketProcessor> q = new LinkedBlockingQueue<SocketProcessor>(); 
static ATread at; 
BufferedImage image;
ByteArrayOutputStream bt;
byte[] size;
Image im ;
ImageView imm  ;

int count=0;
FileInputStream file,file1,file2,file3,file4;
Stage st1;
ArrayList<ArrayList<ArrayList<byte[]>>>ph = new ArrayList<>();
HashMap<String, byte[]>ph1 = new HashMap();
HashMap<String, byte[]>ph2 = new HashMap();
ArrayList<ArrayList<ArrayList<File>>>all = new ArrayList<>();
File change  = new File("");
ArrayList<String>dishPoses = new ArrayList<>();
static ArrayList<String>logs = new ArrayList<String>();
/**
 * 
 * 
 * 
 *  
* Конструктор объекта сервера 
* @param port Порт, где будем слушать входящие сообщения. 
* @throws IOException Если не удасться создать сервер-сокет, вылетит по эксепшену, объект Сервера не будет создан 
*/ 
@Override
public void start(Stage primaryStage) throws Exception {
	st1 = new Stage();
	ResServer.classStage = st1;
	
 AnchorPane ac =new AnchorPane();
	Scene st1 = new Scene(ac);
	imm= new ImageView();
	ac.getChildren().add(imm);
	at = new ATread();
	primaryStage.setScene(st1);
	//primaryStage.show();
	Thread myThready = new Thread(at); //Создание потока "myThready" 
	myThready.start();
	
}  

public synchronized void sendResInfo(String str) {//метод отправки в часть О нас 


}
public int getConnNumber(){
	
	return q.size();
}
public synchronized void sendMenuInfo(ArrayList<String>al,ArrayList<File>alPh,ArrayList<String>style,ArrayList<File>images) { 
try { 
	
	System.out.println(style+"\\\\"+images);
	
	ArrayList<byte[]>patternsImages = new ArrayList<>();
	ArrayList<String>stylel = new ArrayList<>();
	
	if(style!=null){
		stylel  = style;
	}
	if(images!=null){
	for(int j=0;j<4;j++){
		FileInputStream file2 = new FileInputStream(images.get(j));
		byte[] bytes2 = new byte[file2.available()];
	    file2.read(bytes2);
	    patternsImages.add(bytes2);
	}
	}
	//dot3.writeObject(al);
	System.out.println(stylel+"\\\\"+patternsImages);
	
	
	// dot4.writeObject(alll1);
	
	 System.out.println(stylel+"\\\\"+patternsImages);
	 ArrayList<String>all  =new ArrayList<>();
	 HashMap<String, byte[]>ph1 = new HashMap();
	 HashMap<String, byte[]>ph2 = new HashMap();
	if(al!=null){	 
	all = al;	
	}
	if(alPh!=null){ 
	FileInputStream file = new FileInputStream(alPh.get(1));
		  byte[] bytes = new byte[file.available()];
		  file.read(bytes);
		 
		  FileInputStream file1 = new FileInputStream(alPh.get(0));
		  byte[] bytes1= new byte[file1.available()];
		  file1.read(bytes1);
		 
		  
		  
			  
		 ph1.put(al.get(3),bytes);	 
		  
		 ph2.put(al.get(3), bytes1);
	}
		System.out.print(ph1 + "" + ph2 + ""+ all);
    System.out.println("q"+q);
		for(SocketProcessor s:q){
			System.out.println("q"+s);
			s.sendToClient(all, ph2, ph1, stylel, patternsImages);
    }
		
	 ///PrintWriter writer = new PrintWriter("ll.txt", "UTF-8");
		//writer.println("The first line");
		//writer.println("The second line");
		//writer.close();
	//System.out.println("lllllllllll6666");
} catch (IOException e) { 
 //если глюк в момент отправки - закрываем данный сокет. 
} 
}



public synchronized void sendPatternInfo(ArrayList<String>style,ArrayList<File>images) { 

}

public void ServerCon() throws IOException { 
	InetAddress me = InetAddress.getLocalHost();
	String dottedQuad = me.getHostAddress();
	System.out.println(dottedQuad);
	ss = new ServerSocket(port,0,java.net.InetAddress.getByName(dottedQuad));// создаем сервер-сокет 

	// сохраняем порт. 
} 
public class ATread implements Runnable {
	
	
	@Override
	public void run() {
		try {
			ServerCon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serverThread = Thread.currentThread(); // со старта сохраняем нить (чтобы можно ее было interrupt()) 
		while (true) { //бесконечный цикл, типа... 
		Socket s = getNewConn(); // получить новое соединение или фейк-соедиение 
		System.out.println("got");
		if (serverThread.isInterrupted()) { // если это фейк-соединение, то наша нить была interrupted(), 
		// надо прерваться 
		break; 
		} else if (s != null){ // "только если коннект успешно создан"... 
		try { 
		final SocketProcessor processor = new SocketProcessor(s); // создаем сокет-процессор 
		final Thread thread = new Thread(processor); // создаем отдельную асинхронную нить чтения из сокета 
		thread.setDaemon(true); //ставим ее в демона (чтобы не ожидать ее закрытия) 
		thread.start(); //запускаем 
		q.offer(processor); //добавляем в список активных сокет-процессоров 
		
		
		} //тут прикол в замысле. Если попытка создать (new SocketProcessor()) безуспешна, 
		// то остальные строки обойдем, нить запускать не будем, в список не сохраним 
		catch (IOException ignored) {} // само же исключение создания коннекта нам не интересно. 
		} 
		} 
		
	} 



} 



/** 
* главный цикл прослушивания/ожидания коннекта. 
*/ 


/** 
* Ожидает новое подключение. 
* @return Сокет нового подключения 
*/ 
private Socket getNewConn() { 
Socket s = null; 
try { 

	
	s = ss.accept();
	
System.out.println("Got client");
} catch (IOException e) { 
shutdownServer(); // если ошибка в момент приема - "гасим" сервер 
} 
return s; 
} 

/** 
* метод "глушения" сервера 
*/ 
private synchronized void shutdownServer() { 
// обрабатываем список рабочих коннектов, закрываем каждый 
for (SocketProcessor s: q) { 
s.close(); 
} 
if (!ss.isClosed()) { 
try { 
ss.close(); 
} catch (IOException ignored) {} 
} 
} 

/** 
* входная точка программы 
* @param args 
* @throws IOException 
*/ 
public static void main(String[] args) throws IOException { 
	launch(args);  // если сервер не создался, программа
// вылетит по эксепшену, и метод run() не запуститься 
} 

public void writeToFile(String name,String s){
	
	 try(FileWriter writer = new FileWriter("name", true))
     {
        // запись всей строки
         String text = s;
         writer.write(text);
      
          
         writer.flush();
     }
     catch(IOException ex){
          
         System.out.println(ex.getMessage());
     } 
}

public String readFromFile(String name){
	
	
	 try(FileReader reader = new FileReader("name"))
     {
       String m = "";
		 // читаем посимвольно
         int c;
         while((c=reader.read())!=-1){
              
           m+=(char)(c);
         } 
    return m;
     }
     catch(IOException ex){
          
         System.out.println(ex.getMessage());
     }   
return "";
}
public String invoke(String s){
	String []sp = s.split("//");
	System.out.println(sp[0]);
	//MainGUI m = new MainGUI();
	String a = MainGUI.allMenuCombinedAndSorted.get(Integer.parseInt(sp[0])).get(0).get(3);//category
	String b= MainGUI.allMenuCombinedAndSorted.get(Integer.parseInt(sp[0])).get(Integer.parseInt(sp[1])).get(0);
	return a+"."+b;
}

/** 
* вложенный класс асинхронной обработки одного коннекта. 
*/ 
private class SocketProcessor implements Runnable{ 
Socket s; // наш сокет 
InputStream is;
ObjectInputStream in;
OutputStream os,os1,os2,os3,os4;
 ObjectOutputStream dot,dot1,dot2,dot3,dot4;
// буферизированный писатель в сокет 


/** 
* Сохраняем сокет, пробуем создать читателя и писателя. Если не получается - вылетаем без создания объекта 
* @param socketParam сокет 
* @throws IOException Если ошибка в создании br || bw 
*/ 
SocketProcessor(Socket socketParam) throws IOException { 
s = socketParam; 
br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8")); 
bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8") ); 
UL = new BufferedReader(new InputStreamReader(System.in)); 

//oss = s.getOutputStream();
os = s.getOutputStream();
os1 = s.getOutputStream();
os2 = s.getOutputStream();
os3 = s.getOutputStream();
os4 = s.getOutputStream();
//os5 = s.getOutputStream();
//bt= new ByteArrayOutputStream();
//dott = new ObjectOutputStream(oss);
dot = new ObjectOutputStream(os);
dot1 = new ObjectOutputStream(os1);
dot2 = new ObjectOutputStream(os2);
dot3 = new ObjectOutputStream(os3);
dot4 = new ObjectOutputStream(os4);
//dot5 = new ObjectOutputStream(os5);
is = s.getInputStream();
in=new ObjectInputStream(is);
System.out.println("kkkkk");
writeToFile("ava.txt","Подключено новое устройство. Id = "+getConnNumber()+System.lineSeparator());


//dot6 = new ObjectOutputStream(bt);
 


} 

/** 
* Главный цикл чтения сообщений/рассылки 
*/ 
public void run() { 
	//try {
		//dot.writeObject("Hello");
	    
	//System.out.println("dd");
	//} catch (IOException e1) {
		// TODO Auto-generated catch block
		//e1.printStackTrace();
	
while (!s.isClosed()) { // пока сокет не закрыт... 
	 
	ArrayList<String> dishPosess = null;
	try {
		dishPosess = (ArrayList<String>) in.readObject();
	    
		if(dishPosess!=null&&!dishPosess.isEmpty()){
		
			System.out.println("no null");
		 dishPoses = dishPosess;
		 writeToFile("ava.txt",System.lineSeparator()+"Новый заказ"+System.lineSeparator());
		 
		 for(int i  = 0;i<dishPosess.size();i++){
			 writeToFile("ava.txt",invoke(dishPosess.get(i)));
			 
		 }
		 
		
		 System.out.println(dishPoses+"99999999999999999");
	 }
	
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//try { 
//line = br.readLine(); // пробуем прочесть. 
//System.out.println(line);
//} catch (IOException e) { 
//close(); // если не получилось
//- закрываем сокет. 
//} 

//if (line == null) { // если строка null - клиент отключился в штатном режиме. 
///close(); // то закрываем сокет 
///} else if ("shutdown".equals(line)) { // если поступила команда "погасить сервер", то... 
//serverThread.interrupt(); // сначала возводим флаг у северной нити о необходимости прерваться. 
//try { 
//new Socket("localhost", port); // создаем фейк-коннект (чтобы выйти из .accept()) 
//} catch (IOException ignored) { //ошибки неинтересны 
///} finally { 
//shutdownServer(); // а затем глушим сервер вызовом его метода shutdownServer(). 
//} 
//} else { // иначе - банальная рассылка по списку сокет-процессоров 
 
//} 
} 
} 
public synchronized void sendToClient(ArrayList<String>all,HashMap<String,byte[]>ph2,HashMap<String,byte[]>ph1,ArrayList<String>stylel,ArrayList<byte[]>patternsImages) throws IOException{
	dot.reset();
    dot.writeObject(all);//(al.toString());    
	 dot1.reset();
	 dot1.writeObject(ph2);
	 dot2.reset();
	 dot2.writeObject(ph1);
	 dot3.reset();
	 dot3.writeObject(stylel);
	 dot4.reset();
	 dot4.writeObject(patternsImages);
	 System.out.println(stylel+"\\\\"+patternsImages);
}
/** 
* Метод посылает в сокет полученную строку 
* @param line строка на отсылку 
*/ 
 

public synchronized void send(String Usersline) { 
try { 
Usersline = UL.readLine();
System.out.println(Usersline);
bw.write(Usersline); // пишем строку 
bw.write("\n"); // пишем перевод строки 
bw.flush(); // отправляем 
} catch (IOException e) { 
close(); //если глюк в момент отправки - закрываем данный сокет. 
} 
} 


public synchronized void close() { 
q.remove(this); //убираем из списка 
if (!s.isClosed()) { 
try { 
s.close(); // закрываем 
} catch (IOException ignored) {} 
} 
} 


@Override 
protected void finalize() throws Throwable { 
super.finalize(); 
close(); 
} 
}


}