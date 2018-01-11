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
		* ����������� ������� ������� 
		* @param port ����, ��� ����� ������� �������� ���������. 
		* @throws IOException ���� �� �������� ������� ������-�����, ������� �� ���������, ������ ������� �� ����� ������ 
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
			Thread myThready = new Thread(at); //�������� ������ "myThready" 
			myThready.start();
			
		}  
		public synchronized void sendResInfo(File[] fl, String[] str) {//����� �������� � ����� � ��� 
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
		 //���� ���� � ������ �������� - ��������� ������ �����. 
		} 
		}
		public synchronized void sendMenuInfo(ArrayList<ArrayList<String>>al,ArrayList<ArrayList<File>>alPh) { //�������� ����
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
		 //���� ���� � ������ �������� - ��������� ������ �����. 
		} 
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
		
		/** 
		* ��������� ����� ����������� ��������� ������ ��������. 
		*/ 
		private class SocketProcessor implements Runnable{ 
		Socket s; // ��� ����� 
		BufferedReader br; // ��������������� �������� ������ 
		BufferedWriter bw; // ���������������� �������� � ����� 
		
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
		* ������� ���� ������ ���������/�������� 
		*/ 
		public void run() { 
		while (!s.isClosed()) { // ���� ����� �� ������... 
		String line = null; 
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
		for (SocketProcessor sp:q) { 
		sp.send(line); 
		} 
		//} 
		} 
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