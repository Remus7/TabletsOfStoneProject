package TabletsOfStone;

import java.io.*;
import java.net.*;

public class ServerScript {
  public static void serviceCall(TabletsOfStoneMsg msg){
    switch(msg.getType()){
    case 0: // Status
      System.out.printf("Server is online");
    case 1: // Login
      System.out.printf("Login");
      break;
    case 2: // Logout
      System.out.printf("Logout");
      break;
    case 3: // Fetch messages from server
      System.out.printf("Fetch");
      break;
    case 4: // Send
      System.out.printf("Send message to server");
    }
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException{
    System.out.println("Hello to Tablets of Stone Server");
    String fullMessage = "";

    // InetAddress inetAdd = InetAddress.getLocalHost();
    ServerSocket servSocket = new ServerSocket(TabletsOfStoneMsg._PORT);
    System.out.println("Opened Server");

    Boolean closeServer = false;
    while(closeServer == false){
      try{
        Socket socket = servSocket.accept();
        InputStream inStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();
        System.out.println("Opened I/O Streams");

        ObjectInputStream objInStream = new ObjectInputStream(inStream);
        ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
        
        TabletsOfStoneMsg msg = (TabletsOfStoneMsg)objInStream.readObject();
        System.out.println("Recieved message: " + msg.getMsg());
        serviceCall(msg);

        objOutStream.writeObject("Recieved");
        socket.close();

      } catch(Exception e){
        System.out.printf("Exception: %s\n", e);
      }
    }

    System.out.printf(fullMessage);
    servSocket.close();
  }
}
