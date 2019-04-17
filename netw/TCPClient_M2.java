package netw;
import java.io.*; 
import java.net.*; 

import java.net.Socket;

public class TCPClient_M2 {
	public static void main(String argv[]) throws Exception 
    { 
        String sentence;  
        String Serversentence="";
        BufferedReader inFromUser = 
          new BufferedReader(new InputStreamReader(System.in)); 


        	sentence = "";
        	
        	while(!inFromUser.readLine().equals("CONNECT"));
        	

            Socket clientSocket = new Socket("localhost", 6789); 

            DataOutputStream outToServer = 
              new DataOutputStream(clientSocket.getOutputStream()); 

            
            DataInputStream inFromServer = 
                    new DataInputStream(clientSocket.getInputStream()); 
            
        	System.out.println("CONNECTED");
        	
        	
        	while(!Serversentence.equals("Disconnect")) {
        		
        		  sentence = inFromUser.readLine(); 
            	  outToServer.writeUTF(sentence);
            	  
            	  Serversentence=inFromServer.readUTF();
            	  System.out.println("FROM SERVER: "+Serversentence);
 
            	
              }
              clientSocket.close(); 
                         
          } 
}

