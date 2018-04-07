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
* ����� �������. ����� ���� �� �����, ��������� ���������, ������� SocketProcessor �� ������ ��������� 
*/ 
public class ResServer extends Application{ 
	static Stage classStage = new Stage();
	static BufferedReader br;  
	static BufferedWriter bw;
	BufferedReader UL;
	 public  ServerSocket ss; // ��� ������-����� 
public  Thread serverThread; // ������� ���� ��������� ������-������ 
public int port = 54002; // ���� ������ ������. 
//�������, ��� ��������� ��� SocketProcessor� ��� �������� 
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
* ����������� ������� ������� 
* @param port ����, ��� ����� ������� �������� ���������. 
* @throws IOException ���� �� �������� ������� ������-�����, ������� �� ���������, ������ ������� �� ����� ������ 
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
	Thread myThready = new Thread(at); //�������� ������ "myThready" 
	myThready.start();
	
}  

public synchronized void sendResInfo(String str) {//����� �������� � ����� � ��� 


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
 //���� ���� � ������ �������� - ��������� ������ �����. 
} 
}



public synchronized void sendPatternInfo(ArrayList<String>style,ArrayList<File>images) { 

}

public void ServerCon() throws IOException { 
	InetAddress me = InetAddress.getLocalHost();
	String dottedQuad = me.getHostAddress();
	System.out.println(dottedQuad);
	ss = new ServerSocket(port,0,java.net.InetAddress.getByName(dottedQuad));// ������� ������-����� 

	// ��������� ����. 
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
		serverThread = Thread.currentThread(); // �� ������ ��������� ���� (����� ����� �� ���� interrupt()) 
		while (true) { //����������� ����, ����... 
		Socket s = getNewConn(); // �������� ����� ���������� ��� ����-��������� 
		System.out.println("got");
		if (serverThread.isInterrupted()) { // ���� ��� ����-����������, �� ���� ���� ���� interrupted(), 
		// ���� ���������� 
		break; 
		} else if (s != null){ // "������ ���� ������� ������� ������"... 
		try { 
		final SocketProcessor processor = new SocketProcessor(s); // ������� �����-��������� 
		final Thread thread = new Thread(processor); // ������� ��������� ����������� ���� ������ �� ������ 
		thread.setDaemon(true); //������ �� � ������ (����� �� ������� �� ��������) 
		thread.start(); //��������� 
		q.offer(processor); //��������� � ������ �������� �����-����������� 
		
		
		} //��� ������ � �������. ���� ������� ������� (new SocketProcessor()) ����������, 
		// �� ��������� ������ �������, ���� ��������� �� �����, � ������ �� �������� 
		catch (IOException ignored) {} // ���� �� ���������� �������� �������� ��� �� ���������. 
		} 
		} 
		
	} 



} 



/** 
* ������� ���� �������������/�������� ��������. 
*/ 


/** 
* ������� ����� �����������. 
* @return ����� ������ ����������� 
*/ 
private Socket getNewConn() { 
Socket s = null; 
try { 

	
	s = ss.accept();
	
System.out.println("Got client");
} catch (IOException e) { 
shutdownServer(); // ���� ������ � ������ ������ - "�����" ������ 
} 
return s; 
} 

/** 
* ����� "��������" ������� 
*/ 
private synchronized void shutdownServer() { 
// ������������ ������ ������� ���������, ��������� ������ 
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
* ������� ����� ��������� 
* @param args 
* @throws IOException 
*/ 
public static void main(String[] args) throws IOException { 
	launch(args);  // ���� ������ �� ��������, ���������
// ������� �� ���������, � ����� run() �� ����������� 
} 

public void writeToFile(String name,String s){
	
	 try(FileWriter writer = new FileWriter("name", true))
     {
        // ������ ���� ������
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
		 // ������ �����������
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
* ��������� ����� ����������� ��������� ������ ��������. 
*/ 
private class SocketProcessor implements Runnable{ 
Socket s; // ��� ����� 
InputStream is;
ObjectInputStream in;
OutputStream os,os1,os2,os3,os4;
 ObjectOutputStream dot,dot1,dot2,dot3,dot4;
// ���������������� �������� � ����� 


/** 
* ��������� �����, ������� ������� �������� � ��������. ���� �� ���������� - �������� ��� �������� ������� 
* @param socketParam ����� 
* @throws IOException ���� ������ � �������� br || bw 
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
writeToFile("ava.txt","���������� ����� ����������. Id = "+getConnNumber()+System.lineSeparator());


//dot6 = new ObjectOutputStream(bt);
 


} 

/** 
* ������� ���� ������ ���������/�������� 
*/ 
public void run() { 
	//try {
		//dot.writeObject("Hello");
	    
	//System.out.println("dd");
	//} catch (IOException e1) {
		// TODO Auto-generated catch block
		//e1.printStackTrace();
	
while (!s.isClosed()) { // ���� ����� �� ������... 
	 
	ArrayList<String> dishPosess = null;
	try {
		dishPosess = (ArrayList<String>) in.readObject();
	    
		if(dishPosess!=null&&!dishPosess.isEmpty()){
		
			System.out.println("no null");
		 dishPoses = dishPosess;
		 writeToFile("ava.txt",System.lineSeparator()+"����� �����"+System.lineSeparator());
		 
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
//line = br.readLine(); // ������� ��������. 
//System.out.println(line);
//} catch (IOException e) { 
//close(); // ���� �� ����������
//- ��������� �����. 
//} 

//if (line == null) { // ���� ������ null - ������ ���������� � ������� ������. 
///close(); // �� ��������� ����� 
///} else if ("shutdown".equals(line)) { // ���� ��������� ������� "�������� ������", ��... 
//serverThread.interrupt(); // ������� �������� ���� � �������� ���� � ������������� ����������. 
//try { 
//new Socket("localhost", port); // ������� ����-������� (����� ����� �� .accept()) 
//} catch (IOException ignored) { //������ ����������� 
///} finally { 
//shutdownServer(); // � ����� ������ ������ ������� ��� ������ shutdownServer(). 
//} 
//} else { // ����� - ��������� �������� �� ������ �����-����������� 
 
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
* ����� �������� � ����� ���������� ������ 
* @param line ������ �� ������� 
*/ 
 

public synchronized void send(String Usersline) { 
try { 
Usersline = UL.readLine();
System.out.println(Usersline);
bw.write(Usersline); // ����� ������ 
bw.write("\n"); // ����� ������� ������ 
bw.flush(); // ���������� 
} catch (IOException e) { 
close(); //���� ���� � ������ �������� - ��������� ������ �����. 
} 
} 


public synchronized void close() { 
q.remove(this); //������� �� ������ 
if (!s.isClosed()) { 
try { 
s.close(); // ��������� 
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