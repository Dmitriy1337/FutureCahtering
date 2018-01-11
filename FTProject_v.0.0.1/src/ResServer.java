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
		OutputStream os,os1,os2,os3,os4,os5,oss ;
		static ObjectOutputStream dot,dot1,dot2,dot3,dot4,dot5,dot6;
		int count=0;
		FileInputStream file,file1,file2,file3,file4;
		Stage st1;
		ArrayList<ArrayList<ArrayList<byte[]>>>ph = new ArrayList<>();
		HashMap<String, ArrayList<byte[]>>ph1 = new HashMap();
		HashMap<String, byte[]>ph2 = new HashMap();
		ArrayList<ArrayList<ArrayList<File>>>all = new ArrayList<>();
		File change  = new File("");
		/**
		 * 
		 * 
		 * 
		 *  
		* Конструктор объекта сервера 
		* @param port Порт, где будем слушать входящие сообщения. 
		* @throws IOException Если не удасться создать сервер-сокет, вылетит по эксепшену, объект Сервера не будет создан 
		*/ 
		
		public int getConnNumber(){
			
			return q.size();
		}
		
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
		public synchronized void sendResInfo(File[] fl, String[] str) {//метод отправки в часть О нас 
		try { 
			
			file = new FileInputStream(fl[0]);
			
			file1 = new FileInputStream(fl[1]);
			file2 = new FileInputStream(fl[2]);
			file3 = new FileInputStream(fl[3]);
			file4 = new FileInputStream(fl[4]);
			
			byte[] bytes = new byte[file.available()];
			
			byte[] bytes1 = new byte[file1.available()];
			byte[] bytes2 = new byte[file2.available()];
			byte[] bytes3 = new byte[file3.available()];
			byte[] bytes4 = new byte[file4.available()];
			
			file.read(bytes);
			
			file1.read(bytes1);
			file2.read(bytes2);
			file3.read(bytes3);
			file4.read(bytes4);
			  
		
			//System.out.println(bytes);
		
			im = new Image(new ByteArrayInputStream(bytes));
			imm.setImage(im);
		
			 
			 dot.writeObject(bytes);
			 dot1.writeObject(bytes1);
			 dot2.writeObject(bytes2);
			 dot3.writeObject(bytes3);
			 dot4.writeObject(bytes4);
		     dot5.writeObject(str);
			
		} catch (IOException e) { 
		 //если глюк в момент отправки - закрываем данный сокет. 
		} 
		}
		public synchronized void sendMenuInfo(ArrayList<ArrayList<String>>al,ArrayList<ArrayList<File>>alPh) { //отправка меню
		try { 
			 for(int i=0;i<al.size();i++){
			  ArrayList<byte[]>all = new ArrayList<>();
			  ArrayList<byte[]>all1 = new ArrayList<>();
			  FileInputStream file = new FileInputStream(alPh.get(i).get(1));
			  byte[] bytes = new byte[file.available()];
			  file.read(bytes);
			  all.add(bytes);
			  FileInputStream file1 = new FileInputStream(alPh.get(i).get(0));
			  byte[] bytes1= new byte[file1.available()];
			  file1.read(bytes1);
			  all1.add(bytes1);
			  if(ph1.containsKey(al.get(i).get(3))){
				ph1.get(al.get(i).get(3)).add(bytes);	 
				 }
			  else{
				  ph1.put(al.get(i).get(3),all);	 
			  }
			 ph2.put(al.get(i).get(3), bytes1);
			 }
			System.out.print(ph1);
			
			 dot3.writeObject(al);
			 dot4.writeObject(ph2);
			 dot5.writeObject(ph1);
			
			//System.out.println("lllllllllll6666");
		} catch (IOException e) { 
		 //если глюк в момент отправки - закрываем данный сокет. 
		} 
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
		
		/** 
		* вложенный класс асинхронной обработки одного коннекта. 
		*/ 
		private class SocketProcessor implements Runnable{ 
		Socket s; // наш сокет 
		BufferedReader br; // буферизировнный читатель сокета 
		BufferedWriter bw; // буферизированный писатель в сокет 
		
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
		os5 = s.getOutputStream();
		//bt= new ByteArrayOutputStream();
		//dott = new ObjectOutputStream(oss);
		dot = new ObjectOutputStream(os);
		dot1 = new ObjectOutputStream(os1);
		dot2 = new ObjectOutputStream(os2);
		dot3 = new ObjectOutputStream(os3);
		dot4 = new ObjectOutputStream(os4);
		dot5 = new ObjectOutputStream(os5);
		System.out.println("kkkkk");
		//dot6 = new ObjectOutputStream(bt);
		 
		
		
		} 
		
		/** 
		* Главный цикл чтения сообщений/рассылки 
		*/ 
		public void run() { 
		while (!s.isClosed()) { // пока сокет не закрыт... 
		String line = null; 
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
		for (SocketProcessor sp:q) { 
		sp.send(line); 
		} 
		//} 
		} 
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