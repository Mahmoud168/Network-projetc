package netw;
import java.io.*; 
import java.net.*; 

public class TCPServer_M2 {
	public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String sentence="";  
      ServerSocket welcomeSocket = new ServerSocket(6789); 
      Socket connectionSocket = welcomeSocket.accept();
      System.out.println("Connected to user");
      BufferedReader inFromUser = 
              new BufferedReader(new InputStreamReader(System.in)); 
      

      DataInputStream inFromClient = 
         new DataInputStream(connectionSocket.getInputStream()); 

      DataOutputStream  outToClient = 
              new DataOutputStream(connectionSocket.getOutputStream()); 

      while(!sentence.equals("Disconnect")) { 

                 clientSentence = inFromClient.readUTF();     
                
     	  System.out.println("FROM Client: "+clientSentence);
    	  
    	  sentence = inFromUser.readLine(); 
    	  outToClient.writeUTF(sentence);
      }
      welcomeSocket.close();
      } 
          } 
      
       
